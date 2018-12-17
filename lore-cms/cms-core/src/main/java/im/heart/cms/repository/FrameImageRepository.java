package im.heart.cms.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import im.heart.cms.entity.FrameImage;


public interface FrameImageRepository  extends JpaRepository<FrameImage, BigInteger> ,JpaSpecificationExecutor<FrameImage> {

}
