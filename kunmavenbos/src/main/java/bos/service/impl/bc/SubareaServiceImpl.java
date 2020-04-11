package bos.service.impl.bc;

import java.util.List;

import bos.domain.bc.Subarea;
import bos.page.PageRequestBean;
import bos.page.PageResponseBean;
import bos.service.base.BaseService;
import bos.service.bc.SubareaService;

public class SubareaServiceImpl extends BaseService implements SubareaService {

	@Override
	public void saveOrUpdate(Subarea subarea) {
		// 分区对象中， 关联区域的游离对象，只有id
		subareaDAO.saveOrUpdate(subarea);
	}

	@Override
	public PageResponseBean pageQuery(PageRequestBean pageRequestBean) {
		return pageQuery(pageRequestBean, subareaDAO);
	}

	@Override
	public List<Subarea> findnoassociations() {
		// 分区表中 定区外键 为null
		return subareaDAO.findByNamedQuery("Subarea.findassociations");
	}

}
