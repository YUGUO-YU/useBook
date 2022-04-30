<template>
  <div class="main">
    <div class="main_down">
      <div class="left">
        <div class="left_up">
          <div class="label_title">
            已建立会话
          </div>
          <div :class="curSessionId == item.id ? 'box_select' : 'box'" v-for="item in sessionList_already" :key="item.id">
            <div class="box_left"  @click="startSession(item.id)">
              {{item.listName}}
            </div>
            <div class="right_left">
              <div class="right_left_count">
                {{item.unReadCount}}
              </div>
              <div class="right_left_del">
                <i class="el-icon-close" @click="delSession(item.id)"></i>
              </div>
            </div>
          </div>
        </div>


      </div>
      <div class="right">
        <div class="up" ref="element" id="msg_end">
          <div v-for="(item,i) in list" :key="i" :class="item.fromUserId === curUserId ? 'msg_right' : 'msg_left'">
            <div class="msg_right_up">
              {{item.fromUserName}}
            </div>
            <div :class="item.fromUserId === curUserId ? 'msg_right_down' : 'msg_left_down'">
              {{item.content}}
            </div>
          </div>

        </div>
        <div class="down">
          <el-input
            type="textarea"
            :rows="9"
            placeholder="请输入内容，回车发送！"
            v-on:keyup.enter.native="sendMsg"
            v-model="textarea">
          </el-input>

          <!-- <el-button  @click="sendMsg">发送</el-button> -->
        </div>
      </div>
    </div>

    <el-dialog
      :title="dialogTitle"
      :visible.sync="dialogVisible"
      width="30%"
    >
      <el-input v-model="loginName" placeholder="请输入用户名..."></el-input>
      <span slot="footer" class="dialog-footer">
				<el-button @click="dialogVisible = false">取 消</el-button>
				<el-button type="primary" @click="loginOrRegister">确 定</el-button>
			</span>
    </el-dialog>
  </div>
</template>

