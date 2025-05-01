package com.whatsapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.whatsapp.entity.WhatsappUser;

//DAO(DATA ACCESS OBJECT) is use to interact with database (mysql) via JDBC(JAVA DATABASE CONNECTIVITY) for insert, delete , update, select query

public class WhatsappDAO implements WhatsappDAOInterface {

	@Override
	public int createProfileDAO(WhatsappUser wu) {
		int i = 0;
		try {
			// TO CONNECT WITH JDBC THERE ARE 4 STEPS
			// step 1 load driver
			Class.forName("com.mysql.jdbc.Driver");
			// step 2 create connection with database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rkcpsusmita", "root", "rajesh");

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
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ww;
	}

	@Override
	public ArrayList<WhatsappUser> viewAllProfileDAO() {

		ArrayList<WhatsappUser> pp = new ArrayList<WhatsappUser>();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rkcpsusmita", "root", "rajesh");
		PreparedStatement ps = con.prepareStatement("select * from whatsappuser");

		ResultSet res = ps.executeQuery();

		while (res.next()) {
			String n = res.getString(1);
			String p = res.getString(2);
			String e = res.getString(3);
			String a = res.getString(4);

			WhatsappUser ww = new WhatsappUser();
			ww.setName(n);
			ww.setPassword(p);
			ww.setEmail(e);
			ww.setAddress(a);

			pp.add(ww);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pp;
	}

	@Override
	public int deleteProfileDAO(WhatsappUser wu) {
		int i =0;
	
		try {
	
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rkcpsusmita", "root", "rajesh");

		PreparedStatement ps = con.prepareStatement("delete from whatsappuser where email=?");

		ps.setString(1, wu.getEmail());

		i= ps.executeUpdate(); // for insert, delete, update query we will use executeUpdate() method
									// executeUpdate() method will return int i.e. number of rows affected by query
									// in table
		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public ArrayList<WhatsappUser> searchProfileDAO(WhatsappUser wu) {
		ArrayList<WhatsappUser> pp = new ArrayList<WhatsappUser>();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rkcpsusmita", "root", "rajesh");
		PreparedStatement ps = null;

		if (wu.getName() != null) {
			ps = con.prepareStatement("select * from whatsappuser where name=?");
			ps.setString(1, wu.getName());
		} else {
			ps = con.prepareStatement("select * from whatsappuser where address=?");
			ps.setString(1, wu.getAddress());
		}
		ResultSet res = ps.executeQuery();

		while (res.next()) {
			String n = res.getString(1);
			String p = res.getString(2);
			String e = res.getString(3);
			String a = res.getString(4);

			WhatsappUser ww = new WhatsappUser();
			ww.setName(n);
			ww.setPassword(p);
			ww.setEmail(e);
			ww.setAddress(a);

			pp.add(ww);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pp;

	}

	@Override
	public int edithProfileDAO(WhatsappUser wu) {
		int i = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rkcpsusmita", "root", "rajesh");
			PreparedStatement ps = null;

			if (wu.getPassword() != null) {
				ps = con.prepareStatement("update whatsappuser set password=? where email=?");
				ps.setString(1, wu.getPassword());
				ps.setString(2, wu.getEmail());
			} else {
				ps = con.prepareStatement("update whatsappuser set address=? where email=?");
				ps.setString(1, wu.getAddress());
				ps.setString(2, wu.getEmail());
			}
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
