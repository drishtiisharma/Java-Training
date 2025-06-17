package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ShowCartServlet")
public class ShowCartServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DBService db = new DBService();
		HttpSession session = request.getSession(false);
		String username = (String)session.getAttribute("user");
		ArrayList al =  db.getCart(username);
		session.setAttribute("products", al);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/cart.jsp");
		rd.forward(request, response);
	}

}
