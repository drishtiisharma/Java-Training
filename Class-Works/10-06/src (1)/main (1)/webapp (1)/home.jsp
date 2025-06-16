<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>IPS Academy</h1>
<p>place for IT & CS Students.</p>
<br>
<hr>
<br>
<%
String msg = (String)request.getAttribute("msg");
if(msg!=null)
{
	out.println(msg);
}

%>

<br>
<h1>Product Home Page</h1>
<br>

<a href="amdproduct.jsp">Add / Update / Delete Product Details</a><br><br>
<a href="listofallproducts.jsp">List Of All Product </a><br><br>
<a href="search.jsp">Search Product</a><br><br>
<a href="logout.jsp">Logout</a><br><br>

<br>
<br>
<hr>
<address>
IPS Academty ,Indore
</address>
</center>
</body>
</html>