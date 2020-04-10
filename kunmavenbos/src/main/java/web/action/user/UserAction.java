package web.action.user;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import domain.user.User;
import web.action.base.BaseAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 用户信息管理Action模块
 * @author 李泽坤
 *
 */
public class UserAction extends BaseAction implements ModelDriven<User> {

	// 模型驱动
	private User user = new User();
	
	//获取用户模型
	@Override
	public User getModel() {
		return user;
	}

	//修改密码
	public String editpassword() {
		
		// 获取session中的user信息
		User loginUser = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		// 获取session中的user的id
		user.setId(loginUser.getId());
		try {
			//用户业务层修改密码
			userService.editPassword(user);
			// 新建map
			Map<String, Object> map = new HashMap<String, Object>();
			//成功
			map.put("result", "success");
			map.put("msg", "修改密码成功");
			//将信息放入map中
			ActionContext.getContext().put("map", map);
		} catch (Exception e) {
			// 新建map
			Map<String, Object> map = new HashMap<String, Object>();
			//失败
			map.put("result", "failure");
			//放入失败信息
			map.put("msg", "修改密码失败," + e.getMessage());
			//将信息放入map中
			ActionContext.getContext().put("map", map);
		}
		//修改密码成功
		return "editpasswordSUCCESS";
	}
}
