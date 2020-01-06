
<style>
  .page_1{
    width: 100%;
    height: 100%;
  }
  .page_2{
    width: 100%;
    height: 1000px;
  }
  .goodsshow{
    width: 800px;
    height: 300px;
    float: left;
    margin-top: 40px;
  }
  .goodsshow th{
    text-align: center;
  }
  .shop_gimg{
    width: 60px;
    height: 70px;
    background-size: 100%;
  }
  .best_goods{
    width: 260px;
    height: 1000px;
    float: left;
    margin-left: 10px;
  }
</style>

<template>
  <div class="page_1">
    <goodsbrowse></goodsbrowse>
    <goodstable2></goodstable2>
    <div class="page_2">
      <beatgoods></beatgoods>
      <div class="goodsshow">
        <table class="table" style="line-height: 80px; text-align: center;">
          <tr>
            <th>编号</th>
            <th>商品图片</th>
            <th>商品名称</th>
            <th>尺寸</th>
            <th>单价</th>
            <th>数量</th>
            <th>删除</th>
          </tr>
          <tr v-for="(a,index) in shopcolls" style="line-height: 80px;">
            <td>{{a.ctid}}</td>
            <td>
              <div class="shop_gimg" :style="a.gimgurl"></div>
            </td>
            <td>{{a.gdname}}</td>
            <td>{{a.gstext}}</td>
            <td>{{a.price}}</td>
            <td>
              <div style="height: 20px; width: 60px; line-height: 20px;">
                &nbsp;  &nbsp;  &nbsp;  &nbsp;&nbsp; {{a.gdcount}}
              </div>
            </td>
            <td style="color: red;">
              <i class="fa fa-close fa-2x"></i>
            </td>
          </tr>
        </table>
        <div class="text-right">
        	<button @click="showshopcarpage(1)">首页</button>

        	<button @click="showshopcarpage((pagenum-1)<1?1:(pagenum-1))">上一页</button>

        	<button v-for="c in pagecount" @click="showshopcarpage(c)" class="btn" :class="{'btn-primary':c==pagenum,'btn-link':c!=pagenum}">{{c}}</button>

        	<button @click="showshopcarpage((pagenum+1)>pagecount?pagenum:(pagenum+1))">下一页</button>

        	<button @click="showshopcarpage(pagecount)">尾页</button>
        </div>

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
        shopcolls:[],
        counts:[],
        sum:0,

        pagenum:1,
        pagecount:0
      }
    },
    watch:{
      counts:function(){
       this.counts_shop();
      }
    },
    methods:{
      /* 显示收藏详情*/
      showcollect(bn){
        var ob=this;
        ob.pagenum=bn;
        var url = "http://127.0.0.1:8090/Goods_shop1/collect/showcollect"
        $.ajax(url,{
          async:false,
          data:{
            pagenum:ob.pagenum,
          },
          success:function(result){
            ob.shopcolls=result.array;
            for(var a in ob.shopcolls){
              ob.shopcolls[a].gimgurl="background-image:url('http://127.0.0.1:8090/Goods_shop1/imgs/tp/"+ob.shopcolls[a].gimgurl + "')";
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
      this.showcollect(this.pagenum);
    }



  }
</script>
