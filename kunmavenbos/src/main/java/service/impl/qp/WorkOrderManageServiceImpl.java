package service.impl.qp;

import domain.qp.WorkOrderManage;
import page.PageRequestBean;
import page.PageResponseBean;
import service.base.BaseService;
import service.qp.WorkOrderManageService;

public class WorkOrderManageServiceImpl extends BaseService implements WorkOrderManageService {

	@Override
	public void saveOrUpdate(WorkOrderManage workOrderManage) {
		workOrderManageDAO.saveOrUpdate(workOrderManage);
	}

	@Override
	public PageResponseBean pageQuery(PageRequestBean pageRequestBean) {
		return pageQuery(pageRequestBean, workOrderManageDAO);
	}

	@Override
	public PageResponseBean queryByLucene(String conditionName, String conditionValue, int page, int rows) {
		return workOrderManageDAO.queryByLucene(conditionName, conditionValue, page, rows);
	}

}
