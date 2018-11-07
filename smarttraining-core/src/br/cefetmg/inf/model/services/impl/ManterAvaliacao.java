package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IAvaliacaoDao;
import br.cefetmg.inf.model.dao.impl.AvaliacaoDao;
import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManterAvaliacao implements IManterAvaliacao {

    private IAvaliacaoDao avaliacaoDao;

    public ManterAvaliacao() {
    }

    @Override
    public ArrayList<Avaliacao> pesquisarPorAluno(String codCpf) throws SQLException {
        avaliacaoDao = new AvaliacaoDao();
        ArrayList<Avaliacao> resultado = new ArrayList<>(avaliacaoDao.getListaAvaliacao(codCpf));
        return resultado;
    }

    @Override
    public Avaliacao pesquisar(String codCpf, LocalDate data) throws SQLException {
        avaliacaoDao = new AvaliacaoDao();
        Avaliacao resultado = avaliacaoDao.getAvaliacao(codCpf, data);
        return resultado;
    }

    @Override
    public boolean cadastrar(Avaliacao avaliacao) throws SQLException {
        boolean testeDao;
        
        avaliacaoDao = new AvaliacaoDao();
        testeDao = avaliacaoDao.postAvaliacao(avaliacao);
        avaliacaoDao.fechaConexao();
        
        return testeDao;
    }

    @Override
    public boolean alterar(Avaliacao avaliacao) throws SQLException {
        boolean testeDao;
        
        avaliacaoDao = new AvaliacaoDao();
        testeDao = avaliacaoDao.putAvaliacao(avaliacao);
        avaliacaoDao.fechaConexao();
        
        return testeDao;
    }

    @Override
    public boolean excluir(String codCpf, LocalDate datAvaliacao) throws SQLException {
        boolean testeDao;
        
        avaliacaoDao = new AvaliacaoDao();
        testeDao = avaliacaoDao.deleteAvaliacao(codCpf, datAvaliacao);
        avaliacaoDao.fechaConexao();
        
        return testeDao;
    }
}
