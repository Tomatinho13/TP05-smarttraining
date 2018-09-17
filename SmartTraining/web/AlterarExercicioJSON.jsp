<%-- 
    Document   : AlterarExercicioJSON
    Created on : 17/09/2018, 09:21:57
    Author     : Felipe
--%>

<%@page import="br.cefetmg.inf.model.domain.Exercicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<%
    Exercicio exercicio = (Exercicio) request.getAttribute("exercicio");
%>

<json:object>
    <json:property name="acao" value="AlterarExercicio"/>
    <json:object name="exercise">
        <json:property name="codExercicio" value="${exercicio.getCodExercicio()}"/>
        <json:property name="nomeExercicio" value="${exercicio.getNomeExercicio()}"/>
        <json:property name="descExercicio" value="${exercicio.getDescricaoExercicio()}"/>
    </json:object>
</json:object>