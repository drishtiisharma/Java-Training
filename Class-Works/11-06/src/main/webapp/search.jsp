<%@page import="com.ips.pojo.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.ips.daoimpl.ProductDaoImpl"%>
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
<h1>Search Product Page</h1>
<br>
<br>
<form action="getproduct.jsp">
<h2>Select P-Id To Search Detail : </h2>
<select name="s1">
<%
ProductDaoImpl daoimpl = new ProductDaoImpl();
List<Product>lst = daoimpl.getAllProduct();		

int i=0;
	while(i<lst.size())
	{
		Product pd = lst.get(i);
		%>
		<option value="<%=pd.getPid()%>"><%=pd.getPid()%></option>
		<%
		i++;
	}
	%>
</select>
	<br>
<input type="submit" value="Search Product Detail" name="b1">
<br>
<br>
<a href="home.jsp">Back To Product Home Page</a>
</form>
<br>
<br>
<hr>
<address>
IPS Academty ,Indore
</address>
</center>
</body>
</html>