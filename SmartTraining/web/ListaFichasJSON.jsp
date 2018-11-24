<%-- 
    Document   : ListaFichasJSON
    Created on : 20/09/2018, 09:35:07
    Author     : Aluno
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.inf.model.domain.Ficha"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:array name="listaFichas" var="ficha" items="${fichas}">
    <json:object>
        <json:property name="nroFicha" value="${ficha.numero}"/>
        <json:property name="datFicha" value="${ficha.data}"/>
        <json:property name="codCpfAluno" value="${ficha.cpfAluno}"/>
    </json:object>
</json:array>
