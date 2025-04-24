package com.whatsapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.whatsapp.entity.WhatsappUser;

//DAO(DATA ACCESS OBJECT) is use to interact with database (mysql) via JDBC(JAVA DATABASE CONNECTIVITY) for insert, delete , update, select query

public class WhatsappDAO implements WhatsappDAOInterface {

	@Override
	public int createProfileDAO(WhatsappUser wu)throws Exception {
		//TO CONNECT WITH JDBC THERE ARE 4 STEPS
		//step 1 load driver 
		Class.forName("com.mysql.jdbc.Driver");
		//step 2 create connection with database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rkcpsusmita","root","rajesh");
		
		//step 3 create query
		PreparedStatement ps=con.prepareStatement("insert into whatsappuser values(?,?,?,?)");
		ps.setString(1, wu.getName());
		ps.setString(2, wu.getPassword());
		ps.setString(3, wu.getEmail());
		ps.setString(4, wu.getAddress());
		
		//step 4 how to execute query
		
		int i=ps.executeUpdate(); //for insert delete update query we will use executeUpdate() method
		
		
		return i;
	}

}
