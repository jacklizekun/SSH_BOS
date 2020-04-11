package web.action.base;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;

import service.bc.DecidedZoneService;
import service.bc.RegionService;
import service.bc.StaffService;
import service.bc.StandardService;
import service.bc.SubareaService;
import service.qp.NoticeBillService;
import service.user.UserService;

import com.opensymphony.xwork2.ActionSupport;
import service.qp.WorkOrderManageService;
import crm.service.CustomerService;
import page.PageRequestBean;

/**
 * 基础Action
 * @author 李泽坤
 *
 */
public abstract class BaseAction extends ActionSupport {
	//注入用户模块业务层的实体类
	@Resource(name = "userService")
	protected UserService userService;
	//注入标准信息业务层的实体类
	@Resource(name = "standardService")
	protected StandardService standardService;
	@Resource(name = "staffService")
	protected StaffService staffService;
	@Resource(name = "regionService")
	protected RegionService regionService;
	@Resource(name = "subareaService")
	protected SubareaService subareaService;
	@Resource(name = "decidedZoneService")
	protected DecidedZoneService decidedZoneService;
	@Resource(name = "customerService")
	protected CustomerService customerService;
	@Resource(name = "noticeBillService")
	protected NoticeBillService noticeBillService;
	@Resource(name = "workOrderManageService")
	protected WorkOrderManageService workOrderManageService;

	// 属性驱动，封装分页参数
	private int page;
	private int rows;

	public void setPage(int page) {
		this.page = page;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	// 封装PageRequestBean
	public PageRequestBean initPageRequestBean(DetachedCriteria detachedCriteria) {
		// 将分页查询参数 ，封装 PageRequestBean 对象中
		PageRequestBean pageRequestBean = new PageRequestBean();
		pageRequestBean.setPage(getPage());
		pageRequestBean.setRows(getRows());

		pageRequestBean.setDetachedCriteria(detachedCriteria);
		return pageRequestBean;
	}

	public int getPage() {
		return page;
	}

	public int getRows() {
		return rows;
	}
}
