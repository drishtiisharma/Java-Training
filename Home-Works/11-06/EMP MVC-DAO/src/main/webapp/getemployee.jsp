<%@page import="com.ips.daoimpl.UserInfoDaoImpl"%>
<%@page import="com.ips.pojo.UserInfo"%>
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
<title>Retrieved Record</title>

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
    color: darkblue;
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
<p>Institute of Engineering & Science, Indore(MP)</p><br>
<h3>Retrieved Record</h3>
</div>

<%
String msg = (String)request.getAttribute("msg");
if(msg!=null)
{
	out.println(msg);
}
%>

<div class="container">
<br>

<%
int empid=0;
try{
	empid=Integer.parseInt(request.getParameter("s1"));
}
catch(NumberFormatException nf){
	
}

UserInfoDaoImpl uidi=new UserInfoDaoImpl();
UserInfo uf=uidi.searchUser(empid);

if(uf!=null){
	
		%>
		<form action="saveproduct.jsp" method="post">
		<table>
		<tr>
		<td>Employee ID</td>
		<td><input type="number" name="empid" value="<%=uf.getEmpid()%>" readonly><br><br></td>
		</tr>
		
		<tr>
		<td>Employee Name </td>
		<td><input type="text" name="empname" value="<%=uf.getEmpname()%>" readonly><br><br></td>
		</tr>
		
		<tr>
		<td>	Salary</td>
		<td><input type="number" name="salary" value="<%=uf.getSalary()%>" readonly><br><br></td>
		</tr>
		
		<tr>
		<td>	Designation</td>
		<td><input type="text" name="desgination" value="<%=uf.getDesignation()%>" readonly><br><br></td>
		</tr>
		
		<tr>
		<td>	Department</td>
		<td><input type="text" name="department" value="<%=uf.getDepartment()%>" readonly><br><br></td>
		</tr>
		
		</table>
		</form>
		
	<%
	}
	else{
		out.println("Record Not Found!");
	}

%>
<br>
<br>
<a href="home.jsp">Go Back To Home Page</a>
<br><br>



</div>

<div class="footer">
<address>
IPS Academy, Institute of Engineering & Science, Knowledge Village, Rajendra Nagar A.B. Road, Indore-452012
</address>
</div>
</body>
</html>