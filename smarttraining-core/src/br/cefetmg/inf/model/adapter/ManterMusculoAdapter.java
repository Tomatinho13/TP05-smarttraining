package br.cefetmg.inf.model.adapter;

import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterMusculo;
import br.cefetmg.inf.model.services.impl.ManterMusculo;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterMusculoAdapter implements IManterMusculo {

    private final IManterMusculo manterMusculo;

    public ManterMusculoAdapter() throws RemoteException {
        this.manterMusculo = new ManterMusculo();
    }

    @Override
    public Musculo pesquisarPorCodigo(int codMusculo) throws SQLException, RemoteException {
        Musculo resultado = manterMusculo.pesquisarPorCodigo(codMusculo);
        return resultado;
    }

    @Override
    public ArrayList<Musculo> pesquisarTodos() throws SQLException, RemoteException {
        return manterMusculo.pesquisarTodos();
    }

    @Override
    public boolean cadastrar(Musculo musculo) throws SQLException, RemoteException {
        boolean resultado = manterMusculo.cadastrar(musculo);
        return resultado;
    }

    @Override
    public boolean alterar(Musculo musculo) throws SQLException, RemoteException {
        boolean resultado = manterMusculo.alterar(musculo);
        return resultado;
    }

    @Override
    public boolean excluir(int codMusculo) throws SQLException, RemoteException {
        boolean resultado = manterMusculo.excluir(codMusculo);
        return resultado;
    }
}
