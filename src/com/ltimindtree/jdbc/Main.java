package com.ltimindtree.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		Student st = new Student();
		//st.createDatabase();
		//st.createTable();
		
		/*          CRUD              */
		//C : create data
		//st.createData();
		
		//R : read data
		//st.readData();
		
		//U : update data
	    //st.updateData();
	    
	    //D : delete data
	    st.deleteData();
	}

}
