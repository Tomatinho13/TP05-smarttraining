/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.client.ClientRMI;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterMusculo;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Augusto
 */
public class ManterMusculoProxy implements IManterMusculo {
    
    private final IManterMusculo manterMusculo;
    private final ClientRMI cliente;
    
    public ManterMusculoProxy() {
        this.cliente = ClientRMI.getInstancia();
        manterMusculo = (IManterMusculo) cliente.recebeObjeto("ManterMusculo");
    }

    @Override
    public Musculo pesquisarPorCodigo(int codMusculo) throws SQLException, RemoteException {
        try {
            return manterMusculo.pesquisarPorCodigo(codMusculo);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;    
    }

    @Override
    public ArrayList<Musculo> pesquisarTodos() throws SQLException, RemoteException {
        try {
            return manterMusculo.pesquisarTodos();
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;      
    }

    @Override
    public boolean cadastrar(Musculo musculo) throws SQLException, RemoteException {
        try {
            return manterMusculo.cadastrar(musculo);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;      
    }

    @Override
    public boolean alterar(Musculo musculo) throws SQLException, RemoteException {
       try {
            return manterMusculo.alterar(musculo);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;      
    }

    @Override
    public boolean excluir(int codMusculo) throws SQLException, RemoteException {
        try {
            return manterMusculo.excluir(codMusculo);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;      
    }
    
}
