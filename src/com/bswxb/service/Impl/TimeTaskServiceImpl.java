package com.bswxb.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bswxb.dao.UpdateBooksDao;
import com.bswxb.service.TimeTaskService;
@Service 
public class TimeTaskServiceImpl implements TimeTaskService {
	
	
	@Autowired
	private UpdateBooksDao updateBooksDao ;
	
	
	
	//0 0 17 * * ? 每天17时执行
	//0 0 1 * * ? 每天凌晨一点
	@Scheduled(cron="0 0 1 * * ?  ")   
	@Override
	public void myTest() {
		
		
		
		updateBooksDao.UpdateBooks();
	 
		
		
	}

}
