package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IObjetivoDao;
import br.cefetmg.inf.model.dao.impl.ObjetivoDao;
import br.cefetmg.inf.model.domain.Objetivo;
import br.cefetmg.inf.model.services.IManterObjetivo;
import java.sql.SQLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManterObjetivo extends UnicastRemoteObject implements IManterObjetivo {

    private IObjetivoDao objetivoDao;

    public ManterObjetivo() throws RemoteException {
    }

    @Override
    public Objetivo pesquisarPorCodigo(int codObjetivo) throws SQLException, RemoteException {
        objetivoDao = new ObjetivoDao();
        Objetivo resultado = objetivoDao.getObjetivo(codObjetivo);
        return resultado;
    }

    @Override
    public Objetivo pesquisarPorNome(String nome) throws SQLException, RemoteException {
        objetivoDao = new ObjetivoDao();
        Objetivo objetivo = objetivoDao.getObjetivo(nome);
        return objetivo;
    }

    @Override
    public ArrayList<Objetivo> pesquisarTodos() throws SQLException, RemoteException {
        objetivoDao = new ObjetivoDao();
        ArrayList<Objetivo> resultado = new ArrayList<>(objetivoDao.getListaObjetivos());
        return resultado;
    }

    @Override
    public ArrayList<Objetivo> pesquisarPorAvaliacao(String codCpf, LocalDate dataAvaliacao) throws SQLException, RemoteException {
        objetivoDao = new ObjetivoDao();
        ArrayList<Objetivo> resultado = new ArrayList<>(objetivoDao.getAvaliacaoObjetivos(codCpf, dataAvaliacao));
        return resultado;
    }

    @Override
    public boolean cadastrar(Objetivo objetivo) throws SQLException, RemoteException {
        boolean testeDao;
        
        objetivoDao = new ObjetivoDao();
        testeDao = objetivoDao.postObjetivo(objetivo);
        
        return testeDao;
    }

    @Override
    public boolean alterar(Objetivo objetivo) throws SQLException, RemoteException {
        boolean testeDao;
        
        objetivoDao = new ObjetivoDao();
        testeDao = objetivoDao.putObjetivo(objetivo);
        
        return testeDao;
    }

    @Override
    public boolean excluir(int codObjetivo) throws SQLException, RemoteException {
        boolean testeDao;
        
        objetivoDao = new ObjetivoDao();
        testeDao = objetivoDao.deleteObjetivo(codObjetivo);
        
        return testeDao;
    }
}
