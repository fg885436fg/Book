package com.bswxb.service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bswxb.dao.VisiterDao;
import com.bswxb.po.Visiter;
import com.bswxb.service.VisiterService;
@Service
public class VisiterServiceImpl implements VisiterService {
	

	Date d = new Date();  
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");  
    String dateNowStr = sdf.format(d);  
	
	@Autowired
	private VisiterDao visiterDao;

	@Override
	public void save(String ip) {
	
		
		
	       
	    
	    Visiter  visiter=  this.findOne(ip);
	    if(visiter == null) {
	    	
			visiter = new Visiter();
			visiter.setIp(ip);
			visiter.setDate(dateNowStr);
			this.visiterDao.save(visiter);
	    	
	    } else if(visiter.getDate().equals(dateNowStr) && visiter.getIp().equals(ip)) {
	    	return;
	    }  else {
	    	
	    	visiter = new Visiter();
			visiter.setIp(ip);
			visiter.setDate(dateNowStr);
			this.visiterDao.save(visiter);
	    	
	    	
	    }
	    
	    
	    

		
		
		

	}

	@Override
	public Visiter findOne(String ip) {
		
	
		return this.visiterDao.findByip(ip,dateNowStr);
	}

}
