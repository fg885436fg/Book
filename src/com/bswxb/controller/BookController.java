package com.bswxb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bswxb.po.Book_Book;
import com.bswxb.service.BookService;
import com.bswxb.util.getIp;
import com.bswxb.vo.BookList;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	/*
	 * @Autowired private VisiterService visiterService;
	 */

	@RequestMapping(value = "/findbooks.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<BookList> findBookByHql(String party, String order, String state, String words, String leibie,
			String curpage, HttpServletRequest req) {

		int curPage = Integer.parseInt(curpage);

		// getIp get = new getIp();
		/* this.visiterService.save(get.getRemoteHost(req)); */

		return bookService.findByWord(party, order, state, words, leibie, curPage);
	}

	// 搜索框
	@RequestMapping(value = "/search.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<BookList> findBookByword(String word, String curpage, HttpServletRequest req) {

		// getIp get = new getIp();
		/* this.visiterService.save(get.getRemoteHost(req)); */

		int curPage = Integer.parseInt(curpage);
		// this.bookService.updateBook();
		return this.bookService.search(word, curPage);
	}

	// 得到书库的总本数
	@RequestMapping(value = "/booknum.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public int getBooksNum() {

		int bookNum = bookService.getBooksSize();

		return bookNum;
	}

	// 得到一本书
	@RequestMapping(value = "/findOneBook.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Book_Book findOneBook(String url) {

		return this.bookService.findOneByUrl(url);
	}

	@RequestMapping(value = "/addBook.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String addBook(String text) {

		if (this.bookService.haveBook(text)) {
			// 重复了
			return "书库已有你提交的书籍";

		} else {

			return "书籍提交成功";

		}

	}

	// 更新书库里的书
	@RequestMapping(value = "/updateBook.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updateBook() {

		this.bookService.updateBook();
		this.bookService.delectBook();
		return "更新成功";

	}

	// 收藏排行榜
	/*
	 * @RequestMapping(value = "/updateBook.do", produces =
	 * "application/json; charset=utf-8")
	 * 
	 * @ResponseBody public String sortbyCollection() {
	 * 
	 * this.bookService.updateBook(); this.bookService.delectBook(); return "更新成功";
	 * 
	 * }
	 */

}
