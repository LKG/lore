package im.heart.search.repository;


import im.heart.search.entity.MaterialPeriodical;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import java.math.BigInteger;

public interface MaterialPeriodicalRepository extends ElasticsearchRepository<MaterialPeriodical, BigInteger> {

}
