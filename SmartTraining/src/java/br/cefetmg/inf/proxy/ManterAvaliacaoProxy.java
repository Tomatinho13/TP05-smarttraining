package br.cefetmg.inf.proxy;

import br.cefetmg.inf.client.ClientRMI;
import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManterAvaliacaoProxy implements IManterAvaliacao {

    private final IManterAvaliacao manterAvaliacao;
    private final ClientRMI cliente;

    public ManterAvaliacaoProxy() {
        this.cliente = ClientRMI.getInstancia();
        manterAvaliacao = (IManterAvaliacao) cliente.recebeObjeto("ManterAvaliacao");
    }

    @Override
    public ArrayList<Avaliacao> pesquisarPorAluno(String codCpf) throws SQLException, RemoteException {
        try {
            return manterAvaliacao.pesquisarPorAluno(codCpf);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public Avaliacao pesquisar(String codCpf, LocalDate data) throws SQLException, RemoteException {
        try {
            return manterAvaliacao.pesquisar(codCpf, data);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public boolean cadastrar(Avaliacao avaliacao) throws SQLException, RemoteException {
        try {
            return manterAvaliacao.cadastrar(avaliacao);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean alterar(Avaliacao avaliacao) throws SQLException, RemoteException {
        try {
            return manterAvaliacao.alterar(avaliacao);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean excluir(String codCpf, LocalDate datAvaliacao) throws SQLException, RemoteException {
        try {
            return manterAvaliacao.excluir(codCpf, datAvaliacao);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

}
