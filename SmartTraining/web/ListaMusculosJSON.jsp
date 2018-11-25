<%-- 
    Document   : ListaExerciciosJSON
    Created on : 18/09/2018, 10:53:18
    Author     : Aluno
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.inf.model.domain.Exercicio"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>


<json:array name="musculos" var="musculo" items="${musculos}">
    <json:property name="numero" value="${musculo.numero}"/>
    <json:array name="exercicios" var="exercicioMusculo" items="${musculo.listaExercicios}">
        <json:object>
            <json:property name="numero" value="${exercicioMusculo.numero}"/>
            <json:property name="nome" value="${exercicioMusculo.nome}"/>
            <json:property name="descricao" value="${exercicioMusculo.descricao}"/>
        </json:object>
    </json:array>
</json:array>
