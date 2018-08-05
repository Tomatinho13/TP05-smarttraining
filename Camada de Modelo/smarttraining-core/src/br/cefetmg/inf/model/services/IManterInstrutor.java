package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Instrutor;
import java.sql.SQLException;

public interface IManterInstrutor {

    public Instrutor pesquisarPorCpf(String codCpf) throws SQLException;

    public void cadastrar(Instrutor instrutor) throws SQLException;

    public void alterar(Instrutor instrutor) throws SQLException;

    public void excluir(String codCpf) throws SQLException;
}
