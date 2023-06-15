package com.ltimindtree.jdbc;

import java.sql.*;

public class DemoClass {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/jdbcpgm";
        String uname = "root";
        String pass = "tommy26";
//      String query = "SELECT * FROM Student";
//      String query = "INSERT INTO Student VALUES(4, 'Mohini')";
        int id = 6;
        String name = "Dipali";
        String query = "INSERT INTO Student VALUES (?,?)";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, uname, pass);
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1,  id);
        st.setString(2, name);
 
//      Statement st = con.createStatement();
//      ResultSet rs = st.executeQuery(query);
        int count = st.executeUpdate();
        
        System.out.println(count + " row/s affected");
        
        /*Fetching the data*/
        
/*    String userData = "";
      while(rs.next()) {
        	userData = rs.getInt(1) + " : " + rs.getString(2);
        	System.out.println(userData);
        }

        rs.next();
        String name = rs.getString("name");
        String email = rs.getString("emailid");

        System.out.println(name);
        System.out.println(email);
*/     
        st.close();
        con.close();
    }

}
