package com.bswxb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bswxb.dao.DelectBooksDao;
import com.bswxb.dao.FeedBackDao;
import com.bswxb.po.DelectBooks;
import com.bswxb.po.FeedBack;
import com.bswxb.service.FeedBackService;
import com.bswxb.service.UpdateService;
import com.bswxb.util.getIp;

@Controller
@RequestMapping("/feedback")
public class FeedBackController {
	
	
	@Autowired
	private UpdateService updateService;
	
	@Autowired
	private FeedBackService feedBackService;
	
	@Autowired 
	private FeedBackDao feedBackDao;
	
	@Autowired
	private DelectBooksDao delectBooksDao;
	
	
	//https://www.baidu.com/baidu?tn=monline_3_dg&ie=utf-8&wd=http://book.qidian.com/info/1004153436
	@RequestMapping(value="/saveFeedback.do",produces = "application/json; charset=utf-8")
	@ResponseBody 
	public String saveFeedback(String url, String text,HttpServletRequest reqest) {
	
 		getIp get = new getIp();
		String ip =get.getRemoteHost(reqest);
		
	  this.feedBackService.save(url, text, ip);
		
		
	   
	    
		return "反馈存储成功";
	} 
	
	@RequestMapping(value="/update.do")
	 
	public String update(String bookName, String partySelect,String stateSelect,String delectBook,String bookUrl) {
		
	
		
		if(delectBook.equals("非变文")) {
			
			
			
			DelectBooks delectbook = this.delectBooksDao.findByUrl(bookUrl); 
			
			if(delectbook ==null ) {
				
				delectbook = new DelectBooks ();
			}
			delectbook.setBookName(bookName);
			delectbook.setBookUrl(bookUrl);
		    this.delectBooksDao.saveOrUpdate(delectbook);
			
		    return "/views/feedback.jsp";
			
			
		}
		updateService.saveOrUpdate(bookName, partySelect, stateSelect, bookUrl);
		
		 return "/views/feedback.jsp";
	} 
	
	
	
	@RequestMapping(value="/delectFeedback.do",produces = 
			"application/json; charset=utf-8")
	@ResponseBody 
	public String delectFeedback(String id) {
	
 	
      int Id = Integer.parseInt(id);
		
	  this.feedBackDao.delete(Id);	
	   
	    
		return "删除成功";
	} 
	
	
	@RequestMapping(value="/findAlltFeedback.do",produces = 
			"application/json; charset=utf-8")
	@ResponseBody 
	public List<FeedBack> findAlltFeedback() {
	
 	

	 
	    
		return   this.feedBackDao.findAll();
	} 
	
	
	
	
/*	@RequestMapping(value="/findone.do",produces = 
			"application/json; charset=utf-8")
	@ResponseBody 
	public FeedBack Findone(String  id) {
	
 	
		int Id = Integer.parseInt(id);
		
		
		
	   
	    
		return this.feedBackDao.findOne(Id);
	} 
	*/
	
	
	
	
	
	
	
	
	
	
	

}
