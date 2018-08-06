<%-- 
    Document   : CriarExercicio
    Created on : 02/08/2018, 19:15:19
    Author     : Matheus
--%>

<%@page import="java.util.List"%>
<%@page import="br.cefetmg.inf.model.domain.Aparelho"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

        <title>Criar Exercicio</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2 class="h2">SmartTraining - Criar Exercicio</h2>
            <form action="ServletWeb" method="post">
                <input type="hidden" name="acao" value="CadastrarExercicio">
                
                <label for="nomeExercicio">Nome do novo exercicio:</label><br>
                <input type="text" name="nomeExercicio" class="form-control" placeholder="Digite aqui..."><br>

                <label for="descExercicio">Descrição do novo exercicio:</label><br>
                <textarea name="descExercicio" class="form-control" placeholder="Digite aqui..." rows="5"></textarea><br>
                
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

                <input type="submit" name="criarExercicio" class="btn btn-primary" value="Remover">
            </form>  
        <form action="TelaInicialAluno.jsp">
            <input type="submit" value="Voltar">
        </form>
        </div>
    </body>
</html>