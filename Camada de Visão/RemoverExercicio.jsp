
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

        <title>Remover Exercicio</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2 class="h2">SmartTraining - Remover Exercicio</h2>
            <form action="RemoverExercicioServlet" method="post">
                <label for="nomeExercicio">Escreva o nome do exercicio que deseja remover:</label><br>
                <input type="text" name="nomeExercicio" class="form-control" size="40"><br>
                <input type="submit" name="removerExercicio" class="btn btn-primary" value="Remover">
            </form>  
        </div>
    </body>
</html>