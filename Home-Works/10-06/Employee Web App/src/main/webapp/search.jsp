<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Records</title>

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
}
table{
text-align: justify;
}
</style>




</head>
<div class="header">
<body>
<h1>IPS Academy</h1>
<p>Institute of Engineering & Science, Indore(MP)</p><br>
<h3>Search Records</h3>
</div>
<br>

<br>
<div class ="container">
<form action="getemployee.jsp" method="post">
<table width="500" cellpadding="10">

<tr>
<td>Employee ID</td>
<td> <input type="number" name="empid"><br><br></td>
</tr>

</table>
<center>
<input type="submit" value="Search Record" name="b1"><br><br><br>
</center>
</form>
<a href="home.jsp">Go Back To Home Page</a>
<br><br><br><br>
<br><br>
</div>
<div class ="footer">
<address>
IPS Academy, Institute of Engineering & Science, Knowledge Village, Rajendra Nagar A.B. Road, Indore-452012
</address>
</div>
</body>
</html>