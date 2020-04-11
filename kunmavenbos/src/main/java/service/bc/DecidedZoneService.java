package service.bc;

import domain.bc.DecidedZone;
import page.PageQuery;

/**
 * 
 * @author 李泽坤
 *
 */
public interface DecidedZoneService extends PageQuery {

	//保存定区数据
	public void saveOrUpdate(DecidedZone decidedZone, String[] subareaId);

}