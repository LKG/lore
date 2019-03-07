package im.heart.search.job;

import im.heart.search.entity.Periodical;
import im.heart.search.repository.PeriodicalRepository;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Iterator;
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
        this.jdbcTemplate.queryForList("select * from media_periodical;");
         Iterable<Periodical> its=this.periodicalRepository.findAll();
         //多条件设置
         MatchPhraseQueryBuilder mpq1 = QueryBuilders
                 .matchPhraseQuery("pointid","W3.UNIT1.10LBG01CP301");
         MatchPhraseQueryBuilder mpq2 = QueryBuilders
                 .matchPhraseQuery("inputtime","2016-07-21 00:00:01");
         QueryBuilder qb2 = QueryBuilders.boolQuery()
                 .must(mpq1)
                 .must(mpq2);
         SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
         SearchSourceBuilder query = sourceBuilder.query(qb2);

         Iterator it= its.iterator();
         log.info("=====>>>>>list{}",query.toString());
         while (it.hasNext()){
             Periodical p=(Periodical)it.next();
             log.info("=====>>>>>list{}",p.getContent());
         }

    }
}
