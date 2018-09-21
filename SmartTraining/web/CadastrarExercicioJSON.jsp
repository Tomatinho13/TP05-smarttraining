<%-- 
    Document   : CadastrarExercicioJSON
    Created on : 18/09/2018, 11:29:29
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:array>
        <json:object>
            <json:property name="nroAparelho" value="${aparelho.nroAparelho}"/>
            <json:property name="nomAparelho" value="${aparelho.nomAparelho}"/>
        </json:object>
    </json:array>
    <json:array   name="listamusculos" var="musculo" items="${musculos}">
        <json:object>
            <json:property name="codMusculo" value="${musculo.codMusculo}"/>
            <json:property name="codRegiaoCorporal" value="${musculo.codRegiaoCorporal}"/>
            <json:property name="nomMusculo" value="${musculo.nomMusculo}"/>
            <json:property name="caminhoImagem" value="${musculo.caminhoImagem}"/>
            <json:array name="listaExercicios" var="exercicio" items="${exercicios}">
                <json:object>
                    <json:property name="codExercicio" value="${exercicio.codExercicio}"/>
                    <json:property name="nomeExercicio" value="${exercicio.nomeExercicio}"/>
                    <json:property name="descricaoExercicio" value="${exercicio.descricaoExercicio}"/>
                </json:object>
            </json:array>
        </json:object>
    </json:array>
</json:object>