<style>
  .dv_sser{
    width: 600px;
    height: 400px;
    position: absolute;
    left: 400px;
    margin-top: 20px;
    background-color: coral;
  }
  .dv_sser input{
      margin-left: 15px;
      width: 200px;
      height: 30px;
  }
  .dv_sser button{
    margin-top: 25px;
    margin-left: 65px;
    width: 100px;
    height: 50px;
    border-radius: 10px;
  }
  .dv_sser .dv_ming{
    text-align: right;
    /* float: right;
    margin-right: 15px; */
  }
  .dv_sser tr{
    height: 80px;
  }


</style>

<template>
  <div>
    <merchantbrowse></merchantbrowse>
    <br /><br />
    <div class="dv_sser">
      <br /><br />
      <form>
        <tr>
          <td class="dv_ming">店铺名：</td>
          <td>
            <input type="text" v-model="dianming" placeholder="请输入店铺名"/>
          </td>
        </tr>
        <tr>
          <td class="dv_ming">联系方式：</td>
          <td>
            <input type="text" v-model="dilian" placeholder="请输入商家联系地址"/>
          </td>
        </tr>
        <tr>
          <td class="dv_ming">联系地址：</td>
          <td>
            <input type="text" v-model="dianlian" placeholder="请输入商家联系方式"/>
          </td>
        </tr>
        <tr>
          <button v-for="i in 1" @click="domerchant(i.dianlian,i.dianming,i.dilian)" style="background-color: greenyellow;">完成</button>
        </tr>
      </form>
    </div>
  </div>


</template>

<script>
  import merchantbrowse from '@/components/merchantbrowse.vue'
  export default{

   components:{
      merchantbrowse
    },
    data(){
      return{
        dianming:"",
        dianlian:"",
        dilian:""
      }
    },
    methods:{
      domerchant(dianming,dianlian,dilian){
        this.$router.push({
          name:"merchant",
          query:{
            dianming:dianming,
            dianlian:dianlian,
            dilian:dilian
          }
        })
      }
    }
  }
</script>
