<%-- 
    Document   : all_data_outcome
    Created on : Feb 11, 2026, 10:22:21 PM
    Author     : JREscert
--%>

<%@page import="java.util.List"%>
<%@page import="ac.za.tut.entities.MessageEncrypter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Encryption Data Page</title>
    </head>
    <body>
        <h1>All Encryption</h1>
        <%
            Long id = null;
           String message = "";
           String encryptionType ="";
           String encryptedMessage ="";
           Integer shiftKey =0;
           
         List<MessageEncrypter> list = (List<MessageEncrypter>) request.getAttribute("list");
            for(int i =0; i < list.size(); i++){
                MessageEncrypter me = list.get(i);
                message = me.getMessage();
                encryptionType = me.getEncryptionType();
                encryptedMessage = me.getEncryptedMessage();
                shiftKey = me.getShifKeyNumber();
                id = me.getId();
            }
        
        %>
        <h4>Collected Data:</h4>
        <p><b>ID</b>    : <b>Message</b>   : <b>Encrypted Message</b>:   <b>Encryption Type</b>:     <b>Shift Key</b></p>
        <p><%=id%> &nbsp; <%=id%> &nbsp;<%=message%> &nbsp;<%=encryptionType%> &nbsp;<%=encryptedMessage%> &nbsp; <%=shiftKey%> &nbsp;</p>
    </body>
</html>
