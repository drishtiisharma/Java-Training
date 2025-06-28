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
    background: linear-gradient(135deg, #949984, #8b9c76);
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
    background-color: #4d5557;
    padding: 20px;
    text-align: center;
    width: 100%;
    color: white;
}
.header {
    border-bottom: 1px solid #aaa;
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
    color: purple;
    font-weight: bold;
    text-align: center;
}
table{
text-align: justify;
color: black;
font-weight: bold;
}
</style>


</head>

<body style="color:blue;text-align:center; background-color:#dfe3a3">

<div class ="header">
<h1>IPS Academy</h1>
<p style="font-size:20px">Institute of Engineering & Science, Indore(MP)</p><br>
<h3>New User Registration</h3>
</div>
<br>
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null){
	out.println(msg);
}
%>
<br>
<div class ="container">
<form action="savenewuser.jsp" method="post">
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
<select name= "department" required>
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


<tr>
<td><br><br><input type="submit" value=" Register "></td>

<td><br><br><a href="login.jsp">Go back to Login Page</a></td>
</tr>
</table>
</form>

<br><br>
</div>

<div class ="footer">
<address>
IPS Academy, Institute of Engineering & Science, Knowledge Village, Rajendra Nagar A.B. Road, Indore-452012
</address>
</div>

</body>
</html>