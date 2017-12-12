package com.bswxb.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bswxb.dao.UpdateDao;
import com.bswxb.po.Update;
import com.bswxb.service.UpdateService;

@Service
public class UpdateServiceImpl implements UpdateService{
	
	
	@Autowired
	private UpdateDao updateDao;

	@Override
	public void save(String url, String text, String ip) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String url, String text) {
		
		
	}

	@Override
	public void saveOrUpdate(String bookName, String partySelect,
			String stateSelect, String bookUrl) {
		
		
	   String Hql="from  Update u  where u.book_Name='"+bookName+"'";

	   
		Update update = new Update(bookName,bookUrl,partySelect,stateSelect);
		
	
		 if(updateDao.findbyHql(Hql) == null) {
			 this.updateDao.save(update);
			 
		 } else {
			 
			 update= updateDao.findbyHql(Hql);
	         
			 update.setBook_Adress(bookUrl);
			 update.setBook_Party(partySelect);
			 update.setBook_State(stateSelect);
			 update.setBook_Name(bookName);
		
		 this.updateDao.update(update);	 
		 }
				 
				 
		
		return;
		
		
		
		
		
		
		
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Update> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
