<%-- 
    Document   : TelaInicialAluno
    Created on : 05/08/2018, 13:09:02
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <title>Inserção de Avaliação</title>
</head>
<body>
    <div class="container">
        <form action="servletweb" id="form">
            <input type="hidden" name="acao" id="acao">
            <input type="submit" class="btn btn-primary" value="Mostrar Exercicios" onclick="listarExercicios()">
        </form>
    </div>
    <script>
        function listarExercicios(){
            document.getElementById("acao").value="ListarExercicios"
        }
    </script>
</body>
</html>
