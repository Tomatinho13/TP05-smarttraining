<%-- 
    Document   : MostrarExercicioJSON
    Created on : 18/09/2018, 09:42:21
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object name="exercicio">
    <json:property name="numero" value="${exercicio.numero}"/>
    <json:property name="nome" value="${exercicio.nome}"/>
    <json:property name="descricao" value="${exercicio.descricao}"/>
    <json:array name="musculos" var="musculo" items="${exercicio.listaMusculos}">
        <json:object>
        <json:property name="numero" value="${musculo.numero}"/>
        <json:property name="nome" value="${musculo.nome}"/>
        </json:object>
    </json:array>
</json:object>
