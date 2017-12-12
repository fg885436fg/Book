package com.bswxb.service;

import java.util.List;

import com.bswxb.po.Book_Book;
import com.bswxb.po.CollectionBook;
import com.bswxb.util.PageUtil;
import com.bswxb.vo.BookList;
import com.bswxb.vo.CollectionOfBookList;

public interface CurpageService {
	
	
	//接受Book_Book实体，将其转换为BookList实体
	
	List<BookList>  Curpage(PageUtil page,List<Book_Book> bookList);
	
	
	//接受CollectionBook实体，将其转换为CollectionBookofBookList实体
	List<CollectionOfBookList>  CurpageofCollection(PageUtil page,List<CollectionBook> bookList);

}
