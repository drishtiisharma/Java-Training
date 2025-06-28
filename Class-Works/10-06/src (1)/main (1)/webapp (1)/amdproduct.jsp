<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>IPS Academy</h1>
<p>place for IT & CS Students.</p>
<br>
<hr>
<br>
<h1>AMD Product Page</h1>
<br>
<%
String msg = (String)request.getAttribute("msg");
if(msg!=null)
{
	out.println(msg);
}

%>
<br>
<form action="saveproduct.jsp">
Product - Id<input type="text" name="pid"><br><br>
Product - Name<input type="text" name="pname"><br><br>
Product - Price<input type="text" name="price"><br><br>
<input type="submit" value="Add Product" name="b1">
<input type="submit" value="Update Product" name="b1">
<input type="submit" value="Delete Product" name="b1">
<br>
<br>

<a href="home.jsp">Back To Product Home Page</a>
</form>
<br>
<br>
<hr>
<address>
IPS Academty ,Indore
</address>
</center>
</body>
</html>