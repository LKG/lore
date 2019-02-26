package im.heart.material.service.impl;

import com.google.common.collect.Sets;
import im.heart.core.enums.Status;
import im.heart.core.plugins.persistence.DynamicSpecifications;
import im.heart.core.plugins.persistence.SearchFilter;
import im.heart.core.plugins.persistence.SearchFilter.Operator;
import im.heart.core.service.impl.CommonServiceImpl;
import im.heart.material.entity.PeriodicalLog;
import im.heart.material.repository.PeriodicalLogRepository;
import im.heart.material.service.PeriodicalLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

@Service(value = PeriodicalLogService.BEAN_NAME)
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class PeriodicalLogServiceImpl extends CommonServiceImpl<PeriodicalLog, BigInteger> implements PeriodicalLogService {

	@Autowired
	private PeriodicalLogRepository periodicalLogRepository;

	@Override
	public List<PeriodicalLog> saveAll(Iterable<PeriodicalLog> entities) {
		return this.periodicalLogRepository.saveAll(entities);
	}


	@Override
	public Page<PeriodicalLog> findSearchFilters(
			Collection<SearchFilter> filters, Pageable pageable) {
		if(filters==null||filters.isEmpty()){
			return null;
		}
		Specification<PeriodicalLog> spec = DynamicSpecifications.bySearchFilter(filters, PeriodicalLog.class);
		return this.periodicalLogRepository.findAll(spec,pageable);

	}
}
