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
<h3>Modify Records</h3>
<hr><br>

<br>

<%
String msg=(String)request.getAttribute("msg");
if(msg!=null){
	out.println(msg);
}
%>

<form action="saveemployee.jsp" method="post">
<table width="500" cellpadding="10">

<tr>
<td>Employee ID</td>
<td><input type="number" name="empid"><br><br></td>
</tr>

<tr>
<td>Employee Name</td> 
<td><input type="text" name="empname"><br><br></td>
</tr>

<tr>
<td>Password</td> 
<td><input type="password" name="password"><br><br></td>
</tr>

<tr>
<td>Salary</td> 
<td><input type="numeric" name="salary"><br><br></td>
</tr>

<tr>
<td>Designation</td> 
<td><input type="text" name="designation"><br><br></td>
</tr>

<tr>
<td>Department</td> 
<td>
<select>
<option>--Select Department--</option>
<option>IT</option>
<option>Marketing</option>
<option>R&D</option>
<option>Finance</option>
<option>HR</option>
<option>Academic</option>
<option>Management</option>
</select>
</td>
</tr>
</table>
<br>
<input type="submit" value="Add Employee" name="b1">
<input type="submit" value="Update Employee" name="b1">
<input type="submit" value="Delete Employee" name="b1"><br><br>
<a href="home.jsp">Go back to Employee Home Page</a><br><br>
<a href="login.jsp">Go back to Login Page</a>

</form>

<br><br><hr>

<address>
IPS Academy, Institute of Engineering & Science, Knowledge Village, Rajendra Nagar A.B. Road, Indore-452012
</address>
</center>
</body>
</html>