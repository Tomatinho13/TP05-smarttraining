<%-- 
    Document   : MostrarUsuarioJSON
    Created on : 18/09/2018, 09:41:34
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="cref" value="${usuario.nroCref}"/>
    <json:property name="cpf" value="${usuario.cpf}"/>
    <json:property name="nome" value="${usuario.nome}"/>
    <json:property name="tipo" value="${usuario.tipo}"/>
    <json:property name="email" value="${usuario.email}"/>
    <json:property name="senha" value="${usuario.senha}"/>
    <json:property name="dataNascimento" value="${usuario.dataNascimento}"/>
</json:object>
