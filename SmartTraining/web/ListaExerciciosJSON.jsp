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
    <json:array name="listaMusculos" var="musculo" items="${musculos}">
        <json:property name="codMusculo" value="${musculo.numero}"/>
        <json:array name="listaExercicios" var="exercicioMusculo" items="${musculo.listaExercicios}">
            <json:object>
                <json:property name="codExercicio" value="${exercicioMusculo.numero}"/>
                <json:property name="nomeExercicio" value="${exercicioMusculo.nome}"/>
                <json:property name="descricaoExercicio" value="${exercicioMusculo.descricao}"/>
            </json:object>
        </json:array>
    </json:array>
</json:object>
