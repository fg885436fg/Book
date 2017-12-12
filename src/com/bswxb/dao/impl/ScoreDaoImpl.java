package com.bswxb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bswxb.base.impl.BaseDaoImpl;
import com.bswxb.dao.BookDao;
import com.bswxb.dao.ScoreDao;
import com.bswxb.po.Score;
@Repository
@Transactional
public class ScoreDaoImpl extends BaseDaoImpl<Score>       implements ScoreDao {

	@Autowired 
	private BookDao bookdao;
	
	@Override
	public Score findOne(int Id,int bookId) {
		
		
		SQLQuery query =	this.getSession().createSQLQuery(" select * from score  s where  s.user_user_id="+ Id+" and s.book_id ="+bookId).addEntity(Score.class);
		
		/*query.setInteger(1,Id);
		query.setInteger(2,bookId);*/
		
		
		return (Score) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Score> findById(int bookId) {
		
	
		SQLQuery query =	this.getSession().createSQLQuery(" select * from score  s where  s.book_id ="+bookId).addEntity(Score.class);
		
		return query.list();
	}

	

}
