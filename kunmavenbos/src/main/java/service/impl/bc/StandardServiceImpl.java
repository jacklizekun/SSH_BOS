package service.impl.bc;

import java.util.List;

import domain.bc.Standard;
import page.PageRequestBean;
import page.PageResponseBean;
import service.base.BaseService;
import service.bc.StandardService;
/**
 * 收派标准实现类
 * @author 李泽坤
 *
 */
public class StandardServiceImpl extends BaseService implements StandardService {

	@Override
	public void saveStandard(Standard standard) {
		standardDAO.saveOrUpdate(standard);
	}

	@Override
	public PageResponseBean pageQuery(PageRequestBean pageRequestBean) {
		PageResponseBean pageResponseBean = new PageResponseBean();

		// 满足当前条件，记录总条数
		long total = standardDAO.findTotalCount(pageRequestBean.getDetachedCriteria());
		pageResponseBean.setTotal(total);

		// 查询当前页显示数据
		//开始条数
		int firstResult = (pageRequestBean.getPage() - 1) * pageRequestBean.getRows();
		//最大记录数
		int maxResults = pageRequestBean.getRows();
		// 清除之前 rowCount的投影效果
		pageRequestBean.getDetachedCriteria().setProjection(null); 
		//限制条件查询
		List<Standard> data = standardDAO.pageQuery(pageRequestBean.getDetachedCriteria(), firstResult, maxResults);
		pageResponseBean.setRows(data);

		return pageResponseBean;
	}

	@Override
	public void delBatch(String[] ids) {
		// 将数据 deltag 改为1，代表删除数据 i
		for (String id : ids) {
			Standard standard = standardDAO.findById(id);
			standard.setDeltag("1");
		}
	}
	@Override
	public List<Standard> ajaxlist() {
		return standardDAO.findByNamedQuery("Standard.ajaxlist");
	}
}
