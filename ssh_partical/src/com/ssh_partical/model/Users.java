package com.ssh_partical.model;

import javax.persistence.Id;

public class Users {
     
	private String name;
	@Id
	private Integer id;
	private String email;
	private String company;
	private java.util.Date date;
	
	public java.util.Date getDate(){
		return date;
	}
	
	public void setDate(java.util.Date date){
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
