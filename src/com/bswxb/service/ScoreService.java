package com.bswxb.service;

import java.util.List;

import com.bswxb.po.Score;
import com.bswxb.vo.ScoreVo;
import com.bswxb.vo.UserScore;

public interface  ScoreService {
	
	
	
	
	void SaveOrUpdateScore(int userId,int bookId,int Score);
	Score  FindOne(int userId,int bookId);  
	ScoreVo  getAvgScore(int bookId);
	List<UserScore> getUserScore(int bookId);
	void SaveOrUpdateScoreBookReview(int userId,int bookId,String bookReview);
	
	
	
	
}
