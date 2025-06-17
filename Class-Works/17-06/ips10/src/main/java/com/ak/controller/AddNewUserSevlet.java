package com.ak.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ips.daoimpl.UserInfoDaoImpl;
import com.ips.pojo.UserInfo;

@WebServlet("/AddNewUserSevlet")
public class AddNewUserSevlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		UserInfo u = new UserInfo();
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		u.setFname(request.getParameter("fname"));
		u.setLname(request.getParameter("lname"));
		u.setContact(request.getParameter("contact"));
		
		UserInfoDaoImpl daoimpl = new UserInfoDaoImpl();
		boolean b = daoimpl.addNewUser(u);
		String target="";
		if(b==true)
		{
			target = "/login.jsp";
			request.setAttribute("msg", "User Register Successfully, Can login Here");
		}
		else
		{
			target = "/reg.jsp";
			request.setAttribute("msg", "User Could Not Be Register Successfully");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
	

}
