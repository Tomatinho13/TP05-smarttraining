<%-- 
    Document   : ListaUsuarios
    Created on : 30/07/2018, 14:16:31
    Author     : Matheus
--%>
<%@page import="java.util.List"%>
<%@page import="model.classes.Usuario" %>
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

        <title>Lista de Usuarios</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2>Lista de Usuarios:</h2>
            <br>
            <ul>
                <%
                    List<Usuario> listaUsuarios = (List) request.getAttribute("usuario");
                    Usuario usuario = new Usuario();
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        usuario = listaUsuarios.get(i);
                %>
                <li>
                    <jsp:forward page="MostrarUsuario.jsp">
                        <jsp:param name="usuario" value="<%= usuario %>" />
                    </jsp:forward>
                </li>
                <%
                    }
                %>
            </ul>

        </div>
    </body>
</html>

