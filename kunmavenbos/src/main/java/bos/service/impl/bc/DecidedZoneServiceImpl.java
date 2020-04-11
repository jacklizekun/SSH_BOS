package bos.service.impl.bc;

import bos.domain.bc.DecidedZone;
import bos.domain.bc.Subarea;
import bos.page.PageRequestBean;
import bos.page.PageResponseBean;
import bos.service.base.BaseService;
import bos.service.bc.DecidedZoneService;

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
