<%-- 
    Document   : CadastrarAvaliacaoJSON
    Created on : 18/09/2018, 11:29:52
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="codCpfAluno" value="${aluno.cpf}"/>
    <json:array name="listaObjetivos" var="objetivo" items="${objetivos}">
        <json:object>
            <json:property name="codObjetivo" value="${objetivo.codigo}"/>
            <json:property name="desObjetivo" value="${objetivo.descricao}"/>
            <json:property name="nomObjetivo" value="${objetivo.nome}"/>
        </json:object>
    </json:array>
</json:object>
