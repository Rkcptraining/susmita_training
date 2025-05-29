package com.whatsappweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CaptchaServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rnumber = (int)((Math.random())*10000);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		out.println("<table border=5><tr><td><input type=text id=cc value="+rnumber+" disabled></td><td><button type=button onClick=captcha()>refresh</button></td></tr>");
		out.println("<tr><td>enter the above number <input type=text id=cc1></td><td><button type=button  onClick=validatecaptcha()>validate</button></td></tr></table>");
		
		out.println("</body></html>");
	}

}
