package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Treino;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jamalz
 */
public interface ITreinoDao {

    public Treino getTreino(String cpf, int nroFicha, int nroTreino) throws SQLException;

    public ArrayList<Treino> getFichaTreinos(String cpf, int nroFicha) throws SQLException;

    public boolean postTreino(Treino treino) throws SQLException;

    public boolean putTreino(Treino treino) throws SQLException;

    public boolean deleteTreino(String cpf, int nroFicha, int nroTreino) throws SQLException;

    public void fechaConexao();
}
