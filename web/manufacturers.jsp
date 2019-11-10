<%-- 
    Document   : customers
    Created on : 04/11/2019, 16:48:39
    Author     : a
--%>

<%@page import="br.com.fatecpg.db.Manufacturer"%>
<%@page import="br.com.fatecpg.db.Product"%>
<%@page import="br.com.fatecpg.db.Custumer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manufacturer</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/nav.jspf"%>
        <h1>Manufacturer</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>E-MAIL</th>
                <th>PRODUTOS</th>
            </tr>
            <%try{%>
                <%for(Manufacturer m: Manufacturer.getList()){%>
                <tr>
                    <td><%= m.getId()%></td>
                    <td><%= m.getName()%></td>
                    <td><%= m.getEmail()%></td>                  
                    <td><a href="produtos-manufacturer.jsp?manufacturer_id=<%= m.getId()%>&verLista=s">Ver lista</a></td>
                </tr>
                <%}%>
            <%}catch(Exception e){%>
                <tr>
                    <td colspan="3">Erro: <%= e.getMessage()%></td>
                </tr>
            <%}%>           
        </table>
            <%@include file="WEB-INF/jspf/footer.jspf"%>
    </body>
</html>
