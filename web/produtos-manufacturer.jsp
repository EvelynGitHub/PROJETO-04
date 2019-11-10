
<%@page import="br.com.fatecpg.db.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pordutos Manufacturer</title>
    </head>
    <body>
        <div class="text-center">
            <%@include file="WEB-INF/jspf/nav.jspf"%>

            <%
                int id = 0;

                if (request.getParameter("verLista").equalsIgnoreCase("s")) {
                    if (request.getParameter("manufacturer_id") != null) {
                        id = Integer.parseInt(request.getParameter("manufacturer_id"));
                    }
                }

            %>


            <h1>Produtos Manufacturer</h1>        

            <%try {%>

            <% boolean umaVez = false;%>

            <% for (Product p : Product.getListProductManufacturer(id)) {%>
                <% if (!umaVez) {%>    
                    <h3>Informaçãoes Manufacturer</h3>
                    <h4>Código: <%= p.getManufacturer().getId()%></h4>
                    <h4>Nome: <%= p.getManufacturer().getName()%></h4>
                    <hr>
                    </br>

                    <table border="1">
                        <tr>
                            <th>PRODUCT CODE</th>
                            <th>PURCHASE COST</th>
                            <th>QUANTITY ON HAND</th>
                            <th>MARKUP</th>
                            <th>DESCRIPTION</th>
                        </tr>

                    <% umaVez = true;%>
                <%}%>            


                <tr>
                    <td><%= p.getCode()%></td>
                    <td><%= p.getPurchase_cost()%></td>                   
                    <td><%= p.getQuantity()%></td>                   
                    <td><%= p.getMarkup()%></td>                   
                    <td><%= p.getDesc()%></td>                   
                </tr>


            <%}%>

            <%} catch (Exception e) {%>
                <tr>
                    <td colspan="3">Erro: <%= e.getMessage()%></td>
                </tr>
            <%}%>           
            </table>
            <a href="manufacturers.jsp" class="btn btn-primary">Voltar</a>            
            <%@include file="WEB-INF/jspf/footer.jspf"%>
        </div>
    </body>
</html>
