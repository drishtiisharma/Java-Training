<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.pojo.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product Details</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>

    <%@ include file="customerheader.jsp" %>

    <div class="container mt-5">
        <%
            Product product = (Product) request.getAttribute("product");

            if (product == null) {
        %>
            <div class="alert alert-danger">Product not found!</div>
        <%
            } else {
        %>
        <div class="row">
            <div class="col-md-6">
                <img src="images/<%= product.getImage_url() %>" class="img-fluid rounded border" alt="Product Image">
            </div>
            <div class="col-md-6">
                <h2 class="mb-3"><%= product.getPname() %></h2>
                <p><strong>Category:</strong> <%= product.getCategoryName() %></p>
                <p><strong>Price:</strong> ₹<%= String.format("%.2f", product.getPrice()) %></p>
                <p><strong>Available Quantity:</strong> <%= product.getQuantity() %></p>
                <p><strong>Description:</strong></p>
                <p><%= product.getDescription() %></p>

                <form action="CartServlet" method="post" class="mt-4">
                    <input type="hidden" name="pid" value="<%= product.getPid() %>">
                    <button type="submit" name="action" value="add" class="btn btn-primary me-2">
                        <i class="fas fa-cart-plus"></i> Add to Cart
                    </button>
                    <button type="submit" name="action" value="buy" class="btn btn-success">
                        <i class="fas fa-bolt"></i> Buy Now
                    </button>
                </form>
            </div>
        </div>
        <%
            }
        %>
    </div>

    <%@ include file="footer.jsp" %>

    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>