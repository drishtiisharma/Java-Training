<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Records</title>
</head>

<body style="color:blue;text-align:center; background-color:#dfe3a3">
<center>
<h1>IPS Academy</h1>
<p style="font-size:20px">Institute of Engineering & Science, Indore(MP)
<h3>Search Records</h3>
<hr><br>

<br>

<form action="getemployee.jsp" method="post">
<table width="500" cellpadding="10">

<tr>
<td>Employee ID</td>
<td> <input type="number" name="empid"><br><br></td>
</tr>

</table>
<input type="submit" value="Search Record" name="b1"><br><br><br>
<a href="home.jsp">Go Back To Home Page</a>
</form>
<br><br><br><br>
<br><br><hr>

<address>
IPS Academy, Institute of Engineering & Science, Knowledge Village, Rajendra Nagar A.B. Road, Indore-452012
</address>
</center>
</body>
</html>