package im.heart.frame.repository;

import im.heart.frame.entity.FrameTpl;
import im.heart.frame.entity.QQGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;

/**
 * 
 * @author gg
 * @Desc : QQGroup CROD 接口
 */
public interface QQGroupRepository extends JpaRepository<QQGroup, BigInteger> ,JpaSpecificationExecutor<QQGroup> {


}
