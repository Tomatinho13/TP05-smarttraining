<%-- 
    Document   : MostrarExercicioJSON
    Created on : 18/09/2018, 09:42:21
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="codExercicio" value="${exercicio.codExercicio}"/>
    <json:property name="nomeExercicio" value="${exercicio.nomeExercicio}"/>
    <json:property name="descricaoExercicio" value="${exercicio.descricaoExercicio}"/>
</json:object>
