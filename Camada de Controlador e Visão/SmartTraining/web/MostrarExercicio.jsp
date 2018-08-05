<%-- 
    Document   : MostrarExercicio
    Created on : 05/08/2018, 20:31:02
    Author     : mathe
--%>

<%@page import="br.cefetmg.inf.model.domain.Exercicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <title>Avaliação</title>
    </head>
    <body>
        <div class="container">
            <br>
            <%
                Exercicio exercicio = (Exercicio) request.getAttribute("exercicio");
            %>
            Nome: <%= exercicio.getNomeExercicio()%><br>
            Descrição <%= exercicio.getDescricaoExercicio()%><br>
            
            
            <form action="Listaexercicios.jsp">
                <input type="submit" name="Voltar" value="Voltar">
            </form>
        </div>
    </body>
</html>
