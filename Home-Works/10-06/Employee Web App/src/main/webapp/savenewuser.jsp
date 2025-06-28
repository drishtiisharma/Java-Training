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
<title>Saving New User</title>
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
	
	PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
	ps.setInt(1, Integer.parseInt(empid));
	ps.setString(2, empname);
	ps.setString(3, password);
	ps.setDouble(4, Double.parseDouble(salary));
	ps.setString(5, designation);
	ps.setString(6, department);

	
	int x=ps.executeUpdate();
	if(x>0){
		request.setAttribute("msg", "User Registered Successfully!");
	}
	else{
		request.setAttribute("msg", "Failed to Register User");
	}
}
catch(SQLException s){
request.setAttribute("msg", "user could not be registered");
s.printStackTrace();
}
%>
<jsp:forward page="registration.jsp"></jsp:forward>

</body>
</html>