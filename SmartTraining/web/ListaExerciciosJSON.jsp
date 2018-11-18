<%-- 
    Document   : ListaExerciciosJSON
    Created on : 18/09/2018, 10:53:18
    Author     : Aluno
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.inf.model.domain.Exercicio"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:array name="listaExercicios" var="exercicio" items="${exercicios}">
        <json:property name="numero" value="${exercicio.numero}"/>
        <json:property name="nome" value="${exercicio.nome}"/>
        <json:property name="descricao" value="${exercicio.descricao}"/>
        <json:array name="listaMusculos" var="musculo" items="${exercicio.listaMusculos}">
            <json:object>
                <json:property name="numero" value="${musculo.numero}"/>
                <json:property name="codRegiaoCorporal" value="${musculo.codRegiaoCorporal}"/>
                <json:property name="nome" value="${musculo.nome}"/>
            </json:object>
        </json:array>
    </json:array>
</json:object>
