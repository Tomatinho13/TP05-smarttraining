package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Aparelho;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IManterAparelho extends Remote{

    public Aparelho pesquisar(int nroAparelho) throws SQLException, RemoteException;
    
    public Aparelho pesquisar(String nomAparelho) throws SQLException, RemoteException;
    
    public ArrayList<Aparelho> pesquisarTodos() throws SQLException, RemoteException;
    
    public boolean cadastrar(Aparelho aparelho) throws SQLException, RemoteException;

    public boolean alterar(Aparelho aparelho) throws SQLException, RemoteException;

    public boolean excluir(int nroAparelho) throws SQLException, RemoteException;
}
