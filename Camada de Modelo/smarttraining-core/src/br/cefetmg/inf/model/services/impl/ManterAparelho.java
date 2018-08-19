package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IAparelhoDao;
import br.cefetmg.inf.model.dao.impl.AparelhoDao;
import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.services.IManterAparelho;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterAparelho implements IManterAparelho {

    private final IAparelhoDao aparelhoDao;

    public ManterAparelho() {
        aparelhoDao = new AparelhoDao();
    }

    @Override
    public Aparelho pesquisar(int nroAparelho) throws SQLException {
        Aparelho resultado = aparelhoDao.getAparelho(nroAparelho);
        return resultado;
    }
    
    @Override
    public Aparelho pesquisar(String nomAparelho) throws SQLException{
        Aparelho resultado = aparelhoDao.getAparelho(nomAparelho);
        return resultado;
    }
    
    @Override
    public ArrayList<Aparelho> pesquisarTodos() throws SQLException{
        ArrayList<Aparelho> resultado = aparelhoDao.getListaAparelhos();
        return resultado;
    }

    @Override
    public void cadastrar(Aparelho aparelho) throws SQLException {
        aparelhoDao.postAparelho(aparelho);
    }

    @Override
    public void alterar(Aparelho aparelho) throws SQLException {
        aparelhoDao.putAparelho(aparelho);
    }

    @Override
    public void excluir(int nroAparelho) throws SQLException {
        aparelhoDao.deleteAparelho(nroAparelho);
    }
}
