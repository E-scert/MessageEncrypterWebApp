<%-- 
    Document   : encrypt_results
    Created on : Feb 17, 2026, 12:25:11 AM
    Author     : JREscert
--%>

<%@page import="ac.za.tut.entities.FileEncryptionEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Encryption Outcome Page</title>
    </head>
    <body>
        <h1>Encryption Outcome</h1>
        <%
           String message = (String)request.getAttribute("message");
          FileEncryptionEntity entity = (FileEncryptionEntity)request.getAttribute("fileEntity");
           String path = (String)request.getAttribute("desktopPath");
        %>
        <p><%=message%></p>
        <p><%=entity.getFileName()%></p>
        <p><%=path%></p>
        
    </body>
</html>
