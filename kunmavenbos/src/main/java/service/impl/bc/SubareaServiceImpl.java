package service.impl.bc;

import java.util.List;

import domain.bc.Subarea;
import page.PageRequestBean;
import page.PageResponseBean;
import service.base.BaseService;
import service.bc.SubareaService;

public class SubareaServiceImpl extends BaseService implements SubareaService {

	@Override
	public void saveOrUpdate(Subarea subarea) {
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
