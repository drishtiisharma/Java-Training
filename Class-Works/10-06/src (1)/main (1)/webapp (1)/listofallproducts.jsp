<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
}
catch(ClassNotFoundException e)
{
	out.println("Error in loading drivers");
}

try
{
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ips25java?user=root&password=root");
	PreparedStatement ps = 
		con.prepareStatement("select * from product");
	ResultSet rs = ps.executeQuery();
	int i=1;
	while(rs.next())
	{
		%>
		<tr>
			<td><%=i%></td>
			<td><%=rs.getInt("pid")%></td>
			<td><%=rs.getString("pname")%></td>
			<td><%=rs.getDouble("price")%></td>
		</tr>
		<%
		i++;
	}
		


		
}
catch(SQLException e)
{
	request.setAttribute("msg", "User Could Not Be Register ");
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