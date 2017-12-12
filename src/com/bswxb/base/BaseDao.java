package com.bswxb.base;

import java.util.List;

public interface BaseDao<T> {

	void save(T entity);
	
	void update(T entity);
	
	void saveOrUpdate(T entity);
	
	T findOne(Integer id);
	
	List<T> findAll();
	
	void delete(T entity);
	
	void delete(Integer id);
	
}
