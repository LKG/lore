<!---点赞面板begin--->
<div class="panel panel-default">
   <div class="panel-heading text-center" role="tab" id="headingOne">
     <button type="button" id="praise-btn" class="btn btn-danger hide " data-url="${contextPath}/doc/${result.id}/praise.json" ><i class="fa fa-thumbs-o-up fa-lg"></i><code class="bs-smll-support-code" >0</code></button>
   </div>
   <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
     <div class="panel-body">

         <div class="caption" >
            <p >编号：<code>${result.periodicalCode}</code></p>
            <p >类型：<code>${result.periodicalType}</code></p>
            <p >格式：<code>${result.fileHeader}</code></p>
            <p >大小：<code>${result.dataSizeHuman}</code></p>
            <p >价格：<font class="cOrange originPrice" style="font-size: 18px;"><code>${result.originPrice}</code></font>元</p>
            <p >折扣价：<font class="cOrange finalPrice" style="font-size: 18px;font-weight:bold;color:#f60;"><code>${result.finalPrice}</code></font>元</p>
            <p >上传时间：<code>${(result.createTime?string("yyyy-MM-dd"))!}</code></p>
             <p >总页数：<code>${result.pageNum!'1'}</code></p>
         </div>
     </div>
   </div>
</div>
<!---点赞面板end--->
<!--  downTimes
-->