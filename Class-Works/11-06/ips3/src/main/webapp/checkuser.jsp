
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
boolean isValid = daoimpl.checkUserCredential(u);


	if(isValid==true)
	{
		request.setAttribute("msg","<font color=green size=3>Welcome"+u.getUsername()+" To IPS Academy</font>");
		%>
		<jsp:forward page="home.jsp"></jsp:forward>
		<%
	}
	else
	{
		request.setAttribute("msg", "<font color=red size=3>Invalid Username / Password</font>");
		%>
		<jsp:forward page="login.jsp"></jsp:forward>
		<%
	}
%>
</body>
</html>