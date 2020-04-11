package service.impl.bc;

import domain.bc.DecidedZone;
import domain.bc.Subarea;
import page.PageRequestBean;
import page.PageResponseBean;
import service.base.BaseService;
import service.bc.DecidedZoneService;
/**
 * 定区实现类
 * @author 李泽坤
 *
 */
public class DecidedZoneServiceImpl extends BaseService implements DecidedZoneService {

	@Override
	public void saveOrUpdate(DecidedZone decidedZone, String[] subareaIds) {
		// 保存定区数据
		decidedZoneDAO.save(decidedZone);

		// 实现定区和分区关联（用分区 对象 关联 定区 多方关联一方）
		for (String id : subareaIds) {
			Subarea subarea = subareaDAO.findById(id); // 分区持久对象
			subarea.setDecidedZone(decidedZone);
		}
	}

	@Override
	public PageResponseBean pageQuery(PageRequestBean pageRequestBean) {
		return pageQuery(pageRequestBean, decidedZoneDAO);
	}

}