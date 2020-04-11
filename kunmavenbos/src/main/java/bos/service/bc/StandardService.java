package bos.service.bc;

import java.util.List;

import bos.domain.bc.Standard;
import bos.page.PageRequestBean;
import bos.page.PageResponseBean;

/**
 * 收派标准 业务接口
 * 
 * @author 李泽坤
 * 
 */
public interface StandardService {

	//保存标准
	public void saveStandard(Standard standard);

	//分页查询
	public PageResponseBean pageQuery(PageRequestBean pageRequestBean);

	//批量删除
	public void delBatch(String[] ids);

	// 获取标准列表 （查询可以使用标准 deltag=0）
	public List<Standard> ajaxlist();

}
