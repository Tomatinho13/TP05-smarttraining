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
        fichaDao = new FichaDao();
    }
    
    @Override
    public Ficha pesquisarPorCodigo(String codCpf, int nroFicha) throws SQLException{
        Ficha resultado = fichaDao.getFicha(codCpf, nroFicha);
        return resultado;
    }
    
    @Override
    public ArrayList<Ficha> pesquisarPorAluno(String codCpf) throws SQLException{
        ArrayList<Ficha> resultado = new ArrayList<>(fichaDao.getListaFicha(codCpf));
        return resultado;       
    }
    
    @Override
    public void cadastrar(Ficha ficha) throws SQLException{
        fichaDao.postFicha(ficha);
    }

    @Override
    public void alterar(Ficha ficha) throws SQLException{
        fichaDao.putFicha(ficha);
    }

    @Override
    public void excluir(String codCpf, int nroFicha) throws SQLException{
        fichaDao.deleteFicha(codCpf, nroFicha);
    }     
}
