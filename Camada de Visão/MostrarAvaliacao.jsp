<%--
    Document   : MostarAvaliacao
    Created on : 29/07/2018, 00:24:47
    Author     : Felipe
--%>

<%@page import="model.classes.Avaliacao" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Avaliação</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2>Avaliação</h2>
            <br>

            <table>
                <tr>
                    <td>Peso:</td>
                    <td>Percentual de gordura:</td>
                    <td>Massa gorda:</td>
                    <td>Tamanho do pescoço:</td>
                    <td>Tamanho do ombro:</td>
                    <td>Tamanho do torax:</td>
                    <td>Tamanho do abdômen:</td>
                    <td>Tamanho da cintura:</td>
                    <td>Tamanho do braço esquerdo:</td>
                    <td>Tamanho do braço direito:</td>
                    <td>Tamanho do antebraço esquerdo:</td>
                    <td>Tamanho do antebraço direito:</td>
                    <td>Tamanho da coxa esquerda:</td>
                    <td>Tamanho da coxa direita:</td>
                    <td>Tamanho da panturrilha esquerda:</td>
                    <td>Tamanho da panturrilha direita:</td>
                </tr>

                <%
                    Avaliacao avaliacao = new Avaliacao();
                    avaliacao = request.getParameter("avaliacao");
                %>

                <tr>
                    <td> <%=avaliacao.getPeso() %> </td>
                    <td> <%=avaliacao.getPercentualGordura() %> </td>
                    <td> <%=avaliacao.getMassaGorda() %> </td>
                    <td> <%=avaliacao.getTamanhoPescoco() %> </td>
                    <td> <%=avaliacao.getTamanhoOmbro() %> </td>
                    <td> <%=avaliacao.getTamanhoTorax() %> </td>
                    <td> <%=avaliacao.getTamanhoAbdomen() %> </td>
                    <td> <%=avaliacao.getTamanhoCintura() %> </td>
                    <td> <%=avaliacao.getTamanhoBracoEsquerdo() %> </td>
                    <td> <%=avaliacao.getTamanhoBracoDireito() %> </td>
                    <td> <%=avaliacao.getTamanhoAnteBracoEsquerdo() %> </td>
                    <td> <%=avaliacao.getTamanhoAnteBracoDireito() %> </td>
                    <td> <%=avaliacao.getTamanhoCoxaEsquerda() %> </td>
                    <td> <%=avaliacao.getTamanhoCoxaDireita() %> </td>
                    <td> <%=avaliacao.getTamanhoPanturrilhaEsquerda() %> </td>
                    <td> <%=avaliacao.getTamanhoPanturrilhaDireita() %> </td>
                </tr>
            </table>

            <form action="ListaAvaliacoes.jsp">
                <input type="submit" name="Voltar" value="Voltar">
            </form>
        </div>
    </body>
</html>
