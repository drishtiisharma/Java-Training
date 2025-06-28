<%@page import="com.ips.daoimpl.UserInfoDaoImpl"%>
<%@page import="com.ips.pojo.UserInfo"%>
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
UserInfo us=new UserInfo();

try{
	us.setEmpid(Integer.parseInt(request.getParameter("empid")));
}
catch(NumberFormatException n){
	out.println("Invalid Input");
}

us.setEmpname(request.getParameter("empname"));
us.setPassword(request.getParameter("password"));


try{
	us.setSalary(Double.parseDouble(request.getParameter("salary")));
}
catch(NumberFormatException n){
	out.println("Invalid Input");
}

us.setDesignation(request.getParameter("designation"));
us.setDepartment(request.getParameter("department"));

String op=request.getParameter("b1");
UserInfoDaoImpl udi=new UserInfoDaoImpl();

if(op.equals("Add Employee")){
	boolean b=udi.addUser(us);
	if(b==true){
		request.setAttribute("msg", "New Employee Added Successfully!");
	}
	else{
		request.setAttribute("msg", "Failed to Add Employee!");
	}
}

if(op.equals("Update Employee")){
	boolean b=udi.updateUser(us);
	if(b==true){
		request.setAttribute("msg", "Employee Updated Successfully!");
	}
	else{
		request.setAttribute("msg", "Failed to Update Employee!");
	}
}

if(op.equals("Delete Employee")){
	boolean b=udi.deleteUser(us);
	if(b==true){
		request.setAttribute("msg", "Employee Deleted Successfully!");
	}
	else{
		request.setAttribute("msg", "Failed to Delete Employee!");
	}
}

%>

<jsp:forward page="amd.jsp"></jsp:forward>
</body>
</html>