<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.inf.model.domain.Exercicio"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>


<json:array name="musculos" var="musculo" items="${musculos}">
    <json:property name="numero" value="${musculo.numero}"/>
    <json:array name="exercicios" var="exercicio" items="${musculo.listaExercicios}">
        <json:object>
            <json:property name="numero" value="${exercicio.numero}"/>
            <json:property name="nome" value="${exercicio.nome}"/>
            <json:property name="descricao" value="${exercicio.descricao}"/>
        </json:object>
    </json:array>
</json:array>
