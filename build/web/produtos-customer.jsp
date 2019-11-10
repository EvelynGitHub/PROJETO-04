
<%@page import="br.com.fatecpg.db.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pordutos-Customers</title>
    </head>
    <body>

        inclide do header

        <%
            int id = 0;

            if (request.getParameter("verLista").equalsIgnoreCase("s")) {
                if (request.getParameter("customer_id") != null) {
                    id = Integer.parseInt(request.getParameter("customer_id"));
                }
            }

        %>


        <h1>Produtos-Customers</h1>
        

        <%try {%>

        <% boolean umaVez = false;%>

        <% for (Product p : Product.getListProductCustomer(id)) {%>
            <% if (!umaVez) {%>    
                <h3>Informaçãoes Customer</h3>
                <h4>Código: <%= p.getCustomer().getId()%></h4>
                <h4>Nome: <%= p.getCustomer().getName()%></h4>

                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>PRODUCT CODE</th>
                        <th>DESCRIPTION</th>
                    </tr>

                <% umaVez = true;%>
            <%}%>            
            
            
            <tr>
                <td><%= p.getId()%></td>
                <td><%= p.getName()%></td>                   
                <td><%= p.getDesc()%></td>                   
            </tr>
            
            
        <%}%>

        <%} catch (Exception e) {%>
            <tr>
                <td colspan="3">Erro: <%= e.getMessage()%></td>
            </tr>
        <%}%>           
        </table>
    </body>
</html>
