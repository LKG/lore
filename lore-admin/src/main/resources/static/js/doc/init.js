define(function (require, exports, moudles) {
	var $ = require('jquery');
	var jQuery = require('jquery');
    var template = require('arttemplate');
    var lazyload = require('../../modules/lazyload/lazyload.min.js');
    var message = require('js/common/messages.js');
	var $baseRoot=$("#baseRoot");
	var baseRoot=$baseRoot.attr("href");
	$("#xx,#xx a").on("click",function () {
		$("#top-banner").hide();
    });
	//TODO：后期考虑公用全局配置
	 function showNum(f){
		  if(f>=10000){
             return parseInt(f/10000) +"万";
         }else if(f<10000 && f>=1000){
             return parseInt(f/1000) +"千";
         }else{
             return f;
         }
	  }
	 //加载轮播图片
	 function getDocImgList(){
		 var url=baseRoot+"/doc/"+$("#doc-carousel-generic").attr("data")+"/imgs.json";
		 $.ajax({
	         url:url,
	         dataType:"jsonp",
	         jsonp:"jsoncallback",
	         success:function(json){
	       	  var html = template('doc-carousel-template-js', json);
	       	  $("#doc-carousel-generic").empty();
			  $("#doc-carousel-generic").append(html);
                 $("img.lazy").lazyload({
                     effect : "fadeIn"
                 });
	         }
	    }); 
	 }
	getDocImgList();

	 $("#praise-btn").on("click" ,function(){
		 var $obj=$(this);
		 $obj.attr("disabled","disabled");
		  var dataUrl=$obj.attr("data-url");
		  $.ajax({
		         url:dataUrl,
		         dataType:"jsonp",
		         jsonp:"jsoncallback",
		         success:function(data){
                     message($(this),"点赞成功！");
		        	 $obj.removeAttr("disabled");
		        	 $obj.find(".bs-smll-support-code").html(showNum(data.result));
		         }
		    }); 
	 });
    $("#focus-btn").on("click" ,function(){
        var $obj=$(this);
        $obj.attr("disabled","disabled");
        var dataUrl=$obj.attr("data-url");
        $.ajax({
            url:dataUrl,
            dataType:"jsonp",
            jsonp:"jsoncallback",
            success:function(data){
                if (data.result) {
                    message($(this),"收藏成功！");
                    $("#collect-txt").text("已收藏");
                }else {
                	if(data.httpstatus==403){
						window.location.href="/login.jhtml";
						return;
					}
                    message($(this),"已收藏！");
				}
                $obj.removeAttr("disabled");
                $obj.find(".bs-smll-support-code").html(showNum(data.result));
            }
        });
    });
});