/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.client.ClientRMI;
import br.cefetmg.inf.model.domain.Ficha;
import br.cefetmg.inf.model.services.IManterFicha;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author melog
 */
public class ManterFichaProxy implements IManterFicha {

    private final IManterFicha manterFicha;
    private final ClientRMI cliente;

    public ManterFichaProxy() {
        this.cliente = ClientRMI.getInstancia();
        manterFicha = (IManterFicha) cliente.recebeObjeto("ManterFicha");
    }

    @Override
    public Ficha pesquisarPorCodigo(String codCpf, int nroFicha) throws SQLException, RemoteException {
        try {
            return manterFicha.pesquisarPorCodigo(codCpf, nroFicha);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public ArrayList<Ficha> pesquisarPorAluno(String codCpf) throws SQLException, RemoteException {
        try {
            return manterFicha.pesquisarPorAluno(codCpf);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public boolean cadastrar(Ficha ficha) throws SQLException, RemoteException {
        try {
            return manterFicha.cadastrar(ficha);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean alterar(Ficha ficha) throws SQLException, RemoteException {
        try {
            return manterFicha.alterar(ficha);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean excluir(String codCpf, int nroFicha) throws SQLException, RemoteException {
        try {
            return manterFicha.excluir(codCpf, nroFicha);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
