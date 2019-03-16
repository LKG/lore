<div class="clearfix"></div>
<div class="layout" ms-controller="IndexCtrl" style="margin-top: 12px;font-size: 12px;">
    <div class="cb"></div>
    <div class="main" ms-widget="collect, indexCollect">
        <div class="like_hot">
            <div class="like_hot_left">
                <div class="moudle_class">
                    <h3 class="ms_ul_h3"><a href="javascript:;" ms-text="activityAd.pic_text">会员优惠专区</a></h3>
                    <a  class="moudle_class_groom" target="_blank"> <img style="width: 385px" alt="党政党风" src="http://www.zhijidoc.com/FileUpload/BookGroup/afa90330-18ef-4a54-aa94-32d892c3848c.jpg"   /> </a>
                    <ul class="ms_ul">
                        <#if docs??&&docs.content??>
                            <#list docs.content as doc>
                                <li><i class="fa fa-angle-down"  style="padding-right: 10px;"></i><a  target="_blank">${doc.shortTitle!''}</a></li>
                            </#list>
                        </#if>
                     </ul>
                </div>
                <div class="moudle_class">
                    <h3 class="ms_ul_h3"><a href="javascript:;"></a></h3>
                    <a class="moudle_class_groom" target="_blank"> <img alt="党政党风" style="width: 385px" src="http://dl.op.wpscdn.cn/odimg/web/2018-12-27/071038/2019gehsui.png" /> </a>
                    <ul class="ms_ul">
                        <#if docs??&&docs.content??>
                            <#list docs.content as doc>
                                <li><i class="fa fa-angle-down"  style="padding-right: 10px;"></i><a  target="_blank">${doc.shortTitle!''}</a></li>
                            </#list>
                        </#if>
                    </ul>
                </div>
            </div>
            <div class="dr_right">
                <div class="cb"></div>
                <div class="hot_doc">
                    <div class="hot_doc_title">
                        <a href="javascript:void(0)" class="active">免费榜</a>
                        <a href="javascript:void(0)">畅销榜</a>
                        <div class="cb"></div>
                    </div>
                    <ul class="hot_doc_ul free" >
                        <#if docs??&&docs.content??>
                            <#list docs.content as doc>
                                <li >
                                    <a href="${contextPath}/doc/${doc.id!''}.jhtml" >
                                        <i class="fa fa-${doc.fileHeader!''} fa-lg text-primary " style="margin-right: 5px"></i>
                                        ${doc.shortTitle!''}</a>
                                <a href="${contextPath}/doc/${doc.id!''}.jhtml"  class="pull-right"><i class="fa fa-download"></i></a> </li>
                            </#list>
                        </#if>
                    </ul>
                    <ul class="hot_doc_ul vip" style="display: none;" >
                        <#if docs??&&docs.content??>
                            <#list docs.content as doc>
                                <li > <a href="${contextPath}/doc/${doc.id!''}.jhtml" >
                                        <i class="fa fa-${doc.fileHeader!''} fa-lg text-primary" style="margin-right: 5px"></i>
                                        ${doc.shortTitle!''}</a>
                                    <a  class="pull-right" ><i class="fa fa-download"></i></a>
                                </li>
                            </#list>
                        </#if>
                    </ul>
                </div>
            </div>
            <div class="cb"></div>
        </div>
        <h2 class="module_h2"><a target="_blank">最新简历范文</a></h2>
        <p class="module_tag"> <a  target="_blank">更多<i class="fa fa-angle-double-right" aria-hidden="true"></i></a> </p>
        <div class="cb"></div>
        <div class="module2">
            <ul class="ml_content_main ml_content_main_word">
                <#if docs??&&docs.content??>
                    <#list docs.content as doc>
                        <li ms-hover="hover">
                            <a  target="_blank" class="mcm_img" id="load${doc.id!''}" title="${doc.periodicalName!''}">
                                <img src="${doc.coverImgUrl!''}" alt="${doc.periodicalName!''}" style="display: block;" />
                            </a>
                            <a target="_blank" class="mcm_title" title="${doc.periodicalName!''}">${doc.shortTitle!''}</a>
                            <div class="mcm_show">
                                <p> <span class="fwb mcm_title_price">￥<span class="red">${doc.originPrice!''}</span></span> <span class="gray">预览：506</span> <a href="javascript:void(0)" class="collect" title="收藏" ms-click="clickCollect($event, 3810722, 3, 1)"></a> </p>
                            </div> </li>
                    </#list>
                </#if>
                <div class="cb"></div>
            </ul>
        </div>
        <h2 class="module_h2"><a target="_blank">最新PPT模板</a></h2>
        <p class="module_tag"> <a target="_blank">更多<i class="fa fa-angle-double-right" aria-hidden="true"></i></a> </p>
        <div class="cb"></div>
        <div class="module2">
            <ul class="ml_content_main ml_content_main_ppt">
                <#if docs??&&docs.content??>
                    <#list docs.content as doc>
                        <li ms-hover="hover">
                            <a  target="_blank" class="mcm_img" id="load${doc.id!''}" title="${doc.periodicalName!''}" >
                                <img src="${doc.coverImgUrl!''}" alt="${doc.periodicalName!''}" style="display: block;" />
                            </a>
                            <a target="_blank" class="mcm_title" title="${doc.periodicalName!''}">${doc.shortTitle!''}</a>
                            <div class="mcm_show">
                                <p> <span class="fwb mcm_title_price">￥<span class="red">${doc.originPrice!''}</span></span> <span class="gray">预览：${doc.hits!''}</span> <a href="javascript:void(0)" class="collect" title="收藏" ></a> </p>
                            </div> </li>
                    </#list>
                </#if>
                <div class="cb"></div>
            </ul>
        </div>
</div>