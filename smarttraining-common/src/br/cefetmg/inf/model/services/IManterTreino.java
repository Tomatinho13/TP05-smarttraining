package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Treino;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jamalz
 */
public interface IManterTreino {

    public Treino pesquisarTreino(String cpf, int nroFicha, int nroTreino) throws SQLException;

    public ArrayList<Treino> pesquisarPorFicha(String cpf, int nroFicha) throws SQLException;

    public boolean cadastrar(Treino treino) throws SQLException;

    public boolean alterar(Treino treino) throws SQLException;

    public boolean excluir(String cpf, int nroTreino, int nroFicha) throws SQLException;
}
