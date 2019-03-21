package im.heart.cms.repository;


import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import im.heart.cms.entity.AdPosition;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gg
 * @desc AdPosition接口
 */
@Repository
public interface AdPositionRepository extends JpaRepository<AdPosition, BigInteger> ,JpaSpecificationExecutor<AdPosition> {


}
