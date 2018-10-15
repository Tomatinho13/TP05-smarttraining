<%-- 
    Document   : ListaAvaliacoesJSON
    Created on : 17/09/2018, 17:12:24
    Author     : Aluno
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.inf.model.domain.Avaliacao"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:array name="listaAvaliacoes" var="avaliacao" items="${avaliacoes}">
        <json:object>
            <json:property name="codCpfAluno" value="${avaliacao.cpfAluno}"/>
            <json:property name="datAvaliacao" value="${avaliacao.data}"/>
        </json:object>
    </json:array>
</json:object>
