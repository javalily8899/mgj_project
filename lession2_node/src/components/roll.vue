<style>
  .table2_whole{
    width: 100%;
    z-index: 9;
  }
  .dv_advs{
      width: 880px;
      height: 420px;
      float: left;
      margin-left: 60px;
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
  .theme{
    width: 300px;
    height: 421px;
    float: left;
    margin-bottom: 40px;
  }
  .dvp{
  width: 140px;
  height: 130px;
  float: right;
  margin: 3px;
  border-radius: 8px;
  }
  .dvp:hover{
    transform: translateY(-5px);
     box-shadow: 0px 4px 6px gray;
  }
</style>
<template>
  <div class="table2_whole">
    <div class="dv_advs" @mouseover="rolladvs_stop()" @mouseout="rolladvs_start()">
         <!-- 根据 数组 遍历产生的 切换广告div-->
        <transition name="fade" v-for="(ad,i) in advs" >
        <div class="dv_adv" :style="ad" v-if="i==advs_index" ></div>
        </transition>

        <div class="dv_btns">
              <button v-for="i in advs.length" @mouseover="changeAdv(i-1)" :class="{'btn_index':(i-1)==advs_index}" ></button>
        </div>
    </div>

    <div class="theme">
      <div class="dvp" v-for="a in array_theme" :style="a"></div>

    </div>

  </div>




</template>

<script>
  export default{
    data(){
      return{
        timer1:"",
        advs_index:0,
        advs:[
          "background-image:url(http://127.0.0.1:8090/Goods_shop1/imgs/rolladv/gg1.png)",
          "background-image:url(http://127.0.0.1:8090/Goods_shop1/imgs/rolladv/gg2.png)",
          "background-image:url(http://127.0.0.1:8090/Goods_shop1/imgs/rolladv/gg3.png)"

        ],
        array_theme:[
          "background-image:url(http://127.0.0.1:8090/Goods_shop1/imgs/theme_p/a1.gif)",
          "background-image:url(http://127.0.0.1:8090/Goods_shop1/imgs/theme_p/a2.jpg)",
          "background-image:url(http://127.0.0.1:8090/Goods_shop1/imgs/theme_p/a3.jpg)",
          "background-image:url(http://127.0.0.1:8090/Goods_shop1/imgs/theme_p/a4.jpg)",
          "background-image:url(http://127.0.0.1:8090/Goods_shop1/imgs/theme_p/a5.jpg)"
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
            if(ob.advs_index==ob.advs.length){
              ob.advs_index=0;
            }
          },2000);

        }
      },
      mounted(){
          this.rolladvs_start();
      }

  }
</script>
