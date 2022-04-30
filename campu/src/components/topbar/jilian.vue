<template>
  <div class="jilian">
    <ul>
      <li>
        <span style="font-family: 华文仿宋">选择分类搜索：</span>
        <el-select v-model="cName" placeholder="请选择院校" @change="getMajor">
          <el-option
            v-for="item in college"
            :key="item.cId"
            :label="item.cName"
            :value="item.cId"
          >
          </el-option>
        </el-select>
      </li>
      <li>

        <el-select v-model="mName" placeholder="请选择专业" @change="getmId">
          <el-option
            v-for="item in major"
            :key="item.mId"
            :label="item.mName"
            :value="item.mId">
          </el-option>
        </el-select>
      </li>
      <li>

        <el-select v-model="label" placeholder="请选择年级" @change="getGId">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
      </li>
    </ul>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        college: [],
        major: [],
        cName: "",
        cId: -1,
        mName: "",
        mId: -1,
        gId: -1,
        options: [{
          value: 1,
          label: '大一'
        }, {
          value: 2,
          label: '大二'
        }, {
          value: 3,
          label: '大三'
        }, {
          value: 4,
          label: '大四'
        }],
        label: ''
      }
    },
    methods:{
      // 分类查询
      getByIdAll(){
        this.$http.get('http://127.0.0.1:8843/product/getByIdAllPro',{
          params:{
            page: 1,
            number: 10,
            cId:this.cId,
            mId:this.mId,
            gId:this.gId
          }
        }).then(res =>{
          this.$emit( 'buttonEvent' , res.data)
          console.log(res.data)
        })
      },
      getAllCollege(){
        this.$http.get('http://127.0.0.1:8843/product/getAllCollege').then(response =>{
          this.college=response.data.data
          console.log(response.data.data)
        });
      },
      getMajor(value){
        this.cId = value
          this.$http.get("http://127.0.0.1:8843/product/getAllMajor",{
            params:{
              cId : value
            }
          }).then(res =>{
            this.major = res.data.data
            console.log(res.data.data)
          });
        if (this.cId!=null){
          this.getByIdAll();
        }else {
          this.cId=-1
          if (this.gId!=null){
            this.getByIdAll();
          }
        }

      },
      getmId(value){
        this.mId = value
        if (this.mId!=null){
          this.getByIdAll();
        }else {
          this.mId=-1
          if (this.gId!=null){
            this.getByIdAll();
          }
        }
      },
      getGId(value){
        this.gId = value
        if (this.gId!=null){
          this.getByIdAll();
        }else {
          this.gId=-1
          if (this.gId!=null){
            this.getByIdAll();
          }
        }
        console.log(this.gId)
      },
    },
    created() {
      this.getAllCollege()
    }
  }
</script>

<style scoped>
.jilian{
  padding: 0;
  margin: 0 auto;
}

  .jilian ul li{
    float: left;
    margin-left: 10px;
  }
</style>
