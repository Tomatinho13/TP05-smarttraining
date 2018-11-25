<%-- 
    Document   : AlterarUsuarioJSON
    Created on : 17/09/2018, 09:26:45
    Author     : Felipe
--%>

<%@page import="br.cefetmg.inf.model.domain.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>



<json:object name="usuario">
    <json:property name="cpf" value="${usuario.cpf}"/>
    <json:property name="nome" value="${usuario.nome}"/>
    <json:property name="idtTipoUsuario" value="${usuario.tipo}"/>
    <json:property name="senha" value="${usuario.senha}"/>
    <json:property name="email" value="${usuario.email}"/>
    <json:property name="dataNascimento" value="${usuario.dataNascimento}"/>
</json:object>
