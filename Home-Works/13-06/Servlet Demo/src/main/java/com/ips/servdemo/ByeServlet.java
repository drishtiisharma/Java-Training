package com.ips.servdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ByeServlet")
public class ByeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String msg= request.getParameter("t1");
		PrintWriter out= response.getWriter();
		out.println("<html><head><title>Servlet Demo</title></head><body bgcolor='green'><font size=20px><center><br><br><br><marquee scrollamount=10>"+msg+"</marquee></center></body></html>");
		
		
		
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
