package com.bswxb.service.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bswxb.dao.BookDao;
import com.bswxb.dao.ScoreDao;
import com.bswxb.dao.UserDao;
import com.bswxb.po.Score;
import com.bswxb.service.ScoreService;
import com.bswxb.util.ChangUnix;
import com.bswxb.util.GetNowDate;
import com.bswxb.vo.ScoreVo;
import com.bswxb.vo.UserScore;
@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired 
	private ScoreDao scoreDao;
	
	@Autowired 
	private BookDao  bookDao ;
	
	@Autowired 
	private UserDao  userDao;
	

	@Override
	public void SaveOrUpdateScore(int userId, int bookId , int Score) {
		GetNowDate getTime =new GetNowDate(); 
		
		Score score = scoreDao.findOne(userId, bookId);
		if(score == null ) {
			
			score = new Score();
			score.setBook(bookDao.findOne(bookId));
			score.setUser(userDao.findOne(userId));
			score.setAssess(Score);
			score.setDate(getTime.getNowDate());
			scoreDao.saveOrUpdate(score);
			return;
			
		}
		
		
		score.setBook(bookDao.findOne(bookId));
		score.setUser(userDao.findOne(userId));
		score.setAssess(Score);
		score.setDate(getTime.getNowDate());
		scoreDao.update(score);
		
	}

	@Override
	public Score FindOne(int userId, int bookId) {
		
		Score score = scoreDao.findOne(userId, bookId);
		return score;
	}

	@Override
	public ScoreVo getAvgScore(int bookId) {
	
	List<Score>  scores= new ArrayList<Score>(); 	
		
	scores = scoreDao.findById(bookId);
	float i=0;//评分
	float jiaren = 0;
	float baihe = 0;
	float tongchi = 0;
	float zhengjv = 0;
	
	
	for (Score score : scores) {
		
		i = i + score.getAssess();
		
		if(score.getUser().getParty().equals("嫁人派")) {
			
			jiaren++;
		}
		
		if(score.getUser().getParty().equals("百合党")) {
			
			baihe++;
		}
		
		if(score.getUser().getParty().equals("通吃派")) {
	
			tongchi++;
		}
		
		if(score.getUser().getParty().equals("正剧党")) {
			
			zhengjv++;
		}
		
	}
	
	
	if(scores.size()!=0) {
		i=i/scores.size();
		jiaren  = jiaren/scores.size();
		baihe   = baihe/scores.size();
		tongchi = tongchi/scores.size();
		zhengjv = zhengjv/scores.size();
		
	}
	
	
	BigDecimal   a   =   new   BigDecimal(i); 
	BigDecimal   b   =   new   BigDecimal(baihe); 
	BigDecimal   c   =   new   BigDecimal(tongchi); 
	BigDecimal   d   =   new   BigDecimal(zhengjv); 
	BigDecimal   e   =   new   BigDecimal(jiaren); 
	
	double   avga       =   a.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();  
	double   avgbaihe   =   b.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
	double   avgtongchi =   c.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();  
	double   avgzhengjv =   d.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();  
	double   avgjiaren  =   e.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();  
	
	
	 

	ScoreVo scoreVo = new ScoreVo (avgjiaren,avgbaihe,avgtongchi,avgzhengjv,avga,scores.size()); 
	
	return scoreVo;
	}

	@Override
	public List<UserScore> getUserScore(int bookId) {
		
		ChangUnix changUnix = new ChangUnix();	//工具
		List<UserScore> userScores = new ArrayList<UserScore>();
		List<Score>  scores= new ArrayList<Score>(); 
		scores = scoreDao.findById(bookId);
		
		for (Score score : scores) {
			
			UserScore userScore = new UserScore();
			userScore.setUname(score.getUser().getUname());
			
			String Date =Long.toString(score.getDate());
			userScore.setDate(changUnix.TimeStamp2Date(Date));
			userScore.setParty(score.getUser().getParty());
			userScore.setBookReview(score.getBookReview());
			
			
			userScores.add(userScore);
			
		}
		
		
		
		return userScores;
	}

	
	
	
	
	@Override
	public void SaveOrUpdateScoreBookReview(int userId, int bookId, String bookReview) {
		
		
	    GetNowDate getTime =new GetNowDate(); 
		
		Score score = scoreDao.findOne(userId, bookId);
		if(score == null ) {

			
			score = new Score();
			score.setBook(bookDao.findOne(bookId));
			score.setUser(userDao.findOne(userId));
			score.setBookReview(bookReview);;
			score.setDate(getTime.getNowDate());
			scoreDao.saveOrUpdate(score);
			return;
			
		}
		
		
		score.setBook(bookDao.findOne(bookId));
		score.setUser(userDao.findOne(userId));
		score.setBookReview(bookReview);
		score.setDate(getTime.getNowDate());
		scoreDao.update(score);		
	}



	


}
