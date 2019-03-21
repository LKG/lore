package im.heart.cms.repository;


import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import im.heart.cms.entity.FriendLink;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gg
 * @desc FriendLink 接口
 */
@Repository
public interface FriendLinkRepository extends JpaRepository<FriendLink, BigInteger> ,JpaSpecificationExecutor<FriendLink> {


}
