/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.proxy;

import br.cefetmg.inf.client.ClientRMI;
import br.cefetmg.inf.model.domain.AparelhoExercicio;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author melog
 */
public class ManterExercicioProxy implements IManterExercicio {

    private final IManterExercicio manterExercicio;
    private final ClientRMI cliente;

    public ManterExercicioProxy() {
        this.cliente = ClientRMI.getInstancia();
        manterExercicio = (IManterExercicio) cliente.recebeObjeto("ManterExercicio");
    }

    @Override
    public Exercicio pesquisarPorCodigo(int codExercicio) throws SQLException, RemoteException {
        try {
            return manterExercicio.pesquisarPorCodigo(codExercicio);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public Exercicio pesquisarPorNome(String nomeExercicio) throws SQLException, RemoteException {
        try {
            return manterExercicio.pesquisarPorNome(nomeExercicio);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public AparelhoExercicio pesquisarAparelhoExercicio(int codExercicio, int nroAparelho) throws SQLException, RemoteException {
        try {
            return manterExercicio.pesquisarAparelhoExercicio(codExercicio, nroAparelho);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public ArrayList<Exercicio> pesquisarPorRegiao(String nomeRegiao) throws SQLException, RemoteException {
        try {
            return manterExercicio.pesquisarPorRegiao(nomeRegiao);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public ArrayList<Exercicio> pesquisarPorAparelho(int nroAparelho) throws SQLException, RemoteException {
        try {
            return manterExercicio.pesquisarPorAparelho(nroAparelho);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public ArrayList<Exercicio> pesquisarPorMusculo(int codMusculo) throws SQLException, RemoteException {
        try {
            return manterExercicio.pesquisarPorMusculo(codMusculo);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public ArrayList<Exercicio> pesquisarTodos() throws SQLException, RemoteException {
        try {
            return manterExercicio.pesquisarTodos();
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public boolean cadastrar(Exercicio exercicio) throws SQLException, RemoteException {
        try {
            return manterExercicio.cadastrar(exercicio);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean cadastrarAparelhoExercicio(int codExercicio, int nroAparelho, String caminhoImg) throws SQLException, RemoteException {
        try {
            return manterExercicio.cadastrarAparelhoExercicio(codExercicio, nroAparelho, caminhoImg);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean alterar(Exercicio exercicio) throws SQLException, RemoteException {
        try {
            return manterExercicio.alterar(exercicio);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean excluir(int codExercicio) throws SQLException, RemoteException {
        try {
            return manterExercicio.excluir(codExercicio);
        } catch (RemoteException e) {
            Logger.getLogger(ManterAlunoProxy.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
