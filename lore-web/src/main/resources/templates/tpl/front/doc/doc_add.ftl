<#include "/includes/taglib.ftl" />
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<title><@spring.message  code="label.system.index" /></title>
  <#include "/includes/head.ftl" />
  	<style>
	#project-select p{
		padding: 10px 0px;
	}
	#project-select ul p{
		padding: 10px 15px;
		color: #337ab7;
		border-radius: 4px;
		display: block;
 		text-decoration: none;
 		cursor: pointer;
	}
	#project-select .nav-pills>li.active>p, #project-select .nav-pills>li.active>p:focus, 
	#project-select .nav-pills>li.active>p:hover{
		color: #fff;
  		background-color: #337ab7;
	}
	</style>
	 <#assign template="project"/>
</head> 
<body class="page-header-fixed">
	<!------页面header信息 begin----->
	<#include "/template/header-navbar-top.ftl" />
	<#include "/template/header-navbar-heart.ftl" />
	<!------页面header信息 end----->
	<div class="clearfix" ></div>
	<div class="container" id="heard-container">
		<div class="panel panel-default" id="project-select">
			<div class="panel-body">
				<div class="row" >
					<div class="col-xs-1 text-right"><p >状态：</p></div>
		  			<div class="col-xs-11">
		  				<ul class="nav nav-pills">
					      <li role="presentation" class="active"><p >全部</p></li>
					      <li data-period="1"><p>预热期</p></li> 
					      <li data-period="2"><p>众筹期</p></li> 
					      <li data-period="3"><p>建设期</p></li> 
					      <li data-period="4"><p>众筹成功</p></li> 
					    </ul>
					</div>
				</div>
				<!----
				<div class="row" >
					<div class="col-xs-1 text-right"><p >类型：</p></div>
		  			<div class="col-xs-11">
		  				<ul class="nav nav-pills">
					      <li data-building-type="all"  class="active"><p>全部</p></li>
					      <li data-building-type="1"><p >住宅</p></li> 
					      <li data-building-type="2"><p >城市公寓</p></li> 
					      <li data-building-type="3"><p >旅游地产</p></li> 
					    </ul>
					</div>
				</div>
				----->
				<!----
				 <div class="row" >
					<div class="col-xs-1 text-right"><p >所在地：</p></div>
		  			<div class="col-xs-11">
					 <ul class="nav nav-pills"> 
				      <li data-city="all" class="active"><p>全部</p></li> 
				      <li data-city="52"><p>北京</p></li> 
				      <li data-city="321"><p>上海</p></li> 
				      <li data-city="76"><p>广州</p></li> 
				      <li data-city="311"><p>西安</p></li> 
				      <li data-city="220"><p>南京</p></li> 
				      <li data-city="283"><p>济南</p></li> 
				      <li data-city="270"><p>银川</p></li> 
				      <li data-city="388"><p>宁波</p></li> 
				      <li data-city="148"><p>张家口</p></li> 
				      <li data-city="-1"><p>海外</p></li> 
				     </ul> 
					</div>
				</div>
				----->
				<!---
				<div class="row" >
					<div class="col-xs-1 text-right"><p >排序：</p></div>
		  			<div class="col-xs-11">
					 	<div class="btn-group" role="group" aria-label="Basic example">
					      <button type="button" class="btn btn-default">综合推荐</button>
					      <button type="button" class="btn btn-default">最近上线</button>
					      <button type="button" class="btn btn-default">金额最多</button>
					    </div>
					</div>
				</div>
				--->
			</div>
		</div>
	</div>
	<div class="container" id="template-container">

	</div>
   	<!------footer信息 begin----->
  	<#include "/includes/footer.ftl" />
  	<#include "/includes/footer-js.ftl" />
  	<!------footer信息 end----->
<!------seajs.config 引用信息 begin----->
<#include "/includes/seajs.config.ftl" />
<!------seajs.config   引用信息 end----->
 <script>
  	seajs.use("js/project/index");
</script>
<script id="msg-template-js" type="text/html">
	<#include "/template/product_list.ftl" />
</script>
<#include "/includes/mechat.config.ftl" />
</body>
</html>