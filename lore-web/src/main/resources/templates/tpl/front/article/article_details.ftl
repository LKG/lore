<#include "/includes/taglib.ftl" />
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<title>${result.type}${result.seo_title}</title>
  <link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css?v=${ver!'1'}" />
    <meta name="description" content="${result.seo_description}" />
    <meta name="Keywords" content="${result.seo_keywords}" />

  <#include "/includes/head.ftl" />
	<style>
        .borline {
            border-bottom: 1px dotted #BFBFBF;
            overflow: hidden;
            zoom: 1;
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
                    <div class="panel-body">
                        <h2 class="newstitle" title="${result.title}">${result.title}</h2>
                        <div class="borline clearfix">
                            <p class="artinfo"><span class="author">${result.author}</span>　时间：${result.pushTime}　|　字体：【<a class="cgray" href="javascript:zoom(16)">大</a> <a class="cgray" href="javascript:zoom(14)">中</a> <a class="cgray" href="javascript:zoom(12)">小</a>】|阅读: ${result.hits}</p>
                            <!-- <p class="share">分享到：</p> -->
                        </div>
						<div class="" style="padding-top: 20px;">
							${result.content}

						</div>
                    </div>
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

</body>
</html>