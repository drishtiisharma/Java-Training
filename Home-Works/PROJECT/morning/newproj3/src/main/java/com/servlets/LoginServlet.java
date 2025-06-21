package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.dao;
import com.daoimpl.daoimpl;
import com.pojo.UserInfo;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private dao userDao = new daoimpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String credential = request.getParameter("credential");
        String password = request.getParameter("password");

        UserInfo user = userDao.getUserByLoginCredential(credential, password);

        if (user != null) {
            HttpSession session = request.getSession();
            // Set BOTH the user object AND the username separately
            session.setAttribute("loggedInUser", user);
            session.setAttribute("username", user.getUsername()); 
            
            // Set session timeout (30 minutes)
            session.setMaxInactiveInterval(30 * 60); 
            
            if ("Admin".equalsIgnoreCase(user.getRole())) {
                response.sendRedirect("admin.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
        } else {
            request.setAttribute("error", "Invalid credentials!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}