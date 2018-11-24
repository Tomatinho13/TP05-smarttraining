<%@page import="java.util.ArrayList"%>
<%@page import="br.cefetmg.inf.model.domain.DiaTreino"%>
<%@page contentType="text/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:array name="diaTreinos" var="diaTreino" items="${diaTreinos}">
    <json:object>
        <json:property name="nroTreino" value="${diaTreino.aividade.nroTreino}"/>
        <json:property name="nroAparelho" value="${diaTreino.atividade.aparelhoExercicio.aparelho.numero}"/>
        <json:property name="nomAparelho" value="${diaTreino.atividade.aparelhoExercicio.aparelho.nome}"/>
        <json:property name="nroExercicio" value="${diaTreino.atividade.aparelhoExercicio.exercicio.numero}"/>
        <json:property name="nomExercicio" value="${diaTreino.atividade.aparelhoExercicio.exercicio.nome}"/>
        <json:array name="musculos" var="musculo" items="${diaTreino.atividade.aparelhoExercicio.exercicio.listaMusculos}">
            <json:object>
                <json:property name="numero" value="${musculo.numero}"/>
                <json:property name="nome" value="${musculo.nome}"/>
            </json:object>
        </json:array>
        <json:property name="imgAtividade" value="${diaTreino.atividade.aparelhoExercicio.caminhoImagem}"/>
        <json:property name="desExercicio" value="${diaTreino.atividade.aparelhoExercicio.exercicio.descricao}"/>
        <json:property name="qtdPeso" value="${diaTreino.atividade.qtdPeso}"/>
        <json:property name="nroSeries" value="${diaTreino.atividade.nroSeries}"/>
        <json:property name="nroRepeticoes" value="${diaTreino.atividade.nroRepeticoes}"/>
        <json:property name="data" value="${diaTreino.data}"/>
    </json:object>
</json:array>
