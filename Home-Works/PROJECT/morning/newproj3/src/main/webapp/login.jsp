<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="author" content="Untree.co">
  <link rel="shortcut icon" href="favicon.png">

  <meta name="description" content="" />
  <meta name="keywords" content="bootstrap, bootstrap4" />

  <!-- Bootstrap CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
  <link href="css/tiny-slider.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <title>Furni Login</title>

  <style>
    .login-container {
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 60vh;
      padding: 20px;
    }
    
    .login-box {
      width: 100%;
      max-width: 400px;
      padding: 30px; 
      background: #ffffff;
      border-radius: 12px;
      box-shadow: 5px 5px 8px rgba(0,0,0,0.1);
    }
    
    .login-box h1 {
      text-align: center;
      margin-bottom: 20px;
      color: #3b5d50;
    }
    
    .login-box label {
      display: block;
      margin-bottom: 4px;
      font-weight: bold;
      color: #3b5d50;
    }
    
    .login-box input[type="text"],
    .login-box input[type="password"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      border: 1px solid #ccc;
      border-radius: 6px;
      box-sizing: border-box;
    }
    
    .login-box input[type="submit"] {
      width: 100%;
      padding: 10px;
      background: #3b5d50;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      font-size: 16px;
      font-weight: bold;
      margin-top: 10px;
    }
    
    .login-box input[type="submit"]:hover {
      background: #2f4a3e;
    }
    
    .login-box .register-link {
      display: block;
      text-align: center;
      margin-top: 15px;
      color: #3b5d50;
      text-decoration: none;
    }
    
    .login-box .register-link:hover {
      text-decoration: underline;
    }
    
    .message-container {
      text-align: center;
      margin: 20px 0;
    }
    
    .error-message {
      color: red;
      text-align: center;
      margin-top: 15px;
    }
  </style>
</head>

<body>
  <%@include file="customerheader.jsp" %>
  
  <div class="message-container">
    <%-- Show success message from registration --%>
    <%
      String msg = (String) session.getAttribute("msg");
      if (msg != null) {
    %>
      <p style="color: green;"><%= msg %></p>
    <%
      session.removeAttribute("msg");
      }
    %>

    <%-- Show error message from login failure --%>
    <%
      String error = (String) request.getAttribute("error");
      if (error != null) {
    %>
      <p style="color: red;"><%= error %></p>
    <%
      }
    %>
  </div>
  
  <div class="login-container">
    <div class="login-box">
      <h1>Login</h1>
      <form method="post" action="LoginServlet">
        <label for="credential">Username or Email:</label>
        <input type="text" id="credential" name="credential" required>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        
        <input type="submit" value="Login">
        
        <a href="registration.jsp" class="register-link">Don't have an account? Register here</a>
      </form>

      <% if (request.getAttribute("error") != null) { %>
        <p class="error-message"><%= request.getAttribute("error") %></p>
      <% } %>
    </div>
  </div>

  <%@include file="footer.jsp" %> 
</body>
</html>