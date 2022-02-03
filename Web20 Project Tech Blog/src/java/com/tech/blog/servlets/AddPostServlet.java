package com.tech.blog.servlets;

import com.tech.blog.dao.PostDao;
import com.tech.blog.entities.Posts;
import com.tech.blog.entities.User;
import com.tech.blog.helper.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

@MultipartConfig
public class AddPostServlet extends HttpServlet {

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
            
            int cid = Integer.parseInt(request.getParameter("cid"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String code = request.getParameter("code");
            Part part = request.getPart("pic");
            
            /*out.println("Cid " + cid);
            out.println("title " + title);
            out.println("Content " + content);
            out.println("code " + code);
            out.println("pic " + pic);*/
            
            // getting user id
            HttpSession s = request.getSession();
            User user = (User) s.getAttribute("currentUser");
            
            // Adding details of posts to its object
            Posts post = new Posts(cid, title, content, code, part.getSubmittedFileName(), user.getId());
            
            // Adding details to database
            PostDao dao = new PostDao(ConnectionProvider.getCon());
            
            if(dao.addPost(post)){
                String path = request.getRealPath("/") + "blog_pics" + File.separator + part.getSubmittedFileName();
                Helper.saveFile(part.getInputStream(), path);
                out.println("posted");
            }
            else{
                out.println("Unsuccessfull...");                
            }
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
