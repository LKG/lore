define(function (require, exports, moudles) {
    var $ = require('jquery');
    var jQuery = require('jquery');
    var dialog = require('artDialog');
    var $baseRoot=$("#baseRoot");
    window.dialog = dialog;
    var baseRoot=$baseRoot.attr("href");
    var $httpUtil = require('/js/common/httpUtil.js');
    var $msg= require('/js/common/alerts.js');
    $("#btn-search").on("click",function () {
        var param = $("#search-form").serialize();
        var q=$("#q").val();
        var qt=$("#qt").val();
        $msg.alert(q,"<i class='fa fa-exclamation-triangle text-danger'></i>",false)
    });
});