<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.pojo.CartItem, java.util.List" %>
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
  <title>Furni Order Summary</title>

  <style>
    .order-summary-container {
      padding: 40px 0;
      min-height: 60vh;
    }
    
    .order-header {
      text-align: center;
      margin-bottom: 30px;
      color: #3b5d50;
    }
    
    .thank-you-message {
      text-align: center;
      font-size: 1.2rem;
      margin-bottom: 30px;
      padding: 15px;
      background-color: #f8f9fa;
      border-radius: 5px;
    }
    
    .billing-card {
      border: none;
      box-shadow: 0 5px 15px rgba(0,0,0,0.05);
      margin-bottom: 30px;
    }
    
    .billing-card .card-header {
      background-color: #3b5d50;
      color: white;
      font-weight: bold;
    }
    
    .order-table {
      margin-top: 30px;
      box-shadow: 0 5px 15px rgba(0,0,0,0.05);
    }
    
    .order-table thead {
      background-color: #3b5d50;
      color: white;
    }
    
    .total-amount {
      font-size: 1.3rem;
      color: #3b5d50;
      font-weight: bold;
    }
    
    .continue-shopping {
      text-align: center;
      margin-top: 30px;
    }
    
    .btn-continue {
      background-color: #3b5d50;
      color: white;
      padding: 10px 30px;
    }
    
    .btn-continue:hover {
      background-color: #2f4a3e;
      color: white;
    }
  </style>
</head>

<body>
  <%@include file="customerheader.jsp" %>
  
  <div class="untree_co-section order-summary-container">
    <div class="container">
      <div class="order-header">
        <h2>Order Confirmation</h2>
        <p class="thank-you-message">
          Thank you for your purchase! Your order #${orderId} has been received.
        </p>
      </div>
      
      <!-- Billing Details Card -->
      <div class="card billing-card mb-4">
        <div class="card-header">
          <h4>Billing Information</h4>
        </div>
        <div class="card-body">
          <div class="row">
            <div class="col-md-6">
              <p><strong>Name:</strong> ${billingName}</p>
              <p><strong>Email:</strong> ${billingEmail}</p>
              <p><strong>Phone:</strong> ${billingPhone}</p>
            </div>
            <div class="col-md-6">
              <p><strong>Address:</strong></p>
              <p>${billingAddress}</p>
              <p><strong>Payment Method:</strong> ${paymentMethod}</p>
            </div>
          </div>
        </div>
      </div>

      <!-- Order Summary -->
      <h3 class="mb-3">Order Details</h3>
      <table class="table table-bordered order-table">
        <thead>
          <tr>
            <th>Product</th>
            <th>Quantity</th>
            <th>Unit Price</th>
            <th>Subtotal</th>
          </tr>
        </thead>
        <tbody>
          <% 
            List<CartItem> cartItems = (List<CartItem>) request.getAttribute("cartItems");
            double total = 0.0;
            if (cartItems != null) {
              for (CartItem item : cartItems) { 
                total += item.getPrice() * item.getQuantity();
          %>
          <tr>
            <td><%= item.getName() %></td>
            <td><%= item.getQuantity() %></td>
            <td>$<%= String.format("%.2f", item.getPrice()) %></td>
            <td>$<%= String.format("%.2f", item.getPrice() * item.getQuantity()) %></td>
          </tr>
          <% 
              }
            }
          %>
        </tbody>
        <tfoot>
          <tr>
            <td colspan="3" class="text-right"><strong>Total Amount</strong></td>
            <td class="total-amount">$<%= String.format("%.2f", total) %></td>
          </tr>
        </tfoot>
      </table>
      
      <div class="continue-shopping">
        <a href="index.jsp" class="btn btn-continue">
          <i class="fas fa-arrow-left"></i> Continue Shopping
        </a>
      </div>
    </div>
  </div>

  <%@include file="footer.jsp" %>

  <script src="js/bootstrap.bundle.min.js"></script>
  <script src="js/tiny-slider.js"></script>
  <script src="js/custom.js"></script>
</body>
</html>