package service.bc;

import domain.bc.Subarea;
import page.PageQuery;
/**
 * 分区模块业务层接口
 * @author 李泽坤
 *
 */
public interface SubareaService extends PageQuery {
	//增加或修改分区
	public void saveOrUpdate(Subarea subarea);
}
