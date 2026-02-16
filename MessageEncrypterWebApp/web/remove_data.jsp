<%-- 
    Document   : remove_data
    Created on : Feb 15, 2026, 1:53:30 PM
    Author     : JREscert
--%>

<%@page import="java.util.List"%>
<%@page import="ac.za.tut.entities.MessageEncrypter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove Data Page</title>
    </head>
    <body>
        <h1>Remove Data</h1>
        <h5>Data to remove</h5>
        
                <P>Enter the first string/word / character before the space.</P>
                
                <form action="RemoveDataServlet.do" method="GET">
                    <table>
            <thead>
            <th>ID:</th>
             <th>Message:</th>
            </thead>
            
            <tbody>
                <%
                List<MessageEncrypter> list = (List<MessageEncrypter>)request.getAttribute("list");
                if(list != null){
                for(MessageEncrypter me : list){
                     %>
                     <tr>
                         <td><%=me.getId()%></td>
                          <td><%=me.getMessage()%></td>
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
                <form action="RemoveDataServlet.do" method="POST">
                    <table>
                        <tr>
                            <td>Enter id:</td>
                            <td><input type="text" name="id"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="DELETE"/></td>
                        </tr>
                        
                    </table>
                   
                    
                </form>
    </body>
</html>
