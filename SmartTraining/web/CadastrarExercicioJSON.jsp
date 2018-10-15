<%-- 
    Document   : CadastrarExercicioJSON
    Created on : 18/09/2018, 11:29:29
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:array name="listaAparelhos" var="aparelho" items="${aparelhos}">
        <json:object>
            <json:property name="nroAparelho" value="${aparelho.numero}"/>
            <json:property name="nomAparelho" value="${aparelho.nome}"/>
        </json:object>
    </json:array>
    <json:array name="listaMusculos" var="musculo" items="${musculos}">
        <json:object>
            <json:property name="codMusculo" value="${musculo.numero}"/>
            <json:property name="codRegiaoCorporal" value="${musculo.codRegiaoCorporal}"/>
            <json:property name="nomMusculo" value="${musculo.nome}"/>
            <json:property name="caminhoImagem" value="${musculo.caminhoImagem}"/>
        </json:object>
    </json:array>
</json:object>