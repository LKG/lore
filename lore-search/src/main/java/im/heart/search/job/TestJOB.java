package im.heart.search.job;

import im.heart.search.entity.Periodical;
import im.heart.search.repository.PeriodicalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@Component
public class TestJOB {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PeriodicalRepository periodicalRepository;

     @Scheduled(cron = "0/15 * * * * *")
    void executeJob()throws Exception{

         Iterable<Periodical> list=this.periodicalRepository.findAll();
         log.info("=====>>>>>list{}",list.iterator());
    };
}
