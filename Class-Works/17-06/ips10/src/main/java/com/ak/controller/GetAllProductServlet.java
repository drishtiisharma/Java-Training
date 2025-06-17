package com.ak.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ips.daoimpl.ProductDaoImpl;
import com.ips.pojo.Product;

@WebServlet("/GetAllProductServlet")
public class GetAllProductServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ProductDaoImpl daoimpl = new ProductDaoImpl();
		List<Product>lst = daoimpl.getAllProduct();
		request.setAttribute("allproducts", lst);
		RequestDispatcher rd = request.getRequestDispatcher("/listofproducts.jsp");
		rd.forward(request, response);
		
	}

}
