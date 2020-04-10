package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.GenericDAO;

/**
 * 通用持久层DAO实现
 * @author 李泽坤
 *
 * @param <T>
 */
public class GenericDAOImpl<T> extends HibernateDaoSupport implements GenericDAO<T> {
	//类名称
	private String className;
	//传入类名
	public GenericDAOImpl(String className) {
		this.className = className;
	}
	//存储
	@Override
	public void save(T obj) {
		this.getHibernateTemplate().save(obj);
	}
	//更新
	@Override
	public void update(T obj) {
		this.getHibernateTemplate().update(obj);
	}
	//删除
	@Override
	public void delete(T obj) {
		this.getHibernateTemplate().delete(obj);
	}

	@Override
	// 通过ID查询
	public T findById(Serializable id) {
		Class<?> clazz = null;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (T) this.getHibernateTemplate().get(clazz, id);
	}
	//查询所有
	@Override
	public List<T> findAll() {
		return this.getHibernateTemplate().find("from " + className);
	}

	@Override
	public List<T> findByNamedQuery(String queryName, Object... values) {
		return this.getHibernateTemplate().findByNamedQuery(queryName, values);
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria detachedCriteria) {
		return this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	@Override
	public long findTotalCount(DetachedCriteria detachedCriteria) {
		// select count(*) from bc_standard
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = this.getHibernateTemplate().findByCriteria(detachedCriteria);
		return list.get(0);
	}

	@Override
	public List<T> pageQuery(DetachedCriteria detachedCriteria, int firstResult, int maxResults) {
		return this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
	}

	@Override
	public void saveOrUpdate(T obj) {
		this.getHibernateTemplate().saveOrUpdate(obj);
	}

}
