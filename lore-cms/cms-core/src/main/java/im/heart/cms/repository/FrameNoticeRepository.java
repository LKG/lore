package im.heart.cms.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import im.heart.cms.entity.FrameNotice;


public interface FrameNoticeRepository  extends JpaRepository<FrameNotice, BigInteger> ,JpaSpecificationExecutor<FrameNotice> {

}
