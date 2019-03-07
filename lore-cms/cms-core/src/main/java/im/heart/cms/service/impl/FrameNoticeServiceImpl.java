package im.heart.cms.service.impl;

import im.heart.cms.entity.FrameNotice;
import im.heart.cms.service.FrameNoticeService;
import im.heart.core.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

/**
 *
 * @author gg
 * @desc 公告
 */
@Service(value = FrameNoticeService.BEAN_NAME)
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class FrameNoticeServiceImpl extends CommonServiceImpl<FrameNotice, BigInteger> implements FrameNoticeService {

}
