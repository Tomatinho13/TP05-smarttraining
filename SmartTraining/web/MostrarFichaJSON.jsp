<%-- 
    Document   : MostrarFichaJSON
    Created on : 18/09/2018, 09:41:54
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="codCpf" value="${ficha.cpfAluno}"/>
    <json:property name="numero" value="${ficha.numero}"/>
    <json:property name="codCpfInstrutor" value="${ficha.cpfInstrutor}"/>
    <json:property name="data" value="${ficha.data}"/>
    <json:property name="dataTroca" value="${ficha.dataTroca}"/>
    <json:array name="treinos" var="treino" items="${ficha.listaTreino}">
        <json:object>
            <json:property name="numero" value="${treino.nroTreino}"/>
            <json:property name="descricao" value="${treino.descricao}"/>
            <json:array name="atividades" var="atividade" items="${treino.atividades}">
                <json:object>
                    <json:property name="nroAparelho" value="${atividade.aparelhoExercicio.aparelho.numero}"/>
                    <json:property name="nomAparelho" value="${atividade.aparelhoExercicio.aparelho.nome}"/>
                    <json:property name="nroExercicio" value="${atividade.aparelhoExercicio.exercicio.numero}"/>
                    <json:property name="nomExercicio" value="${atividade.aparelhoExercicio.exercicio.nome}"/>
                    <json:array name="listaMusculos" var="musculo" items="${atividade.aparelhoExercicio.exercicio.listaMusculos}">
                        <json:object>
                            <json:property name="numero" value="${musculo.numero}"/>
                            <json:property name="nome" value="${musculo.nome}"/>
                        </json:object>
                    </json:array>
                    <json:property name="imgAtividade" value="${atividade.aparelhoExercicio.caminhoImagem}"/>
                    <json:property name="desExercicio" value="${atividade.aparelhoExercicio.exercicio.descricao}"/>
                    <json:property name="qtdPeso" value="${atividade.qtdPeso}"/>
                    <json:property name="nroSeries" value="${atividade.nroSeries}"/>
                    <json:property name="nroRepeticoes" value="${atividade.nroRepeticoes}"/>
                </json:object>
            </json:array>
        </json:object>
    </json:array>
</json:object>