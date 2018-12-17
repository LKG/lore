package im.heart.cms.service.impl;



import im.heart.cms.entity.FrameImage;
import im.heart.cms.entity.FrameNotice;
import im.heart.cms.repository.FrameNoticeRepository;
import im.heart.cms.service.FrameNoticeService;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import im.heart.core.service.ServiceException;
import im.heart.core.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




@Service(value = FrameNoticeService.BEAN_NAME)
@Transactional(propagation = Propagation.SUPPORTS)
public class FrameNoticeServiceImpl extends CommonServiceImpl<FrameNotice, BigInteger> implements FrameNoticeService {

}
