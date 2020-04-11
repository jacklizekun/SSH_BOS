package bos.service.bc;

import java.util.List;

import bos.domain.bc.Staff;
import bos.page.PageQuery;

/**
 * 取派员管理 业务接口
 * 
 * @author 李泽坤
 * 
 */
public interface StaffService extends PageQuery {

	//添加或者修改 取派员
	public void saveOrUpdate(Staff staff);

	// 取派员 作废
	public void delBatch(String[] ids);

	// 查询未作废的取派员
	public List<Staff> findAllNoDeleteStaffs();
}
