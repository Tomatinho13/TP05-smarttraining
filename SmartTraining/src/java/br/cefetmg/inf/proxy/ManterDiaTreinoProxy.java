/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.client.ClientRMI;
import br.cefetmg.inf.model.domain.DiaTreino;
import br.cefetmg.inf.model.services.IManterDiaTreino;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author melog
 */
public class ManterDiaTreinoProxy implements IManterDiaTreino {

    private final IManterDiaTreino manterDiaTreino;
    private final ClientRMI cliente;

    public ManterDiaTreinoProxy() {
        this.cliente = ClientRMI.getInstancia();
        manterDiaTreino = (IManterDiaTreino) cliente.recebeObjeto("ManterDiaTreino");
    }

    @Override
    public ArrayList<DiaTreino> pesquisarTodos(String codCpf, String nroFicha) throws SQLException, RemoteException {
        try {
            return manterDiaTreino.pesquisarTodos(codCpf, nroFicha);
        } catch (RemoteException e) {
            Logger.getLogger(ManterDiaTreinoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public boolean cadastrar(DiaTreino diaTreino) throws SQLException, RemoteException {
        try {
            return manterDiaTreino.cadastrar(diaTreino);
        } catch (RemoteException e) {
            Logger.getLogger(ManterDiaTreinoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
