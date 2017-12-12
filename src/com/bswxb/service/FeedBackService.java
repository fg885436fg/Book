package com.bswxb.service;

import java.util.List;

import com.bswxb.po.FeedBack;

public interface FeedBackService {
	
	
    void save(String url, String text,String ip);
	
	void update(String url, String text);
	
	void saveOrUpdate(String url, String text);
	
	void delete(int id);
	List<FeedBack> findAll();

	
}
