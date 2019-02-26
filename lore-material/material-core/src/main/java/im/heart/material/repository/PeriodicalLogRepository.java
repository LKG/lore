package im.heart.material.repository;

import im.heart.material.entity.PeriodicalLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;

/**
 *
 * @author gg
 * Periodical日志处理Repository
 */
public interface PeriodicalLogRepository extends JpaRepository<PeriodicalLog, BigInteger> ,JpaSpecificationExecutor<PeriodicalLog> {

}
