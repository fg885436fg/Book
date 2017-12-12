package com.bswxb.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Addbooks")
public class AddBooks {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private   int  id; 
   @Column(length=50) 
   private	String text;
   
   
   
   
   
   
   
public AddBooks() {

}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
} 


}
