package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
 * 通用DAO接口设计
 * @author 李泽坤
 *
 * @param <T>
 */
public interface GenericDAO<T> {
	//保存
	public void save(T obj);
	//修改
	public void update(T obj);
	//新增或修改
	public void saveOrUpdate(T obj);
	//删除
	public void delete(T obj);
	//ID查询
	public T findById(Serializable id);
	//查询所有数据
	public List<T> findAll();
	//条件查询hql
	public List<T> findByNamedQuery(String queryName, Object... values); 
	//面向对象条件查询
	public List<T> findByCriteria(DetachedCriteria detachedCriteria); 
	//查询记录总数
	public long findTotalCount(DetachedCriteria detachedCriteria);
	//分页查询
	public List<T> pageQuery(DetachedCriteria detachedCriteria, int firstResult, int maxResults);
}
