package im.heart.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
/**
 *
 * @author gg
 * @desc spring session 配置
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=60*60*24*7)
public class SpringSessionConfig {
}
