package com.ips.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String msg = request.getParameter("t1");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Hello Servlet");
		out.print("</title></head><body><font color=green size=5>");
		out.print(msg+"</font></body></html>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
