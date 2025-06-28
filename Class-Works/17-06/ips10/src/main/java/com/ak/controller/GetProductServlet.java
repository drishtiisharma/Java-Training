package com.ak.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ips.daoimpl.ProductDaoImpl;
import com.ips.pojo.Product;

@WebServlet("/GetProductServlet")
public class GetProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int pid = 0;
		try {
			pid =Integer.parseInt(request.getParameter("s1"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		ProductDaoImpl daoimp = new ProductDaoImpl();
		Product pd = daoimp.searchProduct(pid);
		request.setAttribute("product", pd);
		
		RequestDispatcher rd = request.getRequestDispatcher("/modifyproduct.jsp");
		rd.forward(request, response);
		
	}

}
