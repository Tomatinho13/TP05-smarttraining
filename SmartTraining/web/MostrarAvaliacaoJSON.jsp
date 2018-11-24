<%-- 
    Document   : MostrarAvaliacaoJSON
    Created on : 18/09/2018, 10:26:22
    Author     : Augusto
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.inf.model.domain.Avaliacao"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object name="avaliacao">
    <json:property name="codCpf" value="${avaliacao.cpfAluno}"/>
    <json:property name="data" value="${avaliacao.data}"/>
    <json:property name="codCpfInstrutor" value="${avaliacao.cpfInstrutor}"/>
    <json:property name="peso" value="${avaliacao.peso}"/>
    <json:property name="percentualGordura" value="${avaliacao.percentualGordura}"/>
    <json:property name="tamanhoPescoco" value="${avaliacao.tamanhoPescoco}"/>
    <json:property name="tamanhoOmbro" value="${avaliacao.tamanhoOmbro}"/>
    <json:property name="tamanhoTorax" value="${avaliacao.tamanhoTorax}"/>
    <json:property name="tamanhoAbdomen" value="${avaliacao.tamanhoAbdomen}"/>
    <json:property name="tamanhoCintura" value="${avaliacao.tamanhoCintura}"/>
    <json:property name="tamanhoQuadril" value="${avaliacao.tamanhoQuadril}"/>
    <json:property name="massaGorda" value="${avaliacao.massaGorda}"/>
    <json:property name="tamanhoBracoEsquerdo" value="${avaliacao.tamanhoBracoEsquerdo}"/>
    <json:property name="tamanhoBracoDireito" value="${avaliacao.tamanhoBracoDireito}"/>
    <json:property name="tamanhoAntebracoEsquerdo" value="${avaliacao.tamanhoAntebracoEsquerdo}"/>
    <json:property name="tamanhoAntebracoDireito" value="${avaliacao.tamanhoAntebracoDireito}"/>
    <json:property name="tamanhoCoxaEsquerda" value="${avaliacao.tamanhoCoxaEsquerda}"/>
    <json:property name="tamanhoCoxaDireita" value="${avaliacao.tamanhoCoxaDireita}"/>
    <json:property name="tamanhoPanturrilhaEsquerda" value="${avaliacao.tamanhoPanturrilhaEsquerda}"/>
    <json:property name="tamanhoPanturrilhaDireita" value="${avaliacao.tamanhoPanturrilhaDireita}"/>
    <json:array name="objetivos" var="objetivo" items="${avaliacao.listaObjetivos}">
        <json:object>
            <json:property name="codigo" value="${objetivo.codigo}"/>
            <json:property name="nome" value="${objetivo.nome}"/>
            <json:property name="descricao" value="${objetivo.descricao}"/>
        </json:object>
    </json:array>
</json:object>