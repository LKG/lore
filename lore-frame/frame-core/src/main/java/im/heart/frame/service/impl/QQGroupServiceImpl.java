package im.heart.frame.service.impl;

import im.heart.core.service.impl.CommonServiceImpl;
import im.heart.frame.entity.FrameTask;
import im.heart.frame.entity.QQGroup;
import im.heart.frame.repository.FrameTaskRepository;
import im.heart.frame.service.FrameTaskService;
import im.heart.frame.service.QQGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Service(value = QQGroupService.BEAN_NAME)
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class QQGroupServiceImpl extends CommonServiceImpl<QQGroup, BigInteger> implements QQGroupService {
}
