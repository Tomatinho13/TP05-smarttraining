package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IFichaDao;
import br.cefetmg.inf.model.dao.impl.FichaDao;
import br.cefetmg.inf.model.domain.Ficha;
import br.cefetmg.inf.model.services.IManterFicha;
import java.sql.SQLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ManterFicha extends UnicastRemoteObject implements IManterFicha {

    private IFichaDao fichaDao;

    public ManterFicha() throws RemoteException {
    }

    @Override
    public Ficha pesquisarPorCodigo(String codCpf, int nroFicha) throws SQLException, RemoteException {
        fichaDao = new FichaDao();
        Ficha resultado = fichaDao.getFicha(codCpf, nroFicha);
        return resultado;
    }

    @Override
    public ArrayList<Ficha> pesquisarPorAluno(String codCpf) throws SQLException, RemoteException {
        fichaDao = new FichaDao();
        ArrayList<Ficha> resultado = new ArrayList<>(fichaDao.getListaFicha(codCpf));
        return resultado;
    }

    @Override
    public boolean cadastrar(Ficha ficha) throws SQLException, RemoteException {
        boolean testeDao;
        
        fichaDao = new FichaDao();
        testeDao = fichaDao.postFicha(ficha);
                
        return testeDao;
    }

    @Override
    public boolean alterar(Ficha ficha) throws SQLException, RemoteException {
        boolean testeDao;
        
        fichaDao = new FichaDao();
        testeDao = fichaDao.putFicha(ficha);
               
        return testeDao;
    }

    @Override
    public boolean excluir(String codCpf, int nroFicha) throws SQLException, RemoteException {
        boolean testeDao;
        
        fichaDao = new FichaDao();
        testeDao = fichaDao.deleteFicha(codCpf, nroFicha);
        
        return testeDao;
    }
}
