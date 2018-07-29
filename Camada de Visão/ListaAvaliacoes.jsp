<%--
    Document   : ListaAvaliacoes
    Created on : 28/07/2018, 23:42:46
    Author     : Felipe
--%>

<%@page import="java.util.List"%>
<%@page import="model.classes.Avaliacao" %>
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

        <title>Lista de Avaliacoes</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2>Lista de Avaliações:</h2>
            <br>
            <%-- Colocar o CSS aqui ainda --%>
            <ul>
                <%
                    List listaAvaliacoes = (List) request.getAttribute("avaliacoes");
                    Avaliacao avaliacao = new Avaliacao();

                    for (int i = 0; i < listaAvaliacoes.size(); i++) {
                        avaliacao = listaAvaliacoes.get(i);
                %>
                <li>
                    Data: <%= avaliacao.getDatAvaliacao() %>
                    <jsp:forward page="MostrarAvaliacao.jsp">
                        <jsp:param name="avaliacao" value="<%= avaliacao %>" />
                    </jsp:forward>
                </li>
                <%
                    }
                %>
            </ul>

        </div>
    </body>
</html>
