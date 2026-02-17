/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import ac.za.tut.entities.FileEncryptionEntity;
import ac.za.tut.module.bl.FileEncryptionBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JREscert
 */
@WebServlet(name = "DecryptFileServlet", urlPatterns = {"/DecryptFileServlet.do"})
public class DecryptFileServlet extends HttpServlet {

 
    @EJB 
    private FileEncryptionBean feb;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<FileEncryptionEntity> entity = feb.findAll();
        
        //set the entity as attribute
        request.setAttribute("entity", entity);
        
        //request dispatcher
        request.getRequestDispatcher("decrypt_file.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Long id = Long.valueOf(request.getParameter("id"));
        
        try{
            //call decrypt method
            byte[] decryptedData = feb.decryptFile(id);
         //find the entity
         FileEncryptionEntity entity = feb.findById(id);
         
         //set headers
         response.setContentType("application/octet-stream");
         response.setHeader("Content-Disposition","attachment; filename=\""+entity.getFileName());
          //write decrypted bytes to response
          response.getOutputStream().write(decryptedData);
          response.getOutputStream().flush();
          
        
        
        }catch(Exception e){
            request.setAttribute("error", "Decryption failed: " + e.getMessage());
        request.getRequestDispatcher("decrypt_file.jsp").forward(request, response);

        
        }
       
        
        
    }

   

}
