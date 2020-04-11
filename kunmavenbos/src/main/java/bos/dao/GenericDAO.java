package bos.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import bos.page.PageResponseBean;

/**
 * 通用 DAO 设计接口
 * 
 * @author 李泽坤
 * 
 */
public interface GenericDAO<T> {

	// 保存
	public void save(T obj);

	//修改
	public void update(T obj);

	// 新增或修改
	public void saveOrUpdate(T obj);

	//删除
	public void delete(T obj);

	//根据id 查询
	public T findById(Serializable id);

	//查询 所有数据
	public List<T> findAll();

	// 条件查询
	public List<T> findByNamedQuery(String queryName, Object... values); // 根据hql 查询

	public List<T> findByCriteria(DetachedCriteria detachedCriteria); // 面向对象条件查询

	//查询满足条件记录总数
	public long findTotalCount(DetachedCriteria detachedCriteria);

	//分页 查询，查询当前页 数据
	public List<T> pageQuery(DetachedCriteria detachedCriteria, int firstResult, int maxResults);

	// 结合lucene索引库 进行分页查询
	public PageResponseBean queryByLucene(String conditionName, String conditionValue, int page, int rows);
}
