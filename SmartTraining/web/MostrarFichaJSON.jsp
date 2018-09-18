<%-- 
    Document   : MostrarFichaJSON
    Created on : 18/09/2018, 09:41:54
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="codCpfAluno" value="${ficha.codCpfAluno}"/>
    <json:property name="nroFicha" value="${ficha.nroFicha}"/>
    <json:property name="codCpfInstrutor" value="${ficha.codCpfInstrutor}"/>
    <json:property name="dataFicha" value="${ficha.dataFicha}"/>
    <json:property name="dataPrevistaTroca" value="${ficha.dataPrevistaTroca}"/>
    <json:property name="idtTreino" value="${ficha.idtTreino}"/>
    <json:property name="listaTreino" value="${ficha.listaTreino}"/>
</json:object>
