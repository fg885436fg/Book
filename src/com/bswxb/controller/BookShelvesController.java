package com.bswxb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bswxb.service.BookService;
import com.bswxb.service.CurpageService;
import com.bswxb.service.UserBooksService;
import com.bswxb.vo.BookList;

@Controller
@RequestMapping("/bookshelves")
public class BookShelvesController {
	
	@Autowired BookService bookService;
	
	@Autowired CurpageService curpageService;
	
	@Autowired UserBooksService userBooksService;//用户书架业务
	
	
	
	
	@RequestMapping(value="/findall.do",produces = 
			"application/json; charset=utf-8")
	@ResponseBody 
	public List<BookList> findBookByHql(String curpage,String id) {
		
	     int curPage=Integer.parseInt(curpage);
	     int Id     =Integer.parseInt(id);
	     	    
	     
	     List<BookList> booklist = new ArrayList<BookList>();
	     booklist =this.userBooksService.findUserBooks(Id, curPage);
	     
	     if(booklist ==null) {
	    	 
	    	 List<BookList> books = new ArrayList<BookList>();
	    	 return books;
	     }
	     
		return   booklist;
	} 
	
	
	@RequestMapping(value="/delect.do",produces = 
			"application/json; charset=utf-8")
	@ResponseBody 
	public String delectbook(String url,String id) {
		
		int Id     =Integer.parseInt(id);
	    this.userBooksService.delectUserBooks(url, Id );
		return "成功";
	     	    
		
	} 
	
	@RequestMapping(value="/add.do",produces = 
			"application/json; charset=utf-8")
	@ResponseBody 
	public String addbook(@RequestParam("url") String url,@RequestParam("id") String id) {
		
		int Id     =Integer.parseInt(id);
	    this.userBooksService.addUserBooks(url,Id);
	     	    
	    return "成功" ;
		
	} 
	
	
	
	
	

}
