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
            <json:property name="codCpfUsuario" value="${usuario.codCpf}"/>
            <json:property name="nomUsuario" value="${usuario.nomUsuario}"/>
            <json:property name="idtTipoUsuario" value="${usuario.idtTipoUsuario}"/>
            <json:property name="txtSenhaUsuario" value="${usuario.txtSenha}"/>
            <json:property name="desEmailUsuario" value="${usuario.desEmail}"/>
            <json:property name="datNascimentoUsuario" value="${usuario.datNascimento}"/>
        </json:object>
    </json:array>
</json:object>
