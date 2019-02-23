package im.heart.material.repository;

import im.heart.core.enums.Status;
import im.heart.material.entity.Periodical;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PeriodicalRepository extends JpaRepository<Periodical, BigInteger> ,JpaSpecificationExecutor<Periodical> {

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE Periodical model SET model.checkStatus = :checkStatus WHERE model.id = :periodicalId")
	public void updateStatusByPeriodicalId(@Param("periodicalId") BigInteger periodicalId, @Param("checkStatus") Status checkStatus);

	public List<Periodical> findByPeriodicalCodeAndCityIdAndPeriodicalType(String periodicalCode, String cityId, String periodicalType);
}
