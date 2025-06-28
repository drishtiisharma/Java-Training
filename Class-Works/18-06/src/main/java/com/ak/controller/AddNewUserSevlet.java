package com.ak.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ips.daoimpl.UserInfoDaoImpl;
import com.ips.pojo.UserInfo;

@WebServlet("/AddNewUserSevlet")
@MultipartConfig
public class AddNewUserSevlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		UserInfo u = new UserInfo();
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		u.setFname(request.getParameter("fname"));
		u.setLname(request.getParameter("lname"));
		u.setContact(request.getParameter("contact"));
		
		Part filePart = request.getPart("fpic");

  
        String imageFileName = filePart.getSubmittedFileName(); // get selected image file name
        u.setDp(imageFileName);
        
        //System.out.println("Selected Images File Name: " + imageFileName);
        //request.setAttribute("filename",imageFileName);
        UserInfoDaoImpl daoimpl = new UserInfoDaoImpl();
		boolean b = daoimpl.addNewUser(u);
		String target="";
		if(b==true)
		{
			target = "/login.jsp";
			request.setAttribute("msg", "User Register Successfully, Can login Here");
		}
		else
		{
			target = "/reg.jsp";
			request.setAttribute("msg", "User Could Not Be Register Successfully");
		}
        
        String uploadPath = "/home/administrator/IPS@25/web/ips12/src/main/webapp/images/" + imageFileName;
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
            // Handle the exception, log it, or send an error response
            //response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error during file upload");
            return; // Stop further processing
        }
     
    		
		
		
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
	

}
