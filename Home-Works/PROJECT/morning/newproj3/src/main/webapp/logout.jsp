<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.pojo.UserInfo" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Logout</title>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/style.css">
</head>

<body>

  <%@ include file="customerheader.jsp" %>

  <div class="login_section">
    <div class="container">
      <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
          <div class="card card-signin my-5 shadow rounded-4">
            <div class="card-body">
              <h3 class="card-title text-center text-success">Logout Successful</h3>
              <h4 class="text-center">

              <%
                  if(user != null){
                      String username = user.getUsername();
                      out.print("Goodbye <span class='text-primary fw-bold'>" + username + "</span>, Thanks for visiting!");
                      session.invalidate();
                  } else {
                      out.print("Session already expired or not logged in.");
                  }
              %>

              </h4>
              <div class="text-center mt-4">
                <a href="login.jsp" class="btn btn-primary">Click Here To Login Again</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <%@ include file="footer.jsp" %>

</body>

</html>
