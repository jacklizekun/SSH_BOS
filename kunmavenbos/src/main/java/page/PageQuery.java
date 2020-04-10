package page;

/**
 * 分页查询接口
 * @author 李泽坤
 *
 */
public interface PageQuery {
	//分页查询
	public PageResponseBean pageQuery(PageRequestBean pageRequestBean);
}
