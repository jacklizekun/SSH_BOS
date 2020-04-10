package web.action.user;

import org.apache.struts2.ServletActionContext;

import domain.user.User;
import web.action.base.BaseAction;

import com.opensymphony.xwork2.ModelDriven;

/**
 *  用户登陆Action
 * @author 李泽坤
 *
 */
public class LoginAction extends BaseAction implements ModelDriven<User> {

	// 模型驱动
	private User user = new User();
	//获取用户模型
	@Override
	public User getModel() {
		return user;
	}

	//首先自动执行方法，判断验证条件
	public String execute() {
		// 判断验证码是否 正确(比较用户输入的验证码和Session中验证码 是否一致)
		
		// 获得Session验证码
		String checkCodeSession = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
		//没有验证码或者不相等
		if (checkCodeSession == null || !checkCodeSession.equals(checkcode)) {
			// 验证码失败
			this.addActionError("验证码错误");
			return INPUT;
		}
		
		// 验证码成功，比较用户名和密码 ,调用业务层
		User loginUser = userService.login(user);
		//session中无登陆信息
		if (loginUser == null) {
			// 登陆失败
			this.addActionError("用户名或者密码错误");
			//返回跳转到登陆页面
			return INPUT;
		} else {
			// 登陆成功
			// 将用户信息存入Session
			ServletActionContext.getRequest().getSession().setAttribute("user", loginUser);
			//成功信息
			return SUCCESS;
		}
	}

	// 接收验证码 （属性驱动 ）
	private String checkcode; // 用户输入验证码

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

}
