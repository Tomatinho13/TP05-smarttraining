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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Treino> pesquisarPorFicha(String cpf, int nroFicha) throws SQLException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean cadastrar(Treino treino) throws SQLException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(Treino treino) throws SQLException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(String cpf, int nroTreino, int nroFicha) throws SQLException, RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
