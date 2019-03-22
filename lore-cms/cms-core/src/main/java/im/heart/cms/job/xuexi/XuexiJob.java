package im.heart.cms.job.xuexi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import im.heart.core.utils.OkHttpClientUtils;
import im.heart.core.utils.StringUtilsEx;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.URL;

public class XuexiJob {
    public static void main(String[] args) throws  Exception{
        //https://www.xuexi.cn/03c8b56d5bce4b3619a9d6c2dfb180ef/9a3668c13f6e303932b5e0e100fc248b.html?pageNumber=2
        //学习实践
        String id="e43e220633a65f9b6d8b53712cba9caa";
        String id2="cf346b6667d62a8ed654a0ebd307970f";
        String cl=  OkHttpClientUtils.fetchEntityString("https://www.xuexi.cn/cf346b6667d62a8ed654a0ebd307970f/data"+id+".js",null);

        String jsonContent = StringUtilsEx.substringBetween(cl, "globalCache = ","};");
        JSONObject jsonObject = JSON.parseObject(jsonContent+"}");
        System.out.println(jsonObject.get("sysQuery"));
        System.out.println(jsonObject.get("fp1w9a6h2o1czk01"));
        System.out.println(jsonObject.get("fp8ttetzkclds001"));
        System.out.println(jsonObject.keySet());
//        sysQuery, fp1w9a6h2o1czk01, fp8ttetzkclds001

        String cl2=  OkHttpClientUtils.fetchEntityString("https://www.xuexi.cn/cf346b6667d62a8ed654a0ebd307970f/"+id+".js",null);

        System.out.println(cl2);
    }
}
