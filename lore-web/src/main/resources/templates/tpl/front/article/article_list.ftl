<#include "/includes/taglib.ftl" />
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <title>资料分类</title>
  <#include "/includes/head.ftl" />
<#include "/includes/laypage-css.ftl" />
    <style>
        .tab-pane{
            padding-top:30px;
        }
        .panel-heading {
            padding: 5px 13px;
        }
        .panel-heading  h4{
            border-left: 2px solid #f35d5d;
            padding-left:15px;
            margin-left:-13px;
        }
        .main-panel .panel-heading{
            padding: 0px 15px;
        }
        .main-panel{
            margin-top: -20px;
        }
        .table td{white-space:nowrap;overflow:hidden; text-overflow:ellipsis; }
        .table  {table-layout:fixed;}
        .table th{vertical-align:middle !important;text-align: center; font-size:14px;}
        .Wdate{
            height: 32px !important;
            padding: 3px 1px !important;
            border: 1px solid #ccc !important;
        }
        .form-search select{
            padding: 6px 3px  !important;
        }
        .form-inline .form-group,.form-inline .form-control{
            width: 100px;
            display: inline;
        }
        @media (max-width: 900px){
            .panel-heading{
                padding: 10px 0px !important;
            }
        }
        .laypage_main{
            clear: none !important;
        }
    </style>
<#assign template="docs"/>
</head>
<body class="page-header-fixed">
<!-- toolbar begin-->
<#include "/index-toolbar.ftl"/>
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
            <div class="">
                <ul id="my-tab-rule" class="myNavTab nav nav-tabs" role="tablist">
                    <li role="presentation" style="cursor:pointer" class="active">
                        <a id="my-tab-all" data-key="">
                            文章列表
                        </a>
                    </li>
                </ul>
            </div>
            <div class="panel-body">
                <!---文档begin--->
                <div class="col-md-12  col-xs-12">
                    <div class="row">
                        <form class="form-search form-inline" id="search_form">
                            <input type="hidden" name="page" id="page" value="1">
                        </form>
                    </div>
                    <div  class="bs-table-tbody"  >
                        <ul class="list-group" id="table-tbody"   >
                              <#if (result.content?size<=0) >
	          		               <tr ><td class="text-center" scope="row" colspan='3' ><@spring.message  code="label.default.empty" /></td></tr>
                              <#else>
                                  <#list result.content as article>
                                      <li class="list-group-item">
                                          <span class="item-type" style="padding-right: 50px;">[${article.type}]</span>
                                          <a class="item-href"  href="${contextPath}/article/${article.id}.jhtml"
                                             target="_blank" >${article.title}</a>
                                          <span class="pull-right">${article.pushTime}</span>
                                      </li>
                                  </#list >
                              </#if>
                        </ul>
                            <script id="tr-template-js"  type="text/html">
                                {{if (content.length>0) }}
                                {{each content as article}}
                                    <li class="list-group-item">
                                        <span class="item-type" style="padding-right: 50px;">[{{article.type}}]</span>
                                        <a class="item-href"  href="${contextPath}/article/{{article.id}}.jhtml"
                                           target="_blank" >{{article.title}}</a>
                                        <span class="pull-right">{{article.pushTime}}</span>
                                    </li>
                                {{/each}}
                                {{else}}
                                <tr id="ext_{{$index}}" class="text-center" >
                                    <td colspan="6"><@spring.message  code="label.default.empty" /></td>
                                </tr>
                                {{/if}}
                            </script>
                    </div>
                    <!-----分页-begin---->
                    <div  id="table-pagination" data-totalPages="${result.totalPages}" data-number="${result.number}" style="margin-top: -15px;"  class="clearfix"></div>
                    <!-----分页-end---->

                </div>
                <!---文档end--->
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
<!------footer信息 end----->
  	<#include "/includes/datePicker.ftl" />
<script>
    seajs.use(["js/cms/article.js?v="+Math.random(),"js/left-menu.js?v="+Math.random()]);
</script>
</body>
</html>