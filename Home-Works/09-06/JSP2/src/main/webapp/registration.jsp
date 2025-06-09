<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>

<body style="color:blue;text-align:center; background-color:#dfe3a3">
<center>
<h1>IPS Academy</h1>
<p style="font-size:20px">Institute of Engineering & Science, Indore(MP)
<h2><b><i>Knowledge,Skills and Values</i></b></h2></p>
<br><hr><br>
<h3>New User Registration</h3>
<br>
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null){
	out.println(msg);
}

%>
<form action="savenewuser.jsp" method="post">
Computer Code <input type="number" name="compcode"><br>
Password <input type="password" name="password"><br>
<input type="submit" value="Register">
<a href="login.jsp">Go back to Login Page</a>
</form>

<br><br><hr>

<address>
IPS Academy, Institute of Engineering & Science, Knowledge Village, Rajendra Nagar A.B. Road, Indore-452012
</address>
</center>
</body>
</html>