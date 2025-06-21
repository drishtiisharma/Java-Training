package com.servlets;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import com.dao.dao;
import com.daoimpl.daoimpl;
import com.pojo.UserInfo;

@WebServlet("/EditProfileServlet")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,  // 1MB
    maxFileSize = 1024 * 1024 * 5,    // 5MB
    maxRequestSize = 1024 * 1024 * 10 // 10MB
)
public class EditProfileServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    private dao userDao = new daoimpl();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        UserInfo user = (UserInfo) session.getAttribute("loggedInUser");
        
        // Check if user is logged in
        if (user == null) {
            request.setAttribute("error", "Session expired. Please log in again.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        try {
            // 1. Get form data
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            Part profilePicPart = request.getPart("profilePic");

            // 2. Validate phone number (basic example)
            if (phone != null && !phone.matches("^[0-9+\\-()\\s]{8,15}$")) {
                request.setAttribute("error", "Invalid phone number format. Use digits, +, -, or ().");
                request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
                return;
            }

       

         // 3. Handle profile picture upload
            Part filePart = request.getPart("profilePic");
            String imageFileName = filePart.getSubmittedFileName();
            user.setProfilePicture(imageFileName);
            String uploadPath = "F:\\PROJECTTT\\21-06\\morning\\newproj3\\src\\main\\webapp\\images\\" + imageFileName;
            System.out.println("Upload Path: " + uploadPath);
            try {

            	FileOutputStream fos = new FileOutputStream(uploadPath);
                InputStream is = filePart.getInputStream(); 
                // Read and write the file data
                byte[] data = new byte[is.available()];
                is.read(data);
                fos.write(data);
            }
            catch (IOException e)
            {
                e.printStackTrace();
                return; // Stop further processing
            }
          

            // 4. Update user object
            user.setUsername(username);
            user.setPassword(password);
            user.setPhone(phone);
            user.setAddress(address);

            // 5. Save to database
            boolean success = userDao.updateUser(user); // Ensure this method exists in your DAO

            // 6. Set result message
            if (success) {
                session.setAttribute("loggedInUser", user); // Refresh session
                request.setAttribute("success", "Profile updated successfully!");
            } else {
                request.setAttribute("error", "Failed to update profile. Please try again.");
            }

        } catch (Exception e) {
            request.setAttribute("error", "Error: " + e.getMessage());
            e.printStackTrace();
        }

        // 7. Forward back to editprofile.jsp
        request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
    }
}