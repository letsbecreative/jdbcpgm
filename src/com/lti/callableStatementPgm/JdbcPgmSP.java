package com.lti.callableStatementPgm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcPgmSP {

	InputStreamReader is = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(is);
	String name, emailid, dept, mobileNo;
	
	public static Connection getConnection1() {
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpgm", "root", "tommy26");
			
		} catch(ClassNotFoundException cnfe) {
			System.out.println("Class not found exception");
			
		} catch(SQLException sqle) {
			System.out.println(sqle);
		}
		return c;
		 
	}
	public void insertData() throws IOException, SQLException {
		System.out.println("Enter the name ");
		name = br.readLine();
		System.out.println("Enter the emailId ");
		emailid = br.readLine();
		System.out.println("Enter the dept ");
		dept = br.readLine();
		System.out.println("Enter the mobileNo ");
		mobileNo = br.readLine();
		
		Connection c = getConnection1();
		CallableStatement stmt = c.prepareCall("{call insert_dataintoTabe(?, ?, ?, ?)}");
		stmt.setString(1, name);
		stmt.setString(2,  dept);
		stmt.setString(3,  emailid);
		stmt.setString(4,  mobileNo);
		
		boolean s = stmt.execute();
		if(s) {
			System.out.println("Inserted successfully");
		} else {
			System.out.println("Error in insertion");
		}
	}
	
	public void reteriveValFromProcedure() throws IOException, SQLException {
		Connection c = getConnection1();
		System.out.println("Enter the string Id u want to reterive");
		int registerNo = Integer.parseInt(br.readLine());
		
		CallableStatement cs = c.prepareCall("{call reteriveWithArgument(?)}");
		cs.setInt(1, registerNo);
		boolean s = cs.execute();
		while(s) {
			ResultSet rs = cs.getResultSet();
			while(rs.next()) {
				System.out.println("Id is ---------------->" +rs.getInt("id"));
				System.out.println("Name is ---------------->" +rs.getString("name"));
				System.out.println("Department is ---------------->" +rs.getString("dept"));
				System.out.println("EamilId is ---------------->" +rs.getString("emailid"));
				System.out.println("MobileNo is ---------------->" +rs.getString("mobileNo"));
			}
		}
	}
	public static void main(String[] args) throws IOException, SQLException {
		JdbcPgmSP jdbc = new JdbcPgmSP();
		jdbc.insertData();
		jdbc.reteriveValFromProcedure();
	}

}
