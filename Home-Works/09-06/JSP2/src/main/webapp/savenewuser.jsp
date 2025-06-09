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
	
	PreparedStatement ps=con.prepareStatement("insert into login (compcode,password) values(?,?)");
	ps.setInt(1, Integer.parseInt(compcode));
	ps.setString(2, password);
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
}

%>
<jsp:forward page="registration.jsp"></jsp:forward>
</body>
</html>