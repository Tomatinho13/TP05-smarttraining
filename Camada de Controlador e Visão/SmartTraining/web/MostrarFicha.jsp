<%--
    Document   : MostrarFicha
    Created on : 30/07/2018, 16:39:43
    Author     : Celio
--%>

<%@page import="java.util.List"%>
<%@page import="br.cefetmg.inf.model.domain.Ficha" %>
<%@page import="br.cefetmg.inf.model.domain.Treino" %>
<%@page import="br.cefetmg.inf.model.domain.Exercicio" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <title>Ficha</title>
    </head>
    <body>
        <div>
            <br>
            <h2>Ficha</h2>
            <br>

            <%
                Ficha ficha = new Ficha();
                Treino treino = new Treino();
                Exercicio exercicio = new Exercicio();

                ficha = request.getParameter("ficha");
                request.setAttribute("ficha", ficha);

                List <Treino> listaTreinos = (List) request.getAttribute("treinos");

                for (int i = 0; i < listaTreinos.size(); i++) {
                    treino = listaTreinos.get(i);
            %>

            <h3>Treino <%= treino.getNroTreino() %> </h3>

            <table class="table table-hover">
                <tr>
                    <th>Aparelho</th>
                    <th>Exercício</th>
                    <th>Séries</th>
                    <th>Repetições</th>
                    <th>Peso</th>
                </tr>

            <%
                request.setAttribute("treino", treino);
                List <Exercicio> listaExercicios = (List) request.getAttribute("exercicios");

                    for (int j = 0; j < listaExercicios.size(); j++) {
                        exercicio = listaExercicios.get(j);
                        request.setAttribute("exercicio", exercicio);
            %>
                <tr>
                    <td> <%= request.getAttribute("numeroAparelho") %> </td>
                    <td> <%= exercicio.getNomeExercicio() %> </td>
                    <td> <%= request.getAttribute("numeroSeries") %></td>
                    <td> <%= request.getAttribute("numeroRepeticoes") %></td>
                    <td> <%= request.getAttribute("peso") %></td>
                </tr>
            <%
                   }
                }
            %>
            </table>
            <form action="ListaFichas.jsp">
                <input type="submit" name="Voltar" value="Voltar">
            </form>
        </div>
    </body>
</html>
