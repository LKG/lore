package im.heart.cms.repository;


import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import im.heart.cms.entity.Ad;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gg
 * @desc Ad接口
 */
@Repository
public interface AdRepository extends JpaRepository<Ad, BigInteger> ,JpaSpecificationExecutor<Ad> {


}
