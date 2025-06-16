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
<br>
<table border="2" bordercolor="blue" bgcolor="yellow">
<caption>Product Data</caption>
	<tr>
		<th>S.No.</th>
		<th>Product-Id</th>
		<th>Product-Name</th>
		<th>Product-Price</th>
	</tr>

<%

ProductDaoImpl daoimpl = new ProductDaoImpl();
List<Product>lst = daoimpl.getAllProduct();		
int i=1;
	while(i<lst.size())
	{
		Product pd = lst.get(i);
		%>
		<tr>
			<td><%=i%></td>
			<td><%=pd.getPid()%></td>
			<td><%=pd.getPname()%></td>
			<td><%=pd.getPrice()%></td>
		</tr>
		<%
		i++;
	}
		


		
%>
</table>
<br>
<br>
<a href="home.jsp">Back To Product Home Page</a><br><br>

<br>
<br>
<hr>
<address>
IPS Academty ,Indore
</address>
</center>
</body>
</html>