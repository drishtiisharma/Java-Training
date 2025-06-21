package com.servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.dao;
import com.daoimpl.daoimpl;
import com.pojo.UserInfo;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email    = request.getParameter("email");
        String phone    = request.getParameter("phone");
        String address  = request.getParameter("address");

        UserInfo user = new UserInfo();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setRole("Customer"); // or "Admin" depending on context

        dao daoObj = new daoimpl();

        // ✅ Use the correct method name from daoimpl
        boolean registered = daoObj.addUser(user);

        if (registered) {
            request.getSession().setAttribute("msg", "Registration successful. Please log in.");
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("error", "Registration failed. Try again.");
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        }
    }
}
