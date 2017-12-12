package com.bswxb.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bswxb.base.impl.BaseDaoImpl;
import com.bswxb.dao.VisiterDao;
import com.bswxb.po.Visiter;
@Repository
@Transactional
public class VisiterDaoImpl   extends BaseDaoImpl<Visiter> implements VisiterDao {

	@Override
	public Visiter findByip(String ip,String date) {
		
		
		Query query = this.getSession().createQuery(" from Visiter v where  v.ip=? and v.date=?");
		query.setString(0, ip);
		query.setString(1, date);
		
		return (Visiter) query.uniqueResult();
	}

	
}
