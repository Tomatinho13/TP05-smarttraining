package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IRegiaoCorporalDao;
import br.cefetmg.inf.model.dao.impl.RegiaoCorporalDao;
import br.cefetmg.inf.model.domain.RegiaoCorporal;
import br.cefetmg.inf.model.services.IManterRegiaoCorporal;
import java.sql.SQLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ManterRegiaoCorporal extends UnicastRemoteObject implements IManterRegiaoCorporal {

    private IRegiaoCorporalDao regiaoCorporalDao;

    public ManterRegiaoCorporal() throws RemoteException {
    }

    @Override
    public RegiaoCorporal pesquisarRegiaoCorporal(int codRegiao) throws SQLException, RemoteException {
        regiaoCorporalDao = new RegiaoCorporalDao();
        RegiaoCorporal resultado = regiaoCorporalDao.getRegiaoCorporal(codRegiao);
        return resultado;
    }

    @Override
    public boolean cadastrar(RegiaoCorporal regiaoCorporal, int codMusculo) throws SQLException, RemoteException {
        boolean testeDao;
        
        regiaoCorporalDao = new RegiaoCorporalDao();
        testeDao = regiaoCorporalDao.postRegiaoCorporal(regiaoCorporal, codMusculo);
        
        return testeDao;
    }

    @Override
    public boolean alterar(RegiaoCorporal regiaoCorporal) throws SQLException, RemoteException {
        boolean testeDao;
        
        regiaoCorporalDao = new RegiaoCorporalDao();
        testeDao = regiaoCorporalDao.putRegiaoCorporal(regiaoCorporal);
        
        return testeDao;
    }

    @Override
    public boolean excluir(int codRegiao) throws SQLException, RemoteException {
        boolean testeDao;
        
        regiaoCorporalDao = new RegiaoCorporalDao();
        testeDao = regiaoCorporalDao.deleteRegiaoCorporal(codRegiao);
        
        return testeDao;
    }
}
