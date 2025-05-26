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

public class DeleteProfileServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(true);
		String email= ss.getAttribute("useremailid").toString();
		
		WhatsappUser ww=new WhatsappUser();
		ww.setEmail(email);
		
		WhatsappServiceInterface ws=new WhatsappService();
		int i= ws.deleteProfileService(ww);
		
		System.out.println(i);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><center><font color=red size=7");
		if(i>0) {
			out.println("record deleted successfull");
			
		}
		else {
			out.println("could not delete");
		}
		out.println("</font></center></body></html>");
	}

}
