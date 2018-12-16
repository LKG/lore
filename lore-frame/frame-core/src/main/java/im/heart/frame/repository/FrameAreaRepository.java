package im.heart.frame.repository;

import im.heart.frame.entity.FrameArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 
 * @author gg
 * @desc 区域表CROD 接口
 */
public interface FrameAreaRepository extends JpaRepository<FrameArea, String> ,JpaSpecificationExecutor<FrameArea> {

}
