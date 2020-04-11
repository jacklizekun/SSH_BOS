package bos.service.bc;

import java.util.List;

import bos.domain.bc.Subarea;
import bos.page.PageQuery;

/**
 * 分区管理 业务接口
 * 
 * @author 李泽坤
 * 
 */
public interface SubareaService extends PageQuery {

	// 添加或者修改分区
	public void saveOrUpdate(Subarea subarea);

	// 查询 所有未关联定区的分区
	public List<Subarea> findnoassociations();

}
