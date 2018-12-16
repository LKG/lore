package im.heart.material.repository;

import im.heart.core.enums.Status;
import im.heart.material.entity.MaterialPeriodical;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MaterialPeriodicalRepository extends JpaRepository<MaterialPeriodical, BigInteger> ,JpaSpecificationExecutor<MaterialPeriodical> {

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE MaterialPeriodical model SET model.checkStatus = :checkStatus WHERE model.id = :periodicalId")
	public void updateStatusByPeriodicalId(@Param("periodicalId") BigInteger periodicalId, @Param("checkStatus") Status checkStatus);

	public List<MaterialPeriodical> findByPeriodicalCodeAndCityIdAndPeriodicalType(String periodicalCode, String cityId, String periodicalType);
}
