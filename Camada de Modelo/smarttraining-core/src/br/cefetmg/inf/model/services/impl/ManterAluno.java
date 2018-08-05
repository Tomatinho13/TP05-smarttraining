package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IAlunoDao;
import br.cefetmg.inf.model.dao.impl.AlunoDao;
import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterAluno;
import java.sql.SQLException;

public class ManterAluno implements IManterAluno {

    private IAlunoDao alunoDao;

    public ManterAluno() {
        alunoDao = new AlunoDao();
    }

    @Override
    public Usuario pesquisarPorCpf(String codCpf) throws SQLException {
        Usuario resultado = alunoDao.getAluno(codCpf);
        return resultado;
    }

    @Override
    public void cadastrar(Usuario aluno) throws SQLException {
        alunoDao.postAluno(aluno);
    }

    @Override
    public void alterar(Usuario aluno) throws SQLException {
        alunoDao.putAluno(aluno);
    }

    @Override
    public void excluir(String codCpf) throws SQLException {
        alunoDao.deleteAluno(codCpf);
    }
}
