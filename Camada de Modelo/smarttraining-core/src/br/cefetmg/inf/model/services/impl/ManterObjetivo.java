package br.cefetmg.inf.model.services.impl;


import br.cefetmg.inf.model.dao.IObjetivoDao;
import br.cefetmg.inf.model.dao.impl.ObjetivoDao;
import br.cefetmg.inf.model.domain.Objetivo;
import br.cefetmg.inf.model.services.IManterObjetivo;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManterObjetivo implements IManterObjetivo {

    private final IObjetivoDao objetivoDao;
    
    public ManterObjetivo() {
        objetivoDao = new ObjetivoDao();
    }
    
    @Override
    public Objetivo pesquisarPorCodigo(int codObjetivo) throws SQLException{
        Objetivo resultado = objetivoDao.getObjetivo(codObjetivo);
        return resultado;
    }
        
    @Override
    public Objetivo pesquisarPorNome(String nome) throws SQLException {
        Objetivo objetivo = objetivoDao.getObjetivo(nome);
        return objetivo;
    }
    
    @Override
    public ArrayList<Objetivo> pesquisarPorAvaliacao(String codCpf, LocalDate dataAvaliacao) throws SQLException {
        ArrayList<Objetivo> resultado = new ArrayList<>(objetivoDao.getAvaliacaoObjetivos(codCpf, dataAvaliacao));
        return resultado;       
    }
    
    @Override
    public void cadastrar(Objetivo objetivo) throws SQLException{
        objetivoDao.postObjetivo(objetivo);
    }

    @Override
    public void alterar(Objetivo objetivo) throws SQLException{
        objetivoDao.putObjetivo(objetivo);
    }

    @Override
    public void excluir(int codObjetivo) throws SQLException{
        objetivoDao.deleteObjetivo(codObjetivo);
    }     
}
