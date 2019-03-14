package im.heart.cms.job;

import im.heart.cms.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Async;
import java.io.IOException;
import java.net.URL;

@Slf4j
public abstract class  AbstractJob {
    Integer MAX_PAGE=5;
    @Async
    public void parseArticleList(String url,String type){
        try {
            String pageStr= StringUtils.substringAfterLast(url,"/");
            pageStr=StringUtils.substringBefore(pageStr,".");
            if(Integer.valueOf(pageStr)>MAX_PAGE){
                log.error(url);
                return;
            }
            Document listEle= Jsoup.parse(new URL(url),5000);
            Elements articleEle=listEle.select(".articlelist_title a");
            for (Element article:articleEle){
                String articleUrl=article.attr("href");
                parseArticle(articleUrl,type);
            }
            Elements pages=listEle.select(".page_box a.next");
            if(pages.hasClass("disable")){
                return;
            }
            String aUrl=pages.attr("href");
            parseArticleList(aUrl,type);
        } catch (IOException e) {
            log.error(url);
            log.error(e.getStackTrace()[0].getMethodName(), e);
        }
    }

    public abstract Article parseArticle(String url, String type);
}
