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
String empid = request.getParameter("empid");
String empname = request.getParameter("empname");
String password=request.getParameter("password");
String salary=request.getParameter("salary");
String designation=request.getParameter("designation");
String department=request.getParameter("department");

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
}
catch(ClassNotFoundException e){
	out.println("error in loading drivers");
}

try{
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ips?user=root&password=root");
	
	PreparedStatement ps=con.prepareStatement("select * from employee where empid=?");
	ps.setInt(1, Integer.parseInt(empid));
	
	ResultSet rs=ps.executeQuery();
	if (rs.next()==true){
		%>
		<form action="saveproduct.jsp" method="post">
		<table>
		<tr>
		<td>Employee ID</td>
		<td><input type="number" name="empid" value="<%=rs.getInt("empid")%>" readonly><br><br></td>
		</tr>
		
		<tr>
		<td>Employee Name </td>
		<td><input type="text" name="empname" value="<%=rs.getString("empname")%>" readonly><br><br></td>
		</tr>
		
		<tr>
		<td>	Salary</td>
		<td><input type="number" name="salary" value="<%=rs.getInt("salary")%>" readonly><br><br></td>
		</tr>
		
		<tr>
		<td>	Designation</td>
		<td><input type="text" name="desgination" value="<%=rs.getString("designation")%>" readonly><br><br></td>
		</tr>
		
		<tr>
		<td>	Department</td>
		<td><input type="text" name="department" value="<%=rs.getString("department")%>" readonly><br><br></td>
		</tr>
		
		</table>
		</form>
		
	<%
	}
	else{
		out.println("Record Not Found!");
	}
	
}
catch(SQLException s){
	request.setAttribute("msg", "No such User Registered");
	s.printStackTrace();
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