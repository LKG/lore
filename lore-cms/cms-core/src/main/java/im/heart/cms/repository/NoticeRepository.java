package im.heart.cms.repository;

import im.heart.cms.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;


public interface NoticeRepository  extends JpaRepository<Notice, BigInteger> ,JpaSpecificationExecutor<Notice> {

}
