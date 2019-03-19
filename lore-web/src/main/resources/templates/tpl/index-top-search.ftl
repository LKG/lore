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
        <form class="bs-example bs-example-form" style="margin-left: 370px;">
            <div class="row">
                <div class="col-lg-7">
                    <div class="input-group" >
                        <input type="text" class="form-control" aria-label="Text input with multiple buttons">
                        <div class="input-group-btn">
                            <select class="form-control" style="width: 110px;padding:6px; 10px;">
                                <option val="0" >主题</option>
                                <option val="1" >关键词</option>
                                <option val="2" >篇名</option>
                                <option val="3" >全文</option>
                                <option val="4" >作者</option>
                                <option val="5" >单位</option>
                                <option val="6" >摘要</option>
                                <option val="7" >被引文献</option>
                                <option val="8" >中图分类号</option>
                                <option val="9" >文献来源</option>
                            </select>
                            <button type="button"  id="btn-search" class="btn btn-primary">搜索</button>
                        </div>
                    </div><!-- /.input-group -->
                </div><!-- /.col-lg-6 -->
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
                <a type="button" id="btn-desk"class="btn btn-primary pull-right" href="${contextPath}/userinfo/desk.jhtml" >
                    <i class="fa fa-cloud-upload">上传我的文档</i>
                </a>
            </div><!-- /.row -->
        </form>
    </div>
</div>
<#include "/includes/jquery.ftl" />