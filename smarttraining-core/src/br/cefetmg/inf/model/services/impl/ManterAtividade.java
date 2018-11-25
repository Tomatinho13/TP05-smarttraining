package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IAtividadeDao;
import br.cefetmg.inf.model.dao.impl.AtividadeDao;
import br.cefetmg.inf.model.domain.Atividade;
import br.cefetmg.inf.model.services.IManterAtividade;
import java.sql.SQLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ManterAtividade extends UnicastRemoteObject implements IManterAtividade {

    private IAtividadeDao atividadeDao;

    public ManterAtividade() throws RemoteException{
    }

    @Override
    public Atividade pesquisar(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException, RemoteException {
        atividadeDao = new AtividadeDao();
        Atividade resultado = atividadeDao.getAtividade(codCpf, nroTreino, codExercicio, nroAparelho, nroFicha);
        return resultado;
    }

    @Override
    public boolean cadastrar(Atividade atividade) throws SQLException, RemoteException {
        boolean testeDao;
        
        atividadeDao = new AtividadeDao();
        testeDao = atividadeDao.postAtividade(atividade);
        
        return testeDao;
    }

    @Override
    public boolean alterar(Atividade atividade) throws SQLException, RemoteException {
        boolean testeDao;
        
        atividadeDao = new AtividadeDao();
        testeDao = atividadeDao.putAtividade(atividade);
        
        return testeDao;
    }

    @Override
    public boolean excluir(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException, RemoteException {
        boolean testeDao;
        
        atividadeDao = new AtividadeDao();
        testeDao = atividadeDao.deleteAtividade(codCpf, nroTreino, codExercicio, nroAparelho, nroFicha);

        return testeDao;
    }
}
