<%-- 
    Document   : MostrarUsuarioJSON
    Created on : 18/09/2018, 09:41:34
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="codCpf" value="${usuario.cpf}"/>
    <json:property name="nomUsuario" value="${usuario.nome}"/>
    <json:property name="idtTipoUsuario" value="${usuario.tipo}"/>
    <json:property name="desEmailUsuario" value="${usuario.email}"/>
    <json:property name="senha" value="${usuario.senha}"/>
    <json:property name="datNascimentoUsuario" value="${usuario.dataNascimento}"/>
</json:object>
