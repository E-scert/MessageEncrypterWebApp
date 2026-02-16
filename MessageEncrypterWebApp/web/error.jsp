<%-- 
    Document   : error
    Created on : Feb 16, 2026, 1:36:46 PM
    Author     : JREscert
--%>

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
        
    </body>
</html>
