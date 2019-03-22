<#include "/includes/taglib.ftl" />
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <#include "/includes/head.ftl" />
    <meta name="baidu-site-verification" content="v9ouxuGJew" />
    <title>公文-会议发言稿-工作总结-<@spring.message  code="label.system.name" />-党政- 十九大</title>
    <meta name="description" content="<@spring.message  code="label.system.name" />,为您提供愉悦的资料分享体验!" />
    <meta name="Keywords" content="公文、公文库、ppt模板下载、简历模板、视频教程、ppt素材库、工作总结、工作计划、调研报告、竞聘演讲稿、会议发言稿、学习心得体会、入党申请书、应用公文、论文范文、范文写作技巧" />
    <link href="${contextPath}/css/main.css?v=${ver!'1'}" type="text/css" rel="stylesheet">
    <style>
        a {
            color: #666;
            text-decoration: none;
        }
        a:hover {
            cursor:pointer;
            text-decoration: none;
        }
        #gonggao-login-container .login-layout .login-footer {
            position: absolute;
            left: 0;
            bottom: 0;
            width: 100%;
            height: 177px;
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            overflow: hidden;
            background: url(https://gonggao.xuexi.cn/public/img/layout-footer.c0db2aaa.png) no-repeat bottom;
            background-size: contain;
        }
    </style>
    <style type="text/css">
        .counter{
            padding: 20px 0;
            text-align: center;
            position: relative;
        }
        .counter .counter-content{
            width: 100px;
            height: 100px;
            border-radius: 50%;
            background: #fff;
            z-index: 1;
            position: relative;
            transition: all 0.3s ease 0s;
        }
        .counter .counter-content:before{
            content: "";
            width: 122%;
            height: 122%;
            border-radius: 50%;
            border: 15px solid #f19f48;
            border-bottom: 20px solid transparent;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
        }
        .counter .counter-value{
            font-size: 16px;
            font-weight: 700;
            color: rgba(0,0,0,0.7);
            line-height: 80px;
        }
        .counter.red .counter-content:before{
            border-color: #ef5f61;
            border-bottom-color: transparent;
        }
        .counter.red .counter-content:after{ border-top-color: #ef5f61; }
        .counter.red .counter-icon{ color: #ef5f61; }
        .counter.red .title{ background: #ef5f61; }
        .counter.blue .counter-content:before{
            border-color: #4d9fcf;
            border-bottom-color: transparent;
        }
        .counter.blue .counter-content:after{ border-top-color: #4d9fcf; }
        .counter.blue .counter-icon{ color: #4d9fcf; }
        .counter.blue .title{ background: #4d9fcf; }
        .counter.purple .counter-content:before{
            border-color: #a98ceb;
            border-bottom-color: transparent;
        }
        .counter.purple .counter-content:after{ border-top-color: #a98ceb; }
        .counter.purple .counter-icon{ color: #a98ceb; }
        .counter.purple .title{ background: #a98ceb; }
    </style>
</head>
<body id="top">
<!-- toolbar begin-->
<#include "/index-toolbar.ftl"/>
<!-- toolbar end-->
<!-----------------------------------------顶部-------------->
<!-- header begin-->
<#include "/index-header.ftl" />
<!-- header end-->
<!-- banner 广告 begin-->
<#include "/index-top-banner.ftl" />
<!-- banner 广告 end-->
<!-- 搜索框 begin-->
<#include "index-top-search.ftl" />
<!-- 搜索框 end-->
<!--轮播图上方导航栏  一栏-->
<#include "index-nav-top.ftl" />
<#include "index-nav-left.ftl" />
<!------------------------------------轮播图------------------------------------>
<div id="lunbo">
    <ul id="one">
        <li><a href=""><img src="https://bootcdn.xuexi.cn/dyxx_5a1d70322da1335610ea6a87/1552620657482/8cb6f33f8d76e643bde4b678f0f7855e.jpg?x-oss-process=image/resize,w_590,h_470"></a></li>
        <li><a href=""><img src="https://bootcdn.xuexi.cn/dyxx_5a1d70322da1335610ea6a87/1552540175381/8e5493527de2c30dac541811f24ec4d6.jpg?x-oss-process=image/resize,w_590,h_470"></a></li>
        <li><a href=""><img src="http://media.people.com.cn/NMediaFile/2019/0304/MAIN201903040810553940275526231.jpg" alt="一带一路”建设的成就与挑战"></a></li>
    </ul>
    <ul id="two">
        <#list [1,2,3] as img>
            <li class="<#if img_index==0>on</#if>" >${img_index+1}</li>
        </#list>
    </ul>
    <!------------------------------------轮播图左右箭头------------------------>
    <div class="slider-page">
        <a href="javascript:void(0)" id="left"><</a>
        <a href="javascript:void(0)" id="right">></a>
    </div>
</div>
<div class="m1" style="">
    <div id="J_rec" class="J_rec rec">
        <div class="rec_inner" style="padding-left: 25%;">
            <div class="rec_item">
                <a class="rec_lk mod_loading" href="javascript:void(0)" target="_blank" >
                    <div class="counter  red">
                        <div class="counter-content" title="收录文章数量">
                            <i class="fa fa-archive"></i>
                            <span class="counter-value">
                                <#if articles??> ${articles.totalElements!'0'}</#if>
                               </span>
                        </div>
                    </div>
                </a>
            </div>
            <div class="rec_item">
                <a class="rec_lk mod_loading" href="javascript:void(0)" target="_blank" >
                    <div class="counter blue">
                        <div class="counter-content" title="文档数量">
                            <i class="fa fa-book"></i>
                            <span class="counter-value">
                                <#if docs??> ${docs.totalElements!'0'}</#if>
                             </span>
                        </div>
                    </div>
                </a>
            </div>
            <div class="rec_item">
                <a class="rec_lk mod_loading" href="javascript:void(0)" target="_blank" >
                    <div class="counter">
                        <div class="counter-content" title="用户数量">
                            <i class="fa fa-group"></i>
                            <span class="counter-value">18163</span>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>
<!------------------------------------轮播图右侧一栏------------------------>
<div class="m">
    <div class="mt" style="padding-top: 5px;">
        <h3>天天快报</h3>
        <div class="extra"><a href="${contextPath}/articles.jhtml">更多 ></a></div>
    </div>
    <#if articles??&&articles.content??>
        <#list articles.content as article>
            <div class="mc">
                <ul>
                    <li><a href="${contextPath}/article/${article.id}.jhtml" ><span>[${article.type}]</span>${article.shortTitle}</a></li>
                </ul>
            </div>
        </#list>
    </#if>
</div>

<#include "index-main.ftl" />
</div>
<!------footer信息 begin----->
<#include "/includes/footer.ftl" />
<#include "/includes/footer-js.ftl" />
<!------footer信息 end----->
<!------seajs.config 引用信息 begin----->
<#include "/includes/seajs.config.ftl" />
<!------seajs.config   引用信息 end----->
<div id="app">
    <div id="gonggao-login-container">
        <div class="login-layout"><div class="login-content"><div class="login-logo"></div>
            <div class="login-txt"> · 学习平台供稿系统</div>
            <div>
                <div>


            </div>
            </div>
             </div>
            <div class="login-footer"></div>
        </div>
    </div>
</div>
</body>
<#include "/includes/jquery.ftl" />
<script src="js/index.js?v=${ver!'1'}"></script>
</html>