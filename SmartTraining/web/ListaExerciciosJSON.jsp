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
    <json:array name="listaExercicios" var="exercicio" items="${exercicios}">
        <json:object>
            <json:property name="codExercicio" value="${exercicio.numero}"/>
            <json:property name="nomeExercicio" value="${exercicio.nome}"/>
            <json:property name="descricaoExercicio" value="${exercicio.descricao}"/>
                <json:array name="listaMusculos" var="musculo" items="${exercicios.listaMusculos}">
                    <json:property name="codMusculo" value="${musculo.numero}"/>
                    <json:property name="nomeMusculo" value="${exercicio.nome}"/>
                    <json:property name="codRegiaoCorp" value="${exercicio.codRegiaoCorporal}"/>
                    <json:property name="imagemMusculo" value="${exercicio.caminhoImagem}"/>
                    <json:array name="listaExercicios" var="exercicioMusculo" items="${musculo.listaExercicios}">
                        <json:object>
                            <json:property name="codExercicio" value="${exercicioMusculo.numero}"/>
                            <json:property name="nomeExercicio" value="${exercicioMusculo.nome}"/>
                            <json:property name="descricaoExercicio" value="${exercicioMusculo.descricao}"/>
                        </json:object>
                    </json:array>
                </json:array>
        </json:object>
    </json:array>
</json:object>
