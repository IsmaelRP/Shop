package com.example.demo.users.domain.model;

public class UserQuery {

	private String user;
	private String password;
	
	public UserQuery(String user, String password) {
		this.user = user;
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
	
	
	
}
