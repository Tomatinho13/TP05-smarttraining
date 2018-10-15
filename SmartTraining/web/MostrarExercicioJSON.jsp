<%-- 
    Document   : MostrarExercicioJSON
    Created on : 18/09/2018, 09:42:21
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object name="exercicio">
    <json:property name="codExercicio" value="${exercicio.numero}"/>
    <json:property name="nomeExercicio" value="${exercicio.nome}"/>
    <json:property name="descricaoExercicio" value="${exercicio.descricao}"/>
    <json:array name="listaMusculos" var="musculo" items="${exercicio.listaMusculos}">
        <json:object>
        <json:property name="codMusculo" value="${exercicio.numero}"/>
        <json:property name="nomMusculo" value="${exercicio.nome}"/>
        </json:object>
    </json:array>
</json:object>
