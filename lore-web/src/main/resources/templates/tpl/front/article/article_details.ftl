<#include "/includes/taglib.ftl" />
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <#include "/includes/head.ftl" />
    <title>${result.type!''}${result.itle!''}</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css?v=${ver!'1'}" />
    <meta name="Keywords" content="${result.seoKeywords!''}" />
    <meta name="description" itemprop="description"  content="${result.seoDescription!''}" />
    <style>
        .tab-pane{
            padding-top:30px;
        }
        .panel-heading #focus-btn,.panel-heading #cart-btn,.panel-heading #vip-btn,.panel-heading #down-btn{
            margin-top: -27px;
        }
        .panel-heading  h4{
            border-left: 2px solid #189ae5;
            padding-left:15px;
            margin-left:-13px;
        }
        .borline{
            border-bottom: 1px solid #e4e4e4;
            padding-bottom: 2px;
        }
        .artinfo{
            padding-left: 2px;
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

<div class="container" style="margin-top: 15px;">
<ol class="breadcrumb">
    <li><a href="${contextPath}/"><@spring.message  code="label.system.index" /></a></li>
    <li><a href="${contextPath}/articles.jhtml">${result.type!''}</a></li>
    <li class="active">文章</li>
</ol>
</div>
<div class="container" >

    <div class="row" style="padding-bottom: 15px;padding-top: 15px;border: 1px solid #ddd;" >
        <!---文档左侧begin--->
        <div class="col-md-9  col-xs-9" >
            <div class="row" style="padding: 5px 15px">
                <h2 class="newstitle" title="${result.title}">${result.title!''}</h2>
                <div class="borline clearfix">
                    <p class="artinfo">　时间：${result.pushTime!''} |　<span class="author"><#if result.author??><code>${result.author!''}</code></#if></span>  |　字体：【<a class="cgray" href="javascript:zoom(16)">大</a> <a class="cgray" href="javascript:zoom(14)">中</a> <a class="cgray" href="javascript:zoom(12)">小</a>】|　阅读: ${result.hits!''}</p>
                    <!-- <p class="share">分享到：</p> -->
                </div>
                <div class="article-content-dev" style="padding-top: 10px; font-size: 16px;">
                    ${result.content!''}
                </div>
            </div>
        </div>
        <!---文档左侧end--->
        <!---文档右侧begin--->
        <div class="col-md-3 col-xs-3">
            <!---点赞面板begin--->

            <!---点赞面板end--->
        </div>
        <!---文档右侧end--->
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
<script>
    seajs.use("js/cms/article-details.js");
</script>
</body>
</html>