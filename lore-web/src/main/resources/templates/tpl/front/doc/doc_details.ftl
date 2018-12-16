<#include "/includes/taglib.ftl" />
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <title>${result.periodicalName!''}详情</title>
  <#include "/includes/head.ftl" />
    <style>
        .tab-pane{
            padding-top:30px;
        }
        .panel-heading #focus-btn,.panel-heading #cart-btn,.panel-heading #vip-btn,.panel-heading #down-btn{
            margin-top: -27px;
        }
        .panel-heading  h4{
            border-left: 2px solid #f35d5d;
            padding-left:15px;
            margin-left:-13px;
        }
        .isStuck{
            z-index: 99;
            /*min-width: 77%;*/
            left: 15px;
            right: 15px;
        }
        .originPrice{
            text-decoration: line-through;
        }
    </style>
<#assign template="project"/>
</head>
<body class="page-header-fixed">
<!-- toolbar begin-->
<#include "/index-toolbar.ftl" />
<!-- toolbar end-->
<!-----------------------------------------顶部-------------->
<!-- header begin-->
<#include "/index-header.ftl" />
<!-- banner 广告 begin-->
  <#include "/index-top-banner.ftl" />
<!-- banner 广告 end-->
<div class="container" style="margin-top: 35px;">
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading" id="doc-nav-top" ><h4>${result.periodicalName!''}</h4>

                <a type="button" id="vip-btn" class="btn pull-right" target="_blank" href="${contextPath}/vip.jttml" ><i class="fa fa-free-code-camp">加入Vip免费下载</i></a>
                <a type="button" id="down-btn" class="btn btn-danger pull-right" href="${contextPath}/order/getOrderInfo.jhtml?id=${result.id!''}" ><i class="fa  fa-cloud-download">立即下载</i></a>
                <button type="button" id="focus-btn" class="btn btn-danger pull-right" data-url="${contextPath}/doc/${result.id}/collect.json"><i class="fa heart fa-lg"></i><span id="collect-txt">收藏</span></button>

                <button type="button" id="cart-btn" class="btn btn-primary pull-right hide" data-url="${contextPath}/doc/${result.id}/praise.json" ><i class="fa fa-cart-plus">加入购物车</i></button>

            </div>
            <div class="panel-body">
                <!---文档左侧begin--->
                <div class="col-md-9  col-xs-9">
                    <div class="row">
				       <#include "/front/doc/template/doc_carousel.ftl" />
                    </div>
                </div>
                <!---文档左侧end--->
                <!---文档右侧begin--->
                <div class="col-md-3 col-xs-3">
                    <!---点赞面板begin--->
  				    <#include "/front/doc/template/doc-goods.ftl" />
                    <!---点赞面板end--->
                </div>
                <!---文档右侧end--->
            </div>
        </div>
    </div>
</div>
<!------footer信息 begin----->
  	<#include "/includes/footer.ftl" />
  	<#include "/includes/footer-js.ftl" />
<!------footer信息 end----->
<!------seajs.config 引用信息 begin----->
<#include "/includes/seajs.config.ftl" />
<!------seajs.config   引用信息 end----->
<#include "/includes/jquery.ftl" />
<#include "/includes/stickUp.ftl" />
<script type="text/javascript">
    //initiating jQuery
    jQuery(function($) {
        $(document).ready( function() {
            $('#doc-nav-top').stickUp();
        });
    });

</script>
<script>
    seajs.use("js/doc/init");
</script>
</body>
</html>