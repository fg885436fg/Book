package com.bswxb.service;

import java.util.List;

import com.bswxb.po.Book_Book;
import com.bswxb.vo.CollectionOfBookList;

public  interface  CollectionBookService {
	
	
	
    void save();
	
	void update();
	
	void saveOrUpdate();
	
    List<CollectionOfBookList>  findAll(int curpage);
	
	
	
	
	
	
	

}
