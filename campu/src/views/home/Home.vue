<template>
  <div>
    <div id="Home" v-if="$store.state.flag == true" style="padding-top: 70px">
      <div style="width: 100%;height:130px;background-color: #f6f6f6;margin-top: -9px">
      <div class="HomeBd clear">

        <div class="left">
          <div class="leftBd">
            <div class="q322"><img src="@/assets/img/fav.png" alt=""></div>
            <div class="pipe"></div>
            <div class="manifesto">
              <p>校园二手交易</p>
              <p style="font-family: 微軟正黑體;color: #282828;">为您量身打造的二手书籍交易平台</p>
            </div>
          </div>
        </div>
        <div class="right">
          <div class="rightBd">
            <div id="input">
              <div class="inputBd" @click="focusClick">
                <input @blur="focusState = false" v-model="pkey" type="text" maxlength="12" v-focus="focusState">
              </div>
              <div id="search">
                <button class="searchBtn" @click="ss">搜索</button>
              </div>
            </div>
            <div id="release">
              <div class="releaseBd" @click="goReleaseClick">
                <div class="circle"><span id="sell">卖</span></div>
                <div class="reisin">
                  <p>发布闲置</p>
                  <p>
                    <span>闲置换钱</span><span>快速出售</span>
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      </div>
      <div class="clear"></div>
