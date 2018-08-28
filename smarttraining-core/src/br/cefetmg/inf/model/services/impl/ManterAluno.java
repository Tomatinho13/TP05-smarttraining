package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IUsuarioDao;
import br.cefetmg.inf.model.dao.impl.AlunoDao;
import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import br.cefetmg.inf.model.services.IManterUsuario;

public class ManterAluno implements IManterUsuario {

    private final IUsuarioDao alunoDao;

    public ManterAluno() {
        alunoDao = new AlunoDao();
    }

    @Override
    public Usuario pesquisarPorCpf(String codCpf) throws SQLException {
        Usuario resultado = alunoDao.getUsuario(codCpf);
        return resultado;
    }

    @Override
    public Usuario pesquisarPorNome(String nome) throws SQLException {
        Usuario resultado = alunoDao.getUsuarioPeloNome(nome);
        return resultado;
    }
        
    @Override
    public ArrayList<Usuario> pesquisarTodos() throws SQLException {
        ArrayList <Usuario> listaAlunos = alunoDao.getListaUsuarios();
        return listaAlunos;
    }
    
    @Override
    public void cadastrar(Usuario aluno) throws SQLException {
        alunoDao.postUsuario(aluno);
    }

    @Override
    public void alterar(Usuario aluno) throws SQLException {
        alunoDao.putUsuario(aluno);
    }

    @Override
    public void excluir(String codCpf) throws SQLException {
        alunoDao.deleteUsuario(codCpf);
    }
}
