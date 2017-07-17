package com.askinfo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.askinfo.beans.SignIn;

public class LoginDaoImpl implements LoginDao {
	public SignIn getLoginInfo(String username, String password) {
		Connection c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		SignIn userInfo = new SignIn();
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/askinfo", "postgres", "@Yush614");
			stmt = c.prepareStatement("SELECT * FROM SIGNINDETAILS WHERE USERNAME=? AND PASSWORD=CRYPT(?, PASSWORD);");
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.execute();
			rs = stmt.getResultSet();
			if (!rs.next())
				return null;
			userInfo.setEmail(rs.getString("email"));
			userInfo.setId(rs.getString("id"));
			userInfo.setPassword(rs.getString("password"));
			userInfo.setUsername(rs.getString("username"));

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
		return userInfo;
	}

}
