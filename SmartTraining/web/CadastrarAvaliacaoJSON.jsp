<%-- 
    Document   : CadastrarAvaliacaoJSON
    Created on : 18/09/2018, 11:29:52
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="alunoCodCpf" value="${aluno.getCodCpf}"/>
    <json:array>
        <json:object>
            <json:property name="codObjetivo" value="${objetivo.getCodCpf}"/>
            <json:property name="desObjetivo" value="${objetivo.desObjetivo}"/>
            <json:property name="nomObjetivo" value="${objetivo.nomObjetivo}"/>
        </json:object>
    </json:array>
</json:object>
