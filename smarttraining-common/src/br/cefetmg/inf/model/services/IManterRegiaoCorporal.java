package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.RegiaoCorporal;
import java.sql.SQLException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Jamalz
 */
public interface IManterRegiaoCorporal extends Remote{

    public RegiaoCorporal pesquisarRegiaoCorporal(int codRegiao) throws SQLException, RemoteException;

    public boolean cadastrar(RegiaoCorporal regiaoCorporal, int codMusculo) throws SQLException, RemoteException;

    public boolean alterar(RegiaoCorporal regiaoCorporal) throws SQLException, RemoteException;

    public boolean excluir(int codRegiao) throws SQLException, RemoteException;
}
