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

public class CheckEmailServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ss = request.getParameter("myemail");
		
		WhatsappUser ww=new WhatsappUser();
		ww.setEmail(ss);
		
		WhatsappServiceInterface wi=new WhatsappService();
		int i = wi.checkEmailService(ww);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		if(i>0) {
			out.println("<font color=red>Email Already Exist In Database</font>");
		}
		else {
			out.println("<font color=green>Valid Email</font>");
		}
		out.println("</body></html>");
	}

}
