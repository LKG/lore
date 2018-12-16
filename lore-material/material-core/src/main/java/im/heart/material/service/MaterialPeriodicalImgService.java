package im.heart.material.service;
import im.heart.core.enums.Status;
import im.heart.core.plugins.persistence.SearchFilter;
import im.heart.core.service.CommonService;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import im.heart.material.entity.MaterialPeriodicalImg;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author gg
 * 材料表期刊扫描件对外Service 接口
 */
public interface MaterialPeriodicalImgService extends CommonService<MaterialPeriodicalImg, BigInteger>{
	public static final String BEAN_NAME = "materialPeriodicalImg";
	/**
	 *
	 *批量保存
	 * @param entities
	 * @return
	 */
	public List<MaterialPeriodicalImg>  saveAll(Iterable<MaterialPeriodicalImg> entities);

	
	/**
	 * 扫描件是否存在
	 * @param periodicalCode
	 * @param pageNum
	 * @param cityId
	 * @return
	 */
	public boolean exit(String periodicalCode, Integer pageNum, String cityId);
	/**
	 * 
	 * 查看所以扫描件
	 * @param cityId
	 * @param periodicalCode
	 * @return
	 */
	public List<MaterialPeriodicalImg> findByCityIdAndperiodicalCode(String cityId, String periodicalCode);
	
	
	public  void updateStatusByPeriodicalId(BigInteger periodicalId, Status status);
	public Page<MaterialPeriodicalImg> findSearchFilters(Collection<SearchFilter> filters, Pageable pageable);
	
}
