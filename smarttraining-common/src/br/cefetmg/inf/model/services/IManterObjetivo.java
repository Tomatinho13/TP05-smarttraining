package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Objetivo;
import java.sql.SQLException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface IManterObjetivo extends Remote{

    public Objetivo pesquisarPorCodigo(int codObjetivo) throws SQLException, RemoteException;

    public Objetivo pesquisarPorNome(String nome) throws SQLException, RemoteException;

    public ArrayList<Objetivo> pesquisarPorAvaliacao(String codCpf, LocalDate dataAvaliacao) throws SQLException, RemoteException;
    
    public ArrayList<Objetivo> pesquisarTodos() throws SQLException, RemoteException;

    public boolean cadastrar(Objetivo objetivo) throws SQLException, RemoteException;

    public boolean alterar(Objetivo objetivo) throws SQLException, RemoteException;

    public boolean excluir(int codRegiao) throws SQLException, RemoteException;
}
