package br.cefetmg.inf.model.adapter;

import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.services.IManterAparelho;
import br.cefetmg.inf.model.services.impl.ManterAparelho;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterAparelhoAdapter implements IManterAparelho {

    public ManterAparelhoAdapter() throws RemoteException {
        this.manterAparelho = new ManterAparelho();
    }

    private final IManterAparelho manterAparelho;

    @Override
    public Aparelho pesquisar(int nroAparelho) throws SQLException, RemoteException {
        Aparelho resultado = manterAparelho.pesquisar(nroAparelho);
        return resultado;
    }

    @Override
    public Aparelho pesquisar(String nomAparelho) throws SQLException, RemoteException {
        Aparelho resultado = manterAparelho.pesquisar(nomAparelho);
        return resultado;
    }

    @Override
    public boolean cadastrar(Aparelho aparelho) throws SQLException, RemoteException {
        boolean resultado = manterAparelho.cadastrar(aparelho);
        return resultado;
    }

    @Override
    public boolean alterar(Aparelho aparelho) throws SQLException, RemoteException {
        boolean resultado = manterAparelho.alterar(aparelho);
        return resultado;
    }

    @Override
    public boolean excluir(int nroAparelho) throws SQLException, RemoteException {
        boolean resultado = manterAparelho.excluir(nroAparelho);
        return resultado;
    }

    @Override
    public ArrayList<Aparelho> pesquisarTodos() throws SQLException, RemoteException {
        return manterAparelho.pesquisarTodos();
    }
}
