package page;

import org.hibernate.criterion.DetachedCriteria;

/**
 * 封装分页查询
 * @author 李泽坤
 *
 */
public class PageRequestBean {
	//当前页码
	private int page; 
	//每页记录数
	private int rows; 
	// 面向对象查询条件
	private DetachedCriteria detachedCriteria; 

	public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
		this.detachedCriteria = detachedCriteria;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public DetachedCriteria getDetachedCriteria() {
		return detachedCriteria;
	}

}
