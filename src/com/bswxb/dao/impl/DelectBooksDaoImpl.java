package com.bswxb.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bswxb.base.impl.BaseDaoImpl;
import com.bswxb.dao.DelectBooksDao;
import com.bswxb.po.DelectBooks;

@Repository
@Transactional
public class DelectBooksDaoImpl   extends BaseDaoImpl<DelectBooks> implements DelectBooksDao  {

	@Override
	public DelectBooks findByUrl(String url) {
		
		String Hql = "from  DelectBooks  db where db.bookUrl='" + url + "'";

		return (DelectBooks) this.getSession().createQuery(Hql).uniqueResult();
		
		
	}

	

	
	
	
	
}
