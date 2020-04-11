package bos.service.auth;

import java.util.List;

import bos.domain.auth.Role;

/**
 * 角色管理 业务接口
 * 
 * @author lzk
 * 
 */
public interface RoleService {

	// 添加角色
	public void saveRole(Role role, String functionIds);

	//查询所有角色
	public List<Role> listAll();

}
