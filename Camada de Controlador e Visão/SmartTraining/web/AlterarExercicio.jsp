<%-- 
    Document   : AlterarExercicio
    Created on : 07/08/2018, 15:50:02
    Author     : Felipe
--%>

<%@page import="br.cefetmg.inf.model.domain.Exercicio"%>
<%@page import="java.util.List"%>
<%@page import="br.cefetmg.inf.model.domain.Aparelho"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <title>Alterar Exercício</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2 class="h2">SmartTraining - Alterar Exercicio</h2>
            <br>
            
            <%
                Exercicio exercicio = (Exercicio) request.getAttribute("exercicio");
            %>
            
            <form action="ServletWeb" method="post">
                <input type="hidden" name="acao" value="AlterarExercicio">
                
                <label for="nomeExercicio">Nome do exercicio:</label><br>
                <input type="text" name="nomeExercicio" class="form-control" value="<%= exercicio.getNomeExercicio() %>"><br>

                <label for="descExercicio">Descrição do novo exercicio:</label><br>
                <textarea name="descExercicio" class="form-control"  rows="5"> <%= exercicio.getDescricaoExercicio() %> </textarea><br>
                
                <h4>Aparelhos possíveis:</h4>

                <%
                    Aparelho aparelho = new Aparelho();
                    List<Aparelho> listaAparelhos = (List) request.getAttribute("aparelhos");
                    
                    for(int i=0; i<listaAparelhos.size(); i++){
                        aparelho = listaAparelhos.get(i);
                %>
                
                <input type="checkbox" name="aparelho" value="<%= aparelho.getNomAparelho() %>">
                
                <%
                    }
                %>

                <input type="submit" name="Alterar" class="btn btn-primary" value="Alterar">
            </form>
                
            <a href="ListaExercicios.jsp" class="btn btn-primary">Voltar </a>
        </div>
    </body>
</html>
