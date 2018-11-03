package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IAtividadeDao;
import br.cefetmg.inf.model.dao.impl.AtividadeDao;
import br.cefetmg.inf.model.domain.Atividade;
import br.cefetmg.inf.model.services.IManterAtividade;
import java.sql.SQLException;

public class ManterAtividade implements IManterAtividade {

    private IAtividadeDao atividadeDao;

    public ManterAtividade() {
    }

    @Override
    public Atividade pesquisar(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException {
        atividadeDao = new AtividadeDao();
        Atividade resultado = atividadeDao.getAtividade(codCpf, nroTreino, codExercicio, nroAparelho, nroFicha);
        return resultado;
    }

    @Override
    public boolean cadastrar(Atividade atividade) throws SQLException {
        try {
            atividadeDao = new AtividadeDao();
            atividadeDao.postAtividade(atividade);
            atividadeDao.fechaConexao();
        } catch(SQLException exception){
            return false;
        }
        return true;
    }

    @Override
    public boolean alterar(Atividade atividade) throws SQLException {
        try {
            atividadeDao = new AtividadeDao();
            atividadeDao.putAtividade(atividade);
            atividadeDao.fechaConexao();
        } catch(SQLException exception){
            return false;
        }
        return true;
    }

    @Override
    public boolean excluir(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException {
        try {    
            atividadeDao = new AtividadeDao();
            atividadeDao.deleteAtividade(codCpf, nroTreino, codExercicio, nroAparelho, nroFicha);
            atividadeDao.fechaConexao();
        } catch(SQLException exception){
            return false;
        }    
        return true;
    }
}
