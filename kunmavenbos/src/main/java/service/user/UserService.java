package service.user;

import domain.user.User;

/**
 * 用户模块接口
 * @author 李泽坤
 *
 */
public interface UserService {

	// 登陆
	public User login(User user);

	// 修改密码
	public void editPassword(User user);

}
