package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Ficha;
import java.sql.SQLException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IManterFicha extends Remote{

    public Ficha pesquisarPorCodigo(String codCpf, int nroFicha) throws SQLException, RemoteException;

    public ArrayList<Ficha> pesquisarPorAluno(String codCpf) throws SQLException, RemoteException;

    public boolean cadastrar(Ficha ficha) throws SQLException, RemoteException;

    public boolean alterar(Ficha ficha) throws SQLException, RemoteException;

    public boolean excluir(String codCpf, int nroFicha) throws SQLException, RemoteException;
}
