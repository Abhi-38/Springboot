package com.abhi.prj.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")          //used table annotation to map the table in the database
public class User {
	@Id     //to indicate primary column
	@GeneratedValue(strategy = GenerationType.IDENTITY)     //to auto generate
	private long id;
	
	@Column(nullable = false, unique = true, length = 45)         //to apply not null and unique key constraint and length 45 to email
	private String email; 
	
	@Column(nullable = false, length = 64)                       //applying not null at password
	private String password;
	
	@Column(nullable = false, length = 20)						 //applying not null at firstname
	private  String firstName;
	
	@Column(nullable = false, length = 20)						 //applying not null at lastname
	private String lastName;
	
	public long getId() {										//To get the id data
		return id;
	}//getID
	public void setId(long id) {								//to set the id data
		this.id = id;
	}//setId
	public String getEmail() {									//to get email data
		return email;
	}//getEmail
	public void setEmail(String email) {						//to set email data
		this.email = email;
	}//setEmail
	public String getPassword() {								//to get the password data
		return password;
	}//getPassword
	public void setPassword(String password) {					//to set the Password data
		this.password = password;
	}//setPassword
	public String getFirstName() {								//to get the firstName data
		return firstName;
	}//getFirstName
	public void setFirstName(String firstName) {				//to set the first name
		this.firstName = firstName;
	}//setFirstName
	public String getLastName() {								//to get the last name
		return lastName;
	}//getlastname
	public void setLastName(String lastName) {					//to set the last name
		this.lastName = lastName;
	}//setlastname
}//class
