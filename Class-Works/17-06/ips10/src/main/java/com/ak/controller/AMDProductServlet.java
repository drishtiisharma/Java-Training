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

@WebServlet("/AMDProductServlet")
public class AMDProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Product pd = new Product();
		try {
			pd.setPid(Integer.parseInt(request.getParameter("pid")));	
		}
		catch (Exception e) 
		{
			System.out.println("Invalid Input");
		}
		
		pd.setPname(request.getParameter("pname"));
		
		try {
			pd.setPrice(Double.parseDouble(request.getParameter("price")));
		}
		catch (Exception e) 
		{
			System.out.println("Invalid Input in Price");
		}
		
		String op = request.getParameter("b1");
		ProductDaoImpl daoimp = new ProductDaoImpl();
		if(op.equals("Add Product"))
		{
			if(daoimp.addProduct(pd))
				request.setAttribute("msg", "Product Added Successfully");
			else
				request.setAttribute("msg", "Product Could Not Be Added");
		}
		
		if(op.equals("Update Product"))
		{
			if(daoimp.updateProduct(pd))
				request.setAttribute("msg", "Product Updated Successfully");
			else
				request.setAttribute("msg", "Product Could Not Be Updated");
		}
		if(op.equals("Update Product Detail"))
		{
			if(daoimp.updateProduct(pd))
				request.setAttribute("msg", "Product Updated Successfully");
			else
				request.setAttribute("msg", "Product Could Not Be Updated");
			
			RequestDispatcher rd1 = request.getRequestDispatcher("/modifyproduct.jsp");
			rd1.forward(request, response);
		}
		
		if(op.equals("Delete Product"))
		{
			if(daoimp.deleteProduct(pd))
				request.setAttribute("msg", "Product Deleted Successfully");
			else
				request.setAttribute("msg", "Product Could Not Be Deleted");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/amdproduct.jsp");
		rd.forward(request, response);
		
		
		
	}

}
