package bos.service.user;

import java.util.List;

import bos.domain.user.User;

/**
 * 用户管理 业务接口
 * 
 * @author 李泽坤
 * 
 */
public interface UserService {

	// 登陆
	public User login(User user);

	// 修改密码
	public void editPassword(User user);

	// 添加用户
	public void saveUser(User user);

	// 查询所有用户列表
	public List<User> listAll();

	// 授予角色
	public void grantRole(User user);

}
