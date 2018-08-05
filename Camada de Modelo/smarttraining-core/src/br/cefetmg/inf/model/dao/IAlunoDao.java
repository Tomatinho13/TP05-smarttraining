package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jamalz
 */
public interface IAlunoDao {
    public Usuario getAluno(String codCpf) throws SQLException;
    public Usuario getAlunoPeloNome (String nome) throws SQLException;
    public ArrayList <Usuario> listarTodos () throws SQLException;
    public void postAluno(Usuario aluno)throws SQLException;
    public void putAluno(Usuario aluno) throws SQLException;
    public void deleteAluno(String codCpf) throws SQLException;
}
