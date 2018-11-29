package br.cefetmg.inf.model.adapter;

import br.cefetmg.inf.model.domain.Objetivo;
import br.cefetmg.inf.model.services.IManterObjetivo;
import br.cefetmg.inf.model.services.impl.ManterObjetivo;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManterObjetivoAdapter implements IManterObjetivo {

    private final IManterObjetivo manterObjetivo;

    public ManterObjetivoAdapter() throws RemoteException {
        this.manterObjetivo = new ManterObjetivo();
    }

    @Override
    public Objetivo pesquisarPorCodigo(int codObjetivo) throws SQLException, RemoteException {
        Objetivo resultado = manterObjetivo.pesquisarPorCodigo(codObjetivo);
        return resultado;
    }

    @Override
    public Objetivo pesquisarPorNome(String nome) throws SQLException, RemoteException {
        Objetivo resultado = manterObjetivo.pesquisarPorNome(nome);
        return resultado;
    }

    @Override
    public ArrayList<Objetivo> pesquisarPorAvaliacao(String codCpf, LocalDate dataAvaliacao) throws SQLException, RemoteException {
        return manterObjetivo.pesquisarPorAvaliacao(codCpf, dataAvaliacao);
    }

    @Override
    public ArrayList<Objetivo> pesquisarTodos() throws SQLException, RemoteException {
        return manterObjetivo.pesquisarTodos();
    }

    @Override
    public boolean cadastrar(Objetivo objetivo) throws SQLException, RemoteException {
        boolean resultado = manterObjetivo.cadastrar(objetivo);
        return resultado;
    }

    @Override
    public boolean alterar(Objetivo objetivo) throws SQLException, RemoteException {
        boolean resultado = manterObjetivo.alterar(objetivo);
        return resultado;
    }

    @Override
    public boolean excluir(int codRegiao) throws SQLException, RemoteException {
        boolean resultado = manterObjetivo.excluir(codRegiao);
        return resultado;
    }
}
