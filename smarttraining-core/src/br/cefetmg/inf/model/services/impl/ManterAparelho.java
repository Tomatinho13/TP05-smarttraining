package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IAparelhoDao;
import br.cefetmg.inf.model.dao.IExercicioDao;
import br.cefetmg.inf.model.dao.impl.AparelhoDao;
import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.services.IManterAparelho;
import java.sql.SQLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ManterAparelho extends UnicastRemoteObject implements IManterAparelho {

    private IAparelhoDao aparelhoDao;

    public ManterAparelho() throws RemoteException{
    }

    @Override
    public Aparelho pesquisar(int nroAparelho) throws SQLException, RemoteException {
        aparelhoDao = new AparelhoDao();
        Aparelho resultado = aparelhoDao.getAparelho(nroAparelho);
        return resultado;
    }

    @Override
    public Aparelho pesquisar(String nomAparelho) throws SQLException, RemoteException {
        aparelhoDao = new AparelhoDao();
        Aparelho resultado = aparelhoDao.getAparelho(nomAparelho);
        return resultado;
    }

    @Override
    public ArrayList<Aparelho> pesquisarTodos() throws SQLException, RemoteException {
        aparelhoDao = new AparelhoDao();
        ArrayList<Aparelho> resultado = aparelhoDao.getListaAparelhos();
        return resultado;
    }

    @Override
    public boolean cadastrar(Aparelho aparelho) throws SQLException, RemoteException {
        boolean testeDao;
        aparelhoDao = new AparelhoDao();
        testeDao = aparelhoDao.postAparelho(aparelho);

        return testeDao;
    }

    @Override
    public boolean alterar(Aparelho aparelho) throws SQLException, RemoteException {
        boolean testeDao;
        aparelhoDao = new AparelhoDao();
        testeDao = aparelhoDao.putAparelho(aparelho);
        
        return testeDao;
    }

    @Override
    public boolean excluir(int nroAparelho) throws SQLException, RemoteException {
        boolean testeDao;
        aparelhoDao = new AparelhoDao();
        testeDao = aparelhoDao.deleteAparelho(nroAparelho);
        
        return testeDao;
    }
}
