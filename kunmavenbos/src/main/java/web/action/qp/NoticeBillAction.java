package web.action.qp;

import org.apache.struts2.ServletActionContext;

import domain.qp.NoticeBill;
import domain.user.User;
import web.action.base.BaseAction;

import com.opensymphony.xwork2.ModelDriven;

/**
 * 业务通知
 * @author 李泽坤
 *
 */
public class NoticeBillAction extends BaseAction implements ModelDriven<NoticeBill> {

	// 模型驱动
	private NoticeBill noticeBill = new NoticeBill();

	@Override
	public NoticeBill getModel() {
		return noticeBill;
	}

	// 业务方法 --- 新增工作单
	public String save() {
		// 完善model信息
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		noticeBill.setUser(user);

		// 调用业务层，完成通知单新增
		noticeBillService.saveNoticeBill(noticeBill);

		return "saveSUCCESS";
	}

}
