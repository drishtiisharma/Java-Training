<!DOCTYPE html>
<html lang="en">
<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<title>Registration</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">	
<!-- bootstrap css -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<!-- style css -->
<link rel="stylesheet" type="text/css" href="css/style.css">
<!-- Responsive-->
<link rel="stylesheet" href="css/responsive.css">
<!-- fevicon -->
<link rel="icon" href="images/fevicon.png" type="image/gif" />
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
<!-- Tweaks for older IEs-->
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<!-- owl stylesheets --> 
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesoeet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">

</head>
<body>
	<%@include file="header.jsp" %>
  <div class="login_section">
     <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">New User Registration</h5>
           
            <%
            String msg = (String)request.getAttribute("msg");
            if(msg!=null)
            	out.print(msg);
            %>
           
           
            <form class="form-signin" action="AddNewUserSevlet" method="post">
              <div class="form-label-group">
                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="username" required autofocus>
                <label for="inputEmail">Email address</label>
              </div>

              <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required minlength="4" maxlength="16">
                <label for="inputPassword">Password</label>
              </div>
              <div class="form-label-group">
                <input type="text" id="inputPassword" class="form-control" placeholder="Contact No" name="fname" required minlength="4" maxlength="16">
                <label for="inputPassword">First Name</label>
              </div>

              <div class="form-label-group">
                <input type="text" id="inputPassword" class="form-control" placeholder="Contact No" name="lname" required minlength="4" maxlength="16">
                <label for="inputPassword">Last Name</label>
              </div>

              <div class="form-label-group">
                <input type="text" id="inputPassword" class="form-control" placeholder="Contact No" name="contact" required minlength="4" maxlength="16">
                <label for="inputPassword">Contact No</label>
              </div>

              <input class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" value="Register">
              <hr class="my-4">
              </form>
          </div>
        </div>
      </div>
    </div>
  </div>
    </div>
  </div>
  <!-- login section end-->

<%@include file="footer.jsp" %>
</body>
</html>