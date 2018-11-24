package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.RegiaoCorporal;
import java.sql.SQLException;

/**
 *
 * @author Jamalz
 */
public interface IManterRegiaoCorporal {

    public RegiaoCorporal pesquisarRegiaoCorporal(int codRegiao) throws SQLException;

    public boolean cadastrar(RegiaoCorporal regiaoCorporal, int codMusculo) throws SQLException;

    public boolean alterar(RegiaoCorporal regiaoCorporal) throws SQLException;

    public boolean excluir(int codRegiao) throws SQLException;
}
