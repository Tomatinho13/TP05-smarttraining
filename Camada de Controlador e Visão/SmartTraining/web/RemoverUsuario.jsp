<%-- 
    Document   : RemoverAluno
    Created on : 30/07/2018, 19:15:19
    Author     : Matheus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

        <title>Remover Usuario</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2 class="h2">SmartTraining - Remover usuario</h2>
            <form action="RemoverUsuarioServlet" method="post">
                <label for="nomeUsuario">Escreva o nome do usuario que deseja remover:</label><br>
                <input type="text" name="nomeUsuario" class="form-control"><br>
                <input type="submit" name="removerUsuario" class="btn btn-primary" value="Remover">
            </form>  
        </div>
    </body>
</html>