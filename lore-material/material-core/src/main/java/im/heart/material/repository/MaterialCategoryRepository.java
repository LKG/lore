package im.heart.material.repository;

import java.math.BigInteger;
import java.util.List;

import im.heart.material.entity.MaterialCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MaterialCategoryRepository extends JpaRepository<MaterialCategory, BigInteger> ,JpaSpecificationExecutor<MaterialCategory> {
	
	public List<MaterialCategory> findByCategoryCodeStartingWith(String categoryCode);
	
	@Query("select new MaterialCategory(model.categoryId, model.categoryCode, model.categoryName,model.parentId , model.level, model.status) from MaterialCategory model where model.parentId = :parentId")
	public List<MaterialCategory> findByParentId(@Param("parentId") BigInteger parentId);
	
}
