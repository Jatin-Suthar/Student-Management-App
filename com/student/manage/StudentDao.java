package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	public static boolean insertStudentToDb(Student st) {
		
		boolean f = false;
		try {
			//jdbc code
			Connection conn = ConProv.createCon();
			String q = "insert into student(sname, sphone, scity) values(?,?,?)";
			//PreparedStatement
			PreparedStatement pstmt = conn.prepareStatement(q);
			//set the values of parameters
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute..
			pstmt.executeUpdate();
			f = true;
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		return f;	
	}

	public static boolean deleteStudent(int userId) {
		
		boolean f = false;
		try {
			//jdbc code
			Connection conn = ConProv.createCon();
			String q = "delete from student where sid=?";
			//PreparedStatement
			PreparedStatement pstmt = conn.prepareStatement(q);
			//set the values of parameters
			pstmt.setInt(1, userId);
			
			//execute..
			pstmt.executeUpdate();
			f = true;
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		return f;
	}

	public static boolean showAllStudent() {
		boolean f = false;
		try {
			//jdbc code
			Connection conn = ConProv.createCon();
			String q = "select * from student";
			//Statement
			Statement st = conn.createStatement();
			//execute..
			ResultSet set = st.executeQuery(q);
			
			while(set.next()) {
				
				int id = set.getInt(1);
				String name = set.getString(2);
				String phoneNo = set.getString(3);
				String city = set.getString(4);
				
				System.out.println("ID : "+ id);
				System.out.println("Name : "+ name);
				System.out.println("Phone No. : "+ phoneNo);
				System.out.println("city : "+ city);
				System.out.println("++++++++++++++++++++++++++++++++++++");
			}
			f = true;
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		return f;
	}
}
