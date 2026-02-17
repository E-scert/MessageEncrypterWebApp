<%-- 
    Document   : decrypt_file
    Created on : Feb 17, 2026, 2:03:23 AM
    Author     : JREscert
--%>

<%@page import="ac.za.tut.entities.FileEncryptionEntity"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Decrypt file page</title>
    </head>
    <body>
        <h1>Decrypt File:</h1>
        <p>Files info</p>
        <form action="DecryptFileServlet.do" method="GET">
          <table>
            <thead>
                <th>ID:</th>
                <th>File name</th>
                
            </thead>
            <tbody>
                <%
                     List<FileEncryptionEntity> list = (List<FileEncryptionEntity>)request.getAttribute("entity");
                     
                           if(list != null){
                           for(FileEncryptionEntity fe : list){
                           
                           %>
                           <tr>
                               <td><%=fe.getId()%></td>
                               <td><%=fe.getFileName()%></td>
                           </tr>
                           
                           <%
                             }
                           }
                %>
            </tbody>
            <tr>
                <td></td>
                <td><input type="submit" value="LIST"/></td>
            </tr>
          </table>
        </form>  
       
            
            <form action="DecryptFileServlet.do" method="POST">
                <table>
                    <tr>
                        <td>Enter ID:</td>
                        <td><input type="text" name="id" required=""/></td>
                    </tr>
                    
                    <tr>
                        <td></td>
                        <td><input type="submit" value="DECRYPT" /></td>
                    </tr>
                </table>
                
            </form>
          
    </body>
</html>
