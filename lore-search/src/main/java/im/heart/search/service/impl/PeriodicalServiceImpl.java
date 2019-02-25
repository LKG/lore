package im.heart.search.service.impl;

import im.heart.search.repository.PeriodicalRepository;
import im.heart.search.service.PeriodicalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gg
 * 材料搜素对外Service 接口实现类
 */
@Slf4j
@Service(value = PeriodicalService.BEAN_NAME)
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class PeriodicalServiceImpl implements PeriodicalService {
    @Autowired
   private PeriodicalRepository periodicalRepository;

}
