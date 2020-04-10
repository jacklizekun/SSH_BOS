package service.bc;

import domain.bc.Staff;
import page.PageQuery;

/**
 * 取派员业务层接口
 * @author 李泽坤
 *
 */
public interface StaffService extends PageQuery {

	//保存或修改取派员
	public void saveOrUpdate(Staff staff);

	//删除取派员
	public void delBatch(String[] ids);
}
