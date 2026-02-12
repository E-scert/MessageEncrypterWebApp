<%-- 
    Document   : search_by_encryption_outcome
    Created on : Feb 12, 2026, 6:22:57 PM
    Author     : JREscert
--%>

<%@page import="java.util.List"%>
<%@page import="ac.za.tut.entities.MessageEncrypter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search_by_encryption_outcome_Page</title>
    </head>
    <body>
        <h1>Search_by_encryption_outcome</h1>
        <h4>Results</h4>
        
        <table>
            <thead>
            <th>ID</th>
            <th>Message</th>
            <th>Encrypted Message</th>
            <th>Encryption Type</th>
            <th>Shift key</th>
            </thead>
            <tbody>
                
                <%
                List<MessageEncrypter> list = (List<MessageEncrypter>)request.getAttribute("list");
                 if(list != null){
                
                     for(MessageEncrypter me : list){
                      %>
                      <tr>
                          <td><%=me.getId()%> &nbsp;</td>
                           <td><%=me.getMessage()%> &nbsp;</td>
                            <td><%=me.getEncryptedMessage()%> &nbsp;</td>
                             <td><%=me.getEncryptionType()%> &nbsp;</td>
                              <td><%=me.getShifKeyNumber()%> &nbsp;</td>
                              
                      </tr>
                      <%
                     }
                 }
                %>
            </tbody>
        </table>
    </body>
</html>
