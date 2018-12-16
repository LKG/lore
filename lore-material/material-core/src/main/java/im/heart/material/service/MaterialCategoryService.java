package im.heart.material.service;

import im.heart.material.entity.MaterialCategory;
import im.heart.core.service.CommonService;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author gg
 * 材料分类表对外Service 接口
 */
public interface MaterialCategoryService extends CommonService<MaterialCategory, BigInteger>{
	public static final String BEAN_NAME = "materialCategory";

	/**
	 *
	 * 批量保存
	 * @param entities
	 * @return
	 */
	public List<MaterialCategory>  saveAll(Iterable<MaterialCategory> entities);
	/**
	 *
	 *
	 * @param entitie
	 * @return
	 */
	public MaterialCategory save(MaterialCategory entitie);

	public  List<MaterialCategory>  findByParentId(BigInteger parentId);

	/**
	 * 获取分类信息
	 * @param ppCode 顶节点code
	 * @return
	 */
	public  List<MaterialCategory>  findByPParentIdAndLevel(String ppCode, Integer level);

	public List<MaterialCategory> findByCategoryCodeStartingWith(String categoryCode);

	public boolean exit(String categoryCode);
}
