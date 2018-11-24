<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:array name="aparelhos" var="aparelho" items="${aparelhos}">
    <json:object>
        <json:property name="numero" value="${aparelho.numero}"/>
        <json:property name="nome" value="${aparelho.nome}"/>
        <json:array name="exercicios" var="exercicio" items="${aparelho.exercicios}">
            <json:object>
                <json:property name="numero" value="${exercicio.numero}"/>
                <json:property name="nome" value="${exercicio.nome}"/>
                <json:property name="descricao" value="${exercicio.descricao}"/>
                <json:array name="musculos" var="musculo" items="${exercicio.listaMusculos}">
                    <json:object>
                        <json:property name="numero" value="${musculo.numero}"/>
                        <json:property name="codRegiaoCorporal" value="${musculo.codRegiaoCorporal}"/>
                        <json:property name="nome" value="${musculo.nome}"/>
                    </json:object>
                </json:array>
            </json:object>
        </json:array>
    </json:object>
</json:array>
