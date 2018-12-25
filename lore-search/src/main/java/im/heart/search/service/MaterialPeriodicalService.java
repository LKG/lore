package im.heart.search.service;

import im.heart.core.service.CommonService;
import im.heart.search.entity.MaterialPeriodical;

import java.math.BigInteger;

/**
 * 
 * @author gg
 * 材料价格表对外Service 接口
 */
public interface MaterialPeriodicalService extends CommonService<MaterialPeriodical, BigInteger>{
	public static final String BEAN_NAME = "materialPeriodicalSearchService";
}
