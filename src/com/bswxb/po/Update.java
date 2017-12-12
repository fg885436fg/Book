package com.bswxb.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="updateBooks")
public class Update {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;

	
	@Column(length=50) 
	private String book_Name= "不明";
	@Column(length=50) 
	private String book_Adress= "不明";

	
	@Column(length=10) 
	private String book_Party = "不明";
	
    @Column(length=30) 
	private String book_State = "不明";

    
    
	public Update() {
		
	
	
	}
    
    
    
	public Update(String book_Name, String book_Adress,
			String book_Party, String book_State) {
		
	
		this.book_Name = book_Name;
		this.book_Adress = book_Adress;
		this.book_Party = book_Party;
		this.book_State = book_State;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	






































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
	
    
    
    
    
    
    
    
	

}
