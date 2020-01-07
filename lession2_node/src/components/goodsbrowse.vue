<style>
  .goodstable{
    height: 35px;
    width: 100%;
    text-align: right;
  }
  .table_1_arrys{
    width: 100%;
    height: 25px;
    float: right;
    margin-right: 30px;
    line-height:50px ;
  }
  .table_1_arrys button{
    border: 0px;
    background-color: white;
  }
  .table_1_arrys a{
     cursor: pointer
  }

</style>

<template>
  <div class="goodstable">
    <div class="table_1_arrys">
      <button @click="tohome_page()">
        <i class="fa fa-home" style="color: gray;" >首页&nbsp;&nbsp;&nbsp;&nbsp;    |</i>
      </button>
      <button @click="tohome_page()">
        <i class="fa fa-gift" style="color: gray;">商城&nbsp;&nbsp;&nbsp;&nbsp;    |</i>
      </button>
      <button @click="tohome_page()">
        <i style="color: gray;">我的订单&nbsp;&nbsp;&nbsp;&nbsp;    |</i>
      </button>
      <button @click="tohome_page()">
         <i style="color: gray;">关于我们</i>
      </button>

      <hr style="color: gainsboro;" />
    </div>

  </div>

</template>

<script>
  export default{
    methods:{
      tohome_page(){
        this.$router.push({name:"home"})
      }
    }
  }
</script>
