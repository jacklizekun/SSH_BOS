package bos.service.bc;

import bos.domain.bc.DecidedZone;
import bos.page.PageQuery;

/**
 * 定区管理 业务接口
 * 
 * @author 李泽坤
 * 
 */
public interface DecidedZoneService extends PageQuery {

	//保存定区数据
	public void saveOrUpdate(DecidedZone decidedZone, String[] subareaId);

}
