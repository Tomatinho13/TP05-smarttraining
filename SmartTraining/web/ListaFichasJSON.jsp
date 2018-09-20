<%-- 
    Document   : ListaFichasJSON
    Created on : 20/09/2018, 09:35:07
    Author     : Aluno
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.inf.model.domain.Ficha"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:array name="listaFichas" var="ficha" items="${exercicios}">
        <json:object>
            <json:property name="" value=""/>
            <json:property name="" value=""/>
            <json:property name="" value=""/>
        </json:object>
    </json:array>
</json:object>
