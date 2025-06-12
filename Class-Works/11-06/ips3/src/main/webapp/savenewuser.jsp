
<%@page import="com.ips.daoimpl.UserInfoDaoImpl"%>
<%@page import="com.ips.pojo.UserInfo"%>
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
UserInfo u = new UserInfo();

u.setUsername(request.getParameter("username"));
u.setPassword(request.getParameter("password"));

UserInfoDaoImpl daoimpl = new UserInfoDaoImpl();
boolean isAdded = daoimpl.addNewUser(u);

	if(isAdded==true)
		request.setAttribute("msg", "User Register Successfully");
	else
		request.setAttribute("msg", "User Could Not Be Register ");
		

%>
<jsp:forward page="registration.jsp"></jsp:forward>
</body>
</html>


