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
    <json:object name="aluno">
        <json:property name="codCpf" value="${usuario.cpf}"/>
        <json:property name="nomUsuario" value="${usuario.nome}"/>
        <json:property name="idtTipoUsuario" value="${usuario.tipo}"/>
        <json:property name="txtSenhaUsuario" value="${usuario.senha}"/>
        <json:property name="desEmailUsuario" value="${usuario.email}"/>
        <json:property name="datNascimentoUsuario" value="${usuario.dataNascimento}"/>
    </json:object>
    <json:object name="avaliacao">
        <json:property name="codCpfAluno" value="${avaliacao.cpfAluno}"/>
        <json:property name="datAvaliacao" value="${avaliacao.data}"/>
        <json:property name="codCpfInstrutor" value="${avaliacao.cpfInstrutor}"/>
        <json:property name="idtRecencia" value="${avaliacao.recencia}"/>
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
        <json:array name="listaObjetivos" var="objetivo" items="${avaliacao.listaObjetivos}">
            <json:object>
                <json:property name="codObjetivo" value="${objetivo.codigo}"/>
                <json:property name="nomObjetivo" value="${objetivo.nome}"/>
                <json:property name="desObjetivo" value="${objetivo.descricao}"/>
            </json:object>
        </json:array>
    </json:object>
</json:object>
