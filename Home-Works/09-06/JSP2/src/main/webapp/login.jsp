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

<br><hr><br>
<h3>Log In</h3>
<br>

<form action="checkuser.jsp" method="post">
<table width="500" cellpadding="10">

<tr>
<td>Computer Code</td>
<td> <input type="number" name="compcode"><br><br></td>
</tr>

<tr>
<td>Password</td> 
<td><input type="password" name="password"><br><br></td>
</tr>

<tr>
<td><input type="submit" value="Log In"></td>

<td><a href="registration.jsp">Register Here</a></td>
</tr>
</table>
</form>

<br><br><hr>

<address>
IPS Academy, Institute of Engineering & Science, Knowledge Village, Rajendra Nagar A.B. Road, Indore-452012
</address>
</center>
</body>
</html>