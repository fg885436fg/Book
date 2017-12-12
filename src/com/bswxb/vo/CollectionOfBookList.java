package com.bswxb.vo;



import com.bswxb.po.CollectionBook;
import com.bswxb.util.ChangUnix;

public class CollectionOfBookList {

	

	private int bookId;
	private String book_Name= "不明";
	private String book_Adress= "不明";
	private int book_Words;
	private String book_Author= "不明";
	private String book_Date = "不明";
 	private String book_Tag = "不明";
	private String book_Party = "不明";

	private String book_State = "不明";
	private String book_Msg="不明";
	private String book_site="不明";
	private String book_Url ="";
	private int count;//总页数
	private int curPage=1;
	private int collectionNum= 0 ;//收藏数
   
	
	public CollectionOfBookList(CollectionBook book, int count, int curPage) {
		
		ChangUnix chang = new ChangUnix();
		this.book_Name = book.getBook_Name();
		this.book_Adress = book.getBook_Adress();
		this.book_Words = book.getBook_Words();
		this.book_Author = book.getBook_Author();
		this.book_Date = chang.TimeStamp2Date(book.getBook_Date());
		this.book_Tag = book.getBook_Tag();
		this.book_Party = book.getBook_Party();
		this.bookId = book.getId();
		
		
		this.book_State = book.getBook_State();
		this.book_Msg = book.getBook_Msg();
		this.book_site = book.getBook_site();
		this.book_Url = book.getBook_Url();
		this.count = count;//总页数
		this.curPage = curPage;
		this.collectionNum =book.getBook_CollectionNum();
	}



	public int getBookId() {
		return bookId;
	}



	public void setBookId(int bookId) {
		this.bookId = bookId;
	}



	public String getBook_Name() {
		return book_Name;
	}
	public void setBook_Name(String book_Name) {
		this.book_Name = book_Name;
	}
	public String getBook_Adress() {
		return book_Adress;
	}
	public void setBook_Adress(String book_Adress) {
		this.book_Adress = book_Adress;
	}
	public int getBook_Words() {
		return book_Words;
	}
	public void setBook_Words(int book_Words) {
		this.book_Words = book_Words;
	}
	public String getBook_Author() {
		return book_Author;
	}
	public void setBook_Author(String book_Author) {
		this.book_Author = book_Author;
	}
	public String getBook_Date() {
		return book_Date;
	}
	public void setBook_Date(String book_Date) {
		this.book_Date = book_Date;
	}
	public String getBook_Tag() {
		return book_Tag;
	}
	public void setBook_Tag(String book_Tag) {
		this.book_Tag = book_Tag;
	}
	public String getBook_Party() {
		return book_Party;
	}
	public void setBook_Party(String book_Party) {
		this.book_Party = book_Party;
	}

	public String getBook_State() {
		return book_State;
	}
	public void setBook_State(String book_State) {
		this.book_State = book_State;
	}
	public String getBook_Msg() {
		return book_Msg;
	}
	public void setBook_Msg(String book_Msg) {
		this.book_Msg = book_Msg;
	}
	public String getBook_site() {
		return book_site;
	}
	public void setBook_site(String book_site) {
		this.book_site = book_site;
	}
	public String getBook_Url() {
		return book_Url;
	}
	public void setBook_Url(String book_Url) {
		this.book_Url = book_Url;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}



	public int getCollectionNum() {
		return collectionNum;
	}



	public void setCollectionNum(int collectionNum) {
		this.collectionNum = collectionNum;
	}
	
	
	
	
	
	
	
	
}
