package service.base;

import java.util.List;

import javax.annotation.Resource;

import dao.GenericDAO;
import domain.bc.Region;
import domain.bc.Staff;
import domain.bc.Standard;
import domain.bc.Subarea;
import domain.user.User;
import page.PageRequestBean;
import page.PageResponseBean;

/**
 * 基础业务层
 * @author 李泽坤
 *
 */
public abstract class BaseService {
	//注入UserDAO
	@Resource(name = "userDAO")
	protected GenericDAO<User> userDAO;
	//注入StandardDAO
	@Resource(name = "standardDAO")
	protected GenericDAO<Standard> standardDAO;
	@Resource(name = "staffDAO")
	protected GenericDAO<Staff> staffDAO;
	@Resource(name = "regionDAO")
	protected GenericDAO<Region> regionDAO;
	@Resource(name = "subareaDAO")
	protected GenericDAO<Subarea> subareaDAO;
	
	// 分页通用代码
		public <T> PageResponseBean pageQuery(PageRequestBean pageRequestBean, GenericDAO<T> dao) {
			PageResponseBean pageResponseBean = new PageResponseBean();

			// 满足当前条件，记录总条数
			long total = dao.findTotalCount(pageRequestBean.getDetachedCriteria());
			pageResponseBean.setTotal(total);

			// 查询当前页显示数据
			int firstResult = (pageRequestBean.getPage() - 1) * pageRequestBean.getRows(); // 　从哪条开始
			int maxResults = pageRequestBean.getRows(); // 返回记录数
			pageRequestBean.getDetachedCriteria().setProjection(null); // 清除之前 rowCount的投影效果
			List<T> data = dao.pageQuery(pageRequestBean.getDetachedCriteria(), firstResult, maxResults);
			pageResponseBean.setRows(data);

			return pageResponseBean;
		}
}
