package im.heart.cms.service.impl;



import im.heart.cms.entity.AdPosition;
import im.heart.cms.entity.FrameImage;
import im.heart.cms.repository.FrameImageRepository;
import im.heart.cms.service.FrameImageService;
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




@Service(value = FrameImageService.BEAN_NAME)
@Transactional(propagation = Propagation.SUPPORTS)
public class FrameImageServiceImpl extends CommonServiceImpl<FrameImage, BigInteger> implements FrameImageService {

}
