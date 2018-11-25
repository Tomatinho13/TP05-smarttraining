package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.ITreinoDao;
import br.cefetmg.inf.model.dao.impl.TreinoDao;
import br.cefetmg.inf.model.domain.Treino;
import br.cefetmg.inf.model.services.IManterTreino;
import java.sql.SQLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ManterTreino extends UnicastRemoteObject implements IManterTreino {

    private ITreinoDao treinoDao;

    public ManterTreino() throws RemoteException{
    }

    @Override
    public Treino pesquisarTreino(String cpf, int nroFicha, int nroTreino) throws SQLException, RemoteException {
        treinoDao = new TreinoDao();
        Treino resultado = treinoDao.getTreino(cpf, nroFicha, nroTreino);
        return resultado;
    }

    @Override
    public ArrayList<Treino> pesquisarPorFicha(String cpf, int nroFicha) throws SQLException, RemoteException {
        treinoDao = new TreinoDao();
        ArrayList<Treino> result = treinoDao.getFichaTreinos(cpf, nroFicha);
        return result;
    }

    @Override
    public boolean cadastrar(Treino treino) throws SQLException, RemoteException {
        boolean testeDao;
        
        treinoDao = new TreinoDao();
        testeDao = treinoDao.postTreino(treino);
        
        return testeDao;
    }

    @Override
    public boolean alterar(Treino treino) throws SQLException, RemoteException {
        boolean testeDao;
        
        treinoDao = new TreinoDao();
        testeDao = treinoDao.putTreino(treino);

        return testeDao;
    }

    @Override
    public boolean excluir(String cpf, int nroTreino, int nroFicha) throws SQLException, RemoteException {
        boolean testeDao;
        
        treinoDao = new TreinoDao();
        testeDao = treinoDao.deleteTreino(cpf, nroFicha, nroTreino);
        
        return testeDao;
    }
}
