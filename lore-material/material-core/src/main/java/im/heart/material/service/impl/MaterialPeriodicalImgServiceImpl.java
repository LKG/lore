package im.heart.material.service.impl;

import com.google.common.collect.Sets;
import im.heart.core.enums.Status;
import im.heart.core.plugins.persistence.DynamicSpecifications;
import im.heart.core.plugins.persistence.SearchFilter;
import im.heart.core.plugins.persistence.SearchFilter.Operator;
import im.heart.core.service.impl.CommonServiceImpl;
import im.heart.material.entity.MaterialPeriodicalImg;
import im.heart.material.repository.MaterialPeriodicalImgRepository;
import im.heart.material.service.MaterialPeriodicalImgService;
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

@Service(value = MaterialPeriodicalImgService.BEAN_NAME)
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class MaterialPeriodicalImgServiceImpl  extends CommonServiceImpl<MaterialPeriodicalImg, BigInteger> implements MaterialPeriodicalImgService {

	@Autowired
	private MaterialPeriodicalImgRepository materialPeriodicalImgRepository;

	@Override
	public List<MaterialPeriodicalImg> saveAll(Iterable<MaterialPeriodicalImg> entities) {
		return this.materialPeriodicalImgRepository.saveAll(entities);
	}

	@Override
	public boolean exit(String periodicalCode, Integer pageNum, String cityId) {
		final Collection<SearchFilter> filters  = Sets.newHashSet();
		filters.add(new SearchFilter("pageNum", Operator.EQ, pageNum));
		filters.add(new SearchFilter("cityId", Operator.EQ, cityId));
		filters.add(new SearchFilter("periodicalCode", Operator.EQ, periodicalCode));
		Specification<MaterialPeriodicalImg> spec = DynamicSpecifications.bySearchFilter(filters, MaterialPeriodicalImg.class);
		long countSign = this.materialPeriodicalImgRepository.count(spec);
		return countSign <= 0;
	}

	@Override
	public List<MaterialPeriodicalImg> findByCityIdAndperiodicalCode(
			String cityId, String periodicalCode) {
		final Collection<SearchFilter> filters = Sets.newHashSet();
		filters.add(new SearchFilter("cityId", Operator.EQ, cityId));
		filters.add(new SearchFilter("periodicalCode", Operator.EQ, periodicalCode));
		Specification<MaterialPeriodicalImg> spec = DynamicSpecifications.bySearchFilter(filters, MaterialPeriodicalImg.class);
		return this.materialPeriodicalImgRepository.findAll(spec);
	}

	@Override
	public void updateStatusByPeriodicalId(BigInteger periodicalId,
			Status status) {
		this.materialPeriodicalImgRepository.updateStatusByPeriodicalId(periodicalId,status);
	}

	@Override
	public Page<MaterialPeriodicalImg> findSearchFilters(
			Collection<SearchFilter> filters, Pageable pageable) {
		if(filters==null||filters.isEmpty()){
			return null;
		}
		Specification<MaterialPeriodicalImg> spec = DynamicSpecifications.bySearchFilter(filters, MaterialPeriodicalImg.class);
		return this.materialPeriodicalImgRepository.findAll(spec,pageable);

	}
}
