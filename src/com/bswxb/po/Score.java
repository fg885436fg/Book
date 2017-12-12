package com.bswxb.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Score")
public class Score {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length=1)
	private int assess ;
	
	@Column(length=3000)
	private String  bookReview;
	
	private long date;
	
	
	@OneToOne
	private Book_Book book;
	

	@OneToOne
	private User user;
	
/*	@OneToOne
	private CollectionBook  collectionBook;
	*/

	
	
	
	
	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getBookReview() {
		return bookReview;
	}

	public void setBookReview(String bookReview) {
		this.bookReview = bookReview;
	}

	public int getAssess() {
		return assess;
	}

	public void setAssess(int assess) {
		this.assess = assess;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book_Book getBook() {
		return book;
	}

	public void setBook(Book_Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*public CollectionBook getCollectionBook() {
		return collectionBook;
	}

	public void setCollectionBook(CollectionBook collectionBook) {
		this.collectionBook = collectionBook;
	}
	
	*/

}
