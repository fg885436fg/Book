package com.bswxb.dao;

import java.util.List;

import com.bswxb.base.BaseDao;
import com.bswxb.po.Book_Book;

public interface BookDao extends  BaseDao<Book_Book>{

	
	
	List<Book_Book> findByWord(String Hql  ,  int fromIndex , int ToIndex);
	
	
	
	
	Book_Book findOneByUrl(String url);
	List<Book_Book> search(String Hql,int fromIndex , int ToIndex);
	int getHqlSize(String Hql);
	int getBookSize(String Hql);
	int getAddBookSize(String text);
	int getSerachSize(String word);
	void DobySql(String Hql);
	void DobyHql(String Sql);
}
