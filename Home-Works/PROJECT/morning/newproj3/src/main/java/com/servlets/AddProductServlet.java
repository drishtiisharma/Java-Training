package com.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.daoimpl.ProductDaoImpl;
import com.pojo.Product;

@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 1. Retrieve form data
            String pname = request.getParameter("pname");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int cid = Integer.parseInt(request.getParameter("cid"));

     
            Part filePart = request.getPart("productImage");
            String imageFileName = filePart.getSubmittedFileName();
         
            Product product = new Product();
            product.setPname(pname);
            product.setDescription(description);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setCid(cid);
            product.setImageUrl(imageFileName);  

            // 4. Save product to DB
            ProductDaoImpl dao = new ProductDaoImpl();
            boolean result = dao.addProduct(product);

            //  Save image to webapp/images/ directory
            String imageFolderPath = request.getServletContext().getRealPath("/images");
            File uploadDir = new File(imageFolderPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs(); // Create folder if not exists
            }

            String uploadPath = "C:/Users/TCA/OneDrive/Desktop/java program eclipse/web/newproj/src/main/webapp/images/"+imageFileName;
            System.out.println("Upload Path: " + uploadPath);
            try (FileOutputStream fos = new FileOutputStream(uploadPath);
                 InputStream is = filePart.getInputStream()) {
                byte[] data = new byte[is.available()];
                is.read(data);
                fos.write(data);
            }

            // . Set message
            if (result) {
                request.setAttribute("msg", "Product added successfully!");
            } else {
                request.setAttribute("msg", "Failed to add product!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "Something went wrong: " + e.getMessage());
        }

        //  Forward to addproduct.jsp
        RequestDispatcher rd = request.getRequestDispatcher("addproduct.jsp");
        rd.forward(request, response);
    }
}
