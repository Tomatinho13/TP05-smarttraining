<%--
    Document   : ListaExercicios
    Created on : 30/07/2018, 12:30:53
    Author     : Felipe
--%>

<%@page import="java.util.List"%>
<%@page import="model.classes.Musculo" %>
<%@page import="model.classes.Exercicio" %>
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

        <title>Exercícios</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2>Exercícios</h2>
            <br>

            <ul class="list-group">
                <%
                    Musculo musculo = new Musculo();
                    Exercicio exercicio = new Exercicio();
                    List listaMusculos = (List) request.getAttribute("musculos");

                    for(int i=0; i<listaMusculos.size(); i++){
                        musculo = listaMusculos.get(i);
                %>
                <li class="list-group-item"> <h3> <%= musculo.getNomeMusculo() %> </h3> </li>
                <li>
                    <ul class="list-group">
                        <%
                                request.setAttribute("nomeMusculo", musculo.getNomeMusculo());
                                List listaExercicios = (List) request.getAttribute("exercicios");

                                for(int j=0; j<listaExercicios.size(); j++){
                                    exercicio = listaExercicios.get(j);
                        %>
                        <li class="list-group-item"> <%= exercicio.getNomeExercicio() %> </li>
                        <%
                                }
                        %>
                    </ul>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </body>
</html>
