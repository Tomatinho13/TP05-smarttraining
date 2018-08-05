package br.cefetmg.inf.model.services.impl;


import br.cefetmg.inf.model.dao.IMusculoDao;
import br.cefetmg.inf.model.dao.impl.MusculoDao;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.services.IManterMusculo;
import java.sql.SQLException;

public class ManterMusculo implements IManterMusculo {

    private IMusculoDao musculoDao;
    
    public ManterMusculo() {
        musculoDao = new MusculoDao();
    }
    
    @Override
    public Musculo pesquisarPorCodigo(int codMusculo) throws SQLException{
        Musculo resultado = musculoDao.getMusculo(codMusculo);
        return resultado;
    }
    
    @Override
    public void cadastrar(Musculo musculo) throws SQLException{
        musculoDao.postMusculo(musculo);
    }

    @Override
    public void alterar(Musculo musculo) throws SQLException{
        musculoDao.putMusculo(musculo);
    }

    @Override
    public void excluir(int codMusculo) throws SQLException{
        musculoDao.deleteMusculo(codMusculo);
    }     
}
