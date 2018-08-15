package br.cefetmg.inf.model.services.impl;


import br.cefetmg.inf.model.dao.IAvaliacaoDao;
import br.cefetmg.inf.model.dao.impl.AvaliacaoDao;
import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManterAvaliacao implements IManterAvaliacao {

    private final IAvaliacaoDao avaliacaoDao;
    
    public ManterAvaliacao() {
        avaliacaoDao = new AvaliacaoDao();
    }
    
    @Override
    public ArrayList<Avaliacao> pesquisarPorAluno(String codCpf) throws SQLException{
        ArrayList<Avaliacao> resultado = new ArrayList<>(avaliacaoDao.getListaAvaliacao(codCpf));
        return resultado;       
    }
    
    @Override
    public Avaliacao pesquisarPorAluno(String codCpf, LocalDate data) throws SQLException {
        Avaliacao resultado = avaliacaoDao.getAvaliacao(codCpf, data);
        return resultado;
    }
    
    @Override
    public void cadastrar(Avaliacao avaliacao) throws SQLException{
        avaliacaoDao.postAvaliacao(avaliacao);
    }

    @Override
    public void alterar(Avaliacao avaliacao) throws SQLException{
        avaliacaoDao.putAvaliacao(avaliacao);
    }

    @Override
    public void excluir(String codCpf, LocalDate datAvaliacao) throws SQLException {
        avaliacaoDao.deleteAvaliacao(codCpf, datAvaliacao);
    }     
}