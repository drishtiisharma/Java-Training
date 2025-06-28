<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<font color="blue" size="3">
Thanks
<%
String us = (String)session.getAttribute("user");
out.println(us+" for visiting our site....Fir Ana...!");
		session.invalidate();
%>
</font>


<a href="login.jsp">Click Here For Login Again</a><br><br>

<%@include file="footer.jsp" %></body>
</html>