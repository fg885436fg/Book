package com.bswxb.base.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bswxb.base.BaseDao;




@Repository
@Transactional
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//获取线程中的session
	protected Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	protected Class<?> clazz;
	
	public BaseDaoImpl(){
		//得到类型信息
		//得到父类中的类型信息  类型参数 <T>
		
		
		ParameterizedType type =  (ParameterizedType)this.getClass().getGenericSuperclass();
//		System.out.println(type.getClass());
		//得到类型列表
		Type[] types = type.getActualTypeArguments();
		if(types.length != 1){
			throw new IllegalArgumentException("类型参数错误");
		}
		
		this.clazz = (Class<?>)types[0];
		
//		System.out.println(this.clazz);
		
	}
	

	/**
	 * 保存对象
	 */
	@Override
	public void save(T entity) {
		this.getSession().save(entity);
	}

	/**
	 * 更新对象
	 */
	@Override
	public void update(T entity) {
		
		this.getSession().update(entity);
	}

	/**
	 * 保存或更新对象
	 */
	@Override
	public void saveOrUpdate(T entity) {
		
		this.getSession().saveOrUpdate(entity);
	}

	/**
	 * 根据id查询一个对象
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findOne(Integer id) {
		return (T)this.getSession().get(this.clazz, id);
	}

	/**
	 * 查询所有对象
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Query query = this.getSession().createQuery("from "+this.clazz.getSimpleName()+" c");
		return query.list();
	}

	/**
	 * 删除对象
	 */
	@Override
	public void delete(T entity) {
		this.getSession().delete(entity);
	}

	/**
	 * 删除对象
	 */
	@Override
	public void delete(Integer id) {
		this.delete(this.findOne(id));
	}
	
}
