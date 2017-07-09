package com.askinfo.factories;

import com.askinfo.dao.LoginDaoImpl;

public class LoginDaoFactory {
	private final static LoginDaoImpl service=new LoginDaoImpl();
	
	public static LoginDaoImpl getLoginDaoImpl(){
		return service;
	}
}
