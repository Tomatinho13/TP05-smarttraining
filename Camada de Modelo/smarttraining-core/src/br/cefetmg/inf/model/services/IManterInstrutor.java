package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Instrutor;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IManterInstrutor {

    public Instrutor pesquisarPorCpf(String codCpf) throws SQLException;

    public ArrayList<Instrutor> pesquisarTodos() throws SQLException;

    public void cadastrar(Instrutor instrutor) throws SQLException;

    public void alterar(Instrutor instrutor) throws SQLException;

    public void excluir(String codCpf) throws SQLException;
}
