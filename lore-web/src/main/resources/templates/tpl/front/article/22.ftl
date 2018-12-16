<#include "/includes/taglib.ftl" />
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<title>文章列表</title>
  <#include "/includes/head.ftl" />
  <#include "/includes/laypage-css.ftl" />
	<style>
        .borline {
            border-bottom: 1px dotted #BFBFBF;
            overflow: hidden;
            zoom: 1;
        }
        .news-type-list {
            width: 940px;
            height: 996px;
            box-sizing: border-box;
            overflow: hidden;
            padding: 20px 40px 0 40px;
            position: relative;
        }
    </style>
<#assign template="helps"/>
</head> 
<body class="page-header-fixed">
<!-- toolbar begin-->
<#include "/index-toolbar.ftl"/>
<!-- toolbar end-->
<!-----------------------------------------顶部-------------->
<!-- header begin-->
<#include "/index-header.ftl" />
	<div class="container" id="main-container" style="margin-top: 35px;">
		<div class="row">
			<div class="col-xs-12" >
                <div class="panel panel-default">
                    <div class="">
                        <ul id="my-tab-rule" class="myNavTab nav nav-tabs" role="tablist">
                            <li role="presentation" style="cursor:pointer" class="active">
                                <a id="my-tab-all" data-key="">
                                    文章列表
                                </a>
                            </li>
                        </ul>
                    </div>
                    <form class="form-search form-inline" id="search_form" >
                        <div class="form-group" >
                            <input type="hidden" name="page" id="page" value="1" />
                            <input type="hidden" name="size" id="size" value="10" />
                        </div>
                    </form>
                    <div class="panel-body" id="J_newsListContainer">
                        <ul class="list-group" >
                           <#list result.content as article>
                                <li class="list-group-item">
                                    <span class="item-type" style="padding-right: 50px;">[${article.type}]</span>
                                    <a class="item-href"  href="${contextPath}/article/${article.id}.jhtml"
                                       target="_blank" >${article.title}</a>
                                    <span class="pull-right">${article.pushTime}</span>
                                </li>
                            </#list>
                        </ul>
                    </div>
                    <!-----分页-begin---->
                    <div  id="article-pagination" data-totalPages="${result.totalPages}" data-number="${result.number}"  class="clearfix"></div>
                    <!-----分页-end---->
                    <script id="article-template-js"  type="text/html">
                        <ul class="list-group" >
                            {{each content as article}}
                            <li class="list-group-item">
                                <span class="item-type" style="padding-right: 50px;">[{{article.type}}]</span>
                                <a class="item-href"  href="${contextPath}/article/{{article.id}}.jhtml"

                                   target="_blank" >{{article.title}}</a>
                                <span class="pull-right">{{article.pushTime}}</span>
                            </li>
                            {{/each}}
                        </ul>
                    </script>
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
<script>
    seajs.use(["/js/cms/article.js?v="+Math.random(),"js/userinfo/user-sign.js?v="+Math.random()]);
</script>
</body>
</html>