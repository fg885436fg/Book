package com.bswxb.dao;

import java.util.List;

import com.bswxb.base.BaseDao;
import com.bswxb.po.CollectionBook;

public interface  CollectionBookDao extends  BaseDao<CollectionBook> {

	
	
	List findCollectionNum();
	
	
	
	
	
}
