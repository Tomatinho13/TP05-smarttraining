package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Musculo;
import java.sql.SQLException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IManterMusculo extends Remote{

    public Musculo pesquisarPorCodigo(int codMusculo) throws SQLException, RemoteException;

    public ArrayList <Musculo> pesquisarTodos() throws SQLException, RemoteException;
    
    public boolean cadastrar(Musculo musculo) throws SQLException, RemoteException;

    public boolean alterar(Musculo musculo) throws SQLException, RemoteException;

    public boolean excluir(int codMusculo) throws SQLException, RemoteException;
}
