package com.bswxb.service.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bswxb.dao.BookDao;
import com.bswxb.dao.CollectionBookDao;
import com.bswxb.po.Book_Book;
import com.bswxb.po.CollectionBook;
import com.bswxb.service.BookService;
import com.bswxb.service.CollectionBookService;
import com.bswxb.service.CurpageService;
import com.bswxb.util.PageUtil;
import com.bswxb.vo.CollectionOfBookList;

@Service
public class CollectionOfBookListImpl implements CollectionBookService {

	@Autowired
	private CollectionBookDao collectionBookDao;

	@Autowired
	private BookDao bookDao;

	@Autowired
	private CurpageService curpageService;

	@Override
	public void save() {

	}

	@Override
	public void update() {

	}

	@Override
	public void saveOrUpdate() {

		List ids = collectionBookDao.findCollectionNum();

		Set<Book_Book> books = new HashSet<>();

		// 获得书籍id
		for (int i = 0; i < ids.size(); i++) {

			Book_Book book = bookDao.findOne((Integer) ids.get(i));// 获得藏书
			books.add(book);

		}

	}

	@Override
	public List<CollectionOfBookList> findAll(int curpage) {

		List<CollectionBook> books = new ArrayList<CollectionBook>();

		books = collectionBookDao.findAll();

		String Hql = " from CollectionBook";
		int count = this.bookDao.getHqlSize(Hql);// 获得收藏书籍总数

		PageUtil page = new PageUtil(count, curpage);

		return curpageService.CurpageofCollection(page, books);

	}

}
