<template>
	<div id="Help">
		<div class="top">
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="我买到的" name="first" @click="getMyOrder()">
          <el-card class="box-card" v-for="o in myOrder" :key="o">
            <div class="orderNo">
              订单码：{{o.orderNo}}
            </div>
            <div  class="text item">
              <img :src="http+o.imgUrl" />
            </div>
            <div  class="text item">
              <div class="title">
                <p>品名：{{o.title }}</p>
                <p>介绍：{{o.content}}</p>
                <p>成交价：{{o.realFee }}元</p>
                <p>下单时间：{{o.createTime}}</p>
<!--                <p>收货地址：{{o.address}}</p>-->
              </div>
            </div>

          </el-card>
        </el-tab-pane>
        <el-tab-pane label="我卖出的" name="second" @click="getMySale()">
          <el-card class="box-card" v-for="o in toOrder" :key="o">
            <div class="orderNo">
              订单码：{{o.orderNo}}
            </div>
            <div  class="text item">
              <img :src="http+o.imgUrl" />
            </div>
            <div  class="text item">
              <div class="title">
                <p>品名：{{o.title }}</p>
                <p>介绍：{{o.content}}</p>
                <p>成交价：{{o.realFee }}元</p>
                <p>下单时间：{{o.createTime}}</p>
                <p>收货地址：{{o.address}}</p>
              </div>
            </div>

          </el-card>
        </el-tab-pane>
      </el-tabs>
		</div>

	</div>
</template>

<script>
import "../../assets/css/help.css"

export default {
	name: 'Help',
  data(){
	  return{
      activeName: 'first',
      myOrder:[],
      toOrder:[],
      http: 'http://localhost:8843/'
    }
  },
  methods:{
    handleClick(tab, event) {
      if (tab.name=="first"){
        this.getMyOrder()
      }else if (tab.name=="second"){
        this.getMySale()
      }
      console.log(tab.name);
    },
    getMyOrder(){
      this.$http.get('http://127.0.0.1:8843/order/getByUserIdOrder',{
        params:{
          userId:sessionStorage.getItem("userId")
        }
      }).then(res =>{
        this.myOrder = res.data.data
      })
    },
    getMySale(){
      this.$http.get('http://127.0.0.1:8843/order/getByUserIdToOrder',{
        params:{
          userId:sessionStorage.getItem("userId"),
          isNot:1
        }
      }).then(res =>{
        this.toOrder = res.data.data
      })
    }
  },
  created() {
	  this.getMyOrder();
  },
  activated(){
    this.getMyOrder();
  }
}
</script>

<style>
  .text {
    font-size: 14px;
  }

  .item {
    float: left;
  }
  .item img{
    width: 150px;
    height: 100px;
  }
  .title{
    margin-left: 30px;
    height: 100px;
    margin-top: 1px;
  }
  .title p{
    font-size: 17px;
    font-family: 华文仿宋;
    font-weight: 800;
  }

  .box-card {
    margin-top: 20px;
    height: 140px;
    width: 95%;
  }
  .orderNo{
    font-family: 华文仿宋;
    margin-top: -10px;
    font-size: 14px;
  }
</style>
