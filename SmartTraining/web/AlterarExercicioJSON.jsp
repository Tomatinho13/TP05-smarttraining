<%-- 
    Document   : AlterarExercicioJSON
    Created on : 17/09/2018, 09:21:57
    Author     : Felipe
--%>

<%@page import="br.cefetmg.inf.model.domain.Exercicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>



<json:object name="exercicio">
    <json:property name="numero" value="${exercicio.numero}"/>
    <json:property name="nome" value="${exercicio.nome}"/>
    <json:property name="descricao" value="${exercicio.descricao}"/>
    <json:array name="musculos" var="musculo" items="${exercicio.listaMusculos}">
        <json:object>
        <json:property name="numero" value="${exercicio.numero}"/>
        <json:property name="nome" value="${exercicio.nome}"/>
        </json:object>
    </json:array>
</json:object>