package bos.service.auth;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bos.domain.auth.Function;

/**
 * 功能权限管理业务接口
 * 
 * @author 李泽坤
 * 
 */
public interface FunctionService {

	//查询所有功能列表
	public List<Function> listAll();

	// 保存权限信息
	public void saveFunction(Function function);

	// 查询树节点数据
	public List<Function> findTreeData(DetachedCriteria detachedCriteria);

}
