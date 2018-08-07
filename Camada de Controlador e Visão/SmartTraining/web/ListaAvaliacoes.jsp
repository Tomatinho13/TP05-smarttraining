<%--
    Document   : ListaAvaliacoes
    Created on : 28/07/2018, 23:42:46
    Author     : Felipe
--%>

<%@page import="br.cefetmg.inf.model.domain.Usuario"%>
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
        
        <%
            Usuario usuario = (Usuario) request.getAttribute("usuario");
        %>
        
        <input type = "hidden" name = "codCpfAluno" value="
               <%= request.setAttribute("codCpfAluno", usuario.getCodCpf()) %>" 
        />
        
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
                    <a href="/controller/servletweb?acao=MostrarAvaliacao&dataAvaliacao=<%= avaliacao.getDatAvaliacao() %>" class="btn btn-primary"> 
                        Ver avaliação
                    </a>
                    <a href="/controller/servletweb?acao=AlterarAvaliacao&dataAvaliacao=<%= avaliacao.getDatAvaliacao() %>" class="btn btn-primary">
                        Alterar avaliação
                    </a>
                </li>
                <%
                    }
                %>
            </ul>

        </div>
        <br>
        
        <a href="TelaInicialAluno.jsp" class="btn btn-primary"> Voltar </a>
    </body>
</html>
