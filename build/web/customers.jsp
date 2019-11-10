<%-- 
    Document   : customers
    Created on : 04/11/2019, 16:48:39
    Author     : a
--%>

<%@page import="br.com.fatecpg.db.Product"%>
<%@page import="br.com.fatecpg.db.Custumer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customers</title>
    </head>
    <body>
        <h1>Customers</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>E-MAIL</th>
                <th>Produtos</th>
            </tr>
            <%try{%>
                <%for(Custumer c: Custumer.getList()){%>
                <tr>
                    <td><%= c.getId()%></td>
                    <td><%= c.getName()%></td>
                    <td><%= c.getEmail()%></td>                  
                    <td><a href="produtos-customer.jsp?customer_id=<%= c.getId()%>&verLista=s">Ver lista</a></td>
                </tr>
                <%}%>
            <%}catch(Exception e){%>
                <tr>
                    <td colspan="3">Erro: <%= e.getMessage()%></td>
                </tr>
            <%}%>           
        </table>
    </body>
</html>
