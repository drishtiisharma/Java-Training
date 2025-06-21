<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.pojo.UserInfo" %>
<%
    UserInfo userInfo = (UserInfo) request.getAttribute("user");
    if (userInfo == null) {
        userInfo = (UserInfo) session.getAttribute("loggedInUser");
        if (userInfo == null) {
            response.sendRedirect("login.jsp?reason=null_user");
            return;
        }
    }
    
    String phoneDisplay = userInfo.getPhone() != null ? userInfo.getPhone() : "";
    String profilePic = userInfo.getProfilePicture() != null ? userInfo.getProfilePicture() : "default-profile.jpg";
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
  <title>Edit Profile | Furni</title>
  
  <style>
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
    .form-control:focus {
      border-color: #3d5d50;
      box-shadow: 0 0 0 0.25rem rgba(61, 93, 80, 0.25);
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
    .alert-success {
      background-color: #d4edda;
      border-color: #c3e6cb;
      color: #155724;
    }
    .alert-danger {
      background-color: #f8d7da;
      border-color: #f5c6cb;
      color: #721c24;
    }
    .profile-pic-container {
      text-align: center;
      margin-bottom: 20px;
    }
    .profile-pic {
      width: 150px;
      height: 150px;
      border-radius: 50%;
      object-fit: cover;
      border: 5px solid #3d5d50;
    }
    .profile-pic-upload {
      display: none;
    }
    .profile-pic-label {
      cursor: pointer;
      display: inline-block;
      margin-top: 10px;
    }
    .profile-pic-label:hover {
      text-decoration: underline;
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
              <h2><i class="fas fa-user-edit me-2"></i>Edit Profile</h2>
            </div>
            
            <div class="profile-body p-4">
              <%-- Success/Error Messages --%>
              <% if (request.getAttribute("success") != null) { %>
                <div class="alert alert-success mb-4">
                  <%= request.getAttribute("success") %>
                </div>
              <% } %>
              <% if (request.getAttribute("error") != null) { %>
                <div class="alert alert-danger mb-4">
                  <%= request.getAttribute("error") %>
                </div>
              <% } %>
              
              <form action="EditProfileServlet" method="POST" enctype="multipart/form-data">
                <div class="profile-pic-container">
                  <img src="profile-pics/<%= profilePic %>" alt="Profile Picture" class="profile-pic" id="profilePicPreview">
                  <input type="file" id="profilePicUpload" name="profilePic" class="profile-pic-upload" accept="image/*">
                  <label for="profilePicUpload" class="profile-pic-label">Change Profile Picture</label>
                </div>
                
                <div class="mb-3">
                  <label for="username" class="form-label">Username</label>
                  <input type="text" class="form-control" id="username" name="username" 
                         value="<%= userInfo.getUsername() %>" required>
                </div>
                
                <div class="mb-3">
                  <label for="password" class="form-label">Password</label>
                  <input type="password" class="form-control" id="password" name="password" 
                         value="<%= userInfo.getPassword() %>" required>
                </div>
                
                <div class="mb-3">
                  <label for="email" class="form-label">Email Address</label>
                  <input type="email" class="form-control" id="email" 
                         value="<%= userInfo.getEmail() %>" readonly>
                </div>
                
                <div class="mb-3">
                  <label for="phone" class="form-label">Phone Number</label>
                  <input type="tel" class="form-control" id="phone" name="phone" 
                         value="<%= phoneDisplay %>" 
                         pattern="[0-9+() -]*" 
                         title="Enter a valid phone number (digits, +, -, () or spaces)">
                </div>
                
                <div class="mb-4">
                  <label for="address" class="form-label">Delivery Address</label>
                  <textarea class="form-control" id="address" name="address" rows="3"><%= userInfo.getAddress() != null ? userInfo.getAddress() : "" %></textarea>
                </div>
                
                <div class="d-flex justify-content-between">
                  <button type="submit" class="btn btn-furni-primary">
                    <i class="fas fa-save me-2"></i>Save Changes
                  </button>
                  <a href="MyProfile.jsp" class="btn btn-outline-secondary">
                    <i class="fas fa-times me-2"></i>Cancel
                  </a>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script src="js/bootstrap.bundle.min.js"></script>
  <script src="js/tiny-slider.js"></script>
  <script src="js/custom.js"></script>
  <script>
    // Basic phone number formatting
    document.getElementById('phone').addEventListener('input', function(e) {
      this.value = this.value.replace(/[^0-9+() -]/g, '');
    });

    // Profile picture preview
    document.getElementById('profilePicUpload').addEventListener('change', function(e) {
      const file = this.files[0];
      if (file) {
        const reader = new FileReader();
        reader.onload = function(e) {
          document.getElementById('profilePicPreview').src = e.target.result;
        }
        reader.readAsDataURL(file);
      }
    });
  </script>
</body>
<br><br><br>
<%@include file="footer.jsp" %>
</html>