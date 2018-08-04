/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.domain.RegiaoCorporal;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public interface IRegiaoCorporalDao {
    public RegiaoCorporal getRegiaoCorporal(String codRegiao) throws SQLException;
    public ArrayList<Exercicio> getRegiaoExercicios(String nomRegiao) throws SQLException;
    public void postRegiaoCorporal(RegiaoCorporal regiao, String seqMusculo) throws SQLException;
    public void putRegiaoCorporal(RegiaoCorporal regiao) throws SQLException;
    public void deleteRegiaoCorporal(String codRegiaoCorporal) throws SQLException;
}
