<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Records</title>
</head>

<body style="color:blue;text-align:center; background-color:#dfe3a3">
<center>
<h1>IPS Academy</h1>
<p style="font-size:20px">Institute of Engineering & Science, Indore(MP)
<h3>Employee Records</h3>
<hr><br>
<table width="500" cellpadding="10" border="4" bordercolor="black" bgcolor= "pink"> 

<tr>
<th>Sno.</th>
<th>Employee ID.</th>
<th>Employee Name</th>
<th>Salary</th>
<th>Designation</th>
<th>Department</th>
</tr>

<%
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
}
catch(ClassNotFoundException c){
	out.println("Error in Loading Driver");
	
}

try{
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ips?user=root&password=root");
	PreparedStatement ps=con.prepareStatement("select * from employee");
	ResultSet rs=ps.executeQuery();
	int i=1;
	while(rs.next()){
		%>
		<tr>
		<td><%=i %></td>
		<td><%=rs.getInt("empid")%></td>
		<td><%=rs.getString("empname")%></td>
		<td><%=rs.getDouble("salary") %></td>
		<td><%=rs.getString("designation")%></td>
		<td><%=rs.getString("department")%></td>
		</tr>
		<%
		i++;
	}
}
catch(SQLException se){
	request.setAttribute("msg", "Records Could Not be Retrieved");
	se.printStackTrace();
}
%>

</table>
<br><br>
<a href="home.jsp">Go Back to Home Page</a>
<br><br><hr>

<address>
IPS Academy, Institute of Engineering & Science, Knowledge Village, Rajendra Nagar A.B. Road, Indore-452012
</address>
</center>
</body>
</html>