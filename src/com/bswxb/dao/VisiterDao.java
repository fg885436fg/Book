package com.bswxb.dao;

import com.bswxb.base.BaseDao;
import com.bswxb.po.Visiter;

public interface VisiterDao extends BaseDao<Visiter> {
	
	
	
	Visiter findByip(String ip,String date);
	
	

}
