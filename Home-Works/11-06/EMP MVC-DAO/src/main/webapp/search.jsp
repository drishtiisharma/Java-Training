<%@page import="java.util.List"%>
<%@page import="com.ips.daoimpl.UserInfoDaoImpl"%>
<%@page import="com.ips.pojo.UserInfo"%>
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
table {
    text-align: justify;
    color: black;
    font-weight: bold;
}
td{
padding: 0px 10px;
}
</style>
</head>
<body>
<div class="header">
    <h1>IPS Academy</h1>
    <p>Institute of Engineering & Science, Indore(MP)</p><br>
    <h2>Search Records</h2>
</div>
<br><br>
<div class="container">
<form action="getemployee.jsp" method="post">
    <table>
        <tr>
            <td>Employee ID </td>
        
       
            <td>
                <select name="s1">
                    <option> Select Employee ID</option>
                    <%
                        UserInfoDaoImpl uidi = new UserInfoDaoImpl();
                        List<UserInfo> lst = uidi.getAllEmployee();
                        int i = 0;
                        while(i < lst.size()) {
                            UserInfo ui = lst.get(i);
                    %>
                        <option value="<%= ui.getEmpid() %>"><%= ui.getEmpid() %></option>
                    <%
                            i++;
                        }
                    %>
                </select>
            </td>
        </tr>
    </table>
    <center>
        <br>
        <input type="submit" value="Search Record" name="b1"><br><br><br>
    </center>
</form>
<a href="home.jsp">Go Back To Home Page</a>
<br><br><br><br><br><br>
</div>
<div class="footer">
    <address>
        IPS Academy, Institute of Engineering & Science, Knowledge Village, Rajendra Nagar A.B. Road, Indore-452012
    </address>
</div>
</body>
</html>
