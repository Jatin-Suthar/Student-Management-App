package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConProv {
	
	static Connection conn;
	
	public static Connection createCon() {
		try {
			//load the driver 
			Class.forName("com.mysql.jdbc.Driver");
			
			//create the connection
			String user = "root";
			String password = "Jatin@300";
			String url = "jdbc:mysql://localhost:3306/student_manage";;
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
