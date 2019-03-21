package im.heart.cms.repository;


import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import im.heart.cms.entity.Comment;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gg
 * @desc 评论接口
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, BigInteger> ,JpaSpecificationExecutor<Comment> {


}
