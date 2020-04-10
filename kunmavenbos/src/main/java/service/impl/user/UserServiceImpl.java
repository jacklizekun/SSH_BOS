package service.impl.user;

import java.util.List;

import domain.user.User;
import service.base.BaseService;
import service.user.UserService;
import utils.MD5Utils;
/**
 * 用户模块实现类
 * @author 李泽坤
 *
 */
public class UserServiceImpl extends BaseService implements UserService {
	//登陆
	@Override
	public User login(User user) {
		//通过用户名和加密M5算法的密码查询用户
		List<User> list = userDAO.findByNamedQuery("User.login", user.getUsername(), MD5Utils.md5(user.getPassword()));
		return list.isEmpty() ? null : list.get(0);
	}
	//修改密码
	@Override
	public void editPassword(User user) {
		// 如果修改用户所有内容，直接调用 update
		// 如果修改用户某个属性，先查询，再修改
		User exist = userDAO.findById(user.getId());
		//设置加密的密码
		exist.setPassword(MD5Utils.md5(user.getPassword()));
	}

}
