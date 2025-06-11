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
}
table{
text-align: justify;
}
</style>

</head>

<body>
<div class ="header">
<h1>IPS Academy</h1>
<p>Institute of Engineering & Science, Indore(MP)</p><br>
<h2> Employee Home Page</h2>
</div>
<br>
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null){
	out.println(msg);
}
%>
<br>

<div class="container">
<table>
<tr>
<td><li><a href="amd.jsp">Add Employee/ Update Employee/ Delete Employee</a></li><br></td>
</tr>

<tr>
<td><li><a href="listofallemployees.jsp">List of All Employees</a></li><br></td>
</tr>


<tr>
<td><li><a href="search.jsp">Search Employee Record</a></li><br></td>
</tr>


<tr>
<td><li><a href="logout.jsp">Logout</a></li><br></td>
</tr>

</table>

<br>
<a href="login.jsp">Go Back to Login Page</a>
<br><br><hr>
</div>

<div class ="footer">
<address>
IPS Academy, Institute of Engineering & Science, Knowledge Village, Rajendra Nagar A.B. Road, Indore-452012
</address>
</div>

</body>
</html>