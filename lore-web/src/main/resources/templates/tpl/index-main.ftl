<div class="layout" ms-controller="IndexCtrl">
    <div class="cb"></div>
    <div class="main" ms-widget="collect, indexCollect">
        <div class="like_hot">
            <div class="like_hot_left">
                <div class="moudle_class">
                    <h3 class="ms_ul_h3"><a href="javascript:;" ms-text="activityAd.pic_text">会员优惠专区</a></h3>
                    <a  class="moudle_class_groom" target="_blank"> <img src="http://www.docer.com/application/styles/images/loading48.gif"   /> </a>
                    <ul class="ms_ul">
                         <#list [1,2,3,4,5] as article>
                         <li><i class="fa fa-angle-down"  style="padding-right: 10px;"></i><a target="_blank">哈佛大学用这12张图，教育了10亿人</a></li>
                         </#list>
                     </ul>
                </div>
                <div class="moudle_class">
                    <h3 class="ms_ul_h3"><a href="javascript:;"></a></h3>
                    <a class="moudle_class_groom" target="_blank"> <img lazyloadsrc="http://img1.template.cache.wps.cn/wps/cdnwps/upload/official/template/vip/commend_img/docer/zhaomu_min_20180820.png" alt="内容创作者招募令" src="http://www.docer.com/application/styles/images/loading48.gif" /> </a>
                    <ul class="ms_ul">
                        <#list [1,2,3,4,5] as article>
                            <li><i class="fa fa-angle-down"  style="padding-right: 10px;"></i><a  target="_blank">【PPT教程】关于PPT色彩，少有人知的5个功能！</a></li>
                        </#list>
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
                          <#list [0,1,2,3,4] as article>
                                <li > <a href="${contextPath}/doc/1.jhtml" >通用表格</a> <a href="${contextPath}/doc/1.jhtml"  class="pull-right"><i class="fa fa-download"></i></a> </li>
                          </#list>
                    </ul>
                    <ul class="hot_doc_ul vip" style="display: none;" >
                        <#list [0,1,2,3,4] as article>
                         <li > <a >简历表格007</a> <a  class="pull-right" ><i class="fa fa-download"></i></a> </li>
                        </#list>
                    </ul>
                </div>
            </div>
            <div class="cb"></div>
        </div>
        <h2 class="module_h2"><a target="_blank">最新简历范文</a></h2>
        <p class="module_tag"> <a  target="_blank">更多&gt;&gt;</a> </p>
        <div class="cb"></div>
        <div class="module2">
            <ul class="ml_content_main ml_content_main_word">
                       <#list [0,1,2,3,4] as article>
                          <li ms-hover="hover"> <a  target="_blank" class="mcm_img" id="load3810722" title="求职简历求职模板.docx"> <img src="http://www.docer.com/application/styles/images/loading48.gif" alt="求职简历求职模板.docx" style="display: block;" /> </a> <a target="_blank" class="mcm_title" title="求职简历求职模板.docx">求职简历求职模板</a>
                              <div class="mcm_show">
                                  <p> <span class="fwb mcm_title_price">￥<span class="red">9.99</span></span> <span class="gray">预览：506</span> <a href="javascript:void(0)" class="collect" title="收藏" ms-click="clickCollect($event, 3810722, 3, 1)"></a> </p>
                              </div> </li>
                      </#list>
                <div class="cb"></div>
            </ul>
        </div>
        <h2 class="module_h2"><a target="_blank">最新PPT模板</a></h2>
        <p class="module_tag"> <a target="_blank">更多&gt;&gt;</a> </p>
        <div class="cb"></div>
        <div class="module2">
            <ul class="ml_content_main ml_content_main_ppt">
                 <#list [1,2,3,4,5] as article>
                <li ms-hover="hover"> <a  target="_blank" class="mcm_img" id="load3836251" title="极简极简工作总结极简模板.pptx" > <img src="http://www.docer.com/application/styles/images/loading48.gif" alt="极简极简工作总结极简模板.pptx" style="display: block;" /> </a> <a target="_blank" class="mcm_title" title="极简极简工作总结极简模板.pptx">极简极简工作总结极简模板</a>
                    <div class="mcm_show">
                        <p> <span class="fwb mcm_title_price">￥<span class="red">14.99</span></span> <span class="gray">预览：86</span> <a href="javascript:void(0)" class="collect" title="收藏" ></a> </p>
                    </div> </li>
                  </#list>
                <div class="cb"></div>
            </ul>
        </div>
</div>