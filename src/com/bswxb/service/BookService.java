package com.bswxb.service;

import java.util.List;

import com.bswxb.po.Book_Book;
import com.bswxb.vo.BookList;

public interface  BookService {
	
	
	void save(Book_Book book);
	
	void update(Book_Book book);
	
	void saveOrUpdate(Book_Book book);
	void delete(Book_Book entity);
	
	Book_Book findOne(Integer id);

	List<Book_Book> findAll();
	
	
	
	void delete(String id);
	List<BookList> findByWord(String name, String order, String state,String words,String leibie,int curpage);
	Book_Book findOneByUrl(String url);
	List<BookList> search(String word,int curpage);
	
	int getBooksSize();
	
	Boolean haveBook(String text);
	void updateBook();
	void  delectBook();
	
	
	
}
