package com.bswxb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bswxb.base.impl.BaseDaoImpl;
import com.bswxb.dao.CollectionBookDao;
import com.bswxb.po.CollectionBook;


@Repository
@Transactional
public class CollectionBookDaoImpl extends BaseDaoImpl<CollectionBook> implements CollectionBookDao {

	@Override
	public List findCollectionNum() {
		
		
		String sql = " SELECT user_book.book_id FROM user_book ";
		

		return this.getSession().createSQLQuery(sql).list();
	}

	
	
	
}
