package com.ch.model;

public class User {
	
	private int userId;
	
	private String name;
	
	private String loginName;
	
	
	private String password;


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public User(int userId, String loginName, String password) {
		super();
		this.userId = userId;
		this.loginName = loginName;
		this.password = password;
	}


	
	
	

}
