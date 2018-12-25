package im.heart.search.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestJob {
    /**
     *  //每隔5秒执行一次定时任务
     */
    @Scheduled(cron = "0/5 * * * * ?")
    void tets(){
        System.out.println("@@@@@@@@@@@2");
    }
}
