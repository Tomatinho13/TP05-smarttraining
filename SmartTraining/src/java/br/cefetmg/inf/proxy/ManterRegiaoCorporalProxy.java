/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.client.ClientRMI;
import br.cefetmg.inf.model.domain.RegiaoCorporal;
import br.cefetmg.inf.model.services.IManterRegiaoCorporal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Augusto
 */
public class ManterRegiaoCorporalProxy implements IManterRegiaoCorporal {
    
    private final IManterRegiaoCorporal manterRegiaoCorporal;
    private final ClientRMI cliente;
    
    public ManterRegiaoCorporalProxy() {
        this.cliente = ClientRMI.getInstancia();
        manterRegiaoCorporal = (IManterRegiaoCorporal) cliente.recebeObjeto("ManterRegiaoCorporal");
    }

    @Override
    public RegiaoCorporal pesquisarRegiaoCorporal(int codRegiao) throws SQLException, RemoteException {
        try {
            return manterRegiaoCorporal.pesquisarRegiaoCorporal(codRegiao);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;      
    }

    @Override
    public boolean cadastrar(RegiaoCorporal regiaoCorporal, int codMusculo) throws SQLException, RemoteException {
        try {
            return manterRegiaoCorporal.cadastrar(regiaoCorporal, codMusculo);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;      
    }

    @Override
    public boolean alterar(RegiaoCorporal regiaoCorporal) throws SQLException, RemoteException {
        try {
            return manterRegiaoCorporal.alterar(regiaoCorporal);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;      
    }

    @Override
    public boolean excluir(int codRegiao) throws SQLException, RemoteException {
        try {
            return manterRegiaoCorporal.excluir(codRegiao);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;      
    }
    
}
