<%-- 
    Document   : AlterarUsuarioJSON
    Created on : 17/09/2018, 09:26:45
    Author     : Felipe
--%>

<%@page import="br.cefetmg.inf.model.domain.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
%>

<json:object>
    <json:property name="acao" value="AlterarUsuario"/>
    <json:object name="user">
        <json:property name="nome" value="${usuario.getNomUsuario()}"/>
        <json:property name="senha" value="${usuario.getSenha()}"/>
        <json:property name="cpf" value="${usuario.getCodCpf()}"/>
        <json:property name="email" value="${usuario.getDesEmail}"/>
        <json:property name="datNasc" value="${usuario.getDatNascimento()}"/>
    </json:object>
</json:object>
