<%@page import="java.lang.classfile.constantpool.DoubleEntry"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
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
int pid = 0;
double price = 0;
String pname = "";
try
{
	pid = Integer.parseInt(request.getParameter("pid"));
}
catch(NumberFormatException e)
{
	out.println("Invalid Input");
}
pname = request.getParameter("pname");
try
{
	price = Double.parseDouble(request.getParameter("price"));
}
catch(NumberFormatException e)
{
	out.println("Invalid Input");
}

try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
}
catch(ClassNotFoundException e)
{
	out.println("Error in loading drivers");
}
String op = request.getParameter("b1");
try
{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ips25java?user=root&password=root");
	
	if(op.equals("Add Product"))
	{
		PreparedStatement ps = con.prepareStatement("insert into product values(?,?,?)");
		ps.setInt(1, pid);
		ps.setString(2, pname);
		ps.setDouble(3, price);
		int x = ps.executeUpdate();
		if(x>0)
			request.setAttribute("msg", "Product Added Successfully");
		else
			request.setAttribute("msg", "Product Could Not Be Added");
	}
	if(op.equals("Update Product"))
	{
		PreparedStatement ps = con.prepareStatement("update	product"+
		" set pname = ?, price = ? where pid = ?");
		ps.setString(1, pname);
		ps.setDouble(2, price);
		ps.setInt(3, pid);
		int x = ps.executeUpdate();
		if(x>0)
			request.setAttribute("msg", "Product Updated Successfully");
		else
			request.setAttribute("msg", "Product Could Not Be Updated");
	}
	if(op.equals("Update Product Details"))
	{
		PreparedStatement ps = con.prepareStatement("update	product"+
		" set pname = ?, price = ? where pid = ?");
		ps.setString(1, pname);
		ps.setDouble(2, price);
		ps.setInt(3, pid);
		int x = ps.executeUpdate();
		if(x>0)
			request.setAttribute("msg", "Product Updated Successfully");
		else
			request.setAttribute("msg", "Product Could Not Be Updated");
	}
	if(op.equals("Delete Product"))
	{
		PreparedStatement ps = con.prepareStatement("delete from product"+
		" where pid = ?");
		ps.setInt(1, pid);
		int x = ps.executeUpdate();
		if(x>0)
			request.setAttribute("msg", "Product Deleted Successfully");
		else
			request.setAttribute("msg", "Product Could Not Be Deleted");
		
		%>
		<jsp:forward page="getproduct.jsp"></jsp:forward>
		<%
	}
}
catch(SQLException e)
{
	out.print("Error in sql statement");
}

%>
<jsp:forward page="amdproduct.jsp"></jsp:forward>
</body>
</html>


