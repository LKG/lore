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
                                    <a href="${appHost}/doc/${doc.id!''}.jhtml" >
                                        <i class="fa fa-${doc.fileHeader!''} fa-lg text-primary " style="margin-right: 5px"></i>
                                        ${doc.shortTitle!''}</a>
                                <a href="${appHost}/doc/${doc.id!''}.jhtml"  class="pull-right"><i class="fa fa-download"></i></a> </li>
                            </#list>
                        </#if>
                    </ul>
                    <ul class="hot_doc_ul vip" style="display: none;" >
                        <#if docs??&&docs.content??>
                            <#list docs.content as doc>
                                <li > <a href="${appHost}/doc/${doc.id!''}.jhtml" >
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
</div>
