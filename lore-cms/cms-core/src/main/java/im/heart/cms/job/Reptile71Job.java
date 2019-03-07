package im.heart.cms.job;

import im.heart.core.utils.OkHttpClientUtils;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
@Component
public class Reptile71Job {
    //http://www.71.cn/2019/0306/1036178.shtml

    public static void main(String[] args) {
        try
        {
            URL url=new URL("http://www.71.cn/2019/0306/1036178.shtml");
            Document html=Jsoup.parse(url,3000);
            Elements keywords=html.select("meta[name=keywords]");
            Elements description=html.select("meta[name=description]");
            Elements article=html.select(".article-main");
            Elements title=article.select(".article-title");
            Elements subtitle=article.select(".article-subtitle");
            Elements editors=article.select(".editors");
            Elements date=article.select(".date");
            Elements source=article.select(".source");
            Elements describe=article.select("#describe");
            Elements content=article.select("#article-content");

            System.out.println(keywords);
            System.out.println(html);
        }catch (MalformedURLException e){

        }catch (IOException e){

        }

    }
}
