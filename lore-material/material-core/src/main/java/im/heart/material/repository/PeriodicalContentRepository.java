package im.heart.material.repository;

import im.heart.material.entity.PeriodicalContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 *
 * @author gg
 * PeriodicalContent处理Repository
 */
@Repository
public interface PeriodicalContentRepository extends JpaRepository<PeriodicalContent, BigInteger> ,JpaSpecificationExecutor<PeriodicalContent> {

}
