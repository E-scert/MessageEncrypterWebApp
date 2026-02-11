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
        <h4>Collected Data:</h4>
        <table>
            
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Message</th>
                    <th>Encrypted Message</th>
                    <th>Encryption Type</th>
                    <th>Shift Key</th>
                </tr>
            </thead>
            <tbody>
                <%
                List<MessageEncrypter> list = (List<MessageEncrypter>)request.getAttribute("list");
                if(list != null){
                for(MessageEncrypter me : list){
                    %>
                    <tr>
                     <td><%= me.getId()%>&nbsp;</td>
                    <td><%= me.getMessage() %></td>
                    <td><%= me.getEncryptedMessage() %>&nbsp;</td>
                    <td><%= me.getEncryptionType() %>&nbsp;</td>
                    <td><%= me.getShifKeyNumber() %></td>  
                        
                    </tr>
                <%    
                  
                   }
                }
                %>
            </tbody>
        </table>
  
    </body>
</html>
