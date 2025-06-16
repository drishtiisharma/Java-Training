<!DOCTYPE html>
<%@page import="com.ips.pojo.Product"%>
<%@page import="java.util.List"%>
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
<title>List Of Product</title>
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
            <h5 class="card-title text-center">Product List Page</h5>
           <br>

			<table class="table table-bordered">
				<tr>
					<th>S.No.</th>
					<th>Product-Id</th>
					<th>Product-Name</th>
					<th>Product-Price</th>
				</tr>
				
				<%
				List<Product>lst = (List<Product>)request.getAttribute("allproducts");
				for(int i=0; i<lst.size(); i++)
				{
					Product pd = lst.get(i);
					%>
						<tr>
							<td><%=i+1%></td>
							<td><%=pd.getPid()%></td>
							<td><%=pd.getPname()%></td>
							<td><%=pd.getPrice()%></td>
						</tr>
					<% 
				}
				
				
				%>
			</table>
			<br>
			<br>
              <a href="home.jsp">Back TO Product Home Page</a>
              <br>
			<br>
           
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