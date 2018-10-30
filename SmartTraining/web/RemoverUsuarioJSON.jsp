<%-- 
    Document   : RemoverUsuarioJSON
    Created on : 18/09/2018, 09:41:03
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:array name="usuarios" var="usuario" items="${usuarios}">
        <json:object>
            <json:property name="codCpf" value="${usuario.cpf}"/>
            <json:property name="nomUsuario" value="${usuario.nome}"/>
            <json:property name="idtTipoUsuario" value="${usuario.tipo}"/>
            <json:property name="desEmailUsuario" value="${usuario.email}"/>
            <json:property name="datNascimentoUsuario" value="${usuario.dataNascimento}"/>
        </json:object>
    </json:array>
</json:object>
