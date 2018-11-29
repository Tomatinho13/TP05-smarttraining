package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.DiaTreino;
import java.sql.SQLException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IManterDiaTreino extends Remote{

    public ArrayList<DiaTreino> pesquisarTodos(String codCpf, String nroFicha) throws SQLException, RemoteException;

    public boolean cadastrar(DiaTreino diaTreino) throws SQLException, RemoteException;
}
