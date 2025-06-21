<%@ page import="com.pojo.UserInfo" %>
<%
    String uri = request.getRequestURI();
    String pageName = uri.substring(uri.lastIndexOf("/") + 1);

    HttpSession currentSession = request.getSession(false); // Don't create new session
    UserInfo user = null;
    boolean loggedIn = false;

    if (currentSession != null) {
        user = (UserInfo) currentSession.getAttribute("loggedInUser"); // Must match the attribute set in LoginServlet
        loggedIn = (user != null);
    }
%>

<!-- Embedded CSS for top search bar -->
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

    .search-box select {
        padding-left: 10px;
    }

    .search-box input::placeholder {
        color: #999;
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
    
    .navbar-toggler-icon {
        background-image: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 30 30'%3e%3cpath stroke='rgba%28255, 255, 255, 1%29' stroke-linecap='round' stroke-miterlimit='10' stroke-width='2' d='M4 7h22M4 15h22M4 23h22'/%3e%3c/svg%3e");
    }
    
    /* Added for dropdown submenu */
    .dropdown-submenu {
        position: relative;
    }
    
    .dropdown-submenu .dropdown-menu {
        top: 0;
        left: 100%;
        margin-top: -1px;
        display: none;
    }
    
    .dropdown-submenu:hover .dropdown-menu {
        display: block;
    }
    
    @media (max-width: 768px) {
        .dropdown-submenu .dropdown-menu {
            position: static;
            margin-left: 10px;
            display: none;
        }
        
        .dropdown-submenu .dropdown-menu.show {
            display: block;
        }
    }
</style>

<!-- Top bar with logo and search -->
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

        <!-- User Icon and Cart -->
        <ul class="navbar-nav d-flex flex-row gap-3">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle text-white" href="#" id="userDropdown"
                   role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="images/user.svg" alt="User" width="24" height="24">
                </a>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                    <% if (loggedIn) { %>
                        <li><span class="dropdown-item-text">Welcome, <strong><%= user.getUsername() %></strong></span></li>
                        <li><hr class="dropdown-divider"></li>
                        <% if ("Admin".equalsIgnoreCase(user.getRole())) { %>
                            <li><a class="dropdown-item" href="admin.jsp">Admin Panel</a></li>
                        <% } else { %>
                            <li><a class="dropdown-item" href="MyProfile.jsp">My Profile</a></li>
                            <li><a class="dropdown-item" href="MyOrders.jsp">My Orders</a></li>
                        <% } %>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="logout.jsp">Logout</a></li>
                    <% } else { %>
                        <li><a class="dropdown-item" href="login.jsp">Login</a></li>
                        <li><a class="dropdown-item" href="registration.jsp">Register</a></li>
                    <% } %>
                </ul>
            </li>
            <% if (loggedIn) { %>
                <li class="nav-item">
                    <a class="nav-link text-white" href="cart.jsp">
                        <img src="images/cart.svg" alt="Cart" width="24" height="24">
                        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                            <%-- You can add cart item count here if needed --%>
                        </span>
                    </a>
                </li>
            <% } %>
        </ul>
    </div>
</div>

<!-- Main Navigation -->
<nav class="navbar navbar-expand-md main-nav">
    <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navMain" aria-controls="navMain"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navMain">
            <ul class="navbar-nav mx-auto mb-2 mb-md-0">
                <li class="nav-item"><a class="nav-link <%= "index.jsp".equals(pageName) ? "active" : "" %>" href="index.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link <%= "shop.jsp".equals(pageName) ? "active" : "" %>" href="shop.jsp">Shop</a></li>
                <li class="nav-item"><a class="nav-link <%= "about.jsp".equals(pageName) ? "active" : "" %>" href="about.jsp">About us</a></li>
                <li class="nav-item"><a class="nav-link <%= "services.jsp".equals(pageName) ? "active" : "" %>" href="services.jsp">Services</a></li>
                <li class="nav-item"><a class="nav-link <%= "blog..jsp".equals(pageName) ? "active" : "" %>" href="blog.jsp">Blog</a></li>
                <li class="nav-item"><a class="nav-link <%= "contact.jsp".equals(pageName) ? "active" : "" %>" href="contact.jsp">Contact us</a></li>
            </ul>
        </div>
    </div>
</nav>

<script>
    // Function to handle submenu toggle
    function toggleSubmenu(event) {
        event.preventDefault();
        event.stopPropagation();
        
        const submenu = event.target.nextElementSibling;
        if (submenu) {
            submenu.classList.toggle('show');
            
            // Close other open submenus
            document.querySelectorAll('.dropdown-submenu .dropdown-menu').forEach(menu => {
                if (menu !== submenu) {
                    menu.classList.remove('show');
                }
            });
        }
    }
    
    // Close submenus when clicking elsewhere
    document.addEventListener('click', function() {
        document.querySelectorAll('.dropdown-submenu .dropdown-menu').forEach(menu => {
            menu.classList.remove('show');
        });
    });
</script>