package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Atividade;
import java.sql.SQLException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IManterAtividade extends Remote{

    public Atividade pesquisar(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException, RemoteException;

    public boolean cadastrar(Atividade atividade) throws SQLException, RemoteException;

    public boolean alterar(Atividade atividade) throws SQLException, RemoteException;

    public boolean excluir(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException, RemoteException;
}
