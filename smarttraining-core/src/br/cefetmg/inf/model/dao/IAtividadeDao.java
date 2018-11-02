package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Atividade;
import java.sql.SQLException;

/**
 *
 * @author Jamalz
 */
public interface IAtividadeDao {

    public Atividade getAtividade(String cpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException;

    public boolean postAtividade(Atividade atividade) throws SQLException;

    public boolean putAtividade(Atividade atividade) throws SQLException;

    public boolean deleteAtividade(String cpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException;

    public void fechaConexao();
}
