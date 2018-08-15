<%-- 
    Document   : ListaUsuarios
    Created on : 30/07/2018, 14:16:31
    Author     : Matheus
--%>
<%@page import="java.util.List"%>
<%@page import="br.cefetmg.inf.model.domain.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

        <style>
            ul{
                list-style-type: none;
            }
        </style>

        <title>Lista de Usuarios</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2>Lista de Usuarios:</h2>
            <br>
            <ul>
                <%
                    List<Usuario> listaUsuarios = (List) request.getAttribute("usuarios");
                    Usuario usuario = new Usuario();
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        usuario = listaUsuarios.get(i);
                %>
                <li>
                    <a href="/servletweb?acao=MostrarUsuario&codUsuario=<%= usuario.getCodCpf()%>"> 
                        Ver <b><%= usuario.getNomUsuario()%></b> 
                    </a>
                    <br>
                    <a href="/servletweb?acao=AlterarUsuario&codUsuario=<%= usuario.getCodCpf()%>">
                        Alterar
                    </a>
                    <br>
                    <a href="/servletweb?acao=ListaAvaliacoes&codUsuario=<%= usuario.getCodCpf()%>">
                        Ver Avaliacoes
                    </a>
                    <br>
                    <a href="/servletweb?acao=ListaFichas&codUsuario=<%= usuario.getCodCpf()%>">
                        Ver Fichas
                    </a>
                    <br>
                    <a href="/servletweb?acao=TelaCadastrarAvaliacao&cpfAluno=<%= usuario.getCodCpf()%>">
                        Cadastrar Avaliacao
                    </a>
                    <br><br>
                </li>
                <%
                    }
                %>
            </ul>
            <a class="btn btn-primary" onclick="voltar()">
                Voltar
            </a>
        </div>
        <br>
        <script>
            function voltar() {
                window.history.back();
            }
        </script>
    </body>
</html>

