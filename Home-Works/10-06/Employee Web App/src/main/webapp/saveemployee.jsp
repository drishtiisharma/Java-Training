<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
double salary=0;
String empid = request.getParameter("empid");
String empname = request.getParameter("empname");
String password=request.getParameter("password");
try{
	salary=Double.parseDouble(request.getParameter("salary"));
}
catch(NumberFormatException n){
	out.println("Invalid Input");
	
}
String designation=request.getParameter("designation");
String department=request.getParameter("department");

String op=request.getParameter("b1");
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
}
catch(ClassNotFoundException e){
	out.println("error in loading drivers");
}

try{
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ips?user=root&password=root");
	
	if(op.equals("Add Employee")){
		PreparedStatement ps= con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
		ps.setInt(1, Integer.parseInt(empid));
		ps.setString(2, empname);
		ps.setString(3, password);
		ps.setDouble(4, salary);
		ps.setString(5, designation);
		ps.setString(6, department);
		
		int x=ps.executeUpdate();
		if(x>0){
			request.setAttribute("msg", "New Record Added Successfully!");
		}
		else{
			request.setAttribute("msg", "New Record Could Not Be Added");
		}
	}
	
	if(op.equals("Update Employee")){
		PreparedStatement ps= con.prepareStatement("update employee set empname=?, password=?, salary=?, designation=?, department=?, where empid=?");
		ps.setString(1, empname);
		ps.setString(2, password);
		ps.setDouble(3, salary);
		ps.setString(4, designation);
		ps.setString(5, department);
		ps.setInt(6, Integer.parseInt(empid));
		int x=ps.executeUpdate();
		if(x>0){
			request.setAttribute("msg", "Record Updated Successfully!");
		}
		else{
			request.setAttribute("msg", "Record Could Not Be Updated");
		}
	}
	
	if(op.equals("Delete Employee")){
		PreparedStatement ps= con.prepareStatement("delete from employee where empid=?");
		ps.setInt(1, Integer.parseInt(empid));
		int x=ps.executeUpdate();
		if(x>0){
			request.setAttribute("msg", "Record Deleted Successfully!");
		}
		else{
			request.setAttribute("msg", "Record Could Not Be Deleted");
		}
	}
	
}
catch(SQLException s){
	request.setAttribute("msg", "No such User Registered");
	s.printStackTrace();


}
%>
<jsp:forward page="amd.jsp"></jsp:forward>
</body>
</html>