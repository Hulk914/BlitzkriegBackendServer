package com.askinfo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.askinfo.beans.SignUp;

public class SignUpDaoImpl implements SignUpDao {

	public void addUser(SignUp signUpDetails) {
		Connection c = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/askinfo", "postgres", "@Yush614");
			stmt= c.prepareStatement("INSERT INTO SIGNINDETAILS (username, password, email) VALUES(?, crypt(?, gen_salt('bf', 8)), ?)");
			stmt.setString(1, signUpDetails.getUsername());
			stmt.setString(2, signUpDetails.getPassword());
			stmt.setString(3, signUpDetails.getEmail());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Added User to database successfully");
	}
}
