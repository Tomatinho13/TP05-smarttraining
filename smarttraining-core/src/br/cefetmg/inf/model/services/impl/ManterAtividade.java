package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IAtividadeDao;
import br.cefetmg.inf.model.dao.impl.AtividadeDao;
import br.cefetmg.inf.model.domain.Atividade;
import br.cefetmg.inf.model.services.IManterAtividade;
import java.sql.SQLException;

public class ManterAtividade implements IManterAtividade {

    private final IAtividadeDao atividadeDao;

    public ManterAtividade() {
        atividadeDao = new AtividadeDao();
    }

    @Override
    public Atividade pesquisar(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException {
        Atividade resultado = atividadeDao.getAtividade(codCpf, nroTreino, codExercicio, nroAparelho, nroFicha);
        return resultado;
    }

    @Override
    public void cadastrar(Atividade atividade) throws SQLException {
        atividadeDao.postAtividade(atividade);
    }

    @Override
    public void alterar(Atividade atividade) throws SQLException {
        atividadeDao.putAtividade(atividade);
    }

    @Override
    public void excluir(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException {
        atividadeDao.deleteAtividade(codCpf, nroTreino, codExercicio, nroAparelho, nroFicha);
    }
}
