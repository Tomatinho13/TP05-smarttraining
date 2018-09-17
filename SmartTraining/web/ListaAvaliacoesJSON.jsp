<%-- 
    Document   : ListaAvaliacoesJSON
    Created on : 17/09/2018, 17:12:24
    Author     : Aluno
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.inf.model.domain.Avaliacao"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:array name="listaAvaliacoes" var="avaliacao" items="${avaliacoes}">
        <json:object>
            <json:property name="codCpfAluno" value="${avaliacao.codCpfAluno}"/>
            <json:property name="dataAvaliacao" value="${avaliacao.datAvaliacao}"/>
            <json:property name="codCpfInstrutor" value="${avaliacao.codCpfInstrutor}"/>
            <json:property name="peso" value="${avaliacao.peso}"/>
            <json:property name="percentualGordurda" value="${avaliacao.percentualGordura}"/>
            <json:property name="massaGorda" value="${avaliacao.massaGorda}"/>
            <json:property name="tamanhoPescoco" value="${avaliacao.tamanhoPescoco}"/>
            <json:property name="tamanhoOmbro" value="${avaliacao.tamanhoOmbro}"/>
            <json:property name="tamanhoTorax" value="${avaliacao.tamanhoTorax}"/>
            <json:property name="tamanhoAbdomen" value="${avaliacao.tamanhoAbdomen}"/>
            <json:property name="tamanhoCintura" value="${avaliacao.tamanhoCintura}"/>
            <json:property name="tamanhoQuadril" value="${avaliacao.tamanhoQuadril}"/>
            <json:property name="tamanhoBracoEsquerdo" value="${avaliacao.tamanhoBracoEsquerdo}"/>
            <json:property name="tamanhoBracoDireito" value="${avaliacao.tamanhoBracoDireito}"/>
            <json:property name="tamanhoAntebracoEsquerdo" value="${avaliacao.tamanhoAntebracoEsquerdo}"/>
            <json:property name="tamanhoAntebracoDireito" value="${avaliacao.tamanhoAntebracoDireito}"/>
            <json:property name="tamanhoCoxaEsquerda" value="${avaliacao.tamanhoCoxaEsquerda}"/>
            <json:property name="tamanhoCoxaDireita" value="${avaliacao.tamanhoCoxaDireita}"/>
            <json:property name="tamanhoPanturrilhaEsquerda" value="${avaliacao.tamanhoPanturrilhaEsquerda}"/>
            <json:property name="tamanhoPanturrilhaDireita" value="${avaliacao.tamanhoPanturrilhaDireita}"/>
        </json:object>
    </json:array>
</json:object>
