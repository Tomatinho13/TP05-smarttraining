
<%-- 
    Document   : RemoverExercicioJSON
    Created on : 18/09/2018, 09:41:19
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:array name="exercicios" var="exercicio" items="${exercicios}">
        <json:object>
            <json:property name="numero" value="${exercicio.numero}"/>
            <json:property name="nome" value="${exercicio.nome}"/>
            <json:property name="descricao" value="${exercicio.descricao}"/>
        </json:object>
    </json:array>
</json:object>
