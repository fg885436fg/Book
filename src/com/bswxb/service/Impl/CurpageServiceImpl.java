package com.bswxb.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bswxb.dao.DelectBooksDao;
import com.bswxb.po.Book_Book;
import com.bswxb.po.CollectionBook;
import com.bswxb.po.DelectBooks;
import com.bswxb.service.CurpageService;
import com.bswxb.vo.BookList;
import com.bswxb.vo.CollectionOfBookList;
import com.bswxb.util.*;

@Service
public class CurpageServiceImpl implements CurpageService {
	// 接收全部Booklist书的集合与页数，返回bookList的集合。

	@Autowired
	private DelectBooksDao delectBooksDao;

	@Override
	public List<BookList> Curpage(PageUtil page, List<Book_Book> bookList) {

		List<BookList> books = new ArrayList<BookList>();
		List<DelectBooks> delectBooks = new ArrayList<DelectBooks>();

		delectBooks = this.delectBooksDao.findAll();// 得到非变文名单

		for (Book_Book book_Book : bookList) {

			int i = 1;
			// 检查是否有非变文

			for (DelectBooks delectBook : delectBooks) {

				if (delectBook.getBookName().equals(book_Book.getBook_Name())
						&& delectBook.getBookUrl().equals(
								book_Book.getBook_Adress())) {
					// 如果查到是非变文
					i = 0;

				}
			}

			// 如果是变文则装载

			if (i == 1) {

				BookList book = new BookList(book_Book, page.getNavCount(),
						page.getCurPage());
				books.add(book);

			}

		}

		return books;
	}

	@Override
	public List<CollectionOfBookList> CurpageofCollection(PageUtil page,
			List<CollectionBook> bookList) {
		
		
		List<CollectionOfBookList> books = new ArrayList<CollectionOfBookList>();
		
		//把传入的po转化为vo
		for (CollectionBook collectionBook: bookList) {
			
			
			CollectionOfBookList  book = new CollectionOfBookList(collectionBook,page.getNavCount(),page.getCurPage());
			books.add(book);
			
		}
		
		
		
		
		
		return books ;
	}

}
