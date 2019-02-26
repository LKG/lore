package im.heart.material.service;

import im.heart.core.plugins.persistence.SearchFilter;
import im.heart.core.service.CommonService;
import im.heart.material.entity.PeriodicalImg;
import im.heart.material.entity.PeriodicalLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author gg
 * 材料表期刊扫描件对外Service 接口
 */
public interface PeriodicalLogService extends CommonService<PeriodicalLog, BigInteger>{
	public static final String BEAN_NAME = "periodicalLogService";
	/**
	 *
	 *批量保存
	 * @param entities
	 * @return
	 */
	public List<PeriodicalLog>  saveAll(Iterable<PeriodicalLog> entities);

	/**
	 * 条件查询
	 * @param filters
	 * @param pageable
	 * @return
	 */
	public Page<PeriodicalLog> findSearchFilters(Collection<SearchFilter> filters, Pageable pageable);
}
