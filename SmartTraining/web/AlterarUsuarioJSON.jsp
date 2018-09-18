<%-- 
    Document   : AlterarUsuarioJSON
    Created on : 17/09/2018, 09:26:45
    Author     : Felipe
--%>

<%@page import="br.cefetmg.inf.model.domain.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>



<json:object name="usuario">
    <json:property name="codCpf" value="${usuario.codCpf}"/>
    <json:property name="nomUsuario" value="${usuario.nomUsuario}"/>
    <json:property name="idtTipoUsuario" value="${usuario.idtTipoUsuario}"/>
    <json:property name="txtSenha" value="${usuario.txtSenha}"/>
    <json:property name="desEmail" value="${usuario.desEmail}"/>
    <json:property name="datNascimento" value="${usuario.datNascimento}"/>
</json:object>
