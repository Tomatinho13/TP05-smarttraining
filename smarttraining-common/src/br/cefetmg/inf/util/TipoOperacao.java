/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.util;

/**
 *
 * @author gabriel
 */
public enum TipoOperacao {
    PESQ_APARELHO_NUM, PESQ_APARELHO_NOME, LISTA_APARELHO, CAD_APARELHO, ALTERA_APARELHO, EXCLUI_APARELHO,
    
    PESQ_ATIVIDADE, CAD_ATIVIDADE, ALTERA_ATIVIDADE, EXCLUI_ATIVIDADE,
    
    LISTA_AVALIACOES_ALUNO, PESQ_AVALIACAO, CAD_AVALIACAO, ALTERA_AVALIACAO, EXCLUI_AVALIACAO,
    
    PESQ_EXERCICIO_COD, PESQ_EXERCICIO_NOME, PESQ_APARELHOEXERCICIO, LISTA_EXERCICIO_REGIAO, 
    LISTA_EXERCICIO_MUSCULO, LISTA_EXERCICIO, CAD_EXERCICIO, CAD_APARELHOEXERCICIO, ALTERA_EXERCICIO, EXCLUIEXERCICIO,
    
    PESQ_FICHA, LISTA_FICHA_ALUNO, CAD_FICHA, ALTERA_FICHA, EXCLUI_FICHA,
    
    PESQ_MUSCULO, LISTA_MUSCULO, CAD_MUSCULO, ALTERA_MUSCULO, EXCLUI_MUSCULO,
    
    PESQ_OBJETIVO_COD, PESQ_OBJETIVO_NOME, LISTA_OBJETIVO_AVALIACAO, LISTA_OBJETIVO, CAD_OBJETIVO, 
    ALTERA_OBJETIVO, EXCLUI_OBJETIVO,
    
    PESQ_REGCORP, CAD_REGCORP, ALTERA_REGCORP, EXCLUI_REGCORP,
    
    PESQ_TREINO, LISTA_TREINO_FICHA, CAD_TREINO, ALTERA_TREINO, EXCLUI_TREINO,
    
    PESQ_ALUNO_CPF, PESQ_ALUNO_NOME, CAD_ALUNO, LISTA_ALUNO, ALTERA_ALUNO, EXCLUI_ALUNO,
    
    PESQ_INSTRUTOR_CPF, PESQ_INSTRUTOR_NOME, CAD_INSTRUTOR, LISTA_INSTRUTOR, ALTERA_INSTRUTOR, EXCLUI_INSTRUTOR;
}
