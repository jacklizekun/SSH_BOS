package service.qp;

import domain.qp.WorkOrderManage;
import page.PageQuery;
import page.PageResponseBean;

public interface WorkOrderManageService extends PageQuery {

	//保存工作单信息
	public void saveOrUpdate(WorkOrderManage workOrderManage);

	//结合lucene索引库进行分页查询
	public PageResponseBean queryByLucene(String conditionName, String conditionValue, int page, int rows);

}
