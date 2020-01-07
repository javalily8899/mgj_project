<style>
  .dv_header{
    margin: auto;
    width: 1000px;
    height: 200px;
    background-image: url(../assets/timgs.jpg);
    background-size: 100%;
  }
  .dv_personal{
    float: left;
    width: 300px;
    height: 150px;
    margin: 20px;
  }
  .dv_head{
    background-color: orange;
    width: 90px;
    height: 90px;
    float: left;

  }
  .dv_names{
    font-size: 40px;
    float: left;
  }
  .dv_hname{
    font-size: 30px;
    float: left;

  }
  .dv_ccu{
    font-size: 20px;
    clear: both;
    margin-right: 20px;
  }
  .dv_btn{
    position: absolute;
    right: 200px;
    top: 230px;
    background-color: aqua;
    font-size: 20px;
  }
  .dv_shear{
    position: absolute;
    right: 200px;
    top: 300px;
    background-color: lightgreen;
    font-size: 20px;
  }
  .dv_page{
    width: 1000px;
    height: 200px;
    margin: auto;
    margin-top: 10px;
    background-color: #00FFFF;
  }

    .goods_detail{
   	width: 100%;height: 100%;position: absolute;

   	box-shadow: 0px 0px 166px 6px black inset;
   	transition: all 0.6s;
     opacity: 0;
   	color:#FFFFFF;

   }
   .dv_goods .goods_detail:hover{
      opacity: 1;
   }
    .box-wrappe{
      width: 1000px;
      width: auto;
      float: left;
      margin-top: 25px;
      margin-left: 100px;
    }
    .dv_goods{
      width: 220px;
      height: 330px;
      float: left;
      margin: 10px;
      background-color: orange;
      position:relative;
      overflow: hidden;

    }
    .goods_detail button{

    	background-color: #FFFFFF;
    	color:gray;
    	width: 40px;
    	height: 40px;
    	border-radius: 90px;
    	border:0px;
    	font-size: 23px;

    	float: right;
    	margin-right: 20px;


    }
    .goods_detail button:first-child{
    	margin-top:20px;
    }



</style>

<template>
  <div class="container">

   <merchantbrowse></merchantbrowse>
   <br /><br />
   <merchanttable></merchanttable>
   <br /><br />


    <div class="dv_header">
      <div class="dv_personal">
        <!-- 商家头像 -->
        <div class="dv_head"></div>
        <!-- 店铺名 -->
        <div class="dv_names">美妆博士店</div>
        <!-- 商家名 -->
        <div class="dv_hname">hello!</div>
        <br />
        <!-- 商家联系方式 -->
        <div class="dv_ccu">1870983987</div>
        <!-- 商家地址 -->
        <div class="dv_address">山东省青岛市市南28号</div>
         <!-- 跳转到商家信息页面 -->
        <div >
          <button class="dv_btn " style="border-radius: 12px;width: 200px;height: 50px;border: 1px;" @click="doupdate()">修改用户详细信息</button>
        </div>

        <div >
          <button class="dv_shear " style="border-radius: 12px;width: 200px;height: 50px;border: 1px;" @click="doinsert()">添加商品</button>
        </div>
      </div>
    </div>
    <!-- 轮播图 -->
    <div class="dv_page"></div>

    <div class="box-wrappe">
      <div v-for="i in 10" class="dv_goods" :style="i" >
          <div class="goods_detail">
            <button>
              <i class="fa fa-star-o"></i>
            </button>

            <br/><br/><br/><br/>

             <button>
               <i class="fa fa-thumbs-o-up"></i>
             </button>


             <br/><br/><br/><br/>

             <div class="text-center">
                <hr/>
                <p align="center">
                  中式大衣
                  <br />
                  900.00元
                </p>



             </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
 import merchantbrowse from '@/components/merchantbrowse.vue'
 import merchanttable from '@/components/merchanttable.vue'
 export default{
  components:{
     merchantbrowse,
     merchanttable
   },
    data () {
      return {
        goodsinfoes:[],
       /* pagenum:1,
        locked:false */
      }
    },
    /* mounted(){
      this.getInfoes();
      var ob=this;
      $(window).scroll(function(){
          //页面滚动距离
          var windowScrollTop=$(document).scrollTop();

          var lastDvGoods=$("#");
          if($(lastDvGoods).offset().top-windowScrollTop<500){
            if(ob.locked==false){
              ob.locked=true;
              ob.pagenum+=1;
              ob.getInfoes();
            }
          }

      });
    }, */
    methods:{
      doupdate(){
        this.$router.push({name:"serll"});
      },
      doinsert(){
        this.$router.push({name:"insertgoods"});
      },
      sele_in(){
        
        var ob=this;
        var url="#"
        $ajax(url,{
          /* data:{

          }, */
          success:function(result){
            alert(resurl);

            /* for(var i in goodslist){
              goodslist[i].gimgurl="()";
              ob.goodsinfoes.push(goodslist[i]);
            } */

            // ob.locked=false;

          },


        });

      }
    },
    
  }
</script>
