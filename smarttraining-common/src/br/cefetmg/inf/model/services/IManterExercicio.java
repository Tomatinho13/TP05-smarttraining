package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.AparelhoExercicio;
import br.cefetmg.inf.model.domain.Exercicio;
import java.sql.SQLException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IManterExercicio extends Remote{

    public Exercicio pesquisarPorCodigo(int codExercicio) throws SQLException, RemoteException;

    public Exercicio pesquisarPorNome(String nomeExercicio) throws SQLException, RemoteException;

    public AparelhoExercicio pesquisarAparelhoExercicio(int codExercicio, int nroAparelho) throws SQLException, RemoteException;

    public ArrayList<Exercicio> pesquisarPorRegiao(String nomeRegiao) throws SQLException, RemoteException;
    
    public ArrayList<Exercicio> pesquisarPorAparelho(int nroAparelho) throws SQLException, RemoteException;

    public ArrayList<Exercicio> pesquisarPorMusculo(int codMusculo) throws SQLException, RemoteException;
    
    public ArrayList<Exercicio> pesquisarTodos() throws SQLException, RemoteException;

    public boolean cadastrar(Exercicio exercicio) throws SQLException, RemoteException;
    
    public boolean cadastrarAparelhoExercicio(int codExercicio, int nroAparelho, String caminhoImg) throws SQLException, RemoteException;

    public boolean alterar(Exercicio exercicio) throws SQLException, RemoteException;

    public boolean excluir(int codExercicio) throws SQLException, RemoteException;
}
