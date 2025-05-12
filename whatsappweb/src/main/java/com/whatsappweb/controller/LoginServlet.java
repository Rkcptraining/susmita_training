package com.whatsappweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.whatsappweb.entity.WhatsappUser;
import com.whatsappweb.service.WhatsappService;
import com.whatsappweb.service.WhatsappServiceInterface;


public class LoginServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password=request.getParameter("pass");
		String email=request.getParameter("em");
		
		
		//transfer the above data to service layer using DTO design pattern
		
		WhatsappUser wu=new WhatsappUser();
		
		wu.setPassword(password);
		wu.setEmail(email);
		
		
		WhatsappServiceInterface ws=new WhatsappService();
		
		boolean b=ws.loginProfileService(wu);
		
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><center><font color=red size=7");
		System.out.println(b);
		if(b) {
			
			//why to use session?
			//session is use to share data with entire project and it is valid for 30 minutes
			//how to create session
			//HttpSession ss=request.getSession(true);
			//how i will share my email id with session
			//ss.setAttribute("useremailid",email);
			
			HttpSession ss=request.getSession(true);
			ss.setAttribute("useremailid",email);
			
			out.println("<br>Welcome "+email);
			
			out.println("<br><a href=ViewProfileServlet>View Profile</a>");
			out.println("<br><a href=EditProfileServlet>Edit Profile</a>");
			out.println("<br><a href=DeleteProfileServlet>Delete Profile</a>");
			out.println("<br><a href=SearchProfileServlet>Search Profile</a>");
			out.println("<br><a href=ViewAllProfileServlet>View All Profile</a>");
		}
		else {
			out.println("login Fail or Invalid username and password");
		}
		out.println("</font></center></body></html>");
	}

}
