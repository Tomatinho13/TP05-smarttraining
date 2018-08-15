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
  <title>Instrutor Inicio</title>
</head>
<body>
    <div class="container">
        <form action="servletweb" id="form">
            <input type="hidden" name="acao" id="acao">
            <input type="submit" class="btn btn-primary" value="Mostrar Exercicios" onclick="listarExercicios()">
            <input type="submit" class="btn btn-primary" value="Remover Exercicios" onclick="removerExercicios()">
            <input type="submit" class="btn btn-primary" value="Remover Usuario" onclick="removerUsuario()">
            <input type="submit" class="btn btn-primary" value="Listar Usuarios" onclick="cadastrarAvaliacao()">
        </form>
    </div>
    <script>
        function listarExercicios(){
            document.getElementById("acao").value="ListarExercicios"
        }
        
        function removerExercicios(){
            document.getElementById("acao").value="TelaRemoverExercicio"
        }
        
        function removerUsuario(){
            document.getElementById("acao").value="TelaRemoverUsuario"
        }
        
        function cadastrarAvaliacao(){
            document.getElementById("acao").value="ListarUsuarios";
        }
    </script>
</body>
</html>
