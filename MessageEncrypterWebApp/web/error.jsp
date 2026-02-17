<%-- 
    Document   : error
    Created on : Feb 16, 2026, 1:36:46 PM
    Author     : JREscert
--%>

<%@page import="ac.za.tut.entities.FileEncryptionEntity"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error page</title>
    </head>
    <body>
        <h2 style="color:red;">Error</h2>
        <p><%=request.getAttribute("error")%></p>
        <table>
            <thead>
                <th>ID:</th>
                <th>File Name:</th>
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
                    
                  } 
               }
                %>
            </tbody>
        </table>
    </body>
</html>
