package com.rest.hulk.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDetails {
	private String username;
	private String password;
	
	public UserDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
