package com.askinfo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.askinfo.beans.SignIn;

public class LoginDaoImpl implements LoginDao {
	public SignIn getLoginInfo() {
		Connection c = null;
		Statement stmt = null;
		SignIn userInfo = new SignIn();
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/askinfo", "postgres", "@Yush614");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM SIGNINDETAILS;");
			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				userInfo.setUsername(username);
				userInfo.setPassword(password);
				System.out.println("id: " + id + " username: " + username + " password" + password);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
		return userInfo;
	}

}
