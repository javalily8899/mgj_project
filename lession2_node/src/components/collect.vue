
<style>
</style>

<template>
  <div>
    <goodsbrowse></goodsbrowse>
    <goodstable2></goodstable2>
    <beatgoods></beatgoods>
    <div>
      <table>
        <tr>
          <td>编号</td>
          <td>商品图片</td>
          <td>商品名称</td>
          <td>价格</td>
          <td>删除</td>
        </tr>
        <tr v-for="(a,index) in collests">
          <td>{{a.ctid}}</td>
          <td>
             <div class="shop_gimg" :style="a.gimgurl"></div>
          </td>
          <td>{{a.gdname}}</td>
          <td>{{a.price}}</td>
          <td>
             <i class="fa fa-close fa-2x"></i><!-- 点击删除 -->
          </td>
        </tr>
      </table>
      <div class="text-right">
      	<button @click="showcollectgoods(1)">首页</button>

      	<button @click="showcollectgoods((pagenum-1)<1?1:(pagenum-1))">上一页</button>

      	<button v-for="c in pagecount" @click="showcollectgoods(c)" class="btn" :class="{'btn-primary':c==pagenum,'btn-link':c!=pagenum}">{{c}}</button>

      	<button @click="showcollectgoods((pagenum+1)>pagecount?pagenum:(pagenum+1))">下一页</button>

      	<button @click="showcollectgoods(pagecount)">尾页</button>
      </div>
    </div>




  </div>
</template>

<script>
  import goodsbrowse from '@/components/goodsbrowse.vue'
  import goodstable2 from '@/components/goodstable2.vue'
  import beatgoods from '@/components/beatgoods.vue'
  export default{
    components:{
      goodsbrowse,
      goodstable2,
      beatgoods
    },
    data(){
      return{
        collests:[],
        pagenum:1,
        pagecount:0

      }
    },
    methods:{
      /* 显示收藏的商品详情*/
      showcollectgoods(bn){
        var ob=this;
        ob.pagenum=bn;
        var url = "http://127.0.0.1:8090/Goods_shop1/collect/showshopcar"
        $.ajax(url,{
          async:false,
          data:{
            pagenum:ob.pagenum,
          },
          success:function(result){
            ob.collests=result.array;
            for(var a in ob.collests){
              ob.collests[a].gimgurl="background-image:url('http://127.0.0.1:8090/Goods_shop1/imgs/tp/"+ob.collests[a].gimgurl + "')";

            }
            ob.pagecount=result.pagecount;
          },
          xhrFields:{
            withCredentials:true
          }
        })
      }
    },
    mounted() {
      this.showshopcarpage(this.pagenum);
    }

  }
</script>
