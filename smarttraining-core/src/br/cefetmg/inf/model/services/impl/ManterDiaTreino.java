package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.impl.DiaTreinoDao;
import br.cefetmg.inf.model.domain.DiaTreino;
import br.cefetmg.inf.model.domain.Ficha;
import br.cefetmg.inf.model.services.IManterDiaTreino;
import java.sql.SQLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ManterDiaTreino extends UnicastRemoteObject implements IManterDiaTreino {
    private DiaTreinoDao diaTreinoDao = new DiaTreinoDao();

    public ManterDiaTreino() throws RemoteException {
    }
       
    @Override
    public ArrayList<DiaTreino> pesquisarTodos(String codCpf, String nroFicha) throws SQLException, RemoteException {
        diaTreinoDao = new DiaTreinoDao();
        return diaTreinoDao.getListaDiaTreino(codCpf, nroFicha);
    }

    @Override
    public boolean cadastrar(DiaTreino diaTreino) throws SQLException, RemoteException {
        diaTreinoDao = new DiaTreinoDao();
        return diaTreinoDao.postDiaTreino(diaTreino);
    }

}
