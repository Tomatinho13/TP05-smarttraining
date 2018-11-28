package br.cefetmg.inf.model.adapter;

import br.cefetmg.inf.model.domain.DiaTreino;
import br.cefetmg.inf.model.services.IManterDiaTreino;
import br.cefetmg.inf.model.services.impl.ManterDiaTreino;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterDiaTreinoAdapter implements IManterDiaTreino {

    private final IManterDiaTreino manterDiaTreino;

    public ManterDiaTreinoAdapter() throws RemoteException {
        this.manterDiaTreino = new ManterDiaTreino();
    }

    @Override
    public boolean cadastrar(DiaTreino diaTreino) throws SQLException, RemoteException {
        boolean resultado = manterDiaTreino.cadastrar(diaTreino);
        return resultado;
    }

    @Override
    public ArrayList<DiaTreino> pesquisarTodos(String codCpf, String nroFicha) throws SQLException, RemoteException {
        return manterDiaTreino.pesquisarTodos(codCpf, nroFicha);
    }

}
