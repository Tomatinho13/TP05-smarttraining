<%-- 
    Document   : CriarExercicio
    Created on : 02/08/2018, 19:15:19
    Author     : Matheus
--%>

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
            <form action="CriarExercicioServlet" method="post">
                <label for="nomeExercicio">Nome do novo exercicio:</label><br>
                <input type="text" name="nomeExercicio" class="form-control"placeholder="Digite aqui..."><br>

                <label for="descExercicio">Descrição do novo exercicio:</label><br>
                <textarea name="descExercicio" class="form-control" placeholder="Digite aqui..." rows="5"></textarea><br>

                <label for="nomeAparelho">Nome do aparelho do exercicio:</label><br>
                <input type="text" name="nomeAparelho" class="form-control"placeholder="Digite aqui..."><br>

                <input type="submit" name="criarExercicio" class="btn btn-primary" value="Remover">
            </form>  
        </div>
    </body>
</html>