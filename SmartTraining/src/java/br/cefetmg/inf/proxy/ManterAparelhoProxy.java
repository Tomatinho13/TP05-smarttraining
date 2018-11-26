package br.cefetmg.inf.proxy;

import br.cefetmg.inf.client.ClientRMI;
import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.services.IManterAparelho;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManterAparelhoProxy implements IManterAparelho {

    private final IManterAparelho manterAparelho;
    private final ClientRMI cliente;

    public ManterAparelhoProxy() {
        this.cliente = ClientRMI.getInstancia();
        manterAparelho = (IManterAparelho) cliente.recebeObjeto("ManterAparelho");
    }

    @Override
    public Aparelho pesquisar(int nroAparelho) throws SQLException, RemoteException {
        try {
            return manterAparelho.pesquisar(nroAparelho);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public Aparelho pesquisar(String nomAparelho) throws SQLException, RemoteException {
        try {
            return manterAparelho.pesquisar(nomAparelho);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public boolean cadastrar(Aparelho aparelho) throws SQLException, RemoteException {
        try {
            return manterAparelho.cadastrar(aparelho);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean alterar(Aparelho aparelho) throws SQLException, RemoteException {
        try {
            return manterAparelho.alterar(aparelho);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean excluir(int nroAparelho) throws SQLException, RemoteException {
        try {
            return manterAparelho.excluir(nroAparelho);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public ArrayList<Aparelho> pesquisarTodos() throws SQLException, RemoteException {
        try {
            return manterAparelho.pesquisarTodos();
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
