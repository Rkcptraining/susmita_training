package com.whatsappweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.whatsappweb.entity.Professor;
import com.whatsappweb.entity.Student;
import com.whatsappweb.entity.WhatsappUser;

public class WhatsappDAO implements WhatsappDAOInterface {
	Session ss;
	
	public WhatsappDAO() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		ss=sf.openSession();
	}

	@Override
	public int createProfileDAO(WhatsappUser wu) {
		int i = 0;
		
		EntityTransaction et=ss.getTransaction();
		et.begin();
			ss.save(wu);  //to insert record via hibernate we will use save() method
		et.commit();
		i=1;
		
		
		
		
		
		
		
		
		
		/* JDBC
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
		*/
		return i;

}

	@Override
	public boolean loginProfileDAO(WhatsappUser wu) {
		boolean i = false;
		
		//via load inbuild method
		
		WhatsappUser pp=ss.load(WhatsappUser.class, wu.getEmail()); //to select data we will use load method with 2 parameter 
		                                                             // first parameter is entity name
		                                                            //second parameter will be primary key value
		
		Student pp1=ss.load(Student.class, "");
		Professor p2p=ss.load(Professor.class,2);
		if(pp!=null) {
			if(pp.getPassword().equals(wu.getPassword())) {
				i=true;
			}
		}
		
		//via HQL query
		
		System.out.println(wu.getEmail()+"  "+wu.getPassword());
		
		Query q= ss.createQuery("from com.whatsappweb.entity.WhatsappUser w where w.email= :em and w.password= :pw");
		q.setParameter("em", wu.getEmail());
		q.setParameter("pw", wu.getPassword());
		
		List<WhatsappUser> ll = q.getResultList();
		
		if(ll.size()>0) {
			i=true;
		}
		
		
		/*Connection con =null;
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
		}*/
		return i;
	}

	@Override
	public WhatsappUser viewProfileDAO(WhatsappUser wu) {
		
		WhatsappUser pp=ss.load(WhatsappUser.class, wu.getEmail());
		/*
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
*/
		return pp;
	}
	
	public List<WhatsappUser> viewAllProfileDAO(WhatsappUser wu) {
		
		Query q= ss.createQuery("from com.whatsappweb.entity.WhatsappUser w");
		
		return q.getResultList();
		
	}
	
	public int deleteProfileDAO(WhatsappUser wu) {
		EntityTransaction et=ss.getTransaction();
		et.begin();
		System.out.println(wu.getEmail());
		//Query q= ss.createQuery("delete from com.whatsappweb.entity.WhatsappUser w where w.email= :em");
		
		Query q= ss.createNamedQuery("deleterecord");
		q.setParameter("em", wu.getEmail());
		int i=q.executeUpdate();
		
		et.commit();
		return i;
	}

	@Override
	public int checkEmailDAO(WhatsappUser ww) {
		int i=0;
		Query q= ss.createQuery("from com.whatsappweb.entity.WhatsappUser w where w.email= :em");
		q.setParameter("em", ww.getEmail());
		
		
		List<WhatsappUser> ll = q.getResultList();
		if(ll.size()>0) {
			i=1;
		}
		return i;
	}
}




















