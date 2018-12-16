package im.heart.material.service.impl;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import com.google.common.collect.Sets;
import im.heart.core.service.impl.CommonServiceImpl;
import im.heart.material.entity.MaterialPeriodicalImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import im.heart.material.entity.MaterialCategory;
import im.heart.material.repository.MaterialCategoryRepository;
import im.heart.material.service.MaterialCategoryService;
import im.heart.core.plugins.persistence.DynamicSpecifications;
import im.heart.core.plugins.persistence.SearchFilter;
import im.heart.core.plugins.persistence.SearchFilter.Operator;
/**
 * @author gg
 */
@Service(value = MaterialCategoryService.BEAN_NAME)
@Transactional(propagation = Propagation.SUPPORTS)
public class MaterialCategoryServiceImpl   extends CommonServiceImpl<MaterialCategory, BigInteger> implements 	MaterialCategoryService {

	@Autowired
	private MaterialCategoryRepository materialCategoryRepository;

	@Override
	public List<MaterialCategory> saveAll(Iterable<MaterialCategory> entities) {
		return this.materialCategoryRepository.saveAll(entities);
	}

	@Override
	public List<MaterialCategory> findByParentId(BigInteger parentId) {
		return this.materialCategoryRepository.findByParentId(parentId);
	}
	@Override
	public boolean exit(String categoryCode) {
		final Collection<SearchFilter> filters =  Sets.newHashSet();
		filters.add(new SearchFilter("categoryCode", Operator.EQ, categoryCode));
		Specification<MaterialCategory> spec = DynamicSpecifications.bySearchFilter(filters, MaterialCategory.class);
		long countSign = this.materialCategoryRepository.count(spec);
		return countSign <= 0;
	}
	@Override
	public List<MaterialCategory> findByPParentIdAndLevel(String ppCode, Integer level) {
		final Collection<SearchFilter> filters = Sets.newHashSet();
		filters.add(new SearchFilter("categoryCode", Operator.LIKES, ppCode));
		filters.add(new SearchFilter("level", Operator.EQ, level));
		Specification<MaterialCategory> spec = DynamicSpecifications.bySearchFilter(filters, MaterialCategory.class);
		return this.materialCategoryRepository.findAll(spec);
	}

	@Override
	public List<MaterialCategory> findByCategoryCodeStartingWith(String categoryCode) {
		// TODO Auto-generated method stub
		return this.materialCategoryRepository.findByCategoryCodeStartingWith(categoryCode);
	}


}
