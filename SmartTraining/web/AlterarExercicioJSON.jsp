<%-- 
    Document   : AlterarExercicioJSON
    Created on : 17/09/2018, 09:21:57
    Author     : Felipe
--%>

<%@page import="br.cefetmg.inf.model.domain.Exercicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>



<json:object name="exercicio">
    <json:property name="codExercicio" value="${exercicio.codExercicio}"/>
    <json:property name="nomeExercicio" value="${exercicio.nomeExercicio}"/>
    <json:property name="descricaoExercicio" value="${exercicio.descricaoExercicio}"/>
</json:object>