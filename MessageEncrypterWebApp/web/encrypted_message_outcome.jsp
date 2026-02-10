<%-- 
    Document   : encrypted_message_outcome
    Created on : Feb 10, 2026, 3:53:10 PM
    Author     : JREscert
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Message Encrypt OutCome Page</title>
    </head>
    <body>
        <h1>Encryption OutCome</h1>
        <%
          String message = (String)request.getAttribute("message");
          String encryptedMessage = (String)request.getAttribute("encrypted");
        %>
        <p>
            Origianl message <b><%=message%></b>
        <p/>
    </body>
</html>
