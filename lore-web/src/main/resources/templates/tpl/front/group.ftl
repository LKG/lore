<#include "/includes/taglib.ftl" />
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<title>关于我们</title>
  <link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css?v=${ver!'1'}" />
  <#include "/includes/head.ftl" />
<#assign template="contact"/>
</head> 
<body class="page-header-fixed">
<!-- toolbar begin-->
<#include "/index-toolbar.ftl"/>
<!-- toolbar end-->
<!-----------------------------------------顶部-------------->
<!-- header begin-->
<#include "/index-header.ftl" />
<!-- header end-->
<div class="clear"></div>
<!--轮播图上方导航栏  一栏-->
<div class="clearfix" ></div>
<div class="container" style="margin-top: 35px" id="main-container">

    <div class="panel panel-info">
        <div class="panel-heading">官方推荐资料群</div>
        <div class="panel-body">
        <div class="row">
          <#list ["hello","welcome","hi","hello","welcome","hi","hi","hello","welcome","hi","hi","hello","welcome","hi","hi","hello","welcome","hi","hi"] as word >
                  <div class="col-sm-4 col-md-3">
                      <div class="thumbnail">
                          <img src="http://127.0.0.1:9080/images/qq_vip.jpg" style="width: 200px;" alt="...">
                          <div class="caption">
                              <p></p>
                          </div>
                      </div>
                  </div>
          </#list>
          </div>
        </div>
        <div class="panel-footer">Panel footer</div>
    </div>
</div>
   	<!------footer信息 begin----->
  	<#include "/includes/footer.ftl" />
  	<#include "/includes/footer-js.ftl" />
  	<!------footer信息 end----->
<!------seajs.config 引用信息 begin----->
<#include "/includes/seajs.config.ftl" />
<!------seajs.config   引用信息 end----->

</body>
</html>