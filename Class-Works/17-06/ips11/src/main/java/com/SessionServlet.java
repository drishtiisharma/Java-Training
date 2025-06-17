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
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet 
{
	//private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String op = request.getParameter("b1");
		HttpSession session = request.getSession(false);
		Product p = new Product();
		p.setPid(request.getParameter("s1"));
		p.setPrice(Integer.parseInt(request.getParameter("s2")));
		p.setUsername((String)session.getAttribute("user"));
		DBService db = new DBService();
		int x = db.addToCart(p);
		if(op.equals("addac"))
		{
			ArrayList al = (ArrayList) session.getAttribute("aclist");
			if(al==null)
			{
				al = new ArrayList();
			}
			al.add(p);
			session.setAttribute("aclist", al); 
		}
		if(op.equals("addtv"))
		{
			ArrayList bl = (ArrayList)session.getAttribute("tvlist");
			if(bl==null)
			{
				bl = new ArrayList();
			}
			bl.add(p);
			session.setAttribute("tvlist", bl);
			 
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/itemindex.jsp");
		rd.include(request, response);	
	}
	

}
