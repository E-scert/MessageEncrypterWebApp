/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import ac.za.tut.entities.MessageEncrypter;
import ac.za.tut.module.bl.MessageEncryptorInt;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JREscert
 */
public class RemoveDataServlet extends HttpServlet {

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
            out.println("<title>Servlet RemoveDataServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RemoveDataServlet at " + request.getContextPath() + "</h1>");
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
    @EJB
    private MessageEncryptorInt mei;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<MessageEncrypter> list = mei.findAll();
        
        request.setAttribute("list", list);
        
        RequestDispatcher disp = request.getRequestDispatcher("remove_data.jsp");
        disp.forward(request, response);
        
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
        
      String idString = request.getParameter("id");

      //checks if the string is not empty
        if(idString == null || idString.trim().isEmpty()){
            request.setAttribute("error", "ID must be provided.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;

        }
        try{
            Long id = Long.valueOf(idString);
            mei.deleteData(id);
            request.setAttribute("message", "Record with ID "+id+" deleted successfull");
        
        }catch(NumberFormatException e){
            request.setAttribute("error", "Invalid ID format.");
        
        }
        
        RequestDispatcher disp = request.getRequestDispatcher("delete_data_outcome.jsp");
           
        disp.forward(request, response);
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
