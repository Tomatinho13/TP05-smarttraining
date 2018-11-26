package br.cefetmg.inf.proxy;

import br.cefetmg.inf.client.ClientRMI;
import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManterAlunoProxy implements IManterUsuario {

    private final IManterUsuario manterAluno;
    private final ClientRMI cliente;

    public ManterAlunoProxy() {
        this.cliente = ClientRMI.getInstancia();
        manterAluno = (IManterUsuario) cliente.recebeObjeto("ManterAluno");
    }

    @Override
    public Usuario pesquisarPorCpf(String codCpf) throws SQLException, RemoteException {
        try {
            return manterAluno.pesquisarPorCpf(codCpf);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public Usuario pesquisarPorNome(String nome) throws SQLException, RemoteException {
        try {
            return manterAluno.pesquisarPorNome(nome);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public ArrayList<Usuario> pesquisarTodos() throws SQLException, RemoteException {
        try {
            return manterAluno.pesquisarTodos();
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public boolean cadastrar(Usuario aluno) throws SQLException, RemoteException {
        try {
            return manterAluno.cadastrar(aluno);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean alterar(Usuario aluno) throws SQLException, RemoteException {
        try {
            return manterAluno.alterar(aluno);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean excluir(String codCpf) throws SQLException, RemoteException {
        try {
            return manterAluno.excluir(codCpf);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

}
