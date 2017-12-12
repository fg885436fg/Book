package com.bswxb.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bswxb.dao.AddBooksDao;
import com.bswxb.dao.BookDao;
import com.bswxb.po.AddBooks;
import com.bswxb.po.Book_Book;
import com.bswxb.service.BookService;
import com.bswxb.service.CurpageService;
import com.bswxb.util.PageUtil;
import com.bswxb.vo.BookList;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Autowired
	private CurpageService curpageService;

	@Autowired
	private AddBooksDao addBooksDao;

	@Override
	public void save(Book_Book book) {

		this.bookDao.save(book);

	}

	@Override
	public void update(Book_Book book) {

		this.bookDao.update(book);
	}

	@Override
	public void saveOrUpdate(Book_Book book) {

		this.bookDao.saveOrUpdate(book);
	}

	@Override
	public Book_Book findOne(Integer id) {

		return this.bookDao.findOne(id);
	}

	@Override
	public List<Book_Book> findAll() {

		return this.bookDao.findAll();
	}

	@Override
	public void delete(Book_Book entity) {

		this.bookDao.delete(entity);

	}

	@Override
	public void delete(String url) {

		this.bookDao.delete(this.findOneByUrl(url));

	}

	@Override
	public List<BookList> findByWord(String name, String order, String state,
			String book_Words, String leibie, int curpage) {
		// 字数处理
		String party = "";
		if (name.equals("全部")) {

			party = " is not null ";

		} else if (name.equals("百合")) {

			party = " ='百合' ";

		} else if (name.equals("嫁人")) {

			party = " ='嫁人' ";

		} else if (name.equals("不明")) {

			party = " ='不明' ";

		}

		String State = " ";

		if (state.equals("is not null")) {

			State = "is not null";
		} else if (state.equals("='完结'")) {

			State = "='完结'";
		} else {

			State = "is not null";
		}

		String word = "";
		String book_Words_0 = " and h.book_Words BETWEEN 1000 AND 100000";
		String book_Words_1 = " and h.book_Words BETWEEN 100000 AND 300000";
		String book_Words_2 = " and h.book_Words BETWEEN 300000 AND 500000";
		String book_Words_3 = " and h.book_Words BETWEEN 500000 AND 1000000";
		String book_Words_4 = " and h.book_Words BETWEEN 1000000 AND 10000000000000";

		if (book_Words.equals("10w")) {

			word = book_Words_0;

		} else if (book_Words.equals("30w")) {

			word = book_Words_1;

		} else if (book_Words.equals("50w")) {

			word = book_Words_2;

		} else if (book_Words.equals("100w")) {

			word = book_Words_3;

		} else if (book_Words.equals("10000w")) {

			word = book_Words_4;

		} else {

			word = " ";
		}

		// 细分选项的处理
		String sort = " ";
		String Hql_1 = " and (h.book_Name  LIKE '%奇幻%' or h.book_Tag  LIKE '%奇幻%' or h.book_Author LIKE '%奇幻%' or  "
				+ "  h.book_Name LIKE '%西幻%' or h.book_Tag  LIKE '%西幻%' or h.book_Author LIKE '%西幻%'  or  "
				+ "   h.book_Name LIKE '%异世界%' or h.book_Tag  LIKE '%异世界%' or h.book_Author LIKE '%异世界%')  ";

		String Hql_2 = "  and (h.book_Name LIKE '%都市%' or h.book_Tag  LIKE '%都市%' or h.book_Author LIKE '%都市%')   ";

		String Hql_3 = " and (h.book_Name LIKE '%舰%' or h.book_Tag  LIKE '%舰%' or h.book_Author LIKE '%舰%')  ";

		String Hql_4 = "  and (h.book_Name LIKE '%同人%' or h.book_Tag  LIKE '%同人%' or h.book_Author LIKE '%同人%')  ";

		String Hql_5 = "  and (h.book_Name LIKE '%穿越%' or h.book_Tag  LIKE '%穿越%' or h.book_Author LIKE '%穿越%')  ";

		String Hql_6 = "  and (h.book_Name LIKE '%游戏%' or h.book_Tag  LIKE '%游戏%' or h.book_Author LIKE '%游戏%')  ";

		if (leibie.equals("全部")) {

			leibie = " ";
		} else if (leibie.equals("奇幻")) {

			sort = Hql_1;

		} else if (leibie.equals("都市")) {

			sort = Hql_2;

		} else if (leibie.equals("舰女人")) {

			sort = Hql_3;

		} else if (leibie.equals("同人")) {

			sort = Hql_4;

		} else if (leibie.equals("穿越")) {

			sort = Hql_5;

		} else if (leibie.equals("游戏")) {

			sort = Hql_6;

		} else {

			sort = " ";
		}

		String Order = "book_Date";
		if (order.equals("book_Date")) {

			Order = "book_Date";
		} else if (order.equals("book_Words")) {

			Order = "book_Words";
		}

		String Hql = " FROM Book_Book h WHERE h.book_Party " + party
				+ " and h.book_State  " + State + " " + word + " " + sort
				+ " ORDER BY " + Order + " DESC";
		// 获得所查询的记录总数
		int count = this.bookDao.getBookSize(Hql);

		PageUtil page = new PageUtil(count, curpage);

		// 获得开始与结尾的索引
		int fromIndex = page.getFromIndex();

		return this.curpageService.Curpage(page,
				this.bookDao.findByWord(Hql, fromIndex, page.getPageRow()));

	}

	@Override
	public Book_Book findOneByUrl(String url) {

		return this.bookDao.findOneByUrl(url);
	}

	@Override
	public List<BookList> search(String word, int curpage) {

		// 获得所查询的记录总数
		int count = this.bookDao.getSerachSize(word);
		PageUtil page = new PageUtil(count, curpage);

		// 获得开始与结尾的索引
		int fromIndex = page.getFromIndex();

		return this.curpageService.Curpage(page,
				this.bookDao.search(word, fromIndex, page.getPageRow()));
	}

	@Override
	public int getBooksSize() {
		// 获得书库书的总数
		String Hql = " from Book_Book";

		return this.bookDao.getHqlSize(Hql);
	}

	@Override
	public Boolean haveBook(String text) {

		int i = this.bookDao.getAddBookSize(text);
		if (i >= 1) {
			// 确实重复了
			return true;

		} else {
			// 没重复

			AddBooks book = new AddBooks();
			book.setText(text);
			this.addBooksDao.save(book);

			return false;
		}

	}

	@Override
	public void updateBook() {
		String hql = "update book b,updatebooks u set b.book_Party =u.book_Party,b.book_State  =u.book_State  WHERE b.book_Adress=u.book_Adress";
		this.bookDao.DobyHql(hql);
	}

	@Override
	public void delectBook() {

		String hql = "DELETE b   FROM  book b , delect_books d  WHERE b.book_Adress = d.bookUrl";
		this.bookDao.DobySql(hql);
	}

}
