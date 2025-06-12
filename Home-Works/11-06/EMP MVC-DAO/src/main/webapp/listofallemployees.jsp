<%@page import="com.ips.pojo.UserInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.ips.daoimpl.UserInfoDaoImpl"%>

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
    background: linear-gradient(135deg, #949984, #8b9c76);
    color: blue;
    font-family: sans-serif;
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
    color: darkblue;
    font-weight: bold;
}
</style>
</head>

<body>
<div class="header">
    <h1>IPS Academy</h1>
    <p style="font-size:20px">Institute of Engineering & Science, Indore(MP)</p><br>
    <h2>Employee Records</h2>
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
        UserInfoDaoImpl uid=new UserInfoDaoImpl();
        List<UserInfo>lst=uid.getAllEmployee();
        
 
            int i = 1;
        
            while(i<lst.size()) {
            	UserInfo ue=lst.get(i);
        %>
        <tr>
            <td><%= i %></td>
            <td><%= ue.getEmpid() %></td>
            <td><%= ue.getEmpname() %></td>
            <td><%= ue.getSalary() %></td>
            <td><%= ue.getDesignation() %></td>
            <td><%= ue.getDepartment() %></td>
        </tr>
        <%
                i++;
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
