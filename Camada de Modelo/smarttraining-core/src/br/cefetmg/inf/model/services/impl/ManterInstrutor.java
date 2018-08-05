package br.cefetmg.inf.model.services.impl;


import br.cefetmg.inf.model.dao.IInstrutorDao;
import br.cefetmg.inf.model.dao.impl.InstrutorDao;
import br.cefetmg.inf.model.domain.Instrutor;
import br.cefetmg.inf.model.services.IManterInstrutor;
import java.sql.SQLException;

public class ManterInstrutor implements IManterInstrutor {

    private IInstrutorDao instrutorDao;
    
    public ManterInstrutor() {
        instrutorDao = new InstrutorDao();
    }
    
    @Override
    public Instrutor pesquisarPorCpf(String codCpf) throws SQLException{
        Instrutor resultado = instrutorDao.getInstrutor(codCpf);
        return resultado;
    }
    
    @Override
    public void cadastrar(Instrutor instrutor) throws SQLException{
        instrutorDao.postInstrutor(instrutor);
    }

    @Override
    public void alterar(Instrutor instrutor) throws SQLException{
        instrutorDao.putInstrutor(instrutor);
    }

    @Override
    public void excluir(String codCpf) throws SQLException{
        instrutorDao.deleteInstrutor(codCpf);
    }     
}
