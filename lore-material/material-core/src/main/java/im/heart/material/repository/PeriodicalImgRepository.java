package im.heart.material.repository;


import java.math.BigInteger;

import javax.transaction.Transactional;

import im.heart.core.enums.Status;
import im.heart.material.entity.PeriodicalImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author gg
 * PeriodicalImg处理Repository
 */
public interface PeriodicalImgRepository extends JpaRepository<PeriodicalImg, BigInteger> ,JpaSpecificationExecutor<PeriodicalImg> {
	/**
	 * 根据期刊Id 删除期刊信息
	 * @param periodicalId
	 */
	@Modifying(clearAutomatically = true)
	@Transactional(rollbackOn = Exception.class)
	@Query("DELETE FROM PeriodicalImg model WHERE model.periodicalId = :periodicalId")
	public void deleteByPeriodicalId(@Param("periodicalId") BigInteger periodicalId);

	/**
	 * 根据期刊Id 更新期刊状态
	 * @param periodicalId
	 * @param status
	 */
	@Modifying(clearAutomatically = true)
	@Transactional(rollbackOn = Exception.class)
	@Query("UPDATE PeriodicalImg model SET model.checkStatus = :status WHERE model.periodicalId = :periodicalId")
	public void updateStatusByPeriodicalId(@Param("periodicalId") BigInteger periodicalId, @Param("status") Status status);
}
