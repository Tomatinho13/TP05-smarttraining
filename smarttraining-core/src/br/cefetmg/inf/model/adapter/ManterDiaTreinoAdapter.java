package br.cefetmg.inf.model.adapter;

import br.cefetmg.inf.model.domain.DiaTreino;
import br.cefetmg.inf.model.services.IManterDiaTreino;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;


public class ManterDiaTreinoAdapter implements IManterDiaTreino{

    @Override
    public ArrayList<DiaTreino> pesquisarTodos(String codCpf, String nroFicha) throws SQLException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean cadastrar(DiaTreino diaTreino) throws SQLException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
