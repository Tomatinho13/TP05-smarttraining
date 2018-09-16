<%-- 
    Document   : AlterarAvaliacaoJSON
    Created on : 16/09/2018, 18:42:26
    Author     : Felipe
--%>

<%@page import="br.cefetmg.inf.model.domain.Instrutor"%>
<%@page import="br.cefetmg.inf.model.domain.Avaliacao"%>
<%@page import="br.cefetmg.inf.model.domain.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<%
    Usuario usuario = (Usuario) request.getAttribute("aluno");
    Avaliacao avaliacao = (Avaliacao) request.getAttribute("avaliacao");
    Instrutor instrutor = (Instrutor) request.getSession().getAttribute("usuario");
%>

<json:object>
    <json:property name="acao" value="AlterarAvaliacao"/>
    <json:property name="codCpfAluno" value="${ususario.getCodCpf()}"/>
    <json:property name="dataAvaliacao" value="${avaliacao.getDatAvaliacao()}"/>
    <json:property name="codCpfInstrutor" value="${instrutor.getCodCpf()}"/>
    <json:property name="peso" value="${avaliacao.getPeso()}"/>
    <json:property name="percentualGordurda" value="${avaliacao.getPercentualGordura()}"/>
    <json:property name="massaGorda" value="${avaliacao.getMassaGorda()}"/>
    <json:property name="tamanhoPescoco" value="${avaliacao.getTamanhoPescoco()}"/>
    <json:property name="tamanhoOmbro" value="${avaliacao.getTamanhoOmbro()}"/>
    <json:property name="tamanhoTorax" value="${avaliacao.getTamanhoTorax()}"/>
    <json:property name="tamanhoAbdomen" value="${avaliacao.getTamanhoAbdomen()}"/>
    <json:property name="tamanhoCintura" value="${avaliacao.getTamanhoCintura()}"/>
    <json:property name="tamanhoQuadril" value="${avaliacao.getTamanhoQuadril()}"/>
    <json:property name="tamanhoBracoEsquerdo" value="${avaliacao.getTamanhoBracoEsquerdo()}"/>
    <json:property name="tamanhoBracoDireito" value="${avaliacao.getTamanhoBracoDireito()}"/>
    <json:property name="tamanhoAntebracoEsquerdo" value="${avaliacao.getTamanhoAntebracoEsquerdo()}"/>
    <json:property name="tamanhoAntebracoDireito" value="${avaliacao.getTamanhoAntebracoDireito()}"/>
    <json:property name="tamanhoCoxaEsquerda" value="${avaliacao.getTamanhoCoxaEsquerda()}"/>
    <json:property name="tamanhoCoxaDireita" value="${avaliacao.getTamanhoCoxaDireita()}"/>
    <json:property name="tamanhoPanturrilhaEsquerda" value="${avaliacao.getTamanhoPanturrilhaEsquerda()}"/>
    <json:property name="tamanhoPanturrilhaDireita" value="${avaliacao.getTamanhoPanturrilhaDireita()}"/>
</json:object>
