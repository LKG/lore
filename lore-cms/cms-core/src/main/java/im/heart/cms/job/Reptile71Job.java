package im.heart.cms.job;

import im.heart.cms.entity.Article;
import im.heart.cms.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@Component
public class Reptile71Job {
    //http://www.71.cn/2019/0306/1036178.shtml
    @Autowired
    ArticleService articleService;
    @Scheduled(cron = "0/15 * * * * *")
    void executeJob()throws Exception{
        log.info(".....................");
        String url="http://www.71.cn/2019/0306/1036178.shtml";
        Article entity= parseArticle(url);
        if(entity!=null){
            this.articleService.save(entity);
        }
    }
    private  Article parseArticle(String url){
        Article entity=null;
        try
        {
            URL uri=new URL(url);
            entity= new Article();
            Document html=Jsoup.parse(uri,3000);
            Elements keywordsEle=html.select("meta[name=keywords]");
            String keywords=keywordsEle.attr("content");
            entity.setSeoKeywords(keywords);
            Elements descriptionEle=html.select("meta[name=description]");
            String description=descriptionEle.attr("content");
            entity.setSeoDescription(description);
            Elements article=html.select(".article-main");
            Elements titleEle=article.select(".article-title");
            String title= titleEle.text();
            entity.setTitle(title);
            Elements subtitle=article.select(".article-subtitle");
            Elements editorsEle=article.select(".editors");
            String editors=editorsEle.text();
            entity.setAuthor(editors);
            Elements date=article.select(".date");
            Elements source=article.select(".source");
            Elements describe=article.select("#describe");
            Elements contentEle=article.select("#article-content");
            entity.setContent(contentEle.outerHtml());
            entity.setCategoryId(BigInteger.ZERO);
            entity.setUserId(BigInteger.ZERO);
        }catch (MalformedURLException e){
            log.error(e.getStackTrace()[0].getMethodName(), e);
        }catch (IOException e){
            log.error(e.getStackTrace()[0].getMethodName(), e);
        }
        return entity;
    }
}
