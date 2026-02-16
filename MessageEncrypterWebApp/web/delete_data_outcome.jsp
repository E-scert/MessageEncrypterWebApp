<%-- 
    Document   : delete_data_outcome
    Created on : Feb 15, 2026, 3:20:00 PM
    Author     : JREscert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Data Outcome Page</title>
    </head>
    <body>
        <h1>Delete Data Outcome.</h1>
        <%
        String message = (String)request.getAttribute("message");
        
        %>
        <p><%=message%></p>
    </body>
</html>
