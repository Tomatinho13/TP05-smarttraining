package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IAparelhoDao;
import br.cefetmg.inf.model.dao.impl.AparelhoDao;
import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.services.IManterAparelho;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterAparelho implements IManterAparelho {

    private IAparelhoDao aparelhoDao;

    public ManterAparelho() {
    }

    @Override
    public Aparelho pesquisar(int nroAparelho) throws SQLException {
        aparelhoDao = new AparelhoDao();
        Aparelho resultado = aparelhoDao.getAparelho(nroAparelho);
        return resultado;
    }

    @Override
    public Aparelho pesquisar(String nomAparelho) throws SQLException {
        aparelhoDao = new AparelhoDao();
        Aparelho resultado = aparelhoDao.getAparelho(nomAparelho);
        return resultado;
    }

    @Override
    public ArrayList<Aparelho> pesquisarTodos() throws SQLException {
        aparelhoDao = new AparelhoDao();
        ArrayList<Aparelho> resultado = aparelhoDao.getListaAparelhos();
        return resultado;
    }

    @Override
    public boolean cadastrar(Aparelho aparelho) throws SQLException {
        boolean testeDao;
        aparelhoDao = new AparelhoDao();
        testeDao = aparelhoDao.postAparelho(aparelho);
        aparelhoDao.fechaConexao();

        return testeDao;
    }

    @Override
    public boolean alterar(Aparelho aparelho) throws SQLException {
        boolean testeDao;
        aparelhoDao = new AparelhoDao();
        testeDao = aparelhoDao.putAparelho(aparelho);
        aparelhoDao.fechaConexao();
        
        return testeDao;
    }

    @Override
    public boolean excluir(int nroAparelho) throws SQLException {
        boolean testeDao;
        aparelhoDao = new AparelhoDao();
        testeDao = aparelhoDao.deleteAparelho(nroAparelho);
        aparelhoDao.fechaConexao();
        
        return testeDao;
    }
}
