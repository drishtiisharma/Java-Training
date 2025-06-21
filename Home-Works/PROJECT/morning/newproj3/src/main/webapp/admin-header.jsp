<%@ page import="com.pojo.UserInfo" %>
<%
    String uri = request.getRequestURI();
    String pageName = uri.substring(uri.lastIndexOf("/") + 1);

    HttpSession currentSession = request.getSession(false);
    UserInfo user = null;
    boolean loggedIn = false;
    boolean isAdmin = false;

    if (currentSession != null) {
        user = (UserInfo) currentSession.getAttribute("loggedInUser");
        loggedIn = (user != null);
        isAdmin = loggedIn && "Admin".equalsIgnoreCase(user.getRole());
    }
%>

<style>
    .top-search-bar {
        background-color: #3d5d50;
        padding: 10px 0;
    }
    .search-box {
        max-width: 900px;
        background: white;
        border-radius: 30px;
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        padding: 5px 10px;
    }
    .search-box select,
    .search-box input {
        border: none;
        background: transparent;
        outline: none;
    }
    .search-box button {
        background-color: #343a40;
        border: none;
        color: white;
        border-radius: 20px;
        padding: 5px 15px;
    }
    .main-nav {
        background-color: #3d5d50;
    }
    .main-nav .nav-link {
        color: white !important;
    }
    .main-nav .nav-link:hover {
        color: #ffc107 !important;
    }
</style>

<!-- Top Search Bar -->
<div class="top-search-bar">
    <div class="container d-flex justify-content-between align-items-center flex-wrap gap-3">
        <a class="navbar-brand text-white fs-3" href="index.jsp">Furni<span class="text-warning">.</span></a>

        <form action="search.jsp" method="get" class="search-box d-flex align-items-center w-75">
            <select name="category" class="form-select me-2" style="max-width: 130px;">
                <option value="all">All</option>
                <option value="sofa">Sofas</option>
                <option value="chair">Chairs</option>
                <option value="table">Tables</option>
                <option value="bed">Beds</option>
            </select>
            <input type="text" name="query" class="form-control me-2" placeholder="Search for products...">
            <button type="submit" class="btn">Search</button>
        </form>

        <!-- User Dropdown -->
        <ul class="navbar-nav d-flex flex-row gap-3">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-white" href="#" id="userDropdown" role="button"
                   data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="images/user.svg" alt="User">
                </a>
                <ul class="dropdown-menu" aria-labelledby="userDropdown">
                    <% if (loggedIn) { %>
                        <li><span class="dropdown-item-text">Welcome, <strong><%= user.getUsername() %></strong></span></li>
                        <li><hr class="dropdown-divider"></li>
                        <% if (isAdmin) { %>
                            <li><a class="dropdown-item" href="admin.jsp">Admin Panel</a></li>
                            <li><a class="dropdown-item" href="addProduct.jsp">Add Product</a></li>
                            <li><a class="dropdown-item" href="manageUsers.jsp">Manage Users</a></li>
                        <% } else { %>
                            <li><a class="dropdown-item" href="customerHome.jsp">My Profile</a></li>
                        <% } %>
                        <li><a class="dropdown-item" href="logout.jsp">Logout</a></li>
                    <% } else { %>
                        <li><a class="dropdown-item" href="login.jsp">Login</a></li>
                        <li><a class="dropdown-item" href="registration.jsp">Register</a></li>
                    <% } %>
                </ul>
            </li>
            <li><a class="nav-link text-white" href="cart.jsp"><img src="images/cart.svg" alt="Cart"></a></li>
        </ul>
    </div>
</div>

<!-- Navigation Menu -->
<nav class="navbar navbar-expand-md main-nav">
    <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navMain" aria-controls="navMain"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navMain">
            <ul class="navbar-nav mx-auto mb-2 mb-md-0">
              
                
                    <li class="nav-item"><a class="nav-link" href="product.jsp">Manage Products</a></li>
                     <li class="nav-item"><a class="nav-link" href="customer.jsp">customers</a></li>
                     <li class="nav-item"><a class="nav-link" href="Manage_orders.jsp">Manage orders</a></li>
                     <li class="nav-item"><a class="nav-link" href="admin_categories.jsp">categories</a></li>
               
            </ul>
        </div>
    </div>
</nav>
