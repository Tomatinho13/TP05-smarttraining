<%--
    Document   : ListaFichas
    Created on : 30/07/2018, 15:27:31
    Author     : Felipe
--%>

<%@page import="java.util.List"%>
<%@page import="br.cefetmg.inf.model.domain.Ficha" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

        <style>
            ul{
                list-style-type: none;
            }
        </style>

        <title>Lista de Fichas</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2>Fichas</h2>
            <br>

            <ul class="list-group">
                <%
                    Ficha ficha = new Ficha();
                    List <Ficha> listaFichas = (List) request.getAttribute("fichas");

                    for(int i=0; i<listaFichas.size(); i++){
                        ficha = listaFichas.get(i);
                %>
                <li class="list-group-item">
                    Data: <%= ficha.getDataFicha() %>
                    <jsp:forward page="MostrarFicha.jsp">
                        <jsp:param name="ficha" value="<%= ficha %>" />
                    </jsp:forward>
                </li>

                <%
                    }
                %>
            </ul>
        </div>
    </body>
</html>
