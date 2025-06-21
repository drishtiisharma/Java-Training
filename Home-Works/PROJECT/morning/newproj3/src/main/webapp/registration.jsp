<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="customerheader.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Furni Registration</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <style>
    .register-box {
      width: 400px;
      padding: 30px;
      margin: 50px auto;
      background: #ffffff;
      border-radius: 12px;
      box-shadow: 5px 5px 8px rgba(0,0,0,0.1);
    }
    .register-box label {
      font-weight: bold;
      color: #3b5d50;
    }
    .register-box input[type="text"],
    .register-box input[type="password"] {
      width: 100%;
      padding: 8px;
      margin-bottom: 10px;
      border-radius: 6px;
      border: 1px solid #ccc;
    }
    .register-box input[type="submit"] {
      width: 100%;
      padding: 10px;
      background-color: #3b5d50;
      color: white;
      border: none;
      border-radius: 6px;
      font-size: 15px;
    }
    .register-box input[type="submit"]:hover {
      background-color: #2f4a3e;
    }
    .login-link {
      display: block;
      text-align: center;
      margin-top: 10px;
      color: #3b5d50;
      text-decoration: none;
    }
    .login-link:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>

<%-- Show success or error messages --%>
<center>
  <%
    String msg = (String) session.getAttribute("msg");
    if (msg != null) {
  %>
      <p style="color: green;"><%= msg %></p>
  <%
      session.removeAttribute("msg");
    }

    String error = (String) request.getAttribute("error");
    if (error != null) {
  %>
      <p style="color: red;"><%= error %></p>
  <%
    }
  %>
</center>

<div class="register-box">
  <h2 style="color: #3b5d50; text-align:center;">Register</h2>

  <form action="RegistrationServlet" method="post">
    <label for="username">Username *</label>
    <input type="text" name="username" required>

    <label for="password">Password *</label>
    <input type="password" name="password" required>

    <label for="email">Email *</label>
    <input type="text" name="email" required>

    <label for="phone">Phone</label>
    <input type="text" name="phone">

    <label for="address">Address</label>
    <input type="text" name="address">

    <input type="submit" value="Register">
  </form>

  <a href="login.jsp" class="login-link">Already have an account? Login here</a>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>
