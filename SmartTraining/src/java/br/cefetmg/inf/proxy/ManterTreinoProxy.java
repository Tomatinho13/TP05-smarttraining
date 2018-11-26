/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.client.ClientRMI;
import br.cefetmg.inf.model.domain.Treino;
import br.cefetmg.inf.model.services.IManterTreino;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Augusto
 */
public class ManterTreinoProxy implements IManterTreino {
    
    private final IManterTreino manterTreino;
    private final ClientRMI cliente;
    
    public ManterTreinoProxy() {
        this.cliente = ClientRMI.getInstancia();
        manterTreino = (IManterTreino) cliente.recebeObjeto("ManterTreino");
    }

    @Override
    public Treino pesquisarTreino(String cpf, int nroFicha, int nroTreino) throws SQLException, RemoteException {
        try {
            return manterTreino.pesquisarTreino(cpf, nroFicha, nroTreino);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public ArrayList<Treino> pesquisarPorFicha(String cpf, int nroFicha) throws SQLException, RemoteException {
        try {
            return manterTreino.pesquisarPorFicha(cpf, nroFicha);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public boolean cadastrar(Treino treino) throws SQLException, RemoteException {
        try {
            return manterTreino.cadastrar(treino);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean alterar(Treino treino) throws SQLException, RemoteException {
        try {
            return manterTreino.alterar(treino);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean excluir(String cpf, int nroTreino, int nroFicha) throws SQLException, RemoteException {
        try {
            return manterTreino.excluir(cpf, nroTreino, nroFicha);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
}