<script>
  import axios from 'axios';
  export default {

    name: 'HelloWorld',
    data(){
      return{
        dialogVisible: false,
        dialogTitle: '',
        loginName: '',
        textarea: "",
        list: [],
        curUserId: "",
        curUserName: "",
        curSessionId: '',
        sessionList_already:[],
        sessionList_not:[],
        toUserId: '',
        toUserName: ''
      }
    },
    created() { // 页面创建生命周期函数

    },
    activated() {
      this.toUserId = this.$route.query.toUserId
      this.toUserName = this.$route.query.toUserName
      this.createSession(this.$route.query.toUserId,this.$route.query.toUserName)
      console.log(this.$route.query.toUserId,this.$route.query.toUserName)
      this.curSessionId = sessionStorage.getItem("SessionId")
      this.curUserId = sessionStorage.getItem("userId")
      //this.getSessionListNot()
      //this.sessionListAlready()
      this.startSession(sessionStorage.getItem("SessionId"))
      this.sessionListAlready();
    },
    updated(){
      // 解决每次发消息到最后面
      var elmnt = document.getElementById("msg_end");
      elmnt.scrollTop = elmnt.scrollHeight;
    },
    destroyed: function () { // 离开页面生命周期函数
      this.websocketclose();
      sessionStorage.removeItem("SessionId")
    },
    methods: {
      initWebSocket: function (userId,sessionId) {
        // WebSocket与普通的请求所用协议有所不同，ws等同于http，wss等同于https
        this.websock = new WebSocket("ws://127.0.0.1:8843/websocket/"+userId+"/"+sessionId);
        //this.websock.onopen = this.websocketonopen;
        this.websock.onerror = this.websocketonerror;
        this.websock.onmessage = this.websocketonmessage;
        //this.websock.onclose = this.websocketclose;
      },
      websocketonopen: function () {
        console.log("WebSocket连接成功");
      },
      websocketonerror: function (e) {
        console.log("WebSocket连接发生错误",e);
      },
      websocketonmessage: function (e) {
        let data = JSON.parse(e.data);
        if(data instanceof Array){
          // 列表数据
          this.sessionList_already = data
        }else{
          // 消息数据
          this.list.push(data)
        }
      },
      websocketclose: function (e) {
        if(this.curUserId != null){
          if(this.curSessionId != null){
            this.initWebSocket(this.curUserId, this.curSessionId)
          }else{
            this.initWebSocket(this.curUserId, 99999999)
          }
        }
        console.log("connection closed",e);
        console.log(e);
      },
      // 消息发送
      sendMsg(){
        // if(this.curSessionId == ''){
        //   return this.$message.error("请选择左边的对话框开始聊天!")
        // }
        let data = {
          "fromUserId": sessionStorage.getItem("userId"),
          "fromUserName": sessionStorage.getItem("user"),
          "content": this.textarea,
          "sessionId": this.curSessionId
        }
        this.list.push(data)
        this.websock.send(this.textarea)
        this.textarea = ''
      },
      openDialog(openName){
        this.dialogTitle = openName
        this.dialogVisible = true
      },
      // 登录or注册
      loginOrRegister(){
        let thus = this
        if(this.dialogTitle == "注册"){
          axios.get('http://127.0.0.1:1997/register?name=' + this.loginName)
            .then(function (response) {
              if(response.data.code == -1){
                return thus.$message.error(response.data.errDesc);
              }
              thus.$message.success("注册成功");
              thus.dialogVisible = false
            })
            .catch(function (error) {
              console.log(error);
            });
        }else if(this.dialogTitle == '登录'){
          axios.get('http://127.0.0.1:1997/login?name=' + this.loginName)
            .then(function (response) {
              console.log(response.data);
              if(response.data.code == -1){
                return thus.$message.error(response.data.errDesc);
              }
              thus.curUserId = response.data.data.id
              thus.curUserName = response.data.data.name
              thus.dialogVisible = false
              thus.getSessionListNot()
              thus.sessionListAlready()

            })
            .catch(function (error) {
              console.log(error);
            });
        }
      },
      // 获取可建立会话列表
      getSessionListNot(){
        let thus = this
        let userId = sessionStorage.getItem("userId");
        axios.get('http://127.0.0.1:8843/sessionList/not?id=' + userId)
          .then(function (response) {
            if(response.data.code == -1){
              return thus.$message.error(response.data.errDesc);
            }
            thus.sessionList_not = response.data.data
          })
          .catch(function (error) {
            console.log(error);
          });
      },
      // 获取已存在的会话列表
      sessionListAlready(){
        let thus = this
        let userId = sessionStorage.getItem("userId");
        axios.get('http://127.0.0.1:8843/sessionList/already?id=' + userId)
          .then(function (response) {
            if(response.data.code == -1){
              return thus.$message.error(response.data.errDesc);
            }
            thus.sessionList_already = response.data.data
          })
          .catch(function (error) {
            console.log(error);
          });
      },
      // 创建会话
      createSession(toUserId, toUserName){
        let thus = this
        let userId = sessionStorage.getItem("userId");
        if (toUserId!=null&&toUserName!=null){
          axios.get('http://127.0.0.1:8843/createSession?fromId=' + userId + "&toUserId=" + toUserId + "&toUserName=" + toUserName)
            .then(function (response) {
              if(response.data.code == -1){
                return thus.$message.error(response.data.errDesc);
              }
              sessionStorage.setItem("SessionId",response.data.data.id)
              thus.curSessionId = response.data.data.id
              console.log(response.data.data.id)
              thus.getSessionListNot()
              thus.sessionListAlready()
              thus.startSession(response.data.data.id)
            })
            .catch(function (error) {
              console.log(error);
            });
        }

      },
      // 开始会话
      startSession(sessionId){
        console.log("开始会话")
        let userId = sessionStorage.getItem("userId");
        console.log(this.websock);
        if(this.websock != undefined){
          this.websock.close()
        }
        this.curSessionId = sessionId
        this.initWebSocket(userId, sessionId)
        this.msgList(sessionId)
      },
      // 删除会话
      delSession(sessionId){
        let thus = this
        axios.get('http://127.0.0.1:8843/delSession?sessionId=' + sessionId)
          .then(function (response) {
            if(response.data.code == -1){
              return thus.$message.error(response.data.errDesc);
            }
            thus.getSessionListNot()
            thus.sessionListAlready()
          })
          .catch(function (error) {
            console.log(error);
          });
      },
      // 退出登录
      loginOut(){
        let thus = this
        axios.get('http://127.0.0.1:1997/loginOut?name=' + this.curUserName)
          .then(function (response) {
            if(response.data.code == -1){
              return thus.$message.error(response.data.errDesc);
            }
            thus.curUserId = ''
            thus.curUserName = ''
            return thus.$message.success("退出登录成功");
          })
          .catch(function (error) {
            console.log(error);
          });
      },
      // 获取消息数据
      msgList(sessionId){
        let thus = this
        console.log("sessionId"+sessionId)
        axios.get('http://127.0.0.1:8843/msgList?sessionId=' + sessionId)
          .then(function (response) {
            if(response.data.code == -1){
              return thus.$message.error(response.data.errDesc);
            }
            thus.list = response.data.data
            // 从新获取列表
            thus.sessionListAlready()
          })
          .catch(function (error) {
            console.log(error);
          });


      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .main{
    width: 980px;
    /* border: 1px #1890ff solid; */
    padding-top: 70px;
    height: 790px;
    padding-left: 15%;
  }
  .main_up{
    width: 980px;
    height: 40px;
    /* border:1px red solid; */
  }
  .main_down{
    width: 981px;
    height: 750px;
    border: 1px #1890ff solid;
    display: flex;
    justify-self: space-between;
  }
  .left{
    width: 300px;
    height: 750px;
    border-right: 1px #1890ff solid;
  }
  .left_up{
    width: 300px;
    height: 450px;
    overflow-y: auto;
    /* border: 1px red solid; */
  }
  .label_title{
    width: 282px;
    height: 25px;
    background-color: #f8f8f8;
    font-weight: 600;
    padding: 8px;
  }
  .left_down{
    width: 300px;
    height: 300px;
    overflow-y: auto;
    /* border: 1px green solid; */
  }
  .right{
    width: 680px;
    height: 750px;
    /* border-right: 1px #1890ff solid; */
  }
  .box{
    width: 250px;
    height: 22px;
    padding: 10px 25px 10px 25px;
    display: flex;
    justify-self: flex-end;
    /* border: 1px red solid; */
  }
  .box:hover{
    background-color: gainsboro;
    cursor: pointer;
  }
  .box_select{
    width: 250px;
    height: 22px;
    padding: 10px 25px 10px 25px;
    display: flex;
    justify-self: flex-end;
    background-color: gainsboro;
  }
  .box_left{
    width: 230px;
    height: 22px;
  }
  .right_left{
    width: 50px;
    height: 22px;
    display: flex;
    justify-content: space-between;
    /* border: 1px red solid; */
  }
  .right_left_count{
    /* border: 1px blue solid; */
    padding-left: 10px;
    width: 20px;
  }
  .right_left_del{
    width: 20px;
    padding-left: 10px;
  }
  .up{
    width: 680px;
    height: 550px;
    overflow-y: scroll;
    overflow-x: hidden;
    /* padding-bottom: 40px; */
    border-bottom: 1px #1890ff solid;
  }
  .msg_left{
    width: 675px;
    /* padding-left: 5px; */
    margin-top: 5px;
    /* border: 1px #1890ff solid; */
  }
  .msg_left_up{
    height: 25px;
    margin-top: 5px;
  }
  .msg_left_down{
    height: 25px;
    /* border: 1px #1890ff solid; */
    padding-left: 10px;
  }
  .msg_right{
    width: 660px;
    /* padding-right: 20px; */
    margin-top: 5px;
    /* border: 1px #1890ff solid; */
    text-align: right;
  }
  .msg_right_up{
    height: 25px;

  }
  .msg_right_down{
    height: 25px;
    /* border: 1px #1890ff solid; */
    padding-right: 10px;
  }
  .down{
    width: 680px;
    height: 200px;
    /* border: 1px red solid; */
  }
</style>
