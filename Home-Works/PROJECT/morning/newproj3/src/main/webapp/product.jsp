<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.pojo.Product, com.daoimpl.ProductDaoImpl" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Products</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* [Previous CSS styles remain exactly the same] */
        .error-message {
            color: #dc3545;
            text-align: center;
            margin: 20px 0;
        }
    </style>
</head>
<body>

<%@ include file="admin-header.jsp" %>

<%-- Show success/error messages --%>
<%
String msg = (String) session.getAttribute("msg");
if (msg != null) {
%>
  <div class="message success-message"><%= msg %></div>
<%
  session.removeAttribute("msg");
}

String error = (String) request.getAttribute("error");
if (error != null) {
%>
  <div class="error-message"><%= error %></div>
<%
}
%>

<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2>Manage Products</h2>
        <a href="addproduct.jsp" class="btn btn-outline-dark">Add Product</a>
    </div>

    <%
    try {
        ProductDaoImpl dao = new ProductDaoImpl();
        List<Product> products = dao.getAllProducts();
        
        if (products.isEmpty()) {
    %>
        <div class="alert alert-info">No products found.</div>
    <%
        } else {
    %>
    <table class="table table-bordered cart-table">
        <thead class="table-header-row">
            <tr>
                <th>ID</th>
                <th>Product</th>
                <th>Category</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            for (Product p : products) {
        %>
            <tr>
                <td><%= p.getPid() %></td>
                <td>
                    <img src="images/<%= p.getImageUrl() != null ? p.getImageUrl() : "default-product.png" %>" 
                         class="product-img" alt="<%= p.getPname() %>">
                    <div><strong><%= p.getPname() %></strong></div>
                </td>
                <td><%= p.getCategoryName() != null ? p.getCategoryName() : "Category ID: " + p.getCid() %></td>
                <td>₹<%= String.format("%.2f", p.getPrice()) %></td>
                <td>
                    <div class="quantity-box">
                        <input type="text" value="<%= p.getQuantity() %>" class="form-control quantity-input" readonly>
                    </div>
                </td>
                <td>
                    <a href="editProduct.jsp?pid=<%= p.getPid() %>" class="btn btn-link edit-btn">Edit</a>
                    <form action="DeleteProductServlet" method="post" style="display: inline;">
                        <input type="hidden" name="pid" value="<%= p.getPid() %>">
                        <button type="submit" class="btn btn-link remove-btn">Delete</button>
                    </form>
                </td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
        }
    } catch (Exception e) {
        request.setAttribute("error", "Failed to load products. Please try again later.");
    }
    %>
</div>

<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>