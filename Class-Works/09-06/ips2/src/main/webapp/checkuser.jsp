<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
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
<%
String username = request.getParameter("username");
String password = request.getParameter("password");

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
	con.prepareStatement("select * from userinfo"+ 
			" where username = ? and password = ?");
	ps.setString(1, username);
	ps.setString(2, password);
	ResultSet rs = ps.executeQuery();
	if(rs.next()==true)
		out.println("<font color=green size=5>Welcome "+username+" To IPS Academy</font>");
	else
		out.println("<font color=red size=5>Invalid Username/Password</font>");


		
}
catch(SQLException e)
{
	request.setAttribute("msg", "User Could Not Be Register ");
}



%>
</body>
</html>