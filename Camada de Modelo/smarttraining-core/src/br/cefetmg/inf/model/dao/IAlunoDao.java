package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;

/**
 *
 * @author Jamalz
 */
public interface IAlunoDao {
    public Usuario getAluno(String codCpf) throws SQLException;
    public void postAluno(Usuario aluno)throws SQLException;
    public void putAluno(Usuario aluno) throws SQLException;
    public void deleteAluno(String codCpf) throws SQLException;
}
