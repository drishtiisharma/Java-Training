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
String empid = request.getParameter("empid");
String empname = request.getParameter("empname");
String password=request.getParameter("password");
String salary=request.getParameter("salary");
String designation=request.getParameter("designation");
String department=request.getParameter("department");

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
}
catch(ClassNotFoundException e){
	out.println("error in loading drivers");
}

try{
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ips?user=root&password=root");
	
	PreparedStatement ps=con.prepareStatement("select * from employee where empid=?");
	ps.setInt(1, Integer.parseInt(empid));
	
	ResultSet rs=ps.executeQuery();
	if (rs.next()==true){
		request.setAttribute("msg", "<div style='color: green; font-size:30px; text-align: center'>Welcome"+empname+" to IPS Academy!</div>");
		%>
		<jsp:forward page="home.jsp"></jsp:forward>
		<%
	}
	else{
		out.println("<div style='color: red; font-size: 30px;text-align:center'>Invalid EmployeeID/Password!</div>");
		%>
		<jsp:forward page="login.jsp"></jsp:forward>
		<%
	}
}
catch(SQLException s){
	request.setAttribute("msg", "No such User Registered");


}
%>
</body>
</html>