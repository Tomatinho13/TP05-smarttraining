<%-- 
    Document   : CadastrarAvaliacaoJSON
    Created on : 18/09/2018, 11:29:52
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="codCpf" value="${aluno.cpf}"/>
    <json:array name="objetivos" var="objetivo" items="${objetivos}">
        <json:object>
            <json:property name="codigo" value="${objetivo.codigo}"/>
            <json:property name="descricao" value="${objetivo.descricao}"/>
            <json:property name="nome" value="${objetivo.nome}"/>
        </json:object>
    </json:array>
</json:object>
