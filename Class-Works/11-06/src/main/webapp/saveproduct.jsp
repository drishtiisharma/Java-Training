<%@page import="com.ips.daoimpl.ProductDaoImpl"%>
<%@page import="com.ips.pojo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

Product p = new Product();
try
{
	p.setPid(Integer.parseInt(request.getParameter("pid")));
}
catch(NumberFormatException e)
{
	out.println("Invalid Input");
}
p.setPname(request.getParameter("pname"));
try
{
	p.setPrice(Double.parseDouble(request.getParameter("price")));
}
catch(NumberFormatException e)
{
	out.println("Invalid Input");
}

String op = request.getParameter("b1");
ProductDaoImpl daoimpl = new ProductDaoImpl();

	if(op.equals("Add Product"))
	{
		boolean b = daoimpl.addProduct(p);
		if(b==true)
			request.setAttribute("msg", "Product Added Successfully");
		else
			request.setAttribute("msg", "Product Could Not Be Added");
	}
	if(op.equals("Update Product"))
	{
		boolean b = daoimpl.updateProduct(p);
		if(b==true)
			request.setAttribute("msg", "Product Updated Successfully");
		else
			request.setAttribute("msg", "Product Could Not Be Updated");
	}
	if(op.equals("Update Product Details"))
	{
		boolean b = daoimpl.updateProduct(p);
		if(b==true)
			request.setAttribute("msg", "Product Updated Successfully");
		else
			request.setAttribute("msg", "Product Could Not Be Updated");
		%>
		<jsp:forward page="getproduct.jsp"></jsp:forward>
		<%
	}
	if(op.equals("Delete Product"))
	{
		boolean b = daoimpl.deleteProduct(p);
		if(b==true)
			request.setAttribute("msg", "Product Deleted Successfully");
		else
			request.setAttribute("msg", "Product Could Not Be Deleted");
		
	}

%>
<jsp:forward page="amdproduct.jsp"></jsp:forward>
</body>
</html>


