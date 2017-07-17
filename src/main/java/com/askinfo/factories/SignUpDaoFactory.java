package com.askinfo.factories;

import com.askinfo.dao.SignUpDaoImpl;

public class SignUpDaoFactory {
	private final static SignUpDaoImpl service=new SignUpDaoImpl();
	
	public static SignUpDaoImpl getSignUpDaoImpl() {
		return service;
	}
}
