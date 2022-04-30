<template>
  <div>
    <div class="order">
      <div>
        <span style="margin-left: 45%;font-size: 20px">填写信息</span>
        <!-- Form -->
        <div class="forms">
          <p>选择地址：<el-button type="primary" icon="el-icon-edit" size="small" @click="dialogFormVisible = true" >新增地址</el-button></p>
          <div>
          <div v-for="item in getAddre" @click="dian(item.aId)">
            <el-card class="box-card" >
              <el-radio v-model="item.aId" :label="num" style="font-family: 华文仿宋">地址</el-radio>
              <div class="text item">
                姓名：{{item.aName}}
              </div>
              <div class="text item">
                联系方式：{{item.aTel}}
              </div>
              <div class="text item">
                地址：{{item.aAddress}}
              </div>
            </el-card>
          </div>

          </div>
        </div>
      </div>
      <div class="clear"></div>
      <div class="forms-top">
        <span>图片</span>
        <el-divider direction="vertical" content-position="center" ></el-divider>
        <span>价格</span>
        <el-divider direction="vertical" content-position="center"></el-divider>
        <span>名称</span>
      </div>
      <div class="clear"></div>
      <div class="forms-bom">
        <span><img :src="http+images" /></span>
        <span >{{pri}}</span>
        <span>{{title}}</span>
      </div>
      <div class="buttons">
        <span><el-button type="warning" @click="addOrder" :loading=lod>立即付款</el-button></span>
      </div>
      <el-dialog title="收货地址" :visible.sync="dialogFormVisible">
        <el-form :model="form" ref="refForm" :rules="rules">
          <el-form-item label="收货人姓名" :label-width="formLabelWidth" prop="aName">
            <el-input v-model="form.aName" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="联系电话" :label-width="formLabelWidth" prop="aTel">
            <el-input v-model="form.aTel" type="number"></el-input>
          </el-form-item>
          <el-form-item label="收货地址" :label-width="formLabelWidth" prop="selectedOptions">
            <el-cascader
              size="large"
              :options="options"
              v-model="selectedOptions"
              @change="handleChange"
            >
            </el-cascader>
          </el-form-item>
          <el-form-item label="详细地址" :label-width="formLabelWidth" prop="address">
            <el-input v-model="address" type="text"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button @click="Reset()">重置</el-button>
            <el-button type="primary" @click="addAddressForm('refForm')" :loading=lod>提交</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </div>
  </div>
</template>

<script>
  import { regionData, CodeToText } from "element-china-area-data";
  export default {
    name: "order",
    data() {
      return {
        dialogFormVisible: false,
        form: {
          aName: '',
          aTel: '',
          aAddress: '',
          aUserId: ''
        },
        address:'',
        formLabelWidth: '120px',
        options: regionData,
        selectedOptions: [],
        lod: false,
        num: 0,
        getAddre:[],
        title:"",
        images:"",
        pri:"",
        http: "http://localhost:8843/",
        id: "",
        rules: {
          aName: [
            { required: true, message: '请输入收件人姓名', trigger: 'blur' },
            { min: 1, max: 6, message: '长度在 1 到 6 个字符', trigger: 'blur' }
          ],
          aTel: [
            { required: true, message: '请输入收件人电话', trigger: 'blur' },
            { min: 7, max: 11, message: '长度在 7 到 11 个字符', trigger: 'blur' }
          ],

        }
      }
    },
    methods:{
      getAddress(){
        this.$http.get('http://127.0.0.1:8843/address/getAddress',{
          params:{
            userId:sessionStorage.getItem("userId")
          }
        }).then(res =>{
          this.getAddre = res.data.data
          this.num = res.data.data[0].aId
          console.log(res)
        })
      },
      handleChange() {
        var loc = "";
        for (let i = 0; i < this.selectedOptions.length; i++) {
          loc += CodeToText[this.selectedOptions[i]];
        }
        this.form.aAddress = loc
        this.form.aUserId = sessionStorage.getItem("userId")
      },
      addAddressForm(){
        this.form.aAddress = this.form.aAddress+this.address
        this.lod = true
        this.$http.post('http://127.0.0.1:8843/address/add',this.form).then(res =>{
          console.log(res)
          if (res.data.code==0){
            this.$nextTick(() => {
              setInterval(this.Lodings, 2000);
            });
          }
        })

        console.log(this.form.aAddress)
      },
      Reset(){
        this.form = this.$options.data().form
        this.selectedOptions = this.$options.data().selectedOptions
      },
      Lodings(){
        this.getAddress();
       this.lod=false
        this.dialogFormVisible = false
      },
      Lodingss(){
        this.lod=false
      },
      dian(e){
        this.num = e
        console.log(e)
      },
      addOrder(){

        this.$http.post('http://127.0.0.1:8843/order/addorder',{
          userId: sessionStorage.getItem("userId"),
          addressId: this.num,
          productId: this.id,
          realFee: this.pri
        }).then(res =>{
          if (res.data.code==0){
            this.$nextTick(() => {
              setInterval(this.Lodingss, 2000);
            })
            this.$notify({
              title: '成功',
              message: '购买成功',
              type: 'success'
            });
            this.$router.push('help')

          }else {
            this.$notify.info({
              title: '消息',
              message: '购买失败'
            });
          }
          console.log(res)
        })
      }
    },
    activated(){
      this.getAddress();
      this.title = this.$route.query.title,
        this.images = this.$route.query.images,
        this.pri = this.$route.query.pri,
        this.id = this.$route.query.id
    },
    created() {

    },

  }
</script>

<style scoped>
  .order {
    padding-top: 100px;
    margin: 0 auto;
    width: 80%;
  }
  .forms{
    margin-top: 20px;
  }
  .forms p{
    font-size: 18px;
  }

  .text {
    font-size: 14px;
  }

  .item {
    padding-left: 20px;
    font-family: 华文仿宋;
  }

  .box-card {
    width: 240px;
    height: 150px;
    float: left;
    margin-left: 2%;
  }
  .forms-top{
    margin-top: 190px;
  }
  .forms-top span{
    padding-left: 280px;
  }
  .forms-bom{
    margin-top: 20px;
    text-align: center;
    margin-left: -290px;
  }
  .forms-bom span{
    margin-left: 280px;
    color: #ff714d;
  }
  .forms-bom img{
    width: 150px;
    height: 150px;
  }
  .buttons{
    margin-left: 76%;
    margin-top: 30px;
  }
</style>
