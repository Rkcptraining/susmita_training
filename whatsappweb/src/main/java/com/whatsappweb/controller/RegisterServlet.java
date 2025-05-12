package com.whatsappweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whatsappweb.entity.WhatsappUser;
import com.whatsappweb.service.WhatsappService;
import com.whatsappweb.service.WhatsappServiceInterface;


public class RegisterServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//request is use to take request from view layer and response is use to give reponse to view layer
		String name=request.getParameter("nm");
		String password=request.getParameter("pass");
		String email=request.getParameter("em");
		String address=request.getParameter("ad");
		
		//transfer the above data to service layer using DTO design pattern
		
		WhatsappUser wu=new WhatsappUser();
		wu.setName(name);
		wu.setPassword(password);
		wu.setEmail(email);
		wu.setAddress(address);
		
		WhatsappServiceInterface ws=new WhatsappService();
		
		int i=ws.createProfileService(wu);
		
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><center><font color=red size=7");
		if(i>0) {
			out.println("registration successfull");
			out.println("<br>Your User Name is "+email);
			out.println("<br>Your Password is "+password);
			out.println("<br><a href=signin.html>Sign In</a>");
		}
		else {
			out.println("could not register");
		}
		out.println("</font></center></body></html>");
		
	}

}
