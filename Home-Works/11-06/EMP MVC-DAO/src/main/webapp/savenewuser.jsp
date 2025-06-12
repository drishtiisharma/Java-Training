<%@page import="com.ips.daoimpl.UserInfoDaoImpl"%>
<%@page import="com.ips.pojo.UserInfo"%>
<%@page import="com.ips.dao.UserInfoDao"%>
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
UserInfo u=new UserInfo();
u.setEmpid(Integer.parseInt(request.getParameter("empid")));
u.setEmpname(request.getParameter("empname"));
u.setPassword((request.getParameter("password")));
u.setSalary(Double.parseDouble(request.getParameter("salary")));
u.setDesignation(request.getParameter("designation"));
u.setDepartment(request.getParameter("department"));

UserInfoDaoImpl daoimpl=new UserInfoDaoImpl();
boolean isAdded=daoimpl.registerUser(u);
if(isAdded==true){
	request.setAttribute("msg", "User Registered Successfully!");
}
else{
	request.setAttribute("msg", "User Could Not Be Registered!");
}
	

%>
<jsp:forward page="registration.jsp"></jsp:forward>

</body>
</html>