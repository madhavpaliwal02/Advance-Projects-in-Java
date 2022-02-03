package com.tech.blog.servlets;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

@MultipartConfig

public class EditServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditServlet</title>");
            out.println("</head>");
            out.println("<body>");

            // Fetching values from form
            String name = request.getParameter("user_name");
            String email = request.getParameter("user_email");
            String pass = request.getParameter("user_pass");
            String about = request.getParameter("user_about");
            Part part = request.getPart("image");
            String image = part.getSubmittedFileName();

            // Get the user from session
            HttpSession s = request.getSession();
            User u = (User) s.getAttribute("currentUser");

            u.setName(name);
            u.setEmail(email);
            u.setPassword(pass);
            u.setAbout(about);
            String oldFile = u.getProfile();
            u.setProfile(image);

            // Update the data of user in the database
            UserDao dao = new UserDao(ConnectionProvider.getCon());

            boolean flag = dao.editUser(u);

            if (flag) {

                String path = request.getRealPath("/") + "pics" + File.separator + u.getProfile();
                
                String pathOldFile = request.getRealPath("/") + "pics" + File.separator + oldFile;
                
                Helper.deleteFile(pathOldFile);
                
                if (Helper.saveFile(part.getInputStream(), path)) {
                    
                    out.println("Profile updated...");
                    Message msg = new Message("Profile Updated...", "success", "alert-success");
                    s.setAttribute("msg", msg);
                } 
                else {
                    out.println("not updated...");
                    Message msg = new Message("Something went wrong...", "error", "alert-danger");
                    s.setAttribute("msg", msg);
                }
            } else {
                out.println("not updated...");
                Message msg = new Message("Something went wrong...", "error", "alert-danger");
                s.setAttribute("msg", msg);
            }
            
            response.sendRedirect("profile.jsp");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
