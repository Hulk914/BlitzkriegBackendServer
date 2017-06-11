package com.rest.hulk.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.rest.hulk.data.UserDetails;

public class UserDao {
	   public UserDetails getUserInfo() {
		      Connection c = null;
		      Statement stmt=null;
		      UserDetails userInfo=new UserDetails();
		      try {
		         Class.forName("org.postgresql.Driver");
		         c = DriverManager
		            .getConnection("jdbc:postgresql://localhost:5432/user",
		            "postgres", "@Yush614");
		         stmt=c.createStatement();
		         ResultSet rs=stmt.executeQuery("SELECT * FROM USERDETAILS;");
		         while(rs.next()){
		        	 int id=rs.getInt("id");
		        	 String username=rs.getString("username");
		        	 String password=rs.getString("password");
		        	 userInfo.setUsername(username);
		        	 userInfo.setPassword(password);
		        	 System.out.println("id: "+id+"username: "+username+"password"+password);
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		      }
		      System.out.println("Opened database successfully");
		      return userInfo;
		   }
}
