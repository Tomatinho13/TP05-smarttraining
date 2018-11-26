package br.cefetmg.inf.proxy;

import br.cefetmg.inf.client.ClientRMI;
import br.cefetmg.inf.model.domain.Atividade;
import br.cefetmg.inf.model.services.IManterAtividade;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManterAtividadeProxy implements IManterAtividade {

    private final IManterAtividade manterAtividade;
    private final ClientRMI cliente;

    public ManterAtividadeProxy() {
        this.cliente = ClientRMI.getInstancia();
        manterAtividade = (IManterAtividade) cliente.recebeObjeto("ManterAtividade");
    }

    @Override
    public Atividade pesquisar(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException, RemoteException {
        try {
            return manterAtividade.pesquisar(codCpf, nroTreino, codExercicio, nroAparelho, nroFicha);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public boolean cadastrar(Atividade atividade) throws SQLException, RemoteException {
        try {
            return manterAtividade.cadastrar(atividade);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean alterar(Atividade atividade) throws SQLException, RemoteException {
        try {
            return manterAtividade.alterar(atividade);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean excluir(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException, RemoteException {
        try {
            return manterAtividade.excluir(codCpf, nroTreino, codExercicio, nroAparelho, nroFicha);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

}
