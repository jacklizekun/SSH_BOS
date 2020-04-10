package web.action.bc;

import java.sql.Timestamp;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import domain.bc.Standard;
import domain.user.User;
import page.PageRequestBean;
import page.PageResponseBean;
import web.action.base.BaseAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 收派标准的Action层
 * @author 李泽坤
 *
 */
public class StandardAction extends BaseAction implements ModelDriven<Standard> {

	// 模型驱动
	private Standard standard = new Standard();
	// 获取模型
	@Override
	public Standard getModel() {
		return standard;
	}

	// 保存用户
	public String save() {
		// 获取session中的信息
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		standard.setUser(user);
		//设置系统时间
		standard.setUpdatetime(new Timestamp(System.currentTimeMillis()));
		// 调用业务层保存数据
		standardService.saveStandard(standard);
		//成功
		return "saveSUCCESS";
	}

	//分页查询收派标准数据
	public String pageQuery() {
		//封装分页查询条件对象
		PageRequestBean pageRequestBean = new PageRequestBean();
		//设置页数和行数
		pageRequestBean.setPage(page);
		pageRequestBean.setRows(rows);

		// 面向对象查询
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Standard.class); 
		//0 ： 未删除的数据
		detachedCriteria.add(Restrictions.eq("deltag", "0")); 
		//设置查询条件
		pageRequestBean.setDetachedCriteria(detachedCriteria);
		// 调用业务层
		PageResponseBean pageResponseBean = standardService.pageQuery(pageRequestBean);
		// 将分页查询结果数据，转换 json格式
		ActionContext.getContext().put("pageResponseBean", pageResponseBean);
		//成功
		return "pageQuerySUCCESS";
	}
	// 属性驱动
	private int page;
	private int rows;

	public void setPage(int page) {
		this.page = page;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	// 批量删除
	public String delBatch() {
		// 拆分id，用,分隔
		String[] ids = standard.getId().split(", ");
		// 调用业务层 完成删除
		standardService.delBatch(ids);
		//删除成功
		return "delBatchSUCCESS";
	}
	// 业务方法 --- 查询取派标准 json列表
	public String ajaxlist() {
			// 调用业务层 将列表查出
			List<Standard> standards = standardService.ajaxlist();

			// 将处理结果 转换json返回
			ActionContext.getContext().put("standards", standards);

			return "ajaxlistSUCCESS";
		}
}
