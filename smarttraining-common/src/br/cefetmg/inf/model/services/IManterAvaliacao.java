package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Avaliacao;
import java.sql.SQLException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;

public interface IManterAvaliacao extends Remote{

    public ArrayList<Avaliacao> pesquisarPorAluno(String codCpf) throws SQLException, RemoteException;
    
    public Avaliacao pesquisar(String codCpf, LocalDate data) throws SQLException, RemoteException;

    public boolean cadastrar(Avaliacao avaliacao) throws SQLException, RemoteException;

    public boolean alterar(Avaliacao avaliacao) throws SQLException, RemoteException;

    public boolean excluir(String codCpf, LocalDate datAvaliacao) throws SQLException, RemoteException;
}
