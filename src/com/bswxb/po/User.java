package com.bswxb.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="user")
public class User {

	@Column(length=50) 
	private String uname;
	@Column(length=50) 
	private String upwd;
	@Column(length=50) 
	private String uip;
	@Column(length=100) 
	private String uquestion;
	@Column(length=100) 
	private String uanswer;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id") 
	private int uid;
	@Column(length=50) 
	private String party;
	

	
	
	
	
	
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="user_book",
		joinColumns={
			@JoinColumn(name="user_id")
		},
		inverseJoinColumns={
			@JoinColumn(name="book_id")
		}
	)
	private Set<Book_Book> book = new HashSet<>();
	
	
	@OneToOne(mappedBy="user")
	private Score score;
	
	



	public Set<Book_Book> getBook() {
		return book;
	}

	public void setBook(Set<Book_Book> book) {
		this.book = book;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUip() {
		return uip;
	}

	public void setUip(String uip) {
		this.uip = uip;
	}

	public String getUquestion() {
		return uquestion;
	}

	public void setUquestion(String uquestion) {
		this.uquestion = uquestion;
	}

	public String getUanswer() {
		return uanswer;
	}

	public void setUanswer(String uanswer) {
		this.uanswer = uanswer;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Users [uname=" + uname + ", upwd=" + upwd + ", uip=" + uip + ", uquestion=" + uquestion + ", uanswer="
				+ uanswer + ", uid=" + uid + "]";
	}

}
