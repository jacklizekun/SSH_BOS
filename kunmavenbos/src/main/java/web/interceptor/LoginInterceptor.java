package web.interceptor;

import org.apache.struts2.ServletActionContext;

import domain.user.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 *  拦截器
 * @author 李泽坤
 *
 */
public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 从Session 中获取登陆用户信息
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (user == null) {
			// 没有登陆
			// 设置错误信息
			ActionSupport action = (ActionSupport) invocation.getAction();
			action.addActionError("请登陆");
			// 登陆页面
			return "login"; 
		} else {
			// 已经登陆，放行
			return invocation.invoke();
		}
	}

}
