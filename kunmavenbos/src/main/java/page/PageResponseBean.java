package page;

import java.util.List;


/**
 * 封装分页查询结果
 * @author 李泽坤
 *
 */
@SuppressWarnings("all")
public class PageResponseBean {
	// 总记录数
	private long total; 
	// 当前页数据记录
	private List rows; 

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

}
