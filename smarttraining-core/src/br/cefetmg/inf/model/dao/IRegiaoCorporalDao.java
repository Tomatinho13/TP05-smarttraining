/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.RegiaoCorporal;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public interface IRegiaoCorporalDao {

    public RegiaoCorporal getRegiaoCorporal(int codRegiao) throws SQLException;

    public boolean postRegiaoCorporal(RegiaoCorporal regiao, int codMusculo) throws SQLException;

    public boolean putRegiaoCorporal(RegiaoCorporal regiao) throws SQLException;

    public boolean deleteRegiaoCorporal(int codRegiaoCorporal) throws SQLException;

    public void fechaConexao();
}
