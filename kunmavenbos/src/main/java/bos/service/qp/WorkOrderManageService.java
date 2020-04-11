package bos.service.qp;

import java.util.List;

import bos.domain.qp.WorkOrderManage;
import bos.page.PageQuery;
import bos.page.PageResponseBean;

/**
 * 工作单管理 业务接口
 * 
 * @author 李泽坤
 * 
 */
public interface WorkOrderManageService extends PageQuery {

	// 保存工作单信息
	public void saveOrUpdate(WorkOrderManage workOrderManage);

	//结合lucene索引库进行分页查询
	public PageResponseBean queryByLucene(String conditionName, String conditionValue, int page, int rows);

	// 查询未审核工作单 managerCheck字段为 0
	public List<WorkOrderManage> listUnCheckWorkOrderManages();

	// 对工作单审核
	public void check(WorkOrderManage workOrderManage);

}
