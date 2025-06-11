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
    flex: 1;
    text-align: center;
    padding: 20px;
}
table {
    border-collapse: collapse;
    width: 60%;
    margin: auto;
    background-color: #f2f2f2;
    color: black;
}
th, td {
    border: 2px solid #555;
    padding: 10px;
    text-align: center;
}
th {
    background-color: #9ec9e4;
}
caption {
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 10px;
}
a {
    text-decoration: none;
    color: darkblue;
    font-weight: bold;
}
</style>
</head>

<body>
<div class="header">
    <h1>IPS Academy</h1>
    <p style="font-size:20px">Institute of Engineering & Science, Indore(MP)</p><br>
    <h3 style="color: darkblue;">Employee Records</h3>
</div>

<div class="content">
    <table>
        <caption>Employee Records</caption>
        <tr>
            <th>Sno.</th>
            <th>Employee ID</th>
            <th>Employee Name</th>
            <th>Salary</th>
            <th>Designation</th>
            <th>Department</th>
        </tr>

        <%
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException c) {
            out.println("Error in Loading Driver");
        }

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ips?user=root&password=root");
            PreparedStatement ps = con.prepareStatement("select * from employee");
            ResultSet rs = ps.executeQuery();
            int i = 1;
            while(rs.next()) {
        %>
        <tr>
            <td><%= i %></td>
            <td><%= rs.getInt("empid") %></td>
            <td><%= rs.getString("empname") %></td>
            <td><%= rs.getDouble("salary") %></td>
            <td><%= rs.getString("designation") %></td>
            <td><%= rs.getString("department") %></td>
        </tr>
        <%
                i++;
            }
        } catch(SQLException se) {
            request.setAttribute("msg", "Records Could Not be Retrieved");
            se.printStackTrace();
        }
        %>
    </table>
    <br><br>
    <a href="home.jsp">Go Back to Home Page</a>
    <br><br>
</div>

<div class="footer">
    <address>
        IPS Academy, Institute of Engineering & Science, Knowledge Village, Rajendra Nagar A.B. Road, Indore-452012
    </address>
</div>
</body>
</html>
