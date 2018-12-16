package im.heart.material.service.impl;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import com.google.common.collect.Sets;
import im.heart.core.CommonConst;
import im.heart.core.enums.Status;
import im.heart.core.service.impl.CommonServiceImpl;
import im.heart.material.entity.MaterialPeriodicalImg;
import im.heart.material.repository.MaterialPeriodicalImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import im.heart.material.entity.MaterialPeriodical;
import im.heart.material.entity.MaterialPeriodical.PeriodicalType;
import im.heart.material.repository.MaterialPeriodicalRepository;
import im.heart.material.service.MaterialPeriodicalService;
import im.heart.core.service.ServiceException;
import im.heart.core.plugins.persistence.DynamicSpecifications;
import im.heart.core.plugins.persistence.SearchFilter;
import im.heart.core.plugins.persistence.SearchFilter.Operator;

@Service(value = MaterialPeriodicalService.BEAN_NAME)
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class MaterialPeriodicalServiceImpl   extends CommonServiceImpl<MaterialPeriodical, BigInteger> implements MaterialPeriodicalService {
	@Autowired
	private MaterialPeriodicalRepository materialPeriodicalRepository;

	@Autowired
	private MaterialPeriodicalImgRepository materialPeriodicalImgRepository;

	@Override
	public List<MaterialPeriodical> findAllById(Iterable<BigInteger>  ids ) {
		return this.materialPeriodicalRepository.findAllById(ids);
	}

	@Override
	public void deleteById(BigInteger id)  throws ServiceException{
		this.materialPeriodicalRepository.deleteById(id);
		this.materialPeriodicalImgRepository.deleteByPeriodicalId(id);
	}
	@Override
	public List<MaterialPeriodical> findByStatusAndType(Status status, PeriodicalType type) {
		final Collection<SearchFilter> filters = Sets.newHashSet();
		filters.add(new SearchFilter("status", Operator.EQ, status));
		filters.add(new SearchFilter("periodicalType", Operator.EQ, type.value+""));
		Specification<MaterialPeriodical> spec = DynamicSpecifications.bySearchFilter(filters, MaterialPeriodical.class);
		return this.materialPeriodicalRepository.findAll(spec);
	}
	@Override
	public Page<MaterialPeriodical> findInitPeriodicalByType(PeriodicalType type,Pageable pageable) {
		final Collection<SearchFilter> filters = Sets.newHashSet();
		filters.add(new SearchFilter("status", Operator.EQ, CommonConst.FlowStatus.INITIAL));
		filters.add(new SearchFilter("periodicalType", Operator.EQ, type.value+""));
		Specification<MaterialPeriodical> spec = DynamicSpecifications.bySearchFilter(filters, MaterialPeriodical.class);
		return this.materialPeriodicalRepository.findAll(spec,pageable);
	}
	@Override
	public  void updateStatusByPeriodicalId(BigInteger periodicalId,Status status){
		this.materialPeriodicalRepository.updateStatusByPeriodicalId(periodicalId,status);
	};
}
