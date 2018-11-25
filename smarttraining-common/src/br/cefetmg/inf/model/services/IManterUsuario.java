package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IManterUsuario extends Remote{

    public Usuario pesquisarPorCpf(String codCpf) throws SQLException, RemoteException;

    public Usuario pesquisarPorNome(String nome) throws SQLException, RemoteException;
    
    public ArrayList <Usuario> pesquisarTodos() throws SQLException, RemoteException;
    
    public boolean cadastrar(Usuario aluno) throws SQLException, RemoteException;

    public boolean alterar(Usuario aluno) throws SQLException, RemoteException;

    public boolean excluir(String codCpf) throws SQLException, RemoteException;
}
