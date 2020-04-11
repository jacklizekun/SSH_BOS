package bos.service.base;

import java.util.List;

import javax.annotation.Resource;

import org.jbpm.api.ProcessEngine;

import bos.dao.GenericDAO;
import bos.domain.auth.Function;
import bos.domain.auth.Role;
import bos.domain.bc.DecidedZone;
import bos.domain.bc.Region;
import bos.domain.bc.Staff;
import bos.domain.bc.Standard;
import bos.domain.bc.Subarea;
import bos.domain.qp.NoticeBill;
import bos.domain.qp.WorkBill;
import bos.domain.qp.WorkOrderManage;
import bos.domain.user.User;
import bos.domain.zm.InStore;
import bos.domain.zm.OutStore;
import bos.domain.zm.ReceiveGoodsInfo;
import bos.domain.zm.TransferInfo;
import bos.domain.zm.ZhongZhuanInfo;
import bos.page.PageRequestBean;
import bos.page.PageResponseBean;
import crm.service.CustomerService;

/**
 * 业务层 抽象 （实现业务层代码复用）
 * 
 * @author 李泽坤
 * 
 */
public abstract class BaseService {
	@Resource(name = "userDAO")
	protected GenericDAO<User> userDAO;

	@Resource(name = "standardDAO")
	protected GenericDAO<Standard> standardDAO;

	@Resource(name = "staffDAO")
	protected GenericDAO<Staff> staffDAO;

	@Resource(name = "regionDAO")
	protected GenericDAO<Region> regionDAO;

	@Resource(name = "subareaDAO")
	protected GenericDAO<Subarea> subareaDAO;

	@Resource(name = "decidedZoneDAO")
	protected GenericDAO<DecidedZone> decidedZoneDAO;

	@Resource(name = "noticeBillDAO")
	protected GenericDAO<NoticeBill> noticeBillDAO;

	@Resource(name = "workBillDAO")
	protected GenericDAO<WorkBill> workBillDAO;

	@Resource(name = "customerService")
	protected CustomerService customerService;

	@Resource(name = "workOrderManageDAO")
	protected GenericDAO<WorkOrderManage> workOrderManageDAO;

	@Resource(name = "functionDAO")
	protected GenericDAO<Function> funtionDAO;

	@Resource(name = "roleDAO")
	protected GenericDAO<Role> roleDAO;

	@Resource(name = "processEngine")
	protected ProcessEngine processEngine;

	@Resource(name = "zhongZhuanInfoDAO")
	protected GenericDAO<ZhongZhuanInfo> zhongZhuanInfoDAO;

	@Resource(name = "transferInfoDAO")
	protected GenericDAO<TransferInfo> transferInfoDAO;

	@Resource(name = "inStoreDAO")
	protected GenericDAO<InStore> inStoreDAO;

	@Resource(name = "outStoreDAO")
	protected GenericDAO<OutStore> outStoreDAO;

	@Resource(name = "receiveGoodsInfoDAO")
	protected GenericDAO<ReceiveGoodsInfo> receiveGoodsInfoDAO;

	// 分页通用代码
	public <T> PageResponseBean pageQuery(PageRequestBean pageRequestBean, GenericDAO<T> dao) {
		PageResponseBean pageResponseBean = new PageResponseBean();

		// 查询当前页显示数据
		int firstResult = (pageRequestBean.getPage() - 1) * pageRequestBean.getRows(); // 　从哪条开始
		int maxResults = pageRequestBean.getRows(); // 返回记录数
		List<T> data = dao.pageQuery(pageRequestBean.getDetachedCriteria(), firstResult, maxResults);
		pageResponseBean.setRows(data);

		// 满足当前条件，记录总条数
		long total = dao.findTotalCount(pageRequestBean.getDetachedCriteria());
		pageResponseBean.setTotal(total);

		return pageResponseBean;
	}

}
