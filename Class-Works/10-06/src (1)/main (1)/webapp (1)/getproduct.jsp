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
<%
String msg = (String)request.getAttribute("msg");
if(msg!=null)
{
	out.println(msg);
}

%>
<br>

<%
int pid=0;
try
{
	pid = Integer.parseInt(request.getParameter("pid"));	
	
}
catch(NumberFormatException e)
{
	
}

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
	con.prepareStatement("select * from product where pid = ?");
	ps.setInt(1, pid);
	ResultSet rs = ps.executeQuery();
	
	if(rs.next()==true)
	{
	%>
	<form action="saveproduct.jsp">
	Product - Id<input type="text" name="pid" value="<%=rs.getInt("pid")%>"><br><br>
	Product - Name<input type="text" name="pname" value="<%=rs.getString("pname")%>"><br><br>
	Product - Price<input type="text" name="price" value="<%=rs.getDouble("price")%>"><br><br>
	<input type="submit" value="Update Product Details" name="b1">
	<%
	}
	else
	{
		out.print("<h1>Record Not Found</h1>");
	}
	 %>
	<br>
	<br>
	
	<a href="home.jsp">Back To Product Home Page</a>
	</form>
		<%
	
}	
catch(SQLException e)
{
	request.setAttribute("msg", "User Could Not Be Register ");
}

%>
</table>
<br>
<br>


<br>
<br>
<hr>
<address>
IPS Academty ,Indore
</address>
</center>
</body>
</html>