package com.whatsappweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.whatsappweb.entity.WhatsappUser;

public class WhatsappDAO implements WhatsappDAOInterface {

	@Override
	public int createProfileDAO(WhatsappUser wu) {
		int i = 0;
		Connection con =null;
		try {
			// TO CONNECT WITH JDBC THERE ARE 4 STEPS
			// step 1 load driver
			Class.forName("com.mysql.jdbc.Driver");
			// step 2 create connection with database
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/rkcpsusmita", "root", "rajesh");

			// step 3 create query
			PreparedStatement ps = con.prepareStatement("insert into whatsappuser values(?,?,?,?)");
			ps.setString(1, wu.getName());
			ps.setString(2, wu.getPassword());
			ps.setString(3, wu.getEmail());
			ps.setString(4, wu.getAddress());

			// step 4 how to execute query

			i = ps.executeUpdate(); // for insert delete update query we will use executeUpdate() method
									// executeUpdate() method will return int i.e. number of rows affected by query
									// in table
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		//what is purpose of finally block?
		//finally block will ensure proper termination of program
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;

}

	@Override
	public boolean loginProfileDAO(WhatsappUser wu) {
		boolean i = false;
		Connection con =null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/rkcpsusmita", "root", "rajesh");
			
			PreparedStatement ps = con.prepareStatement("select * from whatsappuser where email=? and password=?");
			ps.setString(1, wu.getEmail());
			ps.setString(2, wu.getPassword());
					
			ResultSet res = ps.executeQuery(); 
									
			if(res.next()) {
				i=true;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		//what is purpose of finally block?
		//finally block will ensure proper termination of program
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}

	@Override
	public WhatsappUser viewProfileDAO(WhatsappUser wu) {
		WhatsappUser ww = null;
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rkcpsusmita", "root", "rajesh");
		PreparedStatement ps = con.prepareStatement("select * from whatsappuser where email=?");
		ps.setString(1, wu.getEmail());

		ResultSet res = ps.executeQuery(); // for select query we will use executeQuery() method
											// return type of executeQuery() method will be ResultSet i.e. result
											// returned by table
		// res.next() will point to next row in table if it exist it will return true
		// otherwise false
		if (res.next()) {
			String n = res.getString(1);
			String p = res.getString(2);
			String e = res.getString(3);
			String a = res.getString(4);

			ww = new WhatsappUser();
			ww.setName(n);
			ww.setPassword(p);
			ww.setEmail(e);
			ww.setAddress(a);

		}
		else {
				
			
		}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return ww;
	}
}




















