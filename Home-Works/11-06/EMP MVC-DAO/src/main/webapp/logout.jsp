<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout Page</title>

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
    text-align: center;
    color: #1452e3;
    font-weight: bolder;
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
    color: darkblue;
    font-weight: bold;
    text-align: center;
}
</style>

</head>

<body>
<div class="header">
<h1>IPS Academy</h1>
<p style="font-size:20px">Institute of Engineering & Science, Indore(MP)</p><br>
<h2>Logout Page</h2>
</div>

<div class="container">
<br><br>
<h2>Bye User!<br><br>Thanks for Visiting!</h2><br><br><br>

<a href="login.jsp">Login Again?</a>
</div>

<br><br>

<div class="footer">
<address>
IPS Academy, Institute of Engineering & Science, Knowledge Village, Rajendra Nagar A.B. Road, Indore-452012
</address>
</div>
</body>
</html>