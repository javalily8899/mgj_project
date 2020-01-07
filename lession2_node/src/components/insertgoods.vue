<style>
  .insert_1{
    width: 100%;
    height: 600px;

  }
  .insert_img{
    width: 100%;
    height: 600px;
    background-image: url(../../static/ww.jpg);
    background-size: 100%;
    background-position: 0px -200px;
  }
  .insert_in{
    width: 500px;
    height: 500px;
    margin-top: 30px;
    margin-left: 380px;
    border-radius: 8px;
    padding: 30px;
    border: 2px dotted black;
    font-size: 16px;
    background-color: white;
    opacity: 0.9;
  }
  .insert_in table tr{
   height: 50px;
  }
  .dv_label{
    width: 80px;
    height: 30px;
    float: left;
    text-align: right;
    margin-top: 3px;
  }
</style>
<template>
  <div class="insert_1">
    <goodsbrowse></goodsbrowse>
    <div class="insert_img">

      <div class="insert_in">
        <table>
          <tr>
            <td>
              <div class="dv_label">
              商品名：
              </div>
            </td>

            <td>
              <input type="text"  placeholder="请输入商品名" class="form-control"/>
            </td>
          </tr>
          <tr>
            <td>
              <div class="dv_label">
              关键字：
              </div>
            </td>
            <td>
              <input type="text"  placeholder="请输入关键字" class="form-control"/>
            </td>
          </tr>
          <tr>
            <td>
              <div class="dv_label">
              选择尺码：
              </div>
            </td>
            <td style="font-size: 16px;">
              S&nbsp;&nbsp;<input type="checkbox" />
              M&nbsp;&nbsp;<input type="checkbox"  />
              L&nbsp;&nbsp;<input type="checkbox"  />
              ML&nbsp;&nbsp;<input type="checkbox"  />
              XL&nbsp;&nbsp;<input type="checkbox"  />
              XXL&nbsp;&nbsp;<input type="checkbox"  />
              均码&nbsp;&nbsp;<input type="checkbox"  />
            </td>
          </tr>
          <tr>
            <td>
              <div class="dv_label">
              填写价格：
              </div>
            </td>
            <td>
               <input type="text"  placeholder="普通用户" class="form-control"/><br />
               <input type="text"  placeholder="VIP" class="form-control"/><br />
               <input type="text"  placeholder="白金" class="form-control"/><br />
               <input type="text"  placeholder="内部用户" class="form-control"/>
            </td>
          </tr>
          <tr>
            <td>
              <div class="dv_label">
              上传图片：
              </div>
            </td>
            <td>
               <input type="file"/>
            </td>
          </tr>
        </table>



      </div>
    </div>

  </div>
</template>

<script>
  import goodsbrowse from '@/components/goodsbrowse.vue'
  export default{
    components:{
      goodsbrowse
    }
  }


</script>
