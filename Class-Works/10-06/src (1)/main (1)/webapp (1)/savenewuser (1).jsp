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
	PreparedStatement ps = con.prepareStatement("insert into userinfo values(?,?)");
	ps.setString(1, username);
	ps.setString(2, password);
	int x = ps.executeUpdate();
	if(x>0)
		request.setAttribute("msg", "User Register Successfully");
	else
		request.setAttribute("msg", "User Could Not Be Register ");
		
}
catch(SQLException e)
{
	request.setAttribute("msg", "User Could Not Be Register ");
}

%>
<jsp:forward page="registration.jsp"></jsp:forward>
</body>
</html>


