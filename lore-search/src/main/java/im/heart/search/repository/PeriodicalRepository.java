package im.heart.search.repository;


import im.heart.search.entity.Periodical;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.math.BigInteger;
/**
 *
 * @author gg
 * 材料表对外Repository 接口
 */
public interface PeriodicalRepository extends ElasticsearchRepository<Periodical, BigInteger> {

}
