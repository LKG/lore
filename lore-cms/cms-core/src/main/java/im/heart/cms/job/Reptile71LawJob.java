package im.heart.cms.job;

import im.heart.cms.entity.Article;
import im.heart.cms.service.ArticleService;
import im.heart.core.utils.DateUtilsEx;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;

@Slf4j
@Component
public class Reptile71LawJob   extends  CommonJob{
    //http://www.71.cn/2019/0306/1036178.shtml
    @Scheduled(cron = "0 57 23 * * ?")
    void executeJob()throws Exception{
        log.info("..........begin...........");
        parseArticleList("http://www.71.cn/acastudies/expcolumn/law/1.shtml","法律");
        log.info("...........end..........");
    }
}
