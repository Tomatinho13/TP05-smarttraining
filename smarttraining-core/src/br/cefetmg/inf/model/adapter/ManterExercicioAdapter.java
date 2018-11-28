package br.cefetmg.inf.model.adapter;

import br.cefetmg.inf.model.domain.AparelhoExercicio;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import br.cefetmg.inf.model.services.impl.ManterExercicio;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterExercicioAdapter implements IManterExercicio {

    private final IManterExercicio manterExercicio;

    public ManterExercicioAdapter() throws RemoteException {
        this.manterExercicio = new ManterExercicio();
    }

    @Override
    public Exercicio pesquisarPorCodigo(int codExercicio) throws SQLException, RemoteException {
        Exercicio resultado = manterExercicio.pesquisarPorCodigo(codExercicio);
        return resultado;
    }

    @Override
    public Exercicio pesquisarPorNome(String nomeExercicio) throws SQLException, RemoteException {
        Exercicio resultado = manterExercicio.pesquisarPorNome(nomeExercicio);
        return resultado;
    }

    @Override
    public AparelhoExercicio pesquisarAparelhoExercicio(int codExercicio, int nroAparelho) throws SQLException, RemoteException {
        return manterExercicio.pesquisarAparelhoExercicio(codExercicio, nroAparelho);
    }

    @Override
    public ArrayList<Exercicio> pesquisarPorRegiao(String nomeRegiao) throws SQLException, RemoteException {
        return manterExercicio.pesquisarPorRegiao(nomeRegiao);
    }

    @Override
    public ArrayList<Exercicio> pesquisarPorAparelho(int nroAparelho) throws SQLException, RemoteException {
        return manterExercicio.pesquisarPorAparelho(nroAparelho);
    }

    @Override
    public ArrayList<Exercicio> pesquisarPorMusculo(int codMusculo) throws SQLException, RemoteException {
        return manterExercicio.pesquisarPorMusculo(codMusculo);
    }

    @Override
    public ArrayList<Exercicio> pesquisarTodos() throws SQLException, RemoteException {
        return manterExercicio.pesquisarTodos();
    }

    @Override
    public boolean cadastrar(Exercicio exercicio) throws SQLException, RemoteException {
        boolean resultado = manterExercicio.cadastrar(exercicio);
        return resultado;
    }

    @Override
    public boolean cadastrarAparelhoExercicio(int codExercicio, int nroAparelho, String caminhoImg) throws SQLException, RemoteException {
        boolean resultado = manterExercicio.cadastrarAparelhoExercicio(codExercicio, nroAparelho, caminhoImg);
        return resultado;
    }

    @Override
    public boolean alterar(Exercicio exercicio) throws SQLException, RemoteException {
        boolean resultado = manterExercicio.alterar(exercicio);
        return resultado;
    }

    @Override
    public boolean excluir(int codExercicio) throws SQLException, RemoteException {
        boolean resultado = manterExercicio.excluir(codExercicio);
        return resultado;
    }
}
