<template>

  <!-- 横向 贯穿 div  -->
  <div class="dv_rolladvs">

     <!-- 据左 轮播广告 容器div-->
    <div class="dv_advs" @mouseover="rolladvs_stop()" @mouseout="rolladvs_start()">

         <!-- 根据 数组 遍历产生的 切换广告div-->
        <transition name="fade" v-for="(ad,i) in advs" >
        <div class="dv_adv" :style="ad" v-if="i==advs_index" ></div>
        </transition>

        <div class="dv_btns">
              <button v-for="i in advs.length" @mouseover="changeAdv(i-1)" :class="{'btn_index':(i-1)==advs_index}" ></button>
        </div>


    </div>
     <div class="dv_themes">
        <div class="dv_theme" v-for="th in themes" :style="th" ></div>


     </div>



  </div>

</template>

<script>
  export default{
    data(){
      return{
        timer1:"",
        timer2:"",
        timer3:"",
        timer4:"",
        advs_index:0,
        advs:[
          "background-image:url('http://127.0.0.1:8090/backstage/imgs/rolladv/gg1.png')",
          "background-image:url('http://127.0.0.1:8090/backstage/imgs/rolladv/gg2.png')",
          "background-image:url('http://127.0.0.1:8090/backstage/imgs/rolladv/gg3.png')",
         "background-image:url('http://127.0.0.1:8090/backstage/imgs/ggzt (1).jpg')",
         "background-image:url('http://127.0.0.1:8090/backstage/imgs/ggzt (2).jpg')",
         "background-image:url('http://127.0.0.1:8090/backstage/imgs/ggzt (3).jpg')",
         "background-image:url('http://127.0.0.1:8090/backstage/imgs/ggzt (4).jpg')",
         "background-image:url('http://127.0.0.1:8090/backstage/imgs/ggzt (1).gif')",
         "background-image:url('http://127.0.0.1:8090/backstage/imgs/hifan (3).jpg')"


        ],
        themes:[
          "background-image:url('http://127.0.0.1:8090/backstage/imgs/ggzt (1).jpg')",
          "background-image:url('http://127.0.0.1:8090/backstage/imgs/ggzt (2).jpg')",
          "background-image:url('http://127.0.0.1:8090/backstage/imgs/ggzt (3).jpg')",
          "background-image:url('http://127.0.0.1:8090/backstage/imgs/ggzt (4).jpg')",
          "background-image:url('http://127.0.0.1:8090/backstage/imgs/ggzt (1).gif')",
          "background-image:url('http://127.0.0.1:8090/backstage/imgs/hifan (3).jpg')"

        ]


      };


    },
  methods:{
          changeAdv(i){
            this.advs_index=i;
          },


          // 停止轮播广告方法
          rolladvs_stop(){
            window.clearInterval(this.timer1);
          },
          // 启动轮播广告方法
          rolladvs_start(){
            var ob=this;

            ob.timer1=window.setInterval(function(){

              ob.advs_index++;
              if(ob.advs_index==3){
                ob.advs_index=0;

  			  ob.timer2=window.setInterval(function(){
  				  ob.advs_index=3;
  			  },6000)
              }
  if(ob.advs_index==6){
  	ob.advs_index=3;
  	ob.timer3=window.setInterval(function(){
  	                  ob.advs_index=6;


  	                },6000);
  }
   if(ob.advs_index==9){
                  ob.advs_index=6;
                  ob.timer4=window.setInterval(function(){
                    ob.advs_index=0;


                  },6000*60*60);
                }



            },1000);

          }
        },
        mounted(){
            this.rolladvs_start();
        }



    }


</script>

<style>
  .dv_rolladvs{

      width: 100%;
      height: 340px;
      position: relative;
      z-index: 2;
    }

  .dv_themes{
    width:310px;

    height: 100%;
    float:left;
    margin-left: 20px;
  }

   .dv_themes .dv_theme{

     float:left;
     width: 47%;
      height: 105px;
      background-color: orangered;
      background-size: 100%;
      margin: 1.5%;
      border-radius: 6px;
      transition: all 0.3s;
   }
    .dv_themes .dv_theme:hover{
      background-size: 150%;
      cursor: pointer
    }


    .dv_advs{
      width: 900px;
      height: 100%;
      float: left;
      margin-left: 70px;
      position: relative;
      border-radius: 6px;
    }

    .dv_adv{
      width: 100%;
      height: 100%;
      position: absolute;
      border-radius: 9px;
      background-position-y: -1px;

    }
    .fade-enter-active, .fade-leave-active {
      transition: opacity .5s;
    }
    .fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
      opacity: 0;
    }

    .dv_btns{
      width: 100%;
      height: 50px;

      position: absolute;
      bottom: 20px;
      text-align: right;

    }
     .dv_btns button{
        margin-right: 20px;
        margin-top: 30px;
        border: 0px;
        width: 30px;
        height: 8px;
        background-color: #EE6688;
        border-radius: 3px;
        box-shadow: 0px 0px 2px 2px #FFFFFF;
     }
      .dv_btns .btn_index{
         background-color: orange;
      }


</style>
