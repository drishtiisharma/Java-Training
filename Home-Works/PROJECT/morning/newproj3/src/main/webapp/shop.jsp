<%@ page import="java.util.List" %>
<%@ page import="com.pojo.Product" %>
<%@ page import="com.daoimpl.ProductDaoImpl" %>
<%@page import="com.daoimpl.ProductDaoImpl"%>
<%@page import="com.pojo.Product"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
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
		<title>Furni Shop </title>
	</head>

	<body>

	
 <%@include file="customerheader.jsp" %>

		<!-- Start Hero Section -->
<div class="hero" style="background-color: #3b5d50; padding: 40px 0; overflow: hidden;">
  <div class="container">
    <div class="row align-items-center">
      <div class="col-lg-6 text-white">
        <h1 class="display-5 mb-3">Explore Our Premium Collection</h1>
        <p class="lead">Discover handcrafted furniture that elevates your lifestyle.</p>
      </div>
      <div class="col-lg-6">
        <div class="carousel-wrapper">
          <div class="carousel-track">
            <a href="product1.jsp"><img src="images/product-3.png" alt="Product 1"></a>
            <a href="product2.jsp"><img src="images/product-1.png" alt="Product 2"></a>
            <a href="product3.jsp"><img src="images/product-2.png" alt="Product 3"></a>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Hero Section -->

<style>
  .carousel-wrapper {
    width: 105%;
    height: 280px; /* 👈 fixed height */
    overflow: hidden;
    border-radius: 8px;
  }

  .carousel-track {
    display: flex;
    width: 250%;
    animation: slide 12s infinite;
  }

  .carousel-track a {
    flex: 0 0 100%;
    height: 100%;
  }

  .carousel-track img {
    width: 20%;
    height: 30%;
    object-fit: cover;
    display: block;
    align:right;
  }

  @keyframes slide {
    0%, 20% { transform: translateX(0%); }
    25%, 45% { transform: translateX(-100%); }
    50%, 70% { transform: translateX(-200%); }
    75%, 100% { transform: translateX(0%); }
  }

  @media (max-width: 768px) {
    .carousel-wrapper {
      height: 180px;
    }
    .hero h1 {
      font-size: 1.6rem;
    }
    .hero p {
      font-size: 0.7rem;
    }
  }
</style>


<div class="container mt-4">
    <div class="row">
        <div class="col text-center">
            <form action="filterServlet" method="get" class="d-inline">
                <input type="hidden" name="category" value="All">
                <button type="submit" class="btn btn-outline-dark me-2">All</button>
            </form>
            <form action="filterServlet" method="get" class="d-inline">
                <input type="hidden" name="category" value="Chairs">
                <button type="submit" class="btn btn-outline-dark me-2">Chairs</button>
            </form>
            <form action="filterServlet" method="get" class="d-inline">
                <input type="hidden" name="category" value="Tables">
                <button type="submit" class="btn btn-outline-dark me-2">Tables</button>
            </form>
            <form action="filterServlet" method="get" class="d-inline">
                <input type="hidden" name="category" value="Sofas">
                <button type="submit" class="btn btn-outline-dark me-2">Sofas</button>
            </form>
            <form action="filterServlet" method="get" class="d-inline">
                <input type="hidden" name="category" value="Decor">
                <button type="submit" class="btn btn-outline-dark">Decor</button>
            </form>
        </div>
    </div>
</div>

<!-- Sort Options -->
<div class="container mt-4 mb-2">
    <div class="row justify-content-end">
        <div class="col-md-3">
            <form action="sortServlet" method="get">
                <select name="sortBy" class="form-select" onchange="this.form.submit()">
                    <option disabled selected>Sort by</option>
                    <option value="price-asc">Price: Low to High</option>
                    <option value="price-desc">Price: High to Low</option>
                    <option value="newest">Newest</option>
                </select>
            </form>
        </div>
    </div>
</div>


<!-- Static Product Section -->
<%@ include file="staticf.jsp" %>

	      	</div>
	    </div>
	</div>

    <%@ include file="footer.jsp" %>
		<script src="js/bootstrap.bundle.min.js"></script>
		<script src="js/tiny-slider.js"></script>
		<script src="js/custom.js"></script>
	</body>

</html>
"