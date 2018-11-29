package br.cefetmg.inf.model.adapter;

import br.cefetmg.inf.model.domain.Treino;
import br.cefetmg.inf.model.services.IManterTreino;
import br.cefetmg.inf.model.services.impl.ManterTreino;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterTreinoAdapter implements IManterTreino {

    private final IManterTreino manterTreino;

    public ManterTreinoAdapter() throws RemoteException {
        this.manterTreino = new ManterTreino();
    }

    @Override
    public Treino pesquisarTreino(String cpf, int nroFicha, int nroTreino) throws SQLException, RemoteException {
        Treino resultado = manterTreino.pesquisarTreino(cpf, nroFicha, nroTreino);
        return resultado;
    }

    @Override
    public ArrayList<Treino> pesquisarPorFicha(String cpf, int nroFicha) throws SQLException, RemoteException {
        return manterTreino.pesquisarPorFicha(cpf, nroFicha);
    }

    @Override
    public boolean cadastrar(Treino treino) throws SQLException, RemoteException {
        boolean resultado = manterTreino.cadastrar(treino);
        return resultado;
    }

    @Override
    public boolean alterar(Treino treino) throws SQLException, RemoteException {
        boolean resultado = manterTreino.alterar(treino);
        return resultado;
    }

    @Override
    public boolean excluir(String cpf, int nroTreino, int nroFicha) throws SQLException, RemoteException {
        boolean resultado = manterTreino.excluir(cpf, nroTreino, nroFicha);
        return resultado;
    }

}
