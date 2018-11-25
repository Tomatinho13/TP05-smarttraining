<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="numero" value="${musculo.numero}"/>
    <json:property name="nome" value="${musculo.nome}"/>
    <json:array name="exercicios" var="exercicio" items="${musculo.exercicios}">
        <json:object>
            <json:property name="numero" value="${exercicio.numero}"/>
            <json:property name="nome" value="${exercicio.nome}"/>
            <json:property name="descricao" value="${exercicio.descricao}"/>
        </json:object>
    </json:array>
</json:object>
