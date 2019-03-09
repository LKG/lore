<#include "/includes/taglib.ftl" />
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="referrer" content="origin" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=1100, maximum-scale=1.0, user-scalable=yes" />
    <link rel="shortcut icon" href="//www.aliyun.com/favicon.ico" type="image/x-icon" />
    <base href="${contextPath}" id="baseRoot"/>
    <base href="${contextPath}" id="baseRoot"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/modules/fontawesome/4.7.0/css/font-awesome.min.css?v=${ver!'1'}" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/modules/nprogress/nprogress.css?v=${ver!'1'}" />
    <link rel="stylesheet" type="text/css" href="${contextPath}/css/animate.css?v=${ver!'1'}" />
    <title><@spring.message  code="label.system.index" /></title>
    <meta name="description" content="为您提供愉悦的资料分享体验!" />
    <meta name="Keywords" content="ppt模板下载，简历模板，PPT定制，视频教程，图片素材下载，ppt素材库、工作总结、工作计划、调研报告、竞聘演讲稿、会议发言稿、学习心得体会、入党申请书、应用公文、论文范文、范文写作技巧" />
    <link rel="stylesheet" href="${contextPath}/modules/bootstrap/3.3.5/css/bootstrap.min.css?v=${ver!'1'}">
    <link href="${contextPath}/css/index.css?v=${ver!'1'}" type="text/css" rel="stylesheet">
    <link href="${contextPath}/css/main.css?v=${ver!'1'}" type="text/css" rel="stylesheet">
    <link rel="stylesheet" href="//piccache.cnki.net/kdn/index/nvsm/nvsmCSS_min/kindex.min.css?v=${ver!'1'}">
    <link rel="stylesheet" href="//piccache.cnki.net/kdn/index/nvsm/nvsmCSS_min/royalslider.min.css?v=${ver!'1'}">
    <link rel="stylesheet" href="//piccache.cnki.net/kdn/index/nvsm/nvsmCSS_min/rs-default.min.css?v=${ver!'1'}">
    <link rel="stylesheet" href="//piccache.cnki.net/kdn/index/nvsm/nvsmCSS_min/index.min.css?v=${ver!'1'}">
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="//piccache.cnki.net/kdn/index/nvsm/nvsmCSS_min/index-ie.min.css?v=${ver!'1'}">
    <![endif]-->
    <base href="${contextPath}" id="baseRoot"/>
    <script type="text/javascript" src="${contextPath}/js/jQuery-hijack.js?v=${ver!'1'}"></script>
    <script type="text/javascript" src="//piccache.cnki.net/kdn/index/nvsm/nvsmScripts/jQuery-1.11.3.min.js?v=${ver!'1'}"></script>
    <script type="text/javascript" src="//piccache.cnki.net/kdn/index/nvsm/nvsmScripts/jquery.cookie.js?v=${ver!'1'}"></script>
    <script type="text/javascript" src="//piccache.cnki.net/kdn/index/nvsm/nvsmScripts/min/GlobalVar.min.js?v=${ver!'1'}"></script>
    <script type="text/javascript" src="//piccache.cnki.net/kdn/index/nvsm/nvsmScripts/min/cachespace.min.js?v=${ver!'1'}"></script>
    <script type="text/javascript" src="//piccache.cnki.net/kdn/index/nvsm/nvsmScripts/jquery.royalslider.js?v=${ver!'1'}"></script>
    <script type="text/javascript" src="//piccache.cnki.net/kdn/index/nvsm/nvsmScripts/min/fieldJson.min.js?v=${ver!'1'}"></script>
    <script type="text/javascript" src="//piccache.cnki.net/kdn/index/nvsm/nvsmScripts/min/slidebox.min.js?v=${ver!'1'}"></script>
    <script type="text/javascript" src="//piccache.cnki.net/kdn/index/nvsm/nvsmScripts/min/index.min.js?v=${ver!'1'}"></script>
    <script type="text/javascript" src="//piccache.cnki.net/kdn/index/nvsm/nvsmScripts/min/cnkisug.min.js?v=${ver!'1'}"></script>
    <script type="text/javascript">
        try {
            CheckTerminalType();
        } catch (e) { }
    </script>
