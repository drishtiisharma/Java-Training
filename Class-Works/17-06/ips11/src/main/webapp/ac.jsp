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
</font>
<form action="SessionServlet">
<br>
AC List<select name="s1">
<option value="ac1">AC1</option>
<option value="ac2">AC2</option>
<option value="ac3">AC3</option>
<option value="ac4">AC4</option>
</select>
Price<select name="s2">
<option value="10000">10000</option>
<option value="20000">20000</option>
<option value="30000">30000</option>
<option value="40000">40000</option>
</select>

<br><br><br>
Add To Cart<input type="submit" value="addac" name="b1"><br>
<a href="Logout.jsp"><font color="red" size="8">Logout</font></a><br><br>

<%@include file="footer.jsp" %></body>
</form>
</html>