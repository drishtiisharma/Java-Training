package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserInfo u = new UserInfo();
		u.setUsername(request.getParameter("t1"));
		u.setPassword(request.getParameter("t2"));
		//PrintWriter hars = response.getWriter();
		DBService db =  new DBService();
		boolean isvalid = db.check(u); 
		RequestDispatcher rd;
		if(isvalid==true)
		{
		HttpSession session = request.getSession(false);//it return old session
		if(session!=null)
		{
			session.invalidate();
		}
		session = request.getSession(true);//it will give a new session
		session.setAttribute("user", u.getUsername());
		rd = getServletContext().getRequestDispatcher("/itemindex.jsp");
		}
		else
		{
			request.setAttribute("sms","<font color=red>InValid User</font>");
			rd = getServletContext().getRequestDispatcher("/login.jsp");
			
		}
		rd.include(request, response);
	}

}
