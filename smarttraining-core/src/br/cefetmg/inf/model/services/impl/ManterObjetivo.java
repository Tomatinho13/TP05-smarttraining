package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IObjetivoDao;
import br.cefetmg.inf.model.dao.impl.ObjetivoDao;
import br.cefetmg.inf.model.domain.Objetivo;
import br.cefetmg.inf.model.services.IManterObjetivo;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManterObjetivo implements IManterObjetivo {

    private  IObjetivoDao objetivoDao;

    public ManterObjetivo() {
    }

    @Override
    public Objetivo pesquisarPorCodigo(int codObjetivo) throws SQLException {
        objetivoDao = new ObjetivoDao();
        Objetivo resultado = objetivoDao.getObjetivo(codObjetivo);
        return resultado;
    }

    @Override
    public Objetivo pesquisarPorNome(String nome) throws SQLException {
        objetivoDao = new ObjetivoDao();
        Objetivo objetivo = objetivoDao.getObjetivo(nome);
        return objetivo;
    }

    @Override
    public ArrayList<Objetivo> pesquisarTodos() throws SQLException {
        objetivoDao = new ObjetivoDao();
        ArrayList<Objetivo> resultado = new ArrayList<>(objetivoDao.getListaObjetivos());
        return resultado;
    }

    @Override
    public ArrayList<Objetivo> pesquisarPorAvaliacao(String codCpf, LocalDate dataAvaliacao) throws SQLException {
        objetivoDao = new ObjetivoDao();
        ArrayList<Objetivo> resultado = new ArrayList<>(objetivoDao.getAvaliacaoObjetivos(codCpf, dataAvaliacao));
        return resultado;
    }

    @Override
    public void cadastrar(Objetivo objetivo) throws SQLException {
        objetivoDao = new ObjetivoDao();
        objetivoDao.postObjetivo(objetivo);
    }

    @Override
    public void alterar(Objetivo objetivo) throws SQLException {
        objetivoDao = new ObjetivoDao();
        objetivoDao.putObjetivo(objetivo);
    }

    @Override
    public void excluir(int codObjetivo) throws SQLException {
        objetivoDao = new ObjetivoDao();
        objetivoDao.deleteObjetivo(codObjetivo);
    }
}
