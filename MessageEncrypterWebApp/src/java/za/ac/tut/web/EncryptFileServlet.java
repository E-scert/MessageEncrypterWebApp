/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import ac.za.tut.entities.FileEncryptionEntity;
import ac.za.tut.module.bl.FileEncryptionBean;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author JREscert
 */
@WebServlet(name = "EncryptFileServlet", urlPatterns = {"/EncryptFileServlet.do"})
@MultipartConfig
public class EncryptFileServlet extends HttpServlet {

    @EJB
    private FileEncryptionBean feb;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String filePath = request.getParameter("file");
        Path path = Paths.get(filePath);
        String fileName = path.getFileName().toString();
        try{
             //read file bytes
             byte[] fileBytes = Files.readAllBytes(path);
             
             //encrypt using bean
               FileEncryptionEntity entity = feb.encryptFile(fileBytes, fileName);
                  
                  //delete original file
                  Files.delete(path);

                   //save encrypted file to Desktop 
                   String userHome = System.getProperty("user.home");
                   File dt = new File(userHome, "Desktop");
                   File encryptedFile = new File(dt,"ENCRYPTED_"+fileName);
                   
                   try(FileOutputStream fos = new FileOutputStream(encryptedFile)){
                   fos.write(entity.getEncryptedData());
                   }

                 //set attributes
                   request.setAttribute("message", "File encrypted and saved successfully! and Original Deleted");
                   request.setAttribute("fileEntity",entity);
                   request.setAttribute("desktopPath",encryptedFile.getAbsolutePath());
                   
                   //forward to jsp
                   request.getRequestDispatcher("encrypt_results.jsp").forward(request, response);
        
        }catch(Exception e){
            request.setAttribute("error","File encryption failed: "+e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        
        }
        
       
    }

   

}
