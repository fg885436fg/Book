package com.bswxb.dao;

import com.bswxb.base.BaseDao;
import com.bswxb.po.Update;

public interface UpdateDao  extends  BaseDao<Update> {

	
	
	
	Update findbyHql(String Hql);
	
}
	
