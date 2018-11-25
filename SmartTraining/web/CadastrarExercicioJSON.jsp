<%-- 
    Document   : CadastrarExercicioJSON
    Created on : 18/09/2018, 11:29:29
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:array name="aparelhos" var="aparelho" items="${aparelhos}">
        <json:object>
            <json:property name="numero" value="${aparelho.numero}"/>
            <json:property name="nome" value="${aparelho.nome}"/>
        </json:object>
    </json:array>
    <json:array name="musculos" var="musculo" items="${musculos}">
        <json:object>
            <json:property name="numero" value="${musculo.numero}"/>
            <json:property name="codRegiaoCorporal" value="${musculo.codRegiaoCorporal}"/>
            <json:property name="nome" value="${musculo.nome}"/>
            <json:property name="caminhoImagem" value="${musculo.caminhoImagem}"/>
        </json:object>
    </json:array>
</json:object>