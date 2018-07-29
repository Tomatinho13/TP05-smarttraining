<%--
    Document   : ListaAvaliacoes
    Created on : 28/07/2018, 23:42:46
    Author     : Felipe
--%>

<%@page import="java.util.List"%>
<%@page import="model.classes.Avaliaçao" %>
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
                    Avaliaçao avaliacao;

                    for (int i = 0; i < listaAvaliacoes.size(); i++) {
                        avaliacao = new Avaliaçao();
                        avaliacao = listaAvaliacoes.get(i);
                %>
                <li>
                    Data: <%= avaliacao.getDatAvaliaçao() %>
                </li>
                <%
                    }
                %>
            </ul>

        </div>
    </body>
</html>
