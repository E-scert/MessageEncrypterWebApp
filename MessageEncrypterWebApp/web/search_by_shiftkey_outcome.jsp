<%-- 
    Document   : search_by_shifkey_outcome
    Created on : Feb 13, 2026, 2:27:27 PM
    Author     : JREscert
--%>

<%@page import="java.util.List"%>
<%@page import="ac.za.tut.entities.MessageEncrypter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search.by.shift_Key.outcome.Page</title>
    </head>
    <body>
        <h1>Search.by.shift_Key.outcome</h1>
        <p><b>Out come:</b></p>
        <table>
            <thead>
            <th>ID:</th>
            <th>Message:</th>
            <th>Encrypted Message:</th>
            <th>Encryption Type:</th>
            <th>Shift Key:</th>
            </thead>
            <tbody>
                
                 <%
            
          List<MessageEncrypter> list = (List<MessageEncrypter>)request.getAttribute("me");
          
          if(list != null){
                  for(MessageEncrypter me : list){
                  %>   
                  <tr>
                      
                      <td><%=me.getId()%>&nbps;</td>
                      <td><%=me.getMessage()%>&nbps;</td>
                      <td><%=me.getEncryptedMessage()%>&nbps;</td>
                      <td><%=me.getEncryptionType()%>&nbps;</td>
                      <td><%=me.getShifKeyNumber()%>&nbps;</td>
                  </tr>
                  <%
                 }
 
          }

        %>
            </tbody>
            
        </table>
       
    </body>
</html>
