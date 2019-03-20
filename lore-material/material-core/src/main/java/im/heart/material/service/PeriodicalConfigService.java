package im.heart.material.service;


import im.heart.core.service.CommonService;
import im.heart.material.entity.PeriodicalConfig;
import im.heart.material.enums.PackageType;

import java.math.BigInteger;
import java.util.List;

/**
 * @author gg
 * 期刊配置表对外Service 接口
 */
public interface PeriodicalConfigService extends CommonService<PeriodicalConfig, BigInteger> {
	public static final String BEAN_NAME = "periodicalConfigService";
	/**
	 *
	 * @功能说明：批量保存
	 * @param entities
	 * @return
	 */
	public List<PeriodicalConfig>  save(Iterable<PeriodicalConfig> entities);
	/**
	 * 
	 * @功能说明：
	 * @param entitie
	 * @return
	 */
	public PeriodicalConfig save(PeriodicalConfig entitie);
	
	public boolean exits(String cityId, Integer year, String periodicalType);
	
	public PeriodicalConfig findBycityIdAndYearAndType(String cityId, Integer year, PackageType periodicalType);
	public List<PeriodicalConfig> findByCityIdStartingWithAndTypeAndYear(String cityId, String type, Integer year);
	
	public void deleteById(BigInteger id);

}