</head>
<body>
<div class="wrapper section1">
    <!-- toolbar begin-->
<#include "/index-toolbar.ftl"/>
    <!-- toolbar end-->
    <!-- header begin-->
    <#include "/index-header.ftl" />
    <!-- header end-->
    <!--header start-->
    <div class="header">
        <div class="head-main">
            <a class="link-home" href="/"></a>
            <!--head-right-->
        </div>
        <!--head-main-->
    </div>
    <!--header end-->
    <!--searchmain start   onclick="LinkDb(this,'http://ref.cnki.net');return false;"-->
    <div class="searchmain">

        <ul class="search-tab">
            <li class="on" val="doc">文献检索</li>
            <li val="ele">知识元检索</li>
            <li val="ref">引文检索</li>
        </ul>
        <div class="search-form">
            <input type="hidden" id="curdbcode" name="curdbcode" value="SCDB">
            <input type="hidden" id="txt_sug" name="txt_sug" value="主题">
            <div class="input-box">
                <div class="sort reopt" id="DBFieldBox">
                    <div class="sort-default">
                        <span>主题</span>
                        <i class="sort-icon">▼</i>
                    </div>
                    <ul class="sort-list" id="DBFieldList">
                        <li class="cur" val="0" field="SU$%=|"><a href="javascript:void(0);">主题</a></li>
                        <li val="1" field="KY$=|"><a href="javascript:void(0);">关键词</a></li>
                        <li val="2" field="TI$%=|"><a href="javascript:void(0);">篇名</a></li>
                        <li val="3" field="FT$%=|"><a href="javascript:void(0);">全文</a></li>
                        <li val="4" field="AU$=|"><a href="javascript:void(0);">作者</a></li>
                        <li val="5" field="AF$%"><a href="javascript:void(0);">单位</a></li>
                        <li val="6" field="AB$%=|"><a href="javascript:void(0);">摘要</a></li>
                        <li val="7" field="RF$%=|"><a href="javascript:void(0);">被引文献</a></li>
                        <li val="8" field="CLC$=|??"><a href="javascript:void(0);">中图分类号</a></li>
                        <li val="9" field="LY$%=|"><a href="javascript:void(0);">文献来源</a></li>
                    </ul>
                </div>
                <!--sort-->
                <input class="search-input" id="txt_SearchText" name="txt_SearchText" type="text" autocomplete="off" placeholder="中文文献、外文文献" value="" maxlength="100" style="color: rgb(125, 125, 125);">
                <input class="search-btn" type="button" value="">
            </div>
            <!--input-box-->
            <div class="option-list">
                <div class="wx">
                    <span class="tit">跨库</span>
                    <ul>
                        <li class="selected" id="CJFQ" val="CJFQ" onclick="CrossDb(this)"><i></i><a href="http://nvsm.cnki.net/kns/brief/result.aspx?dbprefix=CJFQ" target="_blank">学术期刊</a></li>
                        <li class="selected" id="CDMD" val="CDFD,CMFD" onclick="CrossDb(this)"><i></i><a href="http://nvsm.cnki.net/kns/brief/result.aspx?dbprefix=CDMD" target="_blank">博硕</a></li>
                        <li class="selected" id="CIPD" val="CPFD,IPFD" onclick="CrossDb(this)"><i></i><a href="http://nvsm.cnki.net/kns/brief/result.aspx?dbprefix=CIPD" target="_blank">会议</a></li>
                        <li class="selected" id="CCND" val="CCND" onclick="CrossDb(this)"><i></i><a href="http://nvsm.cnki.net/kns/brief/result.aspx?dbprefix=CCND" target="_blank">报纸</a></li>
                        <li id="CYFD" val="CYFD" onclick="CrossDb(this)"><i></i><a href="http://nvsm.cnki.net/kns/brief/result.aspx?dbprefix=CYFD" target="_blank">年鉴</a></li>
                        <li id="SCOD" val="SCOD" onclick="CrossDb(this)"><i></i><a href="http://nvsm.cnki.net/kns/brief/result.aspx?dbprefix=SCOD" target="_blank">专利</a></li>
                        <li id="CISD" val="CISD" onclick="CrossDb(this)"><i></i><a href="http://nvsm.cnki.net/kns/brief/result.aspx?dbprefix=CISD" target="_blank">标准</a></li>
                        <li id="SNAD" val="SNAD" onclick="CrossDb(this)"><i></i><a href="http://nvsm.cnki.net/kns/brief/result.aspx?dbprefix=SNAD" target="_blank">成果</a></li>
                    </ul>
                    <span class="tit">单库</span>
                    <ul>
                        <li id="WWBD" val="WWBD" onclick="SingleDb(this)"><i></i><a href="http://nvsm.cnki.net/kns/brief/result.aspx?dbprefix=WWBD" target="_blank">图书</a></li>
                        <li id="GXDB" val="GXDB_SECTION" onclick="SingleDb(this)"><i></i><a href="http://nvsm.cnki.net/kns/brief/result.aspx?dbprefix=GXDB_SECTION" target="_blank">古籍</a></li>
                        <li id="CLKD" val="CLKD" onclick="SingleDb(this)"><i></i><a href="http://nvsm.cnki.net/kns/brief/result.aspx?dbprefix=CLKD" target="_blank">法律法规</a></li>
                        <!--不进行检索-->
                        <li id="gwkt" val="gwkt" onclick="LinkDb(this,'http://r.cnki.net/kns/brief/result.aspx?dbprefix=gwkt')"><a href="javascript:void(0)">政府文件</a></li>
                        <li id="scef" val="scef" onclick="LinkDb(this,'http://r.cnki.net//KNS/brief/result.aspx?dbprefix=scef')"><a href="javascript:void(0)">企业标准</a></li>
                        <li id="kjbg" val="kjbg" onclick="LinkDb(this,'http://r.cnki.net/KNS/brief/result.aspx?dbPrefix=kjbg')"><a href="javascript:void(0)">科技报告</a></li>
                        <li id="cgxx" val="cgxx" onclick="LinkDb(this,'http://r.cnki.net/KNS/brief/result.aspx?dbPrefix=cgxx')"><a href="javascript:void(0)">政府采购</a></li>
                    </ul>
                </div>
                <ul class="zsy">
                    <li class="selected" id="qa" val="qa" onclick="SingleDb(this)"><i></i><a href="http://qa.cnki.net" target="_blank">知识问答</a></li>
                    <li id="CRPD" val="CRPD" onclick="SingleDb(this)"><i></i><a href="http://kns.cnki.net/kns/brief/result.aspx?dbprefix=CRPD" target="_blank">百科</a></li>
                    <li id="CRDD" val="CRDD" onclick="SingleDb(this)"><i></i><a href="http://kns.cnki.net/kns/brief/result.aspx?dbprefix=CRDD" target="_blank">词典</a></li>
                    <li id="CRMD" val="CRMD" onclick="SingleDb(this)"><i></i><a href="http://kns.cnki.net/kns/brief/result.aspx?dbprefix=CRMD" target="_blank">手册</a></li>
                    <li id="CRFD" val="CRFD" onclick="SingleDb(this)"><i></i><a href="http://gongjushu.cnki.net" target="_blank">工具书</a></li>
                    <li id="IMAGE" val="IMAGE" onclick="SingleDb(this)"><i></i><a href="http://image.cnki.net" target="_blank">图片</a></li>
                    <li id="CSYD" val="CSYD" onclick="SingleDb(this)"><i></i><a href="http://data.cnki.net" target="_blank">统计数据</a></li>
                    <li id="CIDX" val="CIDX" onclick="SingleDb(this)"><i></i><a href="http://kns.cnki.net/kns/brief/default_result.aspx?islist=1&code=CIDX&singleDBName=%E6%8C%87%E6%95%B0" target="_blank">指数</a></li>
                    <li id="METHOD" val="METHOD" onclick="SingleDb(this)"><i></i><a href="http://method.cnki.net/" target="_blank">方法</a></li>
                    <li id="CONC" val="CONC" onclick="SingleDb(this)"><i></i><a href="http://concept.cnki.net/" target="_blank">概念关系</a></li>
                </ul>
                <ul class="yw">
                    <li id="ywk" class="selected" onclick="LinkDb(this,'http://ref.cnki.net/ref')"><i></i><a href="javascript:void(0)">中国引文数据库</a></li>
                </ul>
            </div>
        </div>
        <!--search-form-->
    </div>
    <!--searchmain end-->
    <div class="product-content">
        <div class="unit unit-box1">
            <h4>行业知识服务与知识管理平台</h4>
            <ul style="width:326px; ">
                <li>
                    <h6>农林牧渔、卫生、科学研究</h6>
                    <a href="http://ypt.cnki.net" target="_blank">农业</a>
                    <a href="http://shipin.cnki.net" target="_blank">食品</a>
                    <a href="http://www.chkd.cnki.net" target="_blank">医疗</a>
                    <a href="http://r.cnki.net/index/yaoye" target="_blank">药业</a>
                    <a href="http://r.cnki.net/index/cdchy" target="_blank">公共卫生</a>
                    <a href="http://r.cnki.net/index/gtzy" target="_blank">国土</a>
                    <a href="http://crjt.cnki.net" target="_blank">检验检疫</a>
                    <a href="http://r.cnki.net/index/sthb" target="_blank">环保</a>
                    <a href="http://r.cnki.net/index/shuili" target="_blank">水利</a>
                    <a href="http://r.cnki.net/index/qixiang" target="_blank">气象</a>
                    <a href="http://r.cnki.net/index/haiyang" target="_blank">海洋</a>
                    <a href="http://r.cnki.net/index/dizhen" target="_blank">地震</a>
                </li>
                <li>
                    <h6>建筑、能源、冶炼、交通运输</h6>
                    <a href="http://r.cnki.net/index/up" target="_blank">城乡规划</a>
                    <a href="http://r.cnki.net/index/bmi" target="_blank">建筑材料</a>
                    <a href="http://www.hytsg.cnki.net" target="_blank">建筑</a>
                    <a href="http://r.cnki.net/index/dianli" target="_blank">电力</a>
                    <a href="http://r.cnki.net/index/yjgy" target="_blank">冶金</a>
                    <a href="http://oil.cnki.net" target="_blank">石油</a>
                    <a href="http://mt.cnki.net/" target="_blank">煤炭</a>
                    <a href="http://r.cnki.net/index/jt" target="_blank">交通</a>
                    <a href="http://r.cnki.net/index/chb" target="_blank">船舶</a>
                </li>
                <li>
                    <h6>制造、信息技术、贸易</h6>
                    <a href="http://r.cnki.net/index/qchy" target="_blank">汽车</a>
                    <a href="http://r.cnki.net/index/jxhy" target="_blank">机械</a>
                    <a href="http://r.cnki.net/index/hkhy" target="_blank">航空</a>
                    <a href="http://r.cnki.net/index/hthy" target="_blank">航天</a>
                    <a href="http://myhk.cnki.net/" target="_blank">民用航空</a>
                    <a href="http://r.cnki.net/index/dzhy" target="_blank">电子</a>
                    <a href="http://r.cnki.net/index/dqhy" target="_blank">电气</a>
                    <a href="http://r.cnki.net/index/jdhy" target="_blank">家电</a>
                    <a href="http://r.cnki.net/index/chemsci" target="_blank">化工</a>
                    <a href="http://r.cnki.net/index/ychy" target="_blank">烟草</a>
                    <a href="http://r.cnki.net/index/fzhy" target="_blank">纺织</a>
                    <a href="http://r.cnki.net/index/mc" target="_blank">信息通信</a>
                    <a href="http://smpt.cnki.net/" target="_blank">商贸</a>
                </li>
                <li>
                    <h6>党政、社团、国防、法律、金融</h6>
                    <a href="http://r.cnki.net/index/dang" target="_blank">党委</a>
                    <a href="http://r.cnki.net/index/zhengfu" target="_blank">政府</a>
                    <a href="http://law.cnki.net/rdjc/" target="_blank">人大</a>
                    <a href="http://zxlzta.cnki.net/" target="_blank">政协</a>
                    <a href="http://r.cnki.net/index/zhiku" target="_blank">智库</a>
                    <a href="http://r.cnki.net/index/zzrs" target="_blank">党校</a>
                    <a href="http://r.cnki.net/index/shetuan" target="_blank">社团</a>
                    <a href="http://r.cnki.net/index/81" target="_blank">国防</a>
                    <a href="http://law.cnki.net" target="_blank">法律</a>
                    <a href="http://r.cnki.net/index/fin" target="_blank">金融</a>
                </li>
                <li>
                    <h6>教育、公共文化、社会服务</h6>
                    <a href="http://gj.cnki.net" target="_blank">高教</a>
                    <a href="http://zyjy.cnki.net/" target="_blank">职教</a>
                    <a href="http://www.cfed.cnki.net/" target="_blank">基教</a>
                    <a href="http://r.cnki.net/index/lib" target="_blank">公共图书馆</a>
                    <a href="http://r.cnki.net/index/zwwb" target="_blank">文博</a>
                    <a href="http://r.cnki.net/index/zwly" target="_blank">旅游</a>
                    <a href="http://r.cnki.net/index/cul" target="_blank">文艺文化</a>
                    <a href="http://fybh.cnki.net/" target="_blank">非遗</a>
                    <a href="http://r.cnki.net/index/sports" target="_blank">体育</a>
                    <a href="http://r.cnki.net/index/arc" target="_blank">档案</a>
                    <a href="http://r.cnki.net/index/sti" target="_blank">科情</a>
                    <a href="http://r.cnki.net/index/cbcm" target="_blank">出版传媒</a>
                </li>
            </ul>
        </div>
        <!--unit-box1-->

        <div class="unit unit-box2">
            <h4>研究学习平台</h4>
            <dl>
                <dd class="t">
                    <ul>
                        <li class="left">
                            <h6><a href="http://x.cnki.net" target="_blank">研究型学习平台</a></h6>
                            <a href="http://yjs.x.cnki.net" target="_blank">研究生</a>
                            <a href="http://bks.x.cnki.net" target="_blank">本科生</a>
                            <a href="http://x.cnki.net" target="_blank">高职学生</a>
                            <a href="http://x.cnki.net" target="_blank">中职学生</a>
                            <a href="http://yx.cnki.net" target="_blank">中学生</a>
                        </li>
                        <li class="right">
                            <h6>大数据研究平台</h6>
                            <a href="http://pta.cnki.net" target="_blank">专利分析</a>
                            <a href="http://image.cnki.net" target="_blank">学术图片</a>
                            <a href="http://data.cnki.net" target="_blank">统计数据</a>
                            <a href="http://elib.cnki.net/grid2008/brief/result.aspx?DbPrefix=hotspotcomp&amp;showTitle=%u5B66%u79D1%u5B66%u672F%u70ED%u70B9" target="_blank">学术热点</a>
                            <a href="http://expert.cnki.net" target="_blank">学者库</a>
                            <a href="http://bd.cnki.net" target="_blank">统计分析</a>
                        </li>
                        <li>
                            <h6><a href="http://okms.cnki.net/home/#page1" target="_blank">协同研究平台</a></h6>
                        </li>
                        <li>
                            <h6><a href="http://okms.cnki.net/home/zthome/ztindex" target="_blank">协同研究平台教学版</a></h6>
                        </li>
                        <li>
                            <h6><a href="http://projects.cnki.net/" target="_blank">科研项目申报信息库</a></h6>
                        </li>
                    </ul>
                </dd>
            </dl>
            <img src="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/bar.jpg" alt="中国学术期刊（网络版）|外文资源总库" usemap="#guidemap" />
            <map name="guidemap">
                <area shape="rect" coords="0,0,340,125" href="http://cajn.cnki.net" target="_blank" hidefocus="true" onfocus="this.blur()" />
                <area shape="rect" coords="340,0,500,125" href="http://scholar.cnki.net/new" target="_blank" hidefocus="true" onfocus="this.blur()" />
            </map>
            <h4>出版平台&amp;评价</h4>
            <dl>
                <dd class="b">
                    <ul>
                        <li class="left">
                            <h6>出版平台</h6>
                            <a href="http://cb.cnki.net" target="_blank">选刊投稿</a>
                            <a href="http://find.cb.cnki.net/" target="_blank">期刊采编发</a>
                            <a href="//piccache.cnki.net/index/images2009/other/2018/中国知网网络出版文献出版状态变更与内容更正规范（试行）.pdf" target="_blank">知网出版规范</a><br />
                            <a href="http://caj.cnki.net/eapf/cajn" target="_blank">网络首发</a>
                            <a href="http://caj.cnki.net/eapf" target="_blank">优先出版</a>
                            <a href="http://fast.cnki.net" target="_blank">印后上网</a>
                            <a href="http://www.graduate.cnki.net" target="_blank">研究生综合管理与学位论文出版</a>
                            <a href="http://conf.cnki.net" target="_blank">中国学术会议信息</a>
                            <a href="//www.cnki.net/other/gonggao/GCTG/全国各位研究生敬启2.html" target="_blank">学位论文领取稿酬通告</a>
                        </li>
                        <li class="right">
                            <h6><a href="http://epub.cnki.net/kns/subPage/Evalu.aspx" target="_blank">科研统计与期刊评价</a></h6>
                            <a href="http://www.jif.cnki.net/Core/" target="_blank">个刊分析</a>
                            <a href="http://cjcr.cnki.net/" target="_blank">期刊评价</a>
                            <a href="http://www.jif.cnki.net/Core/Cajes.aspx " target="_blank">期刊管理</a>
                            <a href="http://xsjy.cnki.net/" target="_blank">论文评价</a>
                            <a href="http://www.cbad.cnki.net/" target="_blank">图书评价</a>
                            <a href="http://cdmdpj.cnki.net/" target="_blank">博硕统计</a>
                            <a href="http://pj.cnki.net/" target="_blank">医院评价</a>
                        </li>
                        <li>
                            <h6><a href="http://oversea.cnki.net/" target="_blank">国际出版</a></h6>
                        </li>
                    </ul>
                </dd>
            </dl>
        </div>
        <!--unit-box2-->

        <div class="unit unit-box3">
            <h4>专题知识库</h4>
            <ul>
                <li>
                    <h6>党政/红色专题</h6>
                    <a href="http://jggw.cnki.net" target="_blank">机关公文</a>
                    <a href="http://dzjc.cnki.net" target="_blank">科学决策</a>
                    <a href="http://lxyz.cnki.net" target="_blank">两学一做</a>
                    <a href="http://syss.cnki.net" target="_blank">三严三实</a>
                    <a href="http://xjpt.cnki.net" target="_blank">十九大</a>
                    <a href="http://www.tsk.cnki.net/changzheng/" target="_blank">长征</a>
                    <a href="http://www.tsk.cnki.net/jiandang/ilib.html" target="_blank">党史</a>
                    <a href="http://www.jianjun.cnki.net" target="_blank">军史</a>
                    <a href="http://www.tsk.cnki.net/kangzhan/" target="_blank">抗战</a>
                    <a href="http://dx.cnki.net/xinhai100" target="_blank">辛亥</a>
                </li>
                <li>
                    <h6>公共管理</h6>
                    <a href="http://gaige.cnki.net" target="_blank">深化改革</a>
                    <a href="http://zglz.cnki.net" target="_blank">治国理政</a>
                    <a href="http://law.cnki.net/sfgg/" target="_blank">司法改革</a>
                    <a href="http://law.cnki.net/topic/" target="_blank">依法执政</a>
                    <a href="http://shuigai.cnki.net" target="_blank">税改</a>
                    <a href="http://ppp.cnki.net" target="_blank">PPP</a>
                    <a href="http://gov.cnki.net/czh/" target="_blank">城镇化</a>
                </li>
                <li>
                    <h6>社会知识</h6>
                    <a href="http://maker.cnki.net/DZCT/" target="_blank">创业创新</a>
                    <a href="http://glcx.cnki.net" target="_blank">企业管理</a>
                    <a href="http://yjgl.cnki.net" target="_blank">应急管理</a>
                    <a href="http://www.tsk.cnki.net/qmjs/" target="_blank">全民健身</a>
                    <a href="http://shuwu.cnki.net" target="_blank">科普</a>
                </li>
                <li>
                    <h6>环保治理</h6>
                    <a href="http://jiance.cnki.net" target="_blank">环境监测</a>
                    <a href="http://sthj.cnki.net" target="_blank">生态环境</a>
                </li>
                <li>
                    <h6>金融</h6>
                    <a href="http://itfin.cnki.net" target="_blank">互联网金融</a>
                    <a href="http://finrisk.cnki.net" target="_blank">金融风险</a>
                </li>
                <li>
                    <h6>文化知识</h6>
                    <a href="http://wenbao.cnki.net" target="_blank">文物保护</a>
                    <a href="http://mq.cnki.net" target="_blank">明清史</a>
                    <a href="http://www.wysl.cnki.net" target="_blank">文艺史论</a>
                    <a href="http://yd.cnki.net" target="_blank">文学经典</a>
                </li>
            </ul>
        </div>
        <!--unit-box3-->
    </div>
    <!--product-content-->

    <div class="trends">
        <div class="trends-content">
            <div class="trends-top-box">
                <!--trends-news begin-->
                <#include "/index-news.ftl" />
                <!--trends-news end-->
                <!--trends-banner begin-->
                <#include "/index-banner.ftl" />
                <!--trends-banner end-->

            </div>

            <div class="trends-bottom-box">
                <div class="trends-unit unit1">
                    <h4>
                        <span>教育</span>
                    </h4>

                    <div class="slideBox">
                        <!--rollImg start-->
                        <div class="rollImg" id="rollImg-1">
                            <!--items start-->
                            <ul class="items">
                                <li>
                                    <a target="_blank" href="//piccache.cnki.net/index/images2009/other/2018/关于谨防《中国误诊学杂志》假冒期刊的郑重申明.pdf" title="关于谨防《中国误诊学杂志》假冒期刊的郑重申明">
                                        <img src="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/pic05.jpg" alt="关于谨防《中国误诊学杂志》假冒期刊的郑重申明" />
                                    </a>
                                </li>
                                <li>
                                    <a target="_blank" href="//piccache.cnki.net/index/CNKIRecruit/index.html" title="2019年中国知网校园招聘">
                                        <img src="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/pic04.jpg" alt="2019年中国知网校园招聘" />
                                    </a>
                                </li>
                                <li>
                                    <a target="_blank" href="//www.cnki.net/fpgl.html" title="防诈骗专栏">
                                        <img src="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/pic01.jpg" alt="防诈骗专栏" />
                                    </a>
                                </li>
                                <li>
                                    <a target="_blank" href="http://www.itaic.org/" title="2019 IEEE第8届联合国际信息技术与人工智能会议">
                                        <img src="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/pic07.jpg" alt="2019 IEEE第8届联合国际信息技术与人工智能会议" />
                                    </a>
                                </li>
                                <li>
                                    <a target="_blank" href="http://www.itnec.org/" title="2019 IEEE第3届信息技术、网络、电子与自动化控制国际会议">
                                        <img src="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/pic06.jpg" alt="2019 IEEE第3届信息技术、网络、电子与自动化控制国际会议" />
                                    </a>
                                </li>
                            </ul>
                            <!--items end-->
                        </div>
                        <!--rollImg end-->
                    </div>
                    <!--slideBox-->
                </div>
                <div class="trends-unit unit2">
                    <h4>
                        <span>众知 · 众创</span>
                    </h4>

                    <div class="slideBox">
                        <!--rollImg start-->
                        <div class="rollImg" id="rollImg-2">
                            <!--items start-->
                            <ul class="items">
                                <li>
                                    <a href="//piccache.cnki.net/index/images2009/other/2018/第三届材料科学与工程技术国际学术会议.pdf" target="_blank" title="第三届材料科学与工程技术国际学术会议">
                                        <img src="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/pic-1.jpg" alt="第三届材料科学与工程技术国际学术会议" />
                                    </a>
                                </li>
                                <li>
                                    <a href="http://www.csgpc.org/News/n1/20181114183937.html" target="_blank" title="中国测绘学会-关于举办‘2018奖励申报专题培训班’的通知">
                                        <img src="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/pic-6.jpg" alt="中国测绘学会-关于举办‘2018奖励申报专题培训班’的通知" />
                                    </a>
                                </li>
                                <li>
                                    <a href="http://www.carf.org.cn/html/2018-10/3919.html" target="_blank" title="第七届中国行政改革论坛">
                                        <img src="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/pic-5.jpg" alt="第七届中国行政改革论坛" />
                                    </a>
                                </li>
                                <li>
                                    <a href="http://manu25.magtech.com.cn/Jwk3_jzjgxb/CN/news/news76.shtml" target="_blank" title="《建筑结构学报》创刊四十周年纪念暨第五届建筑结构基础理论与创新实践论坛">
                                        <img src="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/pic-3.jpg" alt="《建筑结构学报》创刊四十周年纪念暨第五届建筑结构基础理论与创新实践论坛" />
                                    </a>
                                </li>
                                <li>
                                    <a href="http://bianke.cnki.net/" target="_blank" title="大成编客">
                                        <img src="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/pic-2.jpg" alt="大成编客" />
                                    </a>
                                </li>
                            </ul>
                            <!--items end-->
                        </div>
                        <!--rollImg end-->
                    </div>
                    <!--slideBox-->

                </div>
                <div class="trends-unit unit3">
                    <h4>
                        <span>软件产品</span>
                    </h4>
                    <ul>
                    </ul>
                </div>
            </div>
        </div>
        <!--trends-content-->
    </div>

    <!--footer start-->
    <div class="footer">

        <div class="foot-top">
            <ul class="content">
                <li>
                    <b>客服咨询</b>
                    <span>QQ咨询：<a target="_blank" href="#"></a></span>
                    <span>邮件咨询：<a target="_blank" href="mailto:help@lkg61230413@163.com">lkg61230413@163.com</a></span>
                </li>
                <li >
                    <a target="_blank"   href="#" alt="新浪微博客服" ><span> <i class="fa fa-4x fa-weibo"></i>新浪微博客服</span></a>
                </li>
            </ul>
        </div>

        <div class="foot-bot clearfix">
            <div class="t" style="height: 80px;">
                <img src="" alt="" />
                <p class="mid">
                        <span>
                            <a target="_blank" href="${contextPath}/aboutus.jhtml">关于我们</a>
                              <a target="_blank" href="${contextPath}/contact.html">联系我们</a>
                            <a target="_blank" href="${contextPath}/questions.html">常见问题</a>
                        </span>
                    <span id="copyright">© 2009-${.now?string("yyyy")} lkg </span>
                </p>
                <p class="right">
                    <!--可信网站图片LOGO安装开始-->
                    <a id="___szfw_logo___" href="https://ss.knet.cn/verifyseal.dll?sn=e13111111010043364isll000000&a=1&pa=0.08881110103584755" target="_blank">
                        <img alt="可信网站" src="${contextPath}/imgs/kxwz.jpg" height="33" width="86"></a>
                    <!--可信网站图片LOGO安装结束-->
                    <!--诚信网站图片LOGO安装开始-->
                    <a id="A1" href="https://credit.cecdc.com/CX20140929005220005306.html" target="_blank">
                        <img alt="诚信网站" src="${contextPath}/imgs/cert.jpg" height="33" width="86">
                    </a>
                    <!--诚信网站图片LOGO安装结束-->
                </p>
            </div>
            <div class="b">
                <span>
                 <a target="_blank" href="//piccache.cnki.net/index/images/gb/271.jpg">网络出版服务许可证 (总)网出证(京)字第 271 号</a>
                 <a target="_blank" href="http://www.hd315.gov.cn/beian/view.asp?bianhao=">经营性网站备案信息</a>
                </span>
            </div>
        </div>
        <!--foot-bot-->
    </div>
    <!--footer end-->

    <ul class="banner">
        <li class="bg1" style="display: block;"></li>
        <li class="bg2"></li>
        <li class="bg3"></li>
    </ul>
</div><!--wrapper-->

<div id="__droplist" class="dictdiv"></div>
<#include "/pages/track.ftl"/>
</body>
</html>
