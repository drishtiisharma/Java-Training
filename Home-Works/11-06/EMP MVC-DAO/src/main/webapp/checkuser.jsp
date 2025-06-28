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
<title>Login Handler</title>
</head>
<body>
<%
String empid = request.getParameter("empid");
String password = request.getParameter("password");

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e) {
    out.println("Error in loading drivers");
}

try {
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ips?user=root&password=root");

    PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE empid = ?");
    ps.setInt(1, Integer.parseInt(empid));

    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
        String dbPassword = rs.getString("password");
        String empname = rs.getString("empname");

        if (dbPassword.equals(password)) {
            request.setAttribute("msg", "<div style='color: #6800ad; font-size:40px; text-align: center'><marquee scrollamount= 7>Welcome " + empname + " to IPS Academy!</marquee></div>");
            %>
            <jsp:forward page="home.jsp"></jsp:forward>
            <%
        } else {
            request.setAttribute("msg", "<div style='color: red; font-size:40px; text-align: center'>Incorrect Password!</div>");
            %>
            <jsp:forward page="login.jsp"></jsp:forward>
            <%
        }
    } else {
        request.setAttribute("msg", "<div style='color: red; font-size:30px; text-align: center'>No such User Registered!</div>");
        %>
        <jsp:forward page="login.jsp"></jsp:forward>
        <%
    }
} catch (SQLException s) {
    request.setAttribute("msg", "<div style='color: red; font-size:30px; text-align: center'>Database Error Occurred!</div>");
    %>
    <jsp:forward page="login.jsp"></jsp:forward>
    <%
}
%>
</body>
</html>
