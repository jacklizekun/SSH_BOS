package service.bc;

import java.util.List;

import domain.bc.Standard;
import page.PageRequestBean;
import page.PageResponseBean;

/**
 * 收派标准业务接口
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
	public List<Standard> ajaxlist();
}
