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
        try {
            regiaoCorporalDao = new RegiaoCorporalDao();
            regiaoCorporalDao.postRegiaoCorporal(regiaoCorporal, codMusculo);
            regiaoCorporalDao.fechaConexao();
        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean alterar(RegiaoCorporal regiaoCorporal) throws SQLException {
        try {
            regiaoCorporalDao = new RegiaoCorporalDao();
            regiaoCorporalDao.putRegiaoCorporal(regiaoCorporal);
            regiaoCorporalDao.fechaConexao();
        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean excluir(int codRegiao) throws SQLException {
        try {
            regiaoCorporalDao = new RegiaoCorporalDao();
            regiaoCorporalDao.deleteRegiaoCorporal(codRegiao);
            regiaoCorporalDao.fechaConexao();
        } catch (SQLException exception) {
            return false;
        }
        return true;
    }
}
