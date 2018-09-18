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


<json:object>
    <json:object name="">
        <json:property name="codCpfUsuario" value="${usuario.codCpf}"/>
        <json:property name="nomUsuario" value="${usuario.nomUsuario}"/>
        <json:property name="idtTipoUsuario" value="${usuario.idtTipoUsuario}"/>
        <json:property name="txtSenhaUsuario" value="${usuario.txtSenha}"/>
        <json:property name="desEmailUsuario" value="${usuario.desEmail}"/>
        <json:property name="datNascimentoUsuario" value="${usuario.datNascimento}"/>
    </json:object>
    <json:object>
        <json:property name="codCpfAlunoAvaliacao" value="${avaliacao.codCpfAluno}"/>
        <json:property name="datAvaliacao" value="${avaliacao.datAvaliacao}"/>
        <json:property name="codCpfInstrutor" value="${avaliacao.codCpfInstrutor}"/>
        <json:property name="idtRecencia" value="${avaliacao.idtRecencia}"/>
        <json:property name="peso" value="${avaliacao.peso}"/>
        <json:property name="percentualGordura" value="${avaliacao.percentualGordura}"/>
        <json:property name="tamanhoPescoco" value="${avaliacao.tamanhoPescoco}"/>
        <json:property name="tamanhoOmbro" value="${avaliacao.tamanhoOmbro}"/>
        <json:property name="tamanhoTorax" value="${avaliacao.tamanhoTorax}"/>
        <json:property name="tamanhoAbdomen" value="${avaliacao.tamanhoAbdomen}"/>
        <json:property name="tamanhoCintura" value="${avaliacao.tamanhoCintura}"/>
        <json:property name="tamanhoQuadril" value="${avaliacao.tamanhoQuadril}"/>
        <json:property name="massaGorda" value="${avaliacao.massaGorda}"/>
        <json:property name="tamanhoBracoEsquerdo" value="${avaliacao.tamanhoBracoEsquerdo}"/>
        <json:property name="tamanhoBracoDireito" value="${avaliacao.tamanhoBracoDireito}"/>
        <json:property name="tamanhoAntebracoEsquerdo" value="${avaliacao.tamanhoAntebracoEsquerdo}"/>
        <json:property name="tamanhoAntebracoDireito" value="${avaliacao.tamanhoAntebracoDireito}"/>
        <json:property name="tamanhoCoxaEsquerda" value="${avaliacao.tamanhoCoxaEsquerda}"/>
        <json:property name="tamanhoCoxaDireita" value="${avaliacao.tamanhoCoxaDireita}"/>
        <json:property name="tamanhoPanturrilhaEsquerda" value="${avaliacao.tamanhoPanturrilhaEsquerda}"/>
        <json:property name="tamanhoPanturrilhaDireita" value="${avaliacao.tamanhoPanturrilhaDireita}"/>
        <json:array var="objetivo" items="${avaliacao.listaObjetivos}">
            <json:object>
                <json:property name="codObjetivo" value="${objetivo.codObjetivo}"/>
                <json:property name="nomObjetivo" value="${objetivo.nomObjetivo}"/>
                <json:property name="desObjetivo" value="${objetivo.desObjetivo}"/>
            </json:object>
        </json:array>
    </json:object>
</json:object>
