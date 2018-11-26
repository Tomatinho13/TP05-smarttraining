/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.client.ClientRMI;
import br.cefetmg.inf.model.domain.Objetivo;
import br.cefetmg.inf.model.services.IManterObjetivo;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Augusto
 */
public class ManterObjetivoProxy implements IManterObjetivo {
    
    private final IManterObjetivo manterObjetivo;
    private final ClientRMI cliente;
    
    public ManterObjetivoProxy() {
        this.cliente = ClientRMI.getInstancia();
        manterObjetivo = (IManterObjetivo) cliente.recebeObjeto("ManterObjetivo");
    }

    @Override
    public Objetivo pesquisarPorCodigo(int codObjetivo) throws SQLException, RemoteException {
        try {
            return manterObjetivo.pesquisarPorCodigo(codObjetivo);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;      
    }

    @Override
    public Objetivo pesquisarPorNome(String nome) throws SQLException, RemoteException {
        try {
            return manterObjetivo.pesquisarPorNome(nome);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;      
    }

    @Override
    public ArrayList<Objetivo> pesquisarPorAvaliacao(String codCpf, LocalDate dataAvaliacao) throws SQLException, RemoteException {
        try {
            return manterObjetivo.pesquisarPorAvaliacao(codCpf, dataAvaliacao);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;      
    }

    @Override
    public ArrayList<Objetivo> pesquisarTodos() throws SQLException, RemoteException {
        try {
            return manterObjetivo.pesquisarTodos();
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;      
    }

    @Override
    public boolean cadastrar(Objetivo objetivo) throws SQLException, RemoteException {
        try {
            return manterObjetivo.cadastrar(objetivo);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;      
    }

    @Override
    public boolean alterar(Objetivo objetivo) throws SQLException, RemoteException {
        try {
            return manterObjetivo.alterar(objetivo);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;      
    }

    @Override
    public boolean excluir(int codRegiao) throws SQLException, RemoteException {
        try {
            return manterObjetivo.excluir(codRegiao);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;      
    }
    
}
