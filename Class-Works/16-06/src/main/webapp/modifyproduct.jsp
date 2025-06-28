<!DOCTYPE html>
<%@page import="com.ips.pojo.Product"%>
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
<title>Modify Product</title>
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
            <h5 class="card-title text-center">Modify Product Page</h5>
           
            <%
            String msg = (String)request.getAttribute("msg");
            if(msg!=null)
            	out.print(msg);
            
            Product pd = (Product)request.getAttribute("product");
            if(pd!=null)
            {
            %>
           
           
            <form class="form-signin" action="AMDProductServlet" method="post">
              <div class="form-label-group">
                <input type="text" id="inputEmail" class="form-control" placeholder="Produt ID" name="pid" value="<%=pd.getPid()%>" required autofocus>
                <label for="inputEmail">Produt ID</label>
              </div>

              <div class="form-label-group">
                <input type="text" id="inputEmail" class="form-control" placeholder="Produt Name" name="pname" value="<%=pd.getPname()%>" required autofocus>
                <label for="inputEmail">Produt Name</label>
              </div>
              
              <div class="form-label-group">
                <input type="text" id="inputEmail" class="form-control" placeholder="Produt Price" name="price" value="<%=pd.getPrice()%>" required autofocus>
                <label for="inputEmail">Produt Price</label>
              </div>

              
              
              <input class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" value="Update Product Detail" name="b1">
           
              <hr class="my-4">
              <br>
              <%
            }
            %>
              <a href="home.jsp">Back TO Product Home Page</a>
              <br>
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