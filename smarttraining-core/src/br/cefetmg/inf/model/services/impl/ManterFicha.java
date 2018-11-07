package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IFichaDao;
import br.cefetmg.inf.model.dao.impl.FichaDao;
import br.cefetmg.inf.model.domain.Ficha;
import br.cefetmg.inf.model.services.IManterFicha;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterFicha implements IManterFicha {

    private IFichaDao fichaDao;

    public ManterFicha() {
    }

    @Override
    public Ficha pesquisarPorCodigo(String codCpf, int nroFicha) throws SQLException {
        fichaDao = new FichaDao();
        Ficha resultado = fichaDao.getFicha(codCpf, nroFicha);
        return resultado;
    }

    @Override
    public ArrayList<Ficha> pesquisarPorAluno(String codCpf) throws SQLException {
        fichaDao = new FichaDao();
        ArrayList<Ficha> resultado = new ArrayList<>(fichaDao.getListaFicha(codCpf));
        return resultado;
    }

    @Override
    public boolean cadastrar(Ficha ficha) throws SQLException {
        boolean testeDao;
        
        fichaDao = new FichaDao();
        testeDao = fichaDao.postFicha(ficha);
        fichaDao.fechaConexao();
        
        return testeDao;
    }

    @Override
    public boolean alterar(Ficha ficha) throws SQLException {
        boolean testeDao;
        
        fichaDao = new FichaDao();
        testeDao = fichaDao.putFicha(ficha);
        fichaDao.fechaConexao();
        
        return testeDao;
    }

    @Override
    public boolean excluir(String codCpf, int nroFicha) throws SQLException {
        boolean testeDao;
        
        fichaDao = new FichaDao();
        testeDao = fichaDao.deleteFicha(codCpf, nroFicha);
        fichaDao.fechaConexao();
        
        return testeDao;
    }
}
