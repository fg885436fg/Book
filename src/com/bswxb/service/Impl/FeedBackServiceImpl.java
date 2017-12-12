package com.bswxb.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bswxb.dao.BookDao;
import com.bswxb.dao.FeedBackDao;
import com.bswxb.po.Book_Book;
import com.bswxb.po.FeedBack;
import com.bswxb.service.FeedBackService;

import java.text.SimpleDateFormat;  

import java.util.Date;  







@Service
public class FeedBackServiceImpl implements FeedBackService {

	
	
	@Autowired
	private  FeedBackDao feedBackDao;
	@Autowired
	private BookDao bookDao;
	
	

	@Override
	public void save(String url, String text,String ip) {
		//获得当前日期
	   Date d = new Date();  
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
       String dateNowStr = sdf.format(d);  
	 
	 
	 
		Book_Book book = new Book_Book();
		FeedBack feedback = new FeedBack();
		
		book = bookDao.findOneByUrl(url);
		
		feedback.setBook_url(url);
		feedback.setDate(dateNowStr);;
		feedback.setBookname(book.getBook_Name());
		feedback.setText(text);
		feedback.setIp(ip);
		
		this.feedBackDao.save(feedback); 
		
	}

	@Override
	public void update(String url, String text) {
		 
		
	}

	@Override
	public void saveOrUpdate(String url, String text) {
		 
		
	}

	@Override
	public void delete(int id) {
		 this.feedBackDao.delete(id);
		
	}

	@Override
	public List<FeedBack> findAll() {
		 

		return this.feedBackDao.findAll();
	}
	
	


}
