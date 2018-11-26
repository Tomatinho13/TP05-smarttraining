package br.cefetmg.inf.model.adapter;

import br.cefetmg.inf.model.domain.Atividade;
import br.cefetmg.inf.model.services.IManterAtividade;
import br.cefetmg.inf.model.services.impl.ManterAtividade;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class ManterAtividadeAdapter implements IManterAtividade {

    public ManterAtividadeAdapter() throws RemoteException {
        this.manterAtividade = new ManterAtividade();
    }

    private final IManterAtividade manterAtividade;

    @Override
    public Atividade pesquisar(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException, RemoteException {
        Atividade resultado = manterAtividade.pesquisar(codCpf, nroTreino, codExercicio, nroAparelho, nroFicha);
        return resultado;
    }

    @Override
    public boolean cadastrar(Atividade atividade) throws SQLException, RemoteException {
        boolean resultado = manterAtividade.cadastrar(atividade);
        return resultado;
    }

    @Override
    public boolean alterar(Atividade atividade) throws SQLException, RemoteException {
        boolean resultado = manterAtividade.alterar(atividade);
        return resultado;
    }

    @Override
    public boolean excluir(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException, RemoteException {
        boolean resultado = manterAtividade.excluir(codCpf, nroTreino, codExercicio, nroAparelho, nroFicha);
        return resultado;
    }
}
