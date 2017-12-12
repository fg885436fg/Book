package com.bswxb.service;

import java.util.List;

import com.bswxb.po.Update;



public interface UpdateService {

	
	
    void save(String url, String text,String ip);
	
	void update(String url, String text);
	
	void saveOrUpdate(String bookName, String partySelect,String stateSelect,String bookUrl);
	
	void delete(int id);
	List<Update> findAll();
	
	
	
	
	
}
