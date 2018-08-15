package br.cefetmg.inf.model.services.impl;


import br.cefetmg.inf.model.dao.IRegiaoCorporalDao;
import br.cefetmg.inf.model.dao.impl.RegiaoCorporalDao;
import br.cefetmg.inf.model.domain.RegiaoCorporal;
import br.cefetmg.inf.model.services.IManterRegiaoCorporal;
import java.sql.SQLException;

public class ManterRegiaoCorporal implements IManterRegiaoCorporal {

    private final IRegiaoCorporalDao regiaoCorporalDao;
    
    public ManterRegiaoCorporal() {
        regiaoCorporalDao = new RegiaoCorporalDao();
    }
    
    @Override
    public RegiaoCorporal pesquisarRegiaoCorporal(int codRegiao) throws SQLException {
        RegiaoCorporal resultado = regiaoCorporalDao.getRegiaoCorporal(codRegiao);
        return resultado;       
    }
    
    @Override
    public void cadastrar(RegiaoCorporal regiaoCorporal, int codMusculo) throws SQLException{
        regiaoCorporalDao.postRegiaoCorporal(regiaoCorporal, codMusculo);
    }

    @Override
    public void alterar(RegiaoCorporal regiaoCorporal) throws SQLException{
        regiaoCorporalDao.putRegiaoCorporal(regiaoCorporal);
    }

    @Override
    public void excluir(int codRegiao) throws SQLException{
        regiaoCorporalDao.deleteRegiaoCorporal(codRegiao);
    }     
}
