<%--
    Document   : MostarAvaliacao
    Created on : 29/07/2018, 00:24:47
    Author     : Felipe
--%>

<%@page import="br.cefetmg.inf.model.domain.Avaliacao" %>
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
            <h2>Avaliação</h2>
            <br>

            <table class="table table-hover">
                <tr>
                    <td>Peso:</td>
                </tr>
                <tr>
                    <td>Percentual de gordura:</td>
                </tr>
                <tr>
                    <td>Massa gorda:</td>
                </tr>
                <tr>
                    <td>Tamanho do pescoço:</td>
                </tr>
                <tr>
                    <td>Tamanho do ombro:</td>
                </tr>
                <tr>
                    <td>Tamanho do torax:</td>
                </tr>
                <tr>
                    <td>Tamanho do abdômen:</td>
                </tr>
                <tr>
                    <td>Tamanho da cintura:</td>
                </tr>
                <tr>
                    <td>Tamanho do braço esquerdo:</td>
                </tr>
                <tr>
                    <td>Tamanho do braço direito:</td>
                </tr>
                <tr>
                    <td>Tamanho do antebraço esquerdo:</td>
                </tr>
                <tr>
                    <td>Tamanho do antebraço direito:</td>
                </tr>
                <tr>
                    <td>Tamanho da coxa esquerda:</td>
                </tr>
                <tr>
                    <td>Tamanho da coxa direita:</td>
                </tr>
                <tr>
                    <td>Tamanho da panturrilha esquerda:</td>
                </tr>
                <tr>
                    <td>Tamanho da panturrilha direita:</td>
                </tr>

                <%
                    Avaliacao avaliacao = new Avaliacao();
                    avaliacao = request.getParameter("avaliacao");
                %>

                <tr>
                    <td> <%=avaliacao.getPeso() %> </td>
                </tr>
                <tr>
                    <td> <%=avaliacao.getPercentualGordura() %> </td>
                </tr>
                <tr>
                    <td> <%=avaliacao.getMassaGorda() %> </td>
                </tr>
                <tr>
                    <td> <%=avaliacao.getTamanhoPescoco() %> </td>
                </tr>
                <tr>
                    <td> <%=avaliacao.getTamanhoOmbro() %> </td>
                </tr>
                <tr>
                    <td> <%=avaliacao.getTamanhoTorax() %> </td>
                </tr>
                <tr>
                    <td> <%=avaliacao.getTamanhoAbdomen() %> </td>
                </tr>
                <tr>
                    <td> <%=avaliacao.getTamanhoCintura() %> </td>
                </tr>
                <tr>
                    <td> <%=avaliacao.getTamanhoBracoEsquerdo() %> </td>
                </tr>
                <tr>
                    <td> <%=avaliacao.getTamanhoBracoDireito() %> </td>
                </tr>
                <tr>
                    <td> <%=avaliacao.getTamanhoAntebracoEsquerdo() %> </td>
                </tr>
                <tr>
                    <td> <%=avaliacao.getTamanhoAntebracoDireito() %> </td>
                </tr>
                <tr>
                    <td> <%=avaliacao.getTamanhoCoxaEsquerda() %> </td>
                </tr>
                <tr>
                    <td> <%=avaliacao.getTamanhoCoxaDireita() %> </td>
                </tr>
                <tr>
                    <td> <%=avaliacao.getTamanhoPanturrilhaEsquerda() %> </td>
                </tr>
                <tr>
                    <td> <%=avaliacao.getTamanhoPanturrilhaDireita() %> </td>
                </tr>
            </table>

            <form action="ListaAvaliacoes.jsp">
                <input type="submit" name="Voltar" value="Voltar">
            </form>
        </div>
    </body>
</html>
