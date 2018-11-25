package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IMusculoDao;
import br.cefetmg.inf.model.dao.impl.MusculoDao;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterMusculo;
import java.sql.SQLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ManterMusculo extends UnicastRemoteObject implements IManterMusculo {

    private IMusculoDao musculoDao;

    public ManterMusculo() throws RemoteException{
    }

    @Override
    public Musculo pesquisarPorCodigo(int codMusculo) throws SQLException, RemoteException {
        musculoDao = new MusculoDao();
        Musculo resultado = musculoDao.getMusculo(codMusculo);
        return resultado;
    }

    @Override
    public ArrayList<Musculo> pesquisarTodos() throws SQLException, RemoteException {
        musculoDao = new MusculoDao();
        ArrayList<Musculo> listaMusculos = musculoDao.getListaMusculos();
        return listaMusculos;
    }

    @Override
    public boolean cadastrar(Musculo musculo) throws SQLException, RemoteException {
        boolean testeDao;
        
        musculoDao = new MusculoDao();
        testeDao = musculoDao.postMusculo(musculo);
        
        return testeDao;
    }

    @Override
    public boolean alterar(Musculo musculo) throws SQLException, RemoteException {
        boolean testeDao;
        
        musculoDao = new MusculoDao();
        testeDao = musculoDao.putMusculo(musculo);
        
        return testeDao;
    }

    @Override
    public boolean excluir(int codMusculo) throws SQLException, RemoteException {
        boolean testeDao;
        
        musculoDao = new MusculoDao();
        testeDao = musculoDao.deleteMusculo(codMusculo);
        
        return testeDao;
    }
}
