package com.bswxb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bswxb.base.impl.BaseDaoImpl;
import com.bswxb.dao.BookDao;
import com.bswxb.po.Book_Book;

@Repository
@Transactional
public class BookDaoImpl extends BaseDaoImpl<Book_Book> implements BookDao {

	@Override
	public Book_Book findOneByUrl(String url) {

		String Hql = "from  Book_Book b where b.book_Adress='" + url + "'";

		return (Book_Book) this.getSession().createQuery(Hql)
				.setCacheable(true).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book_Book> search(String word, int fromIndex, int ToIndex) {

		String Hql = " FROM Book_Book h WHERE  h.book_Name LIKE :word or h.book_Tag  LIKE :word or h.book_Author LIKE :word  ORDER BY book_Words DESC";

		Query query = this.getSession().createQuery(Hql)
				.setString("word", "%" + word + "%");
		query.setFirstResult(fromIndex);
		query.setMaxResults(ToIndex);

		return query.setCacheable(true).list();
	}

	@Override
	public int getHqlSize(String Hql) {
		// 获得查询结果的长度

		String c = "select count(*) ";

		Query query = this.getSession().createQuery(c + Hql);

		int count = ((Number) query.uniqueResult()).intValue();
		return count;

	}

	@Override
	public int getSerachSize(String word) {

		String Hql = " select count(*)  FROM Book_Book h WHERE  h.book_Name LIKE :word  or h.book_Tag  LIKE :word or h.book_Author LIKE :word ORDER BY book_Words DESC";

		Query query = this.getSession().createQuery(Hql)
				.setString("word", "%" + word + "%");
		return ((Number) query.uniqueResult()).intValue();
	}

	@Override
	public void DobyHql(String Hql) {

		this.getSession().createSQLQuery(Hql).executeUpdate();

	}

	@Override
	public int getAddBookSize(String text) {

		String Hql = " select count(*) from  Book_Book b where b.book_Name=:text  or b.book_Adress=:text";
		Query query = this.getSession().createQuery(Hql)
				.setString("text", text);
		return ((Number) query.uniqueResult()).intValue();
	}

	@Override
	public void DobySql(String Sql) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book_Book> findByWord(String Hql, int fromIndex, int ToIndex) {

		Query query = this.getSession().createQuery(Hql);

		query.setFirstResult(fromIndex);
		query.setMaxResults(ToIndex);

		return query.setCacheable(true).list();

	}

	@Override
	public int getBookSize(String Hql) {

		String c = "select count(*)  ";

		Query query = this.getSession().createQuery(c + Hql);

		int count = ((Number) query.uniqueResult()).intValue();
		return count;
	}

}
