package im.heart.usercore.repository;

import im.heart.usercore.entity.FrameRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigInteger;

/**
 * 
 * @author gg
 * @Desc :角色Repository
 */
public interface FrameRoleRepository extends JpaRepository<FrameRole, BigInteger> ,JpaSpecificationExecutor<FrameRole> {
	public FrameRole findByRoleCode(String roleCode);
}
