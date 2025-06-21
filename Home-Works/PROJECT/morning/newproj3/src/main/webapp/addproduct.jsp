<!-- addproduct.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<%@ include file="admin-header.jsp" %>
<div class="container mt-5">
    <h2 class="text-center mb-4">Add New Product</h2>

    <%-- Show success/failure message --%>
    <%
        String msg = (String) request.getAttribute("msg");
        if (msg != null) {
    %>
        <div class="alert alert-info text-center"><%= msg %></div>
    <%
        }
    %>

    <form action="AddProductServlet" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label>Product Name:</label>
            <input type="text" name="pname" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Description:</label>
            <textarea name="description" class="form-control" required></textarea>
        </div>
        <div class="mb-3">
            <label>Price:</label>
            <input type="number" step="0.01" name="price" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Quantity:</label>
            <input type="number" name="quantity" class="form-control" required>
        </div>
        <div class="mb-3">
            <label>Category ID:</label>
            <input type="number" name="cid" class="form-control" required>
        </div>
        
        <div class="mb-3">
            <label>Product Image:</label>
            <input type="file" name="productImage" accept="image/*" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-success">Add Product</button>
    </form>
</div>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
