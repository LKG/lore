package im.heart.conf;

import com.google.common.collect.Maps;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

import java.util.Collections;
import java.util.Map;

/**
 *
 * @author gg
 * @desc UrlRewriteFilter 配置
 */
@Configuration
public class UrlRewriteFilterConfig {
    private static final String URL_REWRITE = "classpath:/urlrewrite.xml";
    @Order(-1)
    @Bean
    public FilterRegistrationBean urlRewrite(){
        UrlRewriteFilter rewriteFilter=new UrlRewriteFilter();
        FilterRegistrationBean<UrlRewriteFilter> registration = new FilterRegistrationBean<UrlRewriteFilter>(rewriteFilter);
        registration.setUrlPatterns(Collections.singleton("/*"));
        Map initParam= Maps.newHashMap();
        initParam.put("confPath",URL_REWRITE);
        initParam.put("infoLevel","INFO");
        registration.setInitParameters(initParam);
        return  registration;
    }
}
