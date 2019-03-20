package im.heart.material.repository;

import im.heart.material.entity.PeriodicalConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;
import java.util.List;

public interface PeriodicalConfigRepository extends JpaRepository<PeriodicalConfig, BigInteger> ,JpaSpecificationExecutor<PeriodicalConfig> {
	public List<PeriodicalConfig> findByCityIdStartingWithAndTypeAndYear(String cityId, String type, Integer year);
}
