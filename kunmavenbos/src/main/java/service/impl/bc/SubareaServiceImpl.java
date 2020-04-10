package service.impl.bc;

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

}
