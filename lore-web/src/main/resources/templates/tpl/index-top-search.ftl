<div class="w" style="height: 77px;">
    <!-- -->
    <div id="logo" class="logo">
        <h1 class="logo_tit">
            <a href="${contextPath}/" class="logo_tit_lk" ><@spring.message  code="label.system.name" /></a>
        </h1>
        <h2 class="logo_subtit"><@spring.message  code="label.system.name" />,为您提供愉悦的资料分享体验!</h2>
        <div class="logo_extend" ></div>
        <a href="${contextPath}/" class="logo_scene logo_scene_hide" target="_blank" >
            <div class="logo_scene_img" style="background-image: url(&quot;//img1.360buyimg.com/da/jfs/t23587/127/1446750136/117942/e88b571d/5b5edcf8N17e6ab2a.gif?v=0.7380383504326977&quot;);"></div>
            <span class="logo_scene_text" style="color: rgb(142, 81, 63);">好资料不容错过</span>
            <span class="logo_scene_btn" style="color: rgb(142, 81, 63); background-color: rgb(255, 255, 255);">去看看&gt;</span>
        </a>
    </div>
    <!-- --->
    <div class="search" style="height: 26px;">
        <input type="text"  value="" class="text" id="textt">
        <button id="btn-search"  class="button">搜索</button>
        <div class="hotwords">
            <a href="#" class="red">毕业答辩</a>
            <a href="#">个人简历</a>
            <a href="#">财务报表</a>
            <a href="#">总结计划</a>
            <a href="#">购销存</a>
        </div>
        <div class="right" style="margin-left: 10px;">
            <i class="gw-left fa fa-lg fa-cart-arrow-down"></i>
            <i class="gw-right">></i>
            <i class="gw-count">0</i>
            <a href="#">我的购物车</a>
            <div class="dorpdown-layer">
                <img src="${contextPath}/images/settleup-nogoods.png">
                购物车中还没有商品，赶紧选购吧！
            </div>
        </div>
        <a type="button" id="btn-desk" style="margin-left: 10px;"
           class="btn btn-primary pull-right" href="${contextPath}/userinfo/desk.jhtml" ><i class="fa fa-cloud-upload">上传我的文档</i></a>
    </div>
</div>
<#include "/includes/jquery.ftl" />
<script>
    $(function(){
        $("#btn-search").on("click",function () {
            alert("@@");
        });
    });
</script>