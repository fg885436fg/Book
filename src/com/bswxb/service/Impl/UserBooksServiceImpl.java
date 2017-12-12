package com.bswxb.service.Impl;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bswxb.dao.BookDao;
import com.bswxb.dao.UserDao;
import com.bswxb.po.Book_Book;
import com.bswxb.po.User;
import com.bswxb.service.CurpageService;
import com.bswxb.service.UserBooksService;
import com.bswxb.util.PageUtil;
import com.bswxb.vo.BookList;
@Service
public class UserBooksServiceImpl implements UserBooksService {
	
	
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CurpageService curpageService;

	@Override
	public List<BookList> findUserBooks(int id,int curpage) {
	
		Set<Book_Book> books = new HashSet<Book_Book>();
		List<Book_Book> bookList = new ArrayList<Book_Book>();
		List<BookList>  Books    = new ArrayList<BookList>(); 
		
		
		User user = new User();
		user =userDao.findOne(id);
		
		books = user.getBook();
		
	
		
		
		
		if(books.size()==0) {
			
			
			
			return null;
		}
		
		for (Book_Book book : books) {
			//获得藏书集合的连接
			
			 bookList.add(this.bookDao.findOneByUrl(book.getBook_Adress()) );
		
			
			
		}
		
		PageUtil page = new PageUtil(bookList.size(),curpage);
		page.getFromIndex();//起始索引
		page.getToIndex();//最终索引
		
		bookList.subList(page.getFromIndex(), page.getToIndex());
		Books =curpageService.Curpage(page, bookList.subList(page.getFromIndex(), page.getToIndex()));
		
		
		
		
		
		return  Books;
	}

	@Override
	public void addUserBooks(String url, Integer id) {
		
		Set<Book_Book> books = new HashSet<Book_Book>();
		User user = new User();
		
		user = this.userDao.findOne(id);
		books=user.getBook();
		
		//看藏书是否重复
		for (Book_Book book : books) {
			
			if(book.equals(this.bookDao.findOneByUrl(url))) {
				
				
				return;
				
				
			}
			
			
		}
		
		books.add(this.bookDao.findOneByUrl(url));
		user.setBook(books);
		this.userDao.update(user);
		
		
		
		
		
	}

	@Override
	public void delectUserBooks(String url, Integer id) {
		
		Set<Book_Book> books = new HashSet<Book_Book>();
		User user = new User();
		
		user = this.userDao.findOne(id);
		books=user.getBook();
		books.remove(this.bookDao.findOneByUrl(url));
		
	
		user.setBook(books);
		this.userDao.update(user);	
		
	}

}
