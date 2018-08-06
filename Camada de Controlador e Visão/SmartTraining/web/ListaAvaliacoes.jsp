<%--
    Document   : ListaAvaliacoes
    Created on : 28/07/2018, 23:42:46
    Author     : Felipe
--%>

<%@page import="java.util.List"%>
<%@page import="br.cefetmg.inf.model.domain.Avaliacao" %>
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

            <ul class="list-group">
                <%
                    List <Avaliacao> listaAvaliacoes = (List) request.getAttribute("avaliacoes");
                    Avaliacao avaliacao = new Avaliacao();

                    for (int i = 0; i < listaAvaliacoes.size(); i++) {
                        avaliacao = listaAvaliacoes.get(i);
                %>
                <li class="list-group-item">
                    <a href="/controller/servletweb?acao=MostrarAvaliacao&data=<%= avaliacao.getDatAvaliacao() %>"> 
                        Data: <%= avaliacao.getDatAvaliacao() %> 
                    </a>
                </li>
                <%
                    }
                %>
            </ul>

        </div>
        <br>
        <form action="TelaInicialAluno.jsp">
            <input type="submit" value="Voltar">
        </form>
    </body>
</html>
