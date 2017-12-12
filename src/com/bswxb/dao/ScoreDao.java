package com.bswxb.dao;

import java.util.List;

import com.bswxb.base.BaseDao;
import com.bswxb.po.Score;


public interface   ScoreDao extends  BaseDao<Score> {
	
	
	Score findOne(int Id,int bookId);
	List<Score> findById(int bookId);
	

}
