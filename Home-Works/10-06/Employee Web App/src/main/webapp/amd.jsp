<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<style>
* {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}
html, body {
    height: 100%;
    display: flex;
    flex-direction: column;
    background-color: #dfe3a3;
    color: blue;
    font-family: sans-serif;
}
.container {
    flex: 1;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}
.header, .footer {
    background-color: #d1e0e0;
    padding: 20px;
    text-align: center;
    width: 100%;
}
.header {
    border-top: 1px solid #aaa;
}
.footer {
    border-top: 1px solid #aaa;
    font-style: italic;
    margin-top: auto;
}
.content {
    text-align: center;
    padding: 20px;
}
a {
    color: darkblue;
    font-weight: bold;
    text-align: center;
    align: center;
}
table{
text-align: justify;
}
</style>


</head>

<body>

<div class="header">
<h1>IPS Academy</h1>
<p style="font-size:20px">Institute of Engineering & Science, Indore(MP)</p><br>
<h3>Modify Records</h3>
</div>

<%
String msg=(String)request.getAttribute("msg");
if(msg!=null){
	out.println(msg);
}
%>
<div class="container">
<form action="saveemployee.jsp" method="post">
<br>
<table width="500" cellpadding="10">

<tr>
<td>Employee ID</td>
<td><input type="number" name="empid" required><br><br></td>
</tr>

<tr>
<td>Employee Name</td> 
<td><input type="text" name="empname" required><br><br></td>
</tr>

<tr>
<td>Password</td> 
<td><input type="password" name="password" required><br><br></td>
</tr>

<tr>
<td>Salary</td> 
<td><input type="numeric" name="salary" required><br><br></td>
</tr>

<tr>
<td>Designation</td> 
<td><input type="text" name="designation" required><br><br></td>
</tr>

<tr>
<td>Department</td> 
<td>
<select name="department" required>
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

<center>
<input type="submit" value="Add Employee" name="b1">
<input type="submit" value="Update Employee" name="b1">
<input type="submit" value="Delete Employee" name="b1"><br><br>
</center>
<br><br>
<center>
<a href="home.jsp">Go back to Employee Home Page</a><br><br>
<a href="login.jsp">Go back to Login Page</a>
</center>

</form>
<br
</div>
<div class="footer">
<address>
IPS Academy, Institute of Engineering & Science, Knowledge Village, Rajendra Nagar A.B. Road, Indore-452012
</address>
</div>
</body>
</html>