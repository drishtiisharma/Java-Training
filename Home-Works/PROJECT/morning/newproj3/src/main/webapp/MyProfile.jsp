<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.pojo.Customer" %>
<%
    UserInfo customer = (UserInfo) request.getAttribute("customer");
    if (customer == null) {
        customer = (UserInfo) session.getAttribute("loggedInUser");
        if (customer == null) {
            response.sendRedirect("login.jsp?reason=null_user");
            return;
        }
    }
    String profilePic = customer.getProfilePicture() != null ? customer.getProfilePicture() : "default-profile.jpg";
%>
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
  <title>Furni. Shopping Portal</title>
  
  <style>
    body {
      margin: 0;
      padding: 0;
    }
    .profile-container {
      background-color: #f8f9fa;
      min-height: 100vh;
      padding-top: 0;
    }
    .profile-card {
      border-radius: 10px;
      box-shadow: 0 4px 12px rgba(0,0,0,0.1);
      border: none;
      margin-top: 20px;
    }
    .profile-header {
      background-color: #3d5d50;
      color: white;
      padding: 2rem;
      border-radius: 10px 10px 0 0;
      text-align: center;
    }
    .profile-avatar {
      width: 120px;
      height: 120px;
      border-radius: 50%;
      border: 5px solid white;
      object-fit: cover;
      margin-bottom: 1rem;
    }
    .profile-body {
      padding: 2rem;
      background-color: white;
      border-radius: 0 0 10px 10px;
    }
    .detail-item {
      margin-bottom: 1.5rem;
      padding-bottom: 1rem;
      border-bottom: 1px solid #eee;
    }
    .detail-label {
      font-weight: 600;
      color: #3d5d50;
      display: block;
      margin-bottom: 5px;
    }
    .detail-value {
      color: #555;
    }
    .btn-furni-primary {
      background-color: #3d5d50;
      color: white;
      border: none;
      padding: 10px 25px;
      border-radius: 30px;
      transition: all 0.3s;
    }
    .btn-furni-primary:hover {
      background-color: #2d453a;
      color: white;
      transform: translateY(-2px);
    }
    .btn-furni-outline {
      border: 1px solid #3d5d50;
      color: #3d5d50;
      padding: 10px 25px;
      border-radius: 30px;
      transition: all 0.3s;
    }
    .btn-furni-outline:hover {
      background-color: #f0f0f0;
    }
    .navbar {
      margin-bottom: 0 !important;
    }
  </style>
</head>
<body>
  <div class="profile-container">
    <%@include file="customerheader.jsp" %>
    
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-8">
          <div class="profile-card mb-5">
            <div class="profile-header">
              <img src="images/<%= profilePic %>" 
                   alt="Profile" class="profile-avatar"
                   onerror="this.onerror=null;this.src='images/default-profile.jpg'">
              <h2><%= customer.getUsername() %></h2>
            </div>
            
            <div class="profile-body">
              <div class="detail-item">
                <span class="detail-label"><i class="fas fa-user me-2"></i>Username</span>
                <p class="detail-value"><%= customer.getUsername() %></p>
              </div>
              
              <div class="detail-item">
                <span class="detail-label"><i class="fas fa-lock me-2"></i>Password</span>
                <p class="detail-value"><%= customer.getPassword() != null ? customer.getPassword() : "Not set" %></p>
              </div>
              
              <div class="detail-item">
                <span class="detail-label"><i class="fas fa-envelope me-2"></i>Email Address</span>
                <p class="detail-value"><%= customer.getEmail() != null && !customer.getEmail().isEmpty() ? customer.getEmail() : "Not provided" %></p>
              </div>
              
              <div class="detail-item">
                <span class="detail-label"><i class="fas fa-phone me-2"></i>Phone Number</span>
                <p class="detail-value">
                  <% 
                    // Handle potential null or empty phone
                    String phone = customer.getPhone();
                    if (phone == null || phone.trim().isEmpty() || "0".equals(phone)) {
                      out.print("Not provided");
                    } else {
                      phone = phone.replaceAll("[^0-9]", ""); // Remove non-numeric characters
                      if (phone.length() == 10) {
                        out.print("(" + phone.substring(0, 3) + ") " 
                                + phone.substring(3, 6) + "-" 
                                + phone.substring(6));
                      } else {
                        out.print(phone); // Raw number if not 10 digits
                      }
                    }
                  %>
                </p>
              </div>
              
              <div class="detail-item">
                <span class="detail-label"><i class="fas fa-map-marker-alt me-2"></i>Delivery Address</span>
                <p class="detail-value"><%= customer.getAddress() != null && !customer.getAddress().isEmpty() ? customer.getAddress() : "Not provided" %></p>
              </div>
              
              <div class="d-flex flex-wrap justify-content-between mt-4">
                <a href="EditProfile.jsp" class="btn btn-furni-primary mb-2">
                  <i class="fas fa-edit me-2"></i>Edit Profile
                </a>
                
                <a href="MyOrders.jsp" class="btn btn-furni-outline mb-2">
                  <i class="fas fa-shopping-bag me-2"></i>My Orders
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<br><br><br><br>
  <script src="js/bootstrap.bundle.min.js"></script>
  <script src="js/tiny-slider.js"></script>
  <script src="js/custom.js"></script>
</body>
<%@include file="footer.jsp" %>
</html>