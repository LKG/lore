package im.heart.material.service;

import im.heart.core.enums.Status;
import im.heart.material.entity.MaterialPeriodical.PeriodicalType;
import im.heart.material.entity.MaterialPeriodical;
import im.heart.core.service.CommonService;
import java.math.BigInteger;
import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 
 * @author gg
 * 材料价格表对外Service 接口
 */
public interface MaterialPeriodicalService extends CommonService<MaterialPeriodical, BigInteger>{
	public static final String BEAN_NAME = "materialPeriodicalService";

	
	public List<MaterialPeriodical>  findByStatusAndType(Status status, PeriodicalType type);

	public List<MaterialPeriodical>  findAllById(Iterable<BigInteger> ids);
	
	public Page<MaterialPeriodical> findInitPeriodicalByType(PeriodicalType type, Pageable pageable);

	public  void updateStatusByPeriodicalId(BigInteger periodicalId, Status status);
}
