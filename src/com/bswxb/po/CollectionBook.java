package com.bswxb.po;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CollectionBook")
public class CollectionBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;

	@Column(length=50) 
	private String book_Name= "不明";
	@Column(length=50) 
	private String book_Adress= "不明";
	private int book_Words;
	
	@Column(length=50) 
	private String book_Author= "不明";
	@Column(length=50) 
	private String book_Date = "不明";
	@Column(length=60) 
	private String book_Tag = "不明";
	@Column(length=10) 
	private String book_Party = "不明";
	@Column(length=30) 
	private String book_Click = "不明";
	@Column(length=30) 
	
	
	private String book_State = "不明";
	@Column(length=1000) 
	private String book_Msg="不明";
	
	@Column(length=10) 
	private String book_site="不明";
	
	@Column(length=200) 
	private String book_Url ="";

	@Column(length=200) 
	private int book_CollectionNum =0;

	
	
/*	@OneToOne(mappedBy="CollectionBook")
	private Score score;
*/


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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



	public String getBook_Click() {
		return book_Click;
	}



	public void setBook_Click(String book_Click) {
		this.book_Click = book_Click;
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



	public int getBook_CollectionNum() {
		return book_CollectionNum;
	}



	public void setBook_CollectionNum(int book_CollectionNum) {
		this.book_CollectionNum = book_CollectionNum;
	}



	/*public Score getScore() {
		return score;
	}



	public void setScore(Score score) {
		this.score = score;
	}
*/


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((book_Name == null) ? 0 : book_Name.hashCode());
		result = prime * result
				+ ((book_Url == null) ? 0 : book_Url.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CollectionBook other = (CollectionBook) obj;
		if (book_Name == null) {
			if (other.book_Name != null)
				return false;
		} else if (!book_Name.equals(other.book_Name))
			return false;
		if (book_Url == null) {
			if (other.book_Url != null)
				return false;
		} else if (!book_Url.equals(other.book_Url))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

    

	
	
	
	
	
}
