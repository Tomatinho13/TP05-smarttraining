package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.ITreinoDao;
import br.cefetmg.inf.model.dao.impl.TreinoDao;
import br.cefetmg.inf.model.domain.Treino;
import br.cefetmg.inf.model.services.IManterTreino;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterTreino implements IManterTreino {

    private ITreinoDao treinoDao;

    public ManterTreino() {
    }

    @Override
    public Treino pesquisarTreino(String cpf, int nroFicha, int nroTreino) throws SQLException {
        treinoDao = new TreinoDao();
        Treino resultado = treinoDao.getTreino(cpf, nroFicha, nroTreino);
        return resultado;
    }

    @Override
    public ArrayList<Treino> pesquisarPorFicha(String cpf, int nroFicha) throws SQLException {
        treinoDao = new TreinoDao();
        ArrayList<Treino> result = treinoDao.getFichaTreinos(cpf, nroFicha);
        return result;
    }

    @Override
    public boolean cadastrar(Treino treino) throws SQLException {
        try {
            treinoDao = new TreinoDao();
            treinoDao.postTreino(treino);
            treinoDao.fechaConexao();
        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean alterar(Treino treino) throws SQLException {
        try {
            treinoDao = new TreinoDao();
            treinoDao.putTreino(treino);
            treinoDao.fechaConexao();
        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean excluir(String cpf, int nroTreino, int nroFicha) throws SQLException {
        try {
            treinoDao = new TreinoDao();
            treinoDao.deleteTreino(cpf, nroFicha, nroTreino);
            treinoDao.fechaConexao();
        } catch (SQLException exception) {
            return false;
        }
        return true;
    }
}
