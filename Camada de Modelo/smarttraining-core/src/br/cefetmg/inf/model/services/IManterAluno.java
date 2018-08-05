package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;

public interface IManterAluno {

    public Usuario pesquisarPorCpf(String codCpf) throws SQLException;

    public void cadastrar(Usuario aluno) throws SQLException;

    public void alterar(Usuario aluno) throws SQLException;

    public void excluir(String codCpf) throws SQLException;
}
