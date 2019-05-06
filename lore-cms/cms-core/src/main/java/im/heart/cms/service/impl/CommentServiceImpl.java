package im.heart.cms.service.impl;

import java.math.BigInteger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import im.heart.cms.entity.Comment;
import im.heart.cms.service.CommentService;
import im.heart.core.service.impl.CommonServiceImpl;
/**
 * 
 * @author gg
 * @desc 评论
 */
@Service(value = CommentService.BEAN_NAME)
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class CommentServiceImpl extends CommonServiceImpl<Comment, BigInteger> implements CommentService {

	
}
