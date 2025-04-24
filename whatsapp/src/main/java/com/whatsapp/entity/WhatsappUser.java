package com.whatsapp.entity;

public class WhatsappUser {
	private String name;
	private String password;
	private String email;
	private String address;
	
	
	//since all the above variables are private so how to add data to these variables and take data from these variables?
	//to add data we will use setter method and to take data we will use getter method.
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
