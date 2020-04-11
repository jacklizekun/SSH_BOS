package web.action.qp;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import domain.qp.WorkOrderManage;
import page.PageRequestBean;
import page.PageResponseBean;
import web.action.base.BaseAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class WorkOrderManageAction extends BaseAction implements ModelDriven<WorkOrderManage> {

	// 模型驱动
	private WorkOrderManage workOrderManage = new WorkOrderManage();

	@Override
	public WorkOrderManage getModel() {
		return workOrderManage;
	}

	// 业务方法 ---- 保存工作单
	public String saveOrUpdate() {
		// 调用业务层 完成保存操作
		try {
			workOrderManageService.saveOrUpdate(workOrderManage);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", "success");
			map.put("msg", "保存成功！");
			ActionContext.getContext().put("map", map);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", "failure");
			map.put("msg", "保存失败！异常原因：" + e.getMessage());
			ActionContext.getContext().put("map", map);
		}
		return "saveOrUpdateSUCCESS";
	}

	// 业务方法 --- 分页列表查询
	public String pageQuery() {
		if (conditionName != null && conditionName.trim().length() > 0 && conditionValue != null && conditionValue.trim().length() > 0) {
			// 有查询条件 ，结合lucene索引库查询
			PageResponseBean pageResponseBean = workOrderManageService.queryByLucene(conditionName, conditionValue, getPage(), getRows());
			ActionContext.getContext().put("pageResponseBean", pageResponseBean);

		} else {
			// 无查询条件
			// 无条件查询所有
			DetachedCriteria detachedCriteria = DetachedCriteria.forClass(WorkOrderManage.class);
			PageRequestBean pageRequestBean = initPageRequestBean(detachedCriteria);

			// 调用业务层
			PageResponseBean pageResponseBean = workOrderManageService.pageQuery(pageRequestBean);
			ActionContext.getContext().put("pageResponseBean", pageResponseBean);
		}

		return "pageQuerySUCCESS";
	}

	// 属性驱动
	private String conditionName;
	private String conditionValue;

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue;
	}

}
