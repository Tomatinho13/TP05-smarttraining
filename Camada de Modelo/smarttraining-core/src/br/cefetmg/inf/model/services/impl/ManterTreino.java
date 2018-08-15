package br.cefetmg.inf.model.services.impl;


import br.cefetmg.inf.model.dao.ITreinoDao;
import br.cefetmg.inf.model.dao.impl.TreinoDao;
import br.cefetmg.inf.model.domain.Treino;
import br.cefetmg.inf.model.services.IManterTreino;
import java.sql.SQLException;
import java.util.List;

public class ManterTreino implements IManterTreino {

    private final ITreinoDao treinoDao;
    
    public ManterTreino() {
        treinoDao = new TreinoDao();
    }
    
    @Override
    public Treino pesquisarTreino(String cpf, int nroFicha, int nroTreino) throws SQLException {
        Treino resultado = treinoDao.getTreino(cpf, nroFicha, nroTreino);
        return resultado;       
    }
    
    @Override
    public List<Treino> pesquisarPorFicha(String cpf, int nroFicha) throws SQLException{
        List<Treino> result = treinoDao.getFichaTreinos(cpf, nroFicha);
        return result;       
    }
    
    @Override
    public void cadastrar(Treino treino) throws SQLException{
        treinoDao.postTreino(treino);
    }

    @Override
    public void alterar(Treino treino) throws SQLException{
        treinoDao.putTreino(treino);
    }

    @Override
    public void excluir(String cpf, int nroTreino, int nroFicha) throws SQLException{
        treinoDao.deleteTreino(cpf, nroFicha, nroTreino);
    }     
}
