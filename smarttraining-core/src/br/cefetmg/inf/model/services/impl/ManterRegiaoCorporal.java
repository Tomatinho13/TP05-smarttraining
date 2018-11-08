package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IRegiaoCorporalDao;
import br.cefetmg.inf.model.dao.impl.RegiaoCorporalDao;
import br.cefetmg.inf.model.domain.RegiaoCorporal;
import br.cefetmg.inf.model.services.IManterRegiaoCorporal;
import java.sql.SQLException;

public class ManterRegiaoCorporal implements IManterRegiaoCorporal {

    private IRegiaoCorporalDao regiaoCorporalDao;

    public ManterRegiaoCorporal() {
    }

    @Override
    public RegiaoCorporal pesquisarRegiaoCorporal(int codRegiao) throws SQLException {
        regiaoCorporalDao = new RegiaoCorporalDao();
        RegiaoCorporal resultado = regiaoCorporalDao.getRegiaoCorporal(codRegiao);
        return resultado;
    }

    @Override
    public boolean cadastrar(RegiaoCorporal regiaoCorporal, int codMusculo) throws SQLException {
        boolean testeDao;
        
        regiaoCorporalDao = new RegiaoCorporalDao();
        testeDao = regiaoCorporalDao.postRegiaoCorporal(regiaoCorporal, codMusculo);
        
        return testeDao;
    }

    @Override
    public boolean alterar(RegiaoCorporal regiaoCorporal) throws SQLException {
        boolean testeDao;
        
        regiaoCorporalDao = new RegiaoCorporalDao();
        testeDao = regiaoCorporalDao.putRegiaoCorporal(regiaoCorporal);
        
        return testeDao;
    }

    @Override
    public boolean excluir(int codRegiao) throws SQLException {
        boolean testeDao;
        
        regiaoCorporalDao = new RegiaoCorporalDao();
        testeDao = regiaoCorporalDao.deleteRegiaoCorporal(codRegiao);
        
        return testeDao;
    }
}
