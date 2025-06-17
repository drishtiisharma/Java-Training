
<%@page import="com.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<font color="blue" size="3">
</font>
<table border="1">
<tr>
<th>S.No.</th>
<th>Product Id</th>
<th>Price</th>
</tr>
<%
//ArrayList tv =(ArrayList) session.getAttribute("tvlist");
//ArrayList ac =(ArrayList) session.getAttribute("aclist");

ArrayList al = (ArrayList)session.getAttribute("products");
if(al!=null)
{
	for(int i=0; i<al.size(); i++)
	{
	Product p = (Product)al.get(i);
	%>
	<tr>
		<td><%= i+1 %></td>
		<td><%=p.getPid() %></td>
		<td><%=p.getPrice() %></td>
		<td><button type="submit" value="<%=p.getPid()%>">Delete</button></td>
	</tr>
	<%
		
	}
}
%>
</table>
<br><br><br>
<a href="itemindex.jsp"><input type="button" value="Back To Index Page"></a><br><br>

<%@include file="footer.jsp" %></body>
</html>