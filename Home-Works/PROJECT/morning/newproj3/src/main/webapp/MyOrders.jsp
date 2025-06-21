<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.pojo.Order, java.util.List, java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Untree.co">
    <link rel="shortcut icon" href="favicon.png">
    <meta name="description" content="View your order history" />
    <meta name="keywords" content="furniture, orders, purchase history" />
    
    <!-- Bootstrap CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link href="css/tiny-slider.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    
    <style>
        .status-badge {
            padding: 5px 10px;
            border-radius: 20px;
            font-size: 0.85rem;
            font-weight: 500;
        }
        .status-pending { background-color: #fff3cd; color: #856404; }
        .status-processing { background-color: #cce5ff; color: #004085; }
        .status-shipped { background-color: #d4edda; color: #155724; }
        .status-delivered { background-color: #d1ecf1; color: #0c5460; }
    </style>
    <title>My Orders | Furni</title>
</head>
<body>

    <%@include file="customerheader.jsp" %>
    
    <div class="untree_co-section">
        <div class="container">
            <div class="d-flex justify-content-between align-items-center mb-4">
                <h2 class="mb-0">My Orders</h2>
                <a href="shop.jsp" class="btn btn-outline-primary">
                    <i class="fas fa-arrow-left me-2"></i>Continue Shopping
                </a>
            </div>
            
            <% if (request.getAttribute("orders") == null || ((List<Order>)request.getAttribute("orders")).isEmpty()) { %>
                <div class="alert alert-info">
                    <i class="fas fa-info-circle me-2"></i> You haven't placed any orders yet.
                </div>
            <% } else { %>
                <div class="table-responsive">
                    <table class="table table-hover align-middle">
                        <thead class="table-light">
                            <tr>
                                <th>Order #</th>
                                <th>Date</th>
                                <th>Total</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
                                List<Order> orders = (List<Order>) request.getAttribute("orders");
                                for (Order order : orders) {
                                    String statusClass = "";
                                    switch(order.getStatus().toLowerCase()) {
                                        case "pending": statusClass = "status-pending"; break;
                                        case "processing": statusClass = "status-processing"; break;
                                        case "shipped": statusClass = "status-shipped"; break;
                                        case "delivered": statusClass = "status-delivered"; break;
                                        default: statusClass = "status-pending";
                                    }
                            %>
                            <tr>
                                <td><strong>#<%= order.getOrderId() %></strong></td>
                                <td><%= dateFormat.format(order.getOrderDate()) %></td>
                                <td>$<%= String.format("%.2f", order.getTotalAmount()) %></td>
                                <td>
                                    <span class="status-badge <%= statusClass %>">
                                        <i class="fas 
                                            <% switch(order.getStatus().toLowerCase()) {
                                                case "pending": %> fa-clock <% break;
                                                case "processing": %> fa-cog <% break;
                                                case "shipped": %> fa-truck <% break;
                                                case "delivered": %> fa-check-circle <% break;
                                            } %>
                                        me-1"></i>
                                        <%= order.getStatus() %>
                                    </span>
                                </td>
                                <td>
                                    <a href="OrderDetailsServlet?orderId=<%= order.getOrderId() %>" 
                                       class="btn btn-sm btn-outline-primary">
                                        <i class="fas fa-eye me-1"></i> Details
                                    </a>
                                </td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            <% } %>
        </div>
    </div>

    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/tiny-slider.js"></script>
    <script src="js/custom.js"></script>
</body>
<%@include file="footer.jsp" %>
</html>