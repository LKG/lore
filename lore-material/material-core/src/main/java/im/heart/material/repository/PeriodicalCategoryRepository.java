package im.heart.material.repository;

import java.math.BigInteger;
import java.util.List;

import im.heart.material.entity.PeriodicalCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PeriodicalCategoryRepository extends JpaRepository<PeriodicalCategory, BigInteger> ,JpaSpecificationExecutor<PeriodicalCategory> {

	public List<PeriodicalCategory> findByCategoryCodeStartingWith(String categoryCode);
	
	@Query("select new PeriodicalCategory(model.categoryId, model.categoryCode, model.categoryName,model.parentId , model.level, model.status) from PeriodicalCategory model where model.parentId = :parentId")
	public List<PeriodicalCategory> findByParentId(@Param("parentId") BigInteger parentId);
	
}
