<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
<%@include file="header.jsp" %>
<form action="LoginServlet">

Username<input type="text" name="t1"><br><br>
Password<input type="password" name="t2"><br><br>

<input type="submit" name = "b1" value="Login">
<input type="reset">
<a href="reg.jsp"><input type="button" value="New User Registration"></a>
<%@include file="footer.jsp" %>
</form>
</body>
</html>