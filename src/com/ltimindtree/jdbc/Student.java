package com.ltimindtree.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student {

	public void createDatabase() {
		//connection establish
				try {
					String url = "jdbc:mysql://localhost:3306/";
					String username = "root";
					String password = "tommy26";
					
					Connection con = DriverManager.getConnection(url, username, password);
					Statement stm = con.createStatement();   //statement create
					
					String query = "CREATE database codingwallah";
					boolean bl = stm.execute(query);        //execute query
					System.out.println("database created successfully " + bl );
					
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
		
	public void createTable() {
		//connection establish
		try {
			String url = "jdbc:mysql://localhost:3306/codingwallah";
			String username = "root";
			String password = "tommy26";
			
			Connection con = DriverManager.getConnection(url, username, password);
			Statement stm = con.createStatement();   //statement create
			
			String query = "CREATE TABLE Student (sid INT(3), sname VARCHAR(200), semail VARCHAR(200))";
			stm.execute(query);        //execute query
			System.out.println("Table created successfully");
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void createData() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String db = "codingwallah";
			String username = "root";
			String password = "tommy26";
			String query = "INSERT INTO Student (sid, sname, semail) VALUES (?,?,?)";
			
			Connection con = DriverManager.getConnection(url+db, username, password);
			
			PreparedStatement pstm = con.prepareStatement(query);   //Prepared statement create
			pstm.setInt(1, 11);
			pstm.setString(2,  "Ashwin");
			pstm.setString(3,  "ashwin@gmail.com");
			
			/* we can execute query in 2 ways */
			//ptsm.execute();
			//pstm.executeUpdate();        
			pstm.executeQuery();           //--Statement.executeQuery() cannot issue statements that do not produce result sets. ERROR
			System.out.println("Data inserted successfully");
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readData() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String db = "codingwallah";
			String username = "root";
			String password = "tommy26";
			String query = "SELECT * FROM Student";
			
			Connection con = DriverManager.getConnection(url+db, username, password);
			
			Statement stm = con.createStatement();   
			//stm.execute(query);   //by this we can only get output "read succ...." but we cant see data
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				System.out.println(" id = " + rs.getInt(1));
				System.out.println(" name = " + rs.getString(2));
				System.out.println(" email = " + rs.getString(3));
			}
			
			System.out.println("Read successfully " );
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateData() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String db = "codingwallah";
			String username = "root";
			String password = "tommy26";
			String query = "UPDATE Student SET sid = ? WHERE sname = ?";
			
			Connection con = DriverManager.getConnection(url+db, username, password);
			
			PreparedStatement pstm = con.prepareStatement(query);   //Prepared statement create
			pstm.setInt(1, 18);
			pstm.setString(2,  "Mampi");
			       
			pstm.execute();           
			System.out.println("Data updated successfully");
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteData() {
		try {
			String url = "jdbc:mysql://localhost:3306/";
			String db = "codingwallah";
			String username = "root";
			String password = "tommy26";
			String query = "DELETE FROM Student WHERE sid = ?";
			
			Connection con = DriverManager.getConnection(url+db, username, password);
			
			PreparedStatement pstm = con.prepareStatement(query);   //Prepared statement create
			pstm.setInt(1, 18);
			
			pstm.execute();           
			System.out.println("Data deleted successfully");
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
