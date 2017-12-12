package com.bswxb.service;

import java.util.List;
import com.bswxb.vo.BookList;

public interface UserBooksService {

	//查
	List<BookList> findUserBooks(int id,int curpage);
	//增用户藏书
	void addUserBooks(String url,Integer id);
	//删用户藏书
	void delectUserBooks(String url,Integer id);
	
	
	
}
