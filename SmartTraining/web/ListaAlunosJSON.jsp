<%-- 
    Document   : ListaAvaliacoesJSON
    Created on : 17/09/2018, 17:12:24
    Author     : Jamalz
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.inf.model.domain.Avaliacao"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:array name="listaAlunos" var="aluno" items="${alunos}">
        <json:object>
            <json:property name="codCpfAluno" value="${aluno.cpf}"/>
            <json:property name="dataAvaliacao" value="${aluno.nome}"/>
        </json:object>
    </json:array>
</json:object>
