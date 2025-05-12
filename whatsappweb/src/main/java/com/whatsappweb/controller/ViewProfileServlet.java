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


public class ViewProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(true);
		String email= ss.getAttribute("useremailid").toString();
		
		WhatsappUser wu=new WhatsappUser();
		wu.setEmail(email);
		
		WhatsappServiceInterface ws=new WhatsappService();
		WhatsappUser b=ws.viewProfileService(wu);
		
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><center><font color=red size=7");
		
		if(b!=null) {
			out.println("<br>Your Profile is  ");
			out.println("<br> Name is "+b.getName());
			out.println("<br>Password is "+b.getPassword());
			out.println("<br>Email is "+b.getEmail());
			out.println("<br>Address is "+b.getAddress());
			
		
		}
		else {
			out.println("profile not found");
		}
		out.println("</font></center></body></html>");
	}

}
