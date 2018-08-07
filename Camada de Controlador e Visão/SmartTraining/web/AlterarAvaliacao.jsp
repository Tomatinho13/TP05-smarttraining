<%-- 
    Document   : AlterarAvaliacao
    Created on : 07/08/2018, 15:33:55
    Author     : Felipe
--%>

<%@page import="br.cefetmg.inf.model.domain.Avaliacao"%>
<%@page import="br.cefetmg.inf.model.domain.Instrutor"%>
<%@page import="br.cefetmg.inf.model.domain.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="br.cefetmg.inf.model.domain.Objetivo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <title>Alterar avaliação</title>
    </head>
    <body>
        <div class="container">
        <br>
        <h2>Alteração de Avaliação</h2>
        <p>*Medidas de peso em Kg e de medida em Cm.</p>
        <br>

        <form action="ServletWeb" method="post">
            <input type="hidden" name="acao" value="AlterarAvaliacao">
            
            <%
                Usuario usuario = (Usuario) request.getAttribute("usuario");
                Instrutor instrutor = (Instrutor) session.getAttribute("instrutor");
                Avaliacao avaliacao = (Avaliacao) request.getAttribute("avaliacao");
            %>

            <input type = "hidden" name = "codCpfAluno" value="
                   <%= request.setAttribute("codCpfAluno", usuario.getCodCpf()) %>" 
            />
            <input type = "hidden" name = "codCpfInstrutor" value="
                   <%= request.setAttribute("codCpfInstrutor", instrutor.getCodCpf() %>"
            />

            <label for="peso" class="form">Peso: </label>
            <input type="number" name="peso" class="form-control" max="300" min="0" value="<%= avaliacao.getPeso() %>" >
            <br>

            <label for="percentualGordura" class="form">Percentual de gordura: </label>
            <input type="number" name="percentualGordura" class="form-control" max="100" min="0" value="<%= avaliacao.getPercentualGordura() %>">
            <br>

            <label for="massaGorda" class="form">Massa gorda: </label>
            <input type="number" name="massaGorda" class="form-control" max="300" min="0" value="<%= avaliacao.getMassaGorda() %>">
            <br>

            <label for="tamanhoPescoco" class="form">Tamanho do pescoço: </label>
            <input type="number" name="tamanhoPescoco" class="form-control" max="1000" min="0" value="<%= avaliacao.getTamanhoPescoco() %>">
            <br>

            <label for="tamanhoOmbro" class="form">Tamanho do ombro: </label>
            <input type="number" name="tamanhoOmbro" class="form-control" max="10000" min="0" value="<%= avaliacao.getTamanhoOmbro() %>">
            <br>

            <label for="tamanhoTorax" class="form">Tamanho do torax: </label>
            <input type="number" name="tamanhoTorax" class="form-control" max="10000" min="0" value="<%= avaliacao.getTamanhoTorax() %>">
            <br>

            <label for="tamanhoAbdomen" class="form">Tamanho do abdômen: </label>
            <input type="number" name="tamanhoAbdomen" class="form-control" max="10000" min="0" value="<%= avaliacao.getTamanhoAbdomen() %>">
            <br>

            <label for="tamanhoCintura" class="form">Tamanho da cintura: </label>
            <input type="number" name="tamanhoCintura" class="form-control" max="10000" min="0" value="<%= avaliacao.getTamanhoCintura() %>">
            <br>

            <label for="tamanhoQuadril" class="form">Tamanho do quadril: </label>
            <input type="number" name="tamanhoQuadril" class="form-control" max="10000" min="0" value="<%= avaliacao.getTamanhoQuadril() %>">
            <br>

            <label for="tamanhoBracoEsquerdo" class="form">Tamanho do braço esquerdo: </label>
            <input type="number" name="tamanhoBracoEsquerdo" class="form-control" max="10000" min="0" value="<%= avaliacao.getTamanhoBracoEsquerdo() %>">
            <br>

            <label for="tamanhoBracoDireito" class="form">Tamanho do braço direito: </label>
            <input type="number" name="tamanhoBracoDireito" class="form-control" max="10000" min="0" value="<%= avaliacao.getTamanhoBracoDireito() %>">
            <br>

            <label for="tamanhoAnteBracoEsquerdo" class="form">Tamanho do antebraço esquerdo: </label>
            <input type="number" name="tamanhoAnteBracoEsquerdo" class="form-control" max="10000" min="0" value="<%= avaliacao.getTamanhoAntebracoEsquerdo() %>">
            <br>

            <label for="tamanhoAnteBracoDireito" class="form">Tamanho do antebraço direito: </label>
            <input type="number" name="tamanhoAnteBracoDireito" class="form-control" max="10000" min="0" value="<%= avaliacao.getTamanhoAntebracoDireito() %>">
            <br>

            <label for="tamanhoCoxaEsquerda" class="form">Tamanho da coxa esquerda: </label>
            <input type="number" name="tamanhoCoxaEsquerda" class="form-control" max="10000" min="0" value="<%= avaliacao.getTamanhoCoxaEsquerda() %>">
            <br>

            <label for="tamanhoCoxaDireita" class="form">Tamanho da coxa direita: </label>
            <input type="number" name="tamanhoCoxaDireita" class="form-control" max="10000" min="0" value="<%= avaliacao.getTamanhoCoxaDireita() %>">
            <br>

            <label for="tamanhoPanturrilhaEsquerda" class="form">Tamanho da panturrilha esquerda: </label>
            <input type="number" name="tamanhoPanturrilhaEsquerda" class="form-control" max="10000" min="0" value="<%= avaliacao.getTamanhoPanturrilhaEsquerda() %>">
            <br>

            <label for="tamanhoPanturrilhaDireita" class="form">Tamanho da panturrilha direita: </label>
            <input type="number" name="tamanhoPanturrilhaDireita" class="form-control" max="10000" min="0" value="<%= avaliacao.getTamanhoPanturrilhaDireita() %>">
            <br>

            <%
                Objetivo objetivo = new Objetivo();
                List<Objetivo> listaObjetivos = (List) request.getAttribute("objetivos");

                for(int i=0; i<listaObjetivos.size(); i++){
                    objetivo = listaObjetivos.get(i);
            %>

            <input type="checkbox" name="objetivo" value="<%= objetivo.getNomObjetivo() %>">

            <%
                }
            %>

            <input type="submit" name="Alterar" class="btn btn-primary" value="Alterar">
        </form>

            <a href="ListaAvaliacoes.jsp" class="btn btn-primary">Voltar</a>

        </div>
    </body>
</html>
