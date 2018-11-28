package br.cefetmg.inf.model.adapter;

import br.cefetmg.inf.model.domain.Ficha;
import br.cefetmg.inf.model.services.IManterFicha;
import br.cefetmg.inf.model.services.impl.ManterFicha;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterFichaAdapter implements IManterFicha {

    private final IManterFicha manterFicha;

    public ManterFichaAdapter() throws RemoteException {
        this.manterFicha = new ManterFicha();
    }

    @Override
    public Ficha pesquisarPorCodigo(String codCpf, int nroFicha) throws SQLException, RemoteException {
        Ficha resultado = manterFicha.pesquisarPorCodigo(codCpf, nroFicha);
        return resultado;
    }

    @Override
    public ArrayList<Ficha> pesquisarPorAluno(String codCpf) throws SQLException, RemoteException {
        return manterFicha.pesquisarPorAluno(codCpf);
    }

    @Override
    public boolean cadastrar(Ficha ficha) throws SQLException, RemoteException {
        boolean resultado = manterFicha.cadastrar(ficha);
        return resultado;
    }

    @Override
    public boolean alterar(Ficha ficha) throws SQLException, RemoteException {
        boolean resultado = manterFicha.alterar(ficha);
        return resultado;
    }

    @Override
    public boolean excluir(String codCpf, int nroFicha) throws SQLException, RemoteException {
        boolean resultado = manterFicha.excluir(codCpf, nroFicha);
        return resultado;
    }
}
