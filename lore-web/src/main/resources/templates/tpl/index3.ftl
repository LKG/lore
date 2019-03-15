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
    <div class="header" style="height: 50px">

    </div>
    <!--header end-->
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
            </ul>
        </div>
        <!--unit-box1-->

        <div class="unit unit-box2">
            <img src="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/bar.jpg" alt="中国学术期刊（网络版）|外文资源总库" usemap="#guidemap" />
            <map name="guidemap">
                <area shape="rect" coords="0,0,340,125" href="http://cajn.cnki.net" target="_blank" hidefocus="true" onfocus="this.blur()" />
                <area shape="rect" coords="340,0,500,125" href="http://scholar.cnki.net/new" target="_blank" hidefocus="true" onfocus="this.blur()" />
            </map>
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
                    <h6>金融</h6>
                    <a href="http://itfin.cnki.net" target="_blank">互联网金融</a>
                    <a href="http://finrisk.cnki.net" target="_blank">金融风险</a>
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
                <div class="trends-banner">
                    <div id="js-gallery" class="royalSlider rsDefault">

                        <div class="rsContent">
                            <a class="rsImg" href="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/lb02.jpg"></a>
                            <a class="rsABlock sampleBlock" href="http://law.cnki.net/zhengwen/index.html" target="_blank"></a>
                            <div class="rsTmb">
                                <h5 title='征文通知 | “2049:我与人工智能”有奖征文大赛'>征文通知 | “2049:我与人工智能”有奖征文大赛</h5>
                            </div>
                        </div>

                        <div class="rsContent">
                            <a class="rsImg" href="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/lb06.jpg"></a>
                            <a class="rsABlock sampleBlock" href="http://bwg.cnki.net/news1.28/News2.html" target="_blank"></a>
                            <div class="rsTmb">
                                <h5 title='第二届全国博物馆学优秀学术成果评选初评结果公示'>第二届全国博物馆学优秀学术成果评选初评结果公示</h5>
                            </div>
                        </div>

                        <div class="rsContent">
                            <a class="rsImg" href="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/lb01.jpg"></a>
                            <a class="rsABlock sampleBlock" href="http://hy.cnki.net/File/WS/2/index.html" target="_blank"></a>
                            <div class="rsTmb">
                                <h5 title='知识创新服务业发展战略高峰论坛在珠海成功举办'>知识创新服务业发展战略高峰论坛在珠海成功举办</h5>
                            </div>
                        </div>

                        <div class="rsContent">
                            <a class="rsImg" href="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/lb10.jpg"></a>
                            <a class="rsABlock sampleBlock" href="http://www.chinamuseum.org.cn/a/xiehuigonggao/20190103/12809.html" target="_blank"></a>
                            <div class="rsTmb">
                                <h5 title='中国博物馆协会博物馆学专业委员会 2019年学术研讨会征稿通知'>中国博物馆协会博物馆学专业委员会 2019年学术研讨会征稿通知</h5>
                            </div>
                        </div>

                        <div class="rsContent">
                            <a class="rsImg" href="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/lb07.jpg"></a>
                            <a class="rsABlock sampleBlock" href="http://mall.cnki.net/pinde/Publishing/detail/pd_zgws" target="_blank"></a>
                            <div class="rsTmb">
                                <h5 title='好书推荐：《民国趣读·老城记》系列丛书'>好书推荐：《民国趣读·老城记》系列丛书</h5>
                            </div>
                        </div>

                        <div class="rsContent">
                            <a class="rsImg" href="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/lb03.jpg"></a>
                            <a class="rsABlock sampleBlock" href="https://jinshuju.net/f/PQMWbJ" target="_blank"></a>
                            <div class="rsTmb">
                                <h5 title='研究生培养协同创新平台申请试用赠漫游啦！'>研究生培养协同创新平台申请试用赠漫游啦！</h5>
                            </div>
                        </div>

                        <div class="rsContent">
                            <a class="rsImg" href="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/lb05.jpg"></a>
                            <a class="rsABlock sampleBlock" href="http://om.cnki.net/notwinter/notice.html" target="_blank"></a>
                            <div class="rsTmb">
                                <h5 title='全球学术快报寒假漫游通知'>全球学术快报寒假漫游通知</h5>
                            </div>
                        </div>

                        <div class="rsContent">
                            <a class="rsImg" href="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/lb09.jpg"></a>
                            <a class="rsABlock sampleBlock" href="//piccache.cnki.net/index/images2009/other/2018/中国知网网络出版文献出版状态变更与内容更正规范（试行）.pdf" target="_blank"></a>
                            <div class="rsTmb">
                                <h5 title='中国知网网络出版文献出版状态变更与内容更正规范（试行）'>中国知网网络出版文献出版状态变更与内容更正规范（试行）</h5>
                            </div>
                        </div>

                        <div class="rsContent">
                            <a class="rsImg" href="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/lb08.jpg"></a>
                            <a class="rsABlock sampleBlock" href="http://x.cnki.net/sale" target="_blank"></a>
                            <div class="rsTmb">
                                <h5 title='研学平台寒假活动'>研学平台寒假活动</h5>
                            </div>
                        </div>

                        <div class="rsContent">
                            <a class="rsImg" href="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/lb04.jpg"></a>
                            <a class="rsABlock sampleBlock" href="//piccache.cnki.net/index/CNKIRecruit/index.html" target="_blank"></a>
                            <div class="rsTmb">
                                <h5 title='知网招聘'>知网招聘</h5>
                            </div>
                        </div>

                    </div>
                </div>
                <!--trends-banner end-->

            </div>

            <div class="trends-bottom-box"  >
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
                                    <a href="http://www.carf.org.cn/html/2018-10/3919.html" target="_blank" title="第七届中国行政改革论坛">
                                        <img src="//piccache.cnki.net/kdn/index/nvsm/nimages/temp/pic-5.jpg" alt="第七届中国行政改革论坛" />
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
                    <span>QQ咨询：<a target="_blank" href="javascript:void(0)"></a></span>
                    <span>邮件咨询：<a target="_blank" href="mailto:help@lkg61230413@163.com">lkg61230413@163.com</a></span>
                </li>
                <li >
                    <a   href="javascript:void(0)" alt="新浪微博客服" ><span> <i class="fa fa-4x fa-weibo"></i>新浪微博客服</span></a>
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
                    <a id="___szfw_logo___" href="javascript:void(0)" target="_blank">
                        <img alt="可信网站" src="${contextPath}/imgs/kxwz.jpg" height="33" width="86"></a>
                    <!--可信网站图片LOGO安装结束-->
                    <!--诚信网站图片LOGO安装开始-->
                    <a id="A1" href="javascript:void(0)" target="_blank">
                        <img alt="诚信网站" src="${contextPath}/imgs/cert.jpg" height="33" width="86">
                    </a>
                    <!--诚信网站图片LOGO安装结束-->
                </p>
            </div>
            <div class="b">
                <span>
                 <a target="_blank" href="javascript:void(0)">网络出版服务许可证 (总)网出证(京)字第 271 号</a>
                 <a target="_blank" href="javascript:void(0)">经营性网站备案信息</a>
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
