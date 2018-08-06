<%--
    Document   : CadastrarAvaliacao
    Created on : 28/07/2018, 23:24:25
    Author     : Felipe
--%>

<%@page import="br.cefetmg.inf.model.domain.Instrutor"%>
<%@page import="br.cefetmg.inf.model.domain.Usuario"%>
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
    <br>
    <h2>Inserção de Avaliação</h2>
    <p>*Medidas de peso em Kg e de medida em Cm.</p>
    <br>

    <form action="ServletWeb" method="post">
        <input type="hidden" name="acao" value="CadastrarAvaliacao">
        <%
            Usuario usuario = (Usuario) request.getAttribute("usuario");
            Instrutor instrutor = (Instrutor) session.getAttribute("instrutor");
        %>
        
        <input type = "hidden" name = "codCpfAluno" value="
               <%= request.setAttribute("codCpfAluno", usuario.getCodCpf()) %>" 
        />
        <input type = "hidden" name = "codCpfInstrutor" value="
               <%= request.setAttribute("codCpfInstrutor", instrutor.getCodCpf() %>"
        />

        <label for="peso" class="form">Peso: </label>
        <input type="number" name="peso" class="form-control" max="300" min="0">
        <br>

        <label for="percentualGordura" class="form">Percentual de gordura: </label>
        <input type="number" name="percentualGordura" class="form-control" max="100" min="0">
        <br>

        <label for="massaGorda" class="form">Massa gorda: </label>
        <input type="number" name="massaGorda" class="form-control" max="300" min="0">
        <br>

        <label for="tamanhoPescoco" class="form">Tamanho do pescoço: </label>
        <input type="number" name="tamanhoPescoco" class="form-control" max="1000" min="0">
        <br>

        <label for="tamanhoOmbro" class="form">Tamanho do ombro: </label>
        <input type="number" name="tamanhoOmbro" class="form-control" max="10000" min="0">
        <br>

        <label for="tamanhoTorax" class="form">Tamanho do torax: </label>
        <input type="number" name="tamanhoTorax" class="form-control" max="10000" min="0">
        <br>

        <label for="tamanhoAbdomen" class="form">Tamanho do abdômen: </label>
        <input type="number" name="tamanhoAbdomen" class="form-control" max="10000" min="0">
        <br>

        <label for="tamanhoCintura" class="form">Tamanho da cintura: </label>
        <input type="number" name="tamanhoCintura" class="form-control" max="10000" min="0">
        <br>
        
        <label for="tamanhoQuadril" class="form">Tamanho do quadril: </label>
        <input type="number" name="tamanhoQuadril" class="form-control" max="10000" min="0">
        <br>
               
        <label for="tamanhoBracoEsquerdo" class="form">Tamanho do braço esquerdo: </label>
        <input type="number" name="tamanhoBracoEsquerdo" class="form-control" max="10000" min="0">
        <br>

        <label for="tamanhoBracoDireito" class="form">Tamanho do braço direito: </label>
        <input type="number" name="tamanhoBracoDireito" class="form-control" max="10000" min="0">
        <br>

        <label for="tamanhoAnteBracoEsquerdo" class="form">Tamanho do antebraço esquerdo: </label>
        <input type="number" name="tamanhoAnteBracoEsquerdo" class="form-control" max="10000" min="0">
        <br>

        <label for="tamanhoAnteBracoDireito" class="form">Tamanho do antebraço direito: </label>
        <input type="number" name="tamanhoAnteBracoDireito" class="form-control" max="10000" min="0">
        <br>

        <label for="tamanhoCoxaEsquerda" class="form">Tamanho da coxa esquerda: </label>
        <input type="number" name="tamanhoCoxaEsquerda" class="form-control" max="10000" min="0">
        <br>

        <label for="tamanhoCoxaDireita" class="form">Tamanho da coxa direita: </label>
        <input type="number" name="tamanhoCoxaDireita" class="form-control" max="10000" min="0">
        <br>

        <label for="tamanhoPanturrilhaEsquerda" class="form">Tamanho da panturrilha esquerda: </label>
        <input type="number" name="tamanhoPanturrilhaEsquerda" class="form-control" max="10000" min="0">
        <br>

        <label for="tamanhoPanturrilhaDireita" class="form">Tamanho da panturrilha direita: </label>
        <input type="number" name="tamanhoPanturrilhaDireita" class="form-control" max="10000" min="0">
        <br>

        <input type="submit" name="Cadastrar" class="btn btn-primary" value="Cadastrar">
        <input type="button" name="Voltar" class="btn btn-primary" value="Voltar">
    </form>
    
    </div>
    <br>
</body>
</html>
