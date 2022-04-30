<template>
	<div id="Release">
			<div class="title">发布闲置:</div>
			<div class="ReleaseBd">
				<ul>
          <li>
            <div class="left-re">
              <span>商品图片:</span>
              <div style="padding-left: 95px">
                <el-upload
                  class="avatar-uploader"
                  action="http://127.0.0.1:8843/image/uploadImg"
                  :show-file-list="false"
                  :on-success="handleAvatarSuccess"
                  :before-upload="beforeAvatarUpload">
                  <img v-if="imageUrl" :src="imageUrl" class="avatar">
                  <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                </el-upload>
              </div>
            </div>
            <div class="right-re">
              <ul>
                <li>
                  <span>院校：</span>
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
                  <span>专业系：</span>
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
                  <span>年级：</span>
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
          </li>
          <div class="clear"></div>
					<li>
						<span>商品名称:</span>
						<input v-model="title" type="text">
					</li>
					<li>
						<span>商品原价格:</span>
						<input v-model="bprice" type="number">
					</li>
          <li>
            <span>商品卖出价格:</span>
            <input v-model="price" type="number">
          </li>
					<li>
						<span class="describe">商品描述:</span>
						<textarea v-model="content" name="textarea" id="" placeholder="请对您发布的商品进行描述">
						</textarea>
					</li>
					<li>
						<span></span>
						<button @click="sunm">发布</button>
						<input type="reset" value="重置" id="reset">
					</li>
				</ul>
			</div>
	</div>
</template>

<script>
import '@/assets/css/release.css'
import request from "@/network/request"

export default {
	name: "Release",
	data () {
		return {
      imageUrl: '',
      dbimgUrl:'',
      title:'',
      bprice:'',
      price:'',
      content:'',
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
	methods: {
    getMajor(value){
      this.cId = value
      this.$http.get("http://127.0.0.1:8843/product/getAllMajor",{
        params:{
          cId : value
        }
      }).then(res =>{
        this.major = res.data.data
        console.log(res.data.data)
      })
    },
    getmId(value){
      this.mId = value
    },
    getGId(value){
      this.gId = value
      console.log(this.gId)
    },
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
      this.dbimgUrl = res.data
      this.$message.success(res.msg)
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return isJPG && isLt2M;
    },
    sunm(){

      this.$http
       .put('http://127.0.0.1:8843/product/addProduct',{
         imgUrl:this.dbimgUrl,
         title:this.title,
         bprice:this.bprice,
         price:this.price,
         content:this.content,
         userName:sessionStorage.getItem("user"),
         collegeId:this.cId,
         MajorId:this.mId,
         GradeId:this.gId
       })
      .then(response=>{
        if (response.data.code==0){
          setTimeout(()=>{
            location.reload();
            this.$router.replace('/home')
            location.reload();
          })
        }
    })
    },
    getAllCollege(){
      this.$http.get('http://127.0.0.1:8843/product/getAllCollege').then(response =>{
        this.college=response.data.data
        console.log(response.data.data)
      })
    }
	},
  created() {
	  this.getAllCollege()
    if(sessionStorage.getItem("user")==null){
      setTimeout(()=>{
        this.$router.replace('/login')
      },0)
    }else {
      this.$router.replace('/release')
    }
  }
}
</script>

<style>
  #Release{
    margin: 0 auto;
    padding-top: 70px;
  }
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
  .left-re{
    float: left;
  }
  .right-re{
    float: left;
    padding-left: 110px;
  }
</style>
