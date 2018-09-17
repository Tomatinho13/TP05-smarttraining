<%-- 
    Document   : AlterarAvaliacaoJSON
    Created on : 16/09/2018, 18:42:26
    Author     : Felipe
--%>

<%@page import="br.cefetmg.inf.model.domain.Instrutor"%>
<%@page import="br.cefetmg.inf.model.domain.Avaliacao"%>
<%@page import="br.cefetmg.inf.model.domain.Usuario"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<%
    Usuario usuario = (Usuario) request.getAttribute("aluno");
    Avaliacao avaliacao = (Avaliacao) request.getAttribute("avaliacao");
    Instrutor instrutor = (Instrutor) request.getSession().getAttribute("usuario");
%>

<json:object>
    <json:property name="acao" value="AlterarAvaliacao"/>
    <json:object name="aval">
        
    </json:object>
</json:object>
