package com.bswxb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bswxb.po.Book_Book;
import com.bswxb.service.BookService;
import com.bswxb.service.ScoreService;
import com.bswxb.vo.UserScore;

@Controller
@RequestMapping("/score")
public class ScoreController {

	@Autowired
	private ScoreService scoreService;

	@Autowired
	private BookService bookService;

	// 使用ajax的功能有，获得综合评分,获得评论,获得用户自己的评分。

	/*
	 * @RequestMapping(value="/getAvgScore.do",produces =
	 * "application/json; charset=utf-8")
	 * 
	 * @ResponseBody public double getAvgScore(int bookId) {
	 * 
	 * 
	 * return this.scoreService.getAvgScore(bookId);
	 * 
	 * }
	 */

	@RequestMapping(value = "/getAvgScor.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int getUserScore(int bookId, int userId) {
		// 获得用户自己的评分

		return this.scoreService.FindOne(userId, bookId).getAssess();

	}

	@RequestMapping(value = "/getBookReview.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<UserScore> getBookReview(int bookId) {
		// 获得书籍下用户的评论

		return this.scoreService.getUserScore(bookId);

	}

	@RequestMapping(value = "/login.do")
	public String getBookRevie(String bookId, HttpSession session) {
		// 转到详细页面

		int bookid = Integer.parseInt(bookId);

		Book_Book book = new Book_Book();
		book = this.bookService.findOne(bookid);
		session.setAttribute("book", book);
		session.setAttribute("avgScore", this.scoreService.getAvgScore(bookid));// 分数

		return "/views/details.jsp";

	}

}
