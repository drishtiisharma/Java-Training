<%@page import="java.sql.ResultSet"%>
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
String compcode = request.getParameter("compcode");
String password=request.getParameter("password");

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
}
catch(ClassNotFoundException e){
	out.println("error in loading drivers");
}

try{
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ips?user=root&password=root");
	
	PreparedStatement ps=con.prepareStatement("select * from login where compcode=? and password=?");
	ps.setInt(1, Integer.parseInt(compcode));
	ps.setString(2, password);
	
	ResultSet rs=ps.executeQuery();
	if (rs.next()==true){
		out.println("<div style='color: blue; font-size:30px; text-align: center'>Welcome to IPS Academy</div>");
	}
	else{
		out.println("<div style='color: red; font-size: 30px;text-align:center'>Invalid ComputerCode/Password!</div>");
	}
}
catch(SQLException s){
	request.setAttribute("msg", "No such User Registered");
//	out.println("user could not be registered");

}
%>
</body>
</html>