<!--      <h3>注意:本二手交易市场完全不收取中介费用，全凭客户喜好打赏。如有不便请多见谅！！！</h3>-->
      <div id="Goods">
        <!--        条件搜索-->
        <div class="class-top">
          <Jilian @buttonEvent="getByIdAllPro"></Jilian>
        </div>
        <!--        条件搜索-->
        <div class="clear"></div>
        <div class="GoodsBd">
          <div class="single"
               v-for="(item, index) in $store.state.Single.slice(0,pagesize)"
               :key="item.id" @click="flagF(item.id,item.userId,item.count);count(index)">
            <div class="imgbox">
              <!-- 图片展示 -->
              <img :src="http+item.imgUrl" alt="">
            </div>
            <ul>
              <li style="padding-left:10px;padding-top: 5px">
                <!-- 二手价/原价 -->
                <span class="price">￥{{item.price}}</span><span>/</span><span class="cost">￥{{item.bprice}}</span>
              </li>
              <li>
                <!-- 描述 -->
                <p class="describe">
                  {{item.content}}
                </p>
              </li>
              <li class="lisc">
								<span class="licount">
									<span>浏览:</span><span>{{item.count}}</span>
									<span>收藏:</span><span>{{item.sc}}</span>
                  <img src="@/assets/img/cars.png" title="收藏" @click="collectSwitchClickT(index,item.id,item.sc)">
                </span>
              </li>
              <li class="clear">
                <p>
                  <!-- 时间 -->
                  <span class="item">发布时间{{item.createTime}}</span>
                  <!-- 收藏次数  浏览次数 点击收藏 -->
                </p>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <!-- 分页 -->
      <div class="clear"></div>
      <div id="paging">
        <div class="block">
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="pageCount"
            :page-size="pagesize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="total">
          </el-pagination>
        </div>
      </div>
    </div>
    <div id="Details" v-else>
      <p>
        商品详情
      </p>
      <div class="clearfix">
        <div class="left">
          <ul>
            <li>
              <el-card shadow="always">
                <img :src="http+$store.state.Single[countrun].imgUrl" alt="">
              </el-card>
            </li>
          </ul>
        </div>
        <div class="right">
          <ul>
            <li>
              <span>商品名称:</span><span class="name">{{$store.state.Single[countrun].title}}</span>
            </li>
            <li>
              <span>商品原价:</span><span>￥</span><span>{{$store.state.Single[countrun].bprice}}</span>
            </li>
            <li>
              <span>商品二手价:</span><span><span
              style="color: red;font-size: 20px">￥{{$store.state.Single[countrun].price}}</span></span>
            </li>
            <li class="des">
              <span>商品描述:</span><span>{{$store.state.Single[countrun].content}}</span>
            </li>
            <li>
              <span>卖家联系方式:</span><span>{{tel}}</span>
            </li>
            <li>
              <span>商品上架时间:</span><span>{{$store.state.Single[countrun].createTime}}</span>
            </li>
            <li>
              <span>浏览次数: <span style="color: red">{{$store.state.Single[countrun].count}}</span></span>
            </li>
            <li>
              <span>收藏次数:<span style="color: red"> {{$store.state.Single[countrun].sc}}</span></span>
            </li>
            <li v-show="showss">
              <span style="margin-left: 45%;font-size: 20px;co">本人发布</span>
            </li>
            <li v-show="shows">
              <el-button type="primary" @click="sc($store.state.Single[countrun].id,$store.state.Single[countrun].sc)">
                收藏商品
              </el-button>
              <el-button type="primary" @click="Consult($store.state.Single[countrun].userId,$store.state.Single[countrun].userName)">
                咨询
              </el-button>
              <el-button type="warning" @click="Orders($store.state.Single[countrun].title,$store.state.Single[countrun].imgUrl,$store.state.Single[countrun].price,$store.state.Single[countrun].id)">
                立即购买
              </el-button>
            </li>
          </ul>
        </div>
        <div style="float: left">
          <el-divider content-position="left"><span style="font-size: 15px">商品留言信息</span></el-divider>
          <el-divider><i class="el-icon-mobile-phone"></i></el-divider>
          <el-link icon="el-icon-edit" style="float: right" @click="ly($store.state.Single[countrun].id)">发布留言</el-link>
          <el-card class="box-card">
            <div class="block">
              <el-timeline>
                <el-timeline-item v-for="(item,index) in  msg" :key="item.id" :timestamp="item.time" placement="top">
                  <el-card>
                    <h4>{{item.text}}</h4>
                    <br>
                    <p>{{username[index].userName}} 提交于 {{item.time}}</p>
                  </el-card>
                </el-timeline-item>
              </el-timeline>
            </div>
          </el-card>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import "@/assets/css/home.css"
  import '@/assets/css/goods.css'
  import '@/assets/css/details.css'
  import request from "@/network/request"
  import Jilian from "../../components/topbar/jilian";

  export default {
    name: 'Home',
    components: {Jilian},
    data() {
      return {
        userName: '',
        countrun: 0,
        focusState: false,
        collectSwitch: false,
        collectSwitchCount: 2,
        single: [],
        currentPage: 1,
        pagesize: 10,
        pageCount: [],
        http: "http://localhost:8843/",
        pkey: '',
        total: 0,
        tel: '',
        msg: [],
        username: [],
        shows : true,
        showss: false
      }
    },
    methods: {
      //接收子组件jilian传值
      getByIdAllPro(e){
        console.log(e)
        this.$store.state.Single = e.data
        this.single = this.$store.state.Single
        this.total = e.total
        let pageArr = [];
        let count = Math.ceil(this.$store.state.Single.length / this.pagesize);
        for (let i = 1; i < count + 1; i++) {
          pageArr.push(this.pagesize * i);
        }
        this.pageCount = pageArr
      },
      //咨询
      Consult(toUserId,toUserName){
        if (sessionStorage.getItem("user") == null) {
          this.$message.error("请登录后再进行操作")
          setTimeout(() => {
            this.$router.replace('/login')
          }, 1000)
        }else {
          this.$router.push({
            path: "WebWx",
            query:{
              toUserId: toUserId,
              toUserName: toUserName
            }
          })
        }

      },
      Orders(title,images,pri,id){
        if (sessionStorage.getItem("user") == null) {
          this.$message.error("请登录后再进行操作")
          setTimeout(() => {
            this.$router.replace('/login')
          }, 1000)
        }else{
          this.$router.push({
            path: 'Order',
            query:{
              title:title,
              images:images,
              pri:pri,
              id:id
            }
          })
        }

      },
      ly(id) {
        console.log(id)
        if (sessionStorage.getItem("user") == null) {
          this.$message.error("请登录后再进行操作")
          setTimeout(() => {
            this.$router.replace('/login')
          }, 1000)
        } else {
          this.$prompt('请输入留言内容', '发布留言信息', {
            confirmButtonText: '提交',
            cancelButtonText: '取消',
            inputType: 'textarea'
          }).then(({value}) => {
            if (value == null || value == '') {
              this.$message.error("请输入内容")
            } else {
              this.$http
                .post('http://127.0.0.1:8843/message/addMessage', {
                  fid: id,
                  text: value,
                  username: sessionStorage.getItem("user")
                })
                .then(response => {
                  if (response.data.data == true) {
                    this.$message({
                      type: 'success',
                      message: '增加留言成功'
                    });
                    setTimeout(function () {
                      location.reload();
                    }, 1000)
                    this.$store.commit('decrementF')
                  } else {
                    this.$message.error("增加留言失败")
                  }
                })
            }

          }).catch(() => {
            this.$message({
              type: 'info',
              message: '取消输入'
            });
          });
        }
      },
      sc(id, sc) {
        if (sessionStorage.getItem("user") == null) {
          this.$message.error("请登录后再进行操作")
          setTimeout(() => {
            this.$router.replace('/login')
          }, 1000)
        } else {
          this.$confirm('是否将此商品加入收藏?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.$http
              .post('http://127.0.0.1:8843/favorites/addFavorites', {
                pid: id,
                state: 1,
                username: sessionStorage.getItem("user")
              })
              .then(response => {
                if (response.data.data == true) {
                  this.$http
                    .put('http://127.0.0.1:8843/product/update?id=' + id + '&sc=' + (sc + 1))
                    .then(response => {
                      if (response.data.data == true) {
                        this.$message({
                          type: 'success',
                          message: '添加成功!'
                        });
                        setTimeout(() => {
                          location.reload();
                        }, 500)
                      }
                    })
                } else {
                  this.$message.error("请不要重复添加相同的商品");
                }
              })

          })
        }
      },
      focusClick() {
        this.focusState = true
      },
      collectSwitchClickT(index, id, sc) {
        setTimeout(() => {
          this.$store.commit('decrementT')
        }, 10)
        console.log(sc)
        this.$confirm('是否将此商品加入收藏?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http
            .post('http://127.0.0.1:8843/favorites/addFavorites', {
              pid: id,
              state: 1,
              username: sessionStorage.getItem("user")
            })
            .then(response => {
              if (response.data.data == true) {
                this.$http
                  .put('http://127.0.0.1:8843/product/update?id=' + id + '&sc=' + (sc + 1))
                  .then(response => {
                    if (response.data.data == true) {
                      this.$message({
                        type: 'success',
                        message: '添加成功!'
                      });
                      setTimeout(() => {
                        location.reload();
                      }, 500)
                    }
                  })
              } else {
                this.$message.error("请不要重复添加相同的商品");
              }
            })

        })
      },
      collectSwitchClickF(index, id) {
        this.single[index].sc--;
      },
      goReleaseClick() {
        if (sessionStorage.getItem("user") == null) {
          this.$message.error("请登录账号后再进行操作")
          setTimeout(() => {
            this.$router.replace('/login')
          }, 0)
        } else {
          this.$router.replace('/release')
        }
      },
      handleSizeChange(val) {
        // 每页多条
        console.log(`每页 ${val} 条`);
        console.log(this.pageCount.length)
        console.log(this.single.length)
        // this.currentPage = val
        // this.pageCount
        this.pagesize = val
      },
      handleCurrentChange(val) {
        this.$store.state.Single = []
        this.single = []
        // 当前页
        console.log(val);
        console.log(`当前页: ${val}`);
        this.currentPage = val;
        let pagehomt = {
          page: this.currentPage,
          number: this.pagesize,
        }
        request({
          url: '/product/productList',
          method: 'post',
          data: pagehomt
        }).then(res => {
          console.log(res.data)
          this.$store.state.Single = res.data
          this.single = this.$store.state.Single
          this.total = res.total
          let pageArr = [];
          let count = Math.ceil(this.$store.state.Single.length / this.pagesize);
          for (let i = 1; i < count + 1; i++) {
            pageArr.push(this.pagesize * i);
          }
          this.pageCount = pageArr
          console.log(this.single)
        }).catch(err => {
          console.log(err);
        })
      },
      handlePageSizes() {
        let pagehomt = {
          page: this.currentPage,
          number: this.pagesize
        };
        request({
          url: '/product/productList',
          method: 'post',
          data: pagehomt
        }).then(res => {
          console.log(res.data);
          this.$store.state.Single = res.data
          this.single = this.$store.state.Single
          this.total = res.total;
          let pageArr = [];
          let count = Math.ceil(this.single.length / this.pagesize);
          for (let i = 1; i < count + 1; i++) {
            pageArr.push(this.pagesize * i);
          }
          this.pageCount = pageArr

        }).catch(err => {
          console.log(err);
        })

      },
      count(index) {
        this.countrun = index
      },
      flagF(id, userId, count) {
        this.$store.commit('decrementF')
        console.log(id, userId)
        if (userId==sessionStorage.getItem("userId")){
          this.shows = false
          this.showss = true
        }
        else {
          this.showss = false
          this.shows = true
        }
        this.$http
          .get('http://127.0.0.1:8843/user/selectById?id=' + userId)
          .then(response => {
            this.tel = response.data.data.tel
          });
        this.$http
          .put('http://127.0.0.1:8843/product/update?id=' + id + '&count=' + (count + 1))
          .then(response => {
            console.log(response.data)
          })
        this.$http
          .post('http://127.0.0.1:8843/message/messageList', {
            page: 1,
            number: 1000,
            pId: id
          })
          .then(response => {
            this.msg = response.data.data
            console.log(response.data.data)
            let index = new Array()
            for (let i = 0; i < response.data.data.length; i++) {
              index.push(response.data.data[i].tid)
            }
            this.$http
              .post('http://127.0.0.1:8843/user/selectByIds', {
                ids: index
              })
              .then(response => {
                index = [];
                this.username = response.data.data
                // alert(this.username[0].userName)
              })
            console.log(this.username)
          })

      },
      ss() {
        if (this.pkey == '') {
          this.$message.error('请输入要搜索的值')
        } else {
          let pagehomt = {
            page: 1,
            number: 10,
            key: this.pkey
          }
          request({
            url: '/product/productList',
            method: 'post',
            data: pagehomt
          }).then(res => {
            console.log(res.data)
            this.$store.state.Single = res.data
            this.single = this.$store.state.Single
            this.total = res.total
            let pageArr = [];
            let count = Math.ceil(this.$store.state.Single.length / this.pagesize);
            for (let i = 1; i < count + 1; i++) {
              pageArr.push(this.pagesize * i);
            }
            this.pageCount = pageArr
            console.log(this.single)
          }).catch(err => {
            console.log(err);
          })
        }
      }
    },
    directives: {
      focus: {
        update: function (el, value) {//表示元素插入到DOM中的时候会执行这个函数
          if (value) {
            el.focus()
          }
        }
      }
    },
    computed: {},
    created() {
      this.handlePageSizes();
      this.ceil;
      this.ceil1;
      const h = this.$createElement;
      this.$notify({
        title: '公告',
        message: h('i', { style: 'color: teal'}, '欢迎使用校园二手书交易平台')
        ,position: 'top-right'
      });

    }
  }
</script>

<style>
  .single{
    border-radius: 4px;
    margin-top: 10px;
    box-shadow: 1px 1px 1px #cfd8de;
  }
  .leftLian{
    float: left;
    margin-left: -10%;
    position: fixed;
  }
  #paging {
    width: 1200px;
    margin: 0 auto;
  }

  #paging > div {
    text-align: center;
  }

  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
    font-family: 方正舒体;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 1200px;
  }
  .class-top{

  }
</style>
