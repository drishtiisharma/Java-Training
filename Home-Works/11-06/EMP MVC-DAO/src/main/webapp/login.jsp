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
}
table{
text-align: center;
color: black;
font-weight: bold;
}
</style>

</head>

<body>
<div class ="header">
<h1>IPS Academy</h1>
<p style="font-size:20px">Institute of Engineering & Science, Indore(MP)<br><br>
<h2>Log In</h2>
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
<form action="checkuser.jsp" method="post">
<table width="500" cellpadding="10">

<tr>
<td>Employee ID</td>
<td> <input type="number" name="empid" required><br><br></td>
</tr>

<tr>
<td>Password</td> 
<td><input type="password" name="password" required><br><br></td>
</tr>

<tr>
<div class ="button">
<td><br><input type="submit" value=" Log In "></td></div>
<td><a href="registration.jsp">Register Here</a></td>
</tr>
</table>
</form>

<br><br>
</div>
<div class= "footer">
<address>
IPS Academy, Institute of Engineering & Science, Knowledge Village, Rajendra Nagar A.B. Road, Indore-452012
</address>
</div>

</body>
</html>