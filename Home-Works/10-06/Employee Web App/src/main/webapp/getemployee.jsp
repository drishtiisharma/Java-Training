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
</head>

<body style="color:blue;text-align:center; background-color:#dfe3a3">
<center>
<h1>IPS Academy</h1>
<p style="font-size:20px">Institute of Engineering & Science, Indore(MP)
<h3>Retrieved Record</h3>
<hr><br>

<%
String msg = (String)request.getAttribute("msg");
if(msg!=null)
{
	out.println(msg);
}
%>

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
		
		Employee ID <input type="numeric" name="empid" value="<%=rs.getInt("empid")%>"><br><br>
		
		Employee Name <input type="text" name="empname" value="<%=rs.getString("empname")%>"><br><br>
		
		Salary <input type="numeric" name="salary" value="<%=rs.getInt("salary")%>"><br><br>
		
		Designation <input type="text" name="desgination" value="<%=rs.getString("designation")%>"><br><br>
		
		Department <input type="text" name="department" value="<%=rs.getString("department")%>"><br><br>
		

		

		
		</form>
		
	<%
	}
	else{
		out.println("Record Not Found");
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
<br><br><hr>






<address>
IPS Academy, Institute of Engineering & Science, Knowledge Village, Rajendra Nagar A.B. Road, Indore-452012
</address>
</center>
</body>
</html>