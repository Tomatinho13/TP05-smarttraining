package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Treino;
import java.sql.SQLException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Jamalz
 */
public interface IManterTreino extends Remote{

    public Treino pesquisarTreino(String cpf, int nroFicha, int nroTreino) throws SQLException, RemoteException;

    public ArrayList<Treino> pesquisarPorFicha(String cpf, int nroFicha) throws SQLException, RemoteException;

    public boolean cadastrar(Treino treino) throws SQLException, RemoteException;

    public boolean alterar(Treino treino) throws SQLException, RemoteException;

    public boolean excluir(String cpf, int nroTreino, int nroFicha) throws SQLException, RemoteException;
}
