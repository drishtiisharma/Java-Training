package com.ak.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ips.daoimpl.UserInfoDaoImpl;
import com.ips.pojo.UserInfo;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserInfo u = new UserInfo();
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		
		UserInfoDaoImpl daoimpl = new UserInfoDaoImpl();
		boolean isValid = daoimpl.checkUserCredential(u);
		
		String target="";
		if(isValid==true)
		{
			
			target = "/home.jsp";
			
			HttpSession session = request.getSession(false);
			if(session!=null)
			{
				session.invalidate();
			}
			session = request.getSession(true);
			session.setAttribute("user", u.getUsername());
			request.setAttribute("username", u.getUsername());
		}
		else
		{
			target = "/login.jsp";
			request.setAttribute("msg", "Invalid Username Password");
		}
		
		RequestDispatcher rd = 
		getServletContext().getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
