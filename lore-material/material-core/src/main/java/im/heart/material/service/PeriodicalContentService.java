package im.heart.material.service;

import im.heart.core.plugins.persistence.SearchFilter;
import im.heart.core.service.CommonService;
import im.heart.material.entity.PeriodicalContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author gg
 * PeriodicalContent对外Service 接口
 */
public interface PeriodicalContentService extends CommonService<PeriodicalContent, BigInteger>{
	public static final String BEAN_NAME = "periodicalContentService";

	/**
	 * 添加异步线程
	 * @param periodicalContent
	 */
	public void addSaveTask(PeriodicalContent periodicalContent) ;
	/**
	 *
	 *批量保存
	 * @param entities
	 * @return
	 */
	public List<PeriodicalContent>  saveAll(Iterable<PeriodicalContent> entities);

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
	public List<PeriodicalContent> findByCityIdAndPeriodicalCode(String cityId, String periodicalCode);

	/**
	 * 条件查询
	 * @param filters
	 * @param pageable
	 * @return
	 */
	public Page<PeriodicalContent> findSearchFilters(Collection<SearchFilter> filters, Pageable pageable);
	
}
