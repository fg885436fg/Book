package com.bswxb.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bswxb.dao.UpdateBooksDao;
@Repository
@Transactional
public class UpdateBooksDaoImpl implements  UpdateBooksDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	//获取线程中的session
	protected Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	
	
	
	
	
	@Override
	public void UpdateBooks() {
		String Sql = "UPDATE book,books  "
				+ "SET  "
				+ "book.book_Click = books.book_Click,  "
				+ "book.book_Date = books.book_Date,   "
				+ "book.book_Words = books.book_Words,    "
				+ "book.book_State = books.book_State   "
				+"WHERE book.book_Adress=books.book_Adress;   ";
		
		
		 

	
		
		Query query =  this.getSession().createSQLQuery(Sql);
		query.executeUpdate();
		
	}

}
