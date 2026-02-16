<%-- 
    Document   : update_data
    Created on : Feb 16, 2026, 2:12:10 PM
    Author     : JREscert
--%>

<%@page import="java.util.List"%>
<%@page import="ac.za.tut.entities.MessageEncrypter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Data Page</title>
    </head>
    <body>
        <h1>Update Data.</h1>
      
        
        <form action="UpdateDataServlet.do" method="get">
            
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
                
          <form action="UpadateDataServlet.do" method="get">
              <p>Enter id to update entity.</p>
              
            <table>
                <tr>
                    <td>Enter Id:</td>
                    <td><input type="text" name="id"/></td>
                </tr>
                 <tr>
                    <td></td>
                    <td><input type="submit" value="FIND"/></td>
                </tr>
                
                <p>Info to update</p>
<!--                code to collect the info in the database-->
                <%%>
                <tr>
                    <td>Message</td>
                    <td><input type="text" name="message"/></td>
                </tr>
                 <!--               alow user to enter the shiftkey to their encryption-->
                                    <tr>
                                        <td>Enter Shift Key:</td>
                                        <td><input type="text" name="shiftkey" required=""/></td>

                                    </tr>
                      
                 <tr>
                    <td></td>
                    <td><input type="submit" value="ENCRYPT"/></td>
                </tr>
                
                
            </table>
            
            
        </form>
    </body>
</html>
