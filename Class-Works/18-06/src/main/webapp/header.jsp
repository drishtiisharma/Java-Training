<!-- header section start-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="logo" href="#"><img src="images/ypsilon.png" height="100" width="100"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                   <a class="nav-link" href="index.html">HOME</a>
                </li>
                <li class="nav-item">
                   <a class="nav-link" href="search jobs.html">SEARCH JOBS</a>
                </li>
                <li class="nav-item">
                   <a class="nav-link" href="recurments.html">RECRUITERS</a>
                </li>
                <li class="nav-item">
                   <a class="nav-link" href="companies.html">COMPANIES</a>
                </li>
                <li class="nav-item">
                   <a class="nav-link" href="services.html">SERVICES</a>
                </li>
                <li class="nav-item">
                   <a class="nav-link" href="#">MORE</a>
                </li>
            </ul>
        </div>
         <div class="login_text"><a href="login.html">LOGIN HERE</a></div>
         <br>
         <%
         String user = (String)session.getAttribute("user");
         if(user!=null)
        	 out.print(user);
         String dp = (String)session.getAttribute("dp");
         if(dp!=null)
         {
         %>
         <img alt="dp" src="images/<%=dp%>" height="30" width="40">
         <%
         }
         %>
    </nav>
  <!-- header section end-->
  <!-- login section start-->
  <div class="services_section">
    <div class="container">
      <h1 class="services_text">SERVICES</h1>
    </div>
  </div>