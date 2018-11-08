package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IUsuarioDao;
import br.cefetmg.inf.model.dao.impl.InstrutorDao;
import br.cefetmg.inf.model.domain.Instrutor;
import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import br.cefetmg.inf.model.services.IManterUsuario;

public class ManterInstrutor implements IManterUsuario {

    private IUsuarioDao instrutorDao;

    public ManterInstrutor() {
    }

    @Override
    public Instrutor pesquisarPorCpf(String codCpf) throws SQLException {
        instrutorDao = new InstrutorDao();
        Instrutor resultado = (Instrutor) instrutorDao.getUsuario(codCpf);
        return resultado;
    }

    @Override
    public Usuario pesquisarPorNome(String nome) throws SQLException {
        instrutorDao = new InstrutorDao();
        Instrutor resultado = (Instrutor) instrutorDao.getUsuarioPeloNome(nome);
        return resultado;
    }

    @Override
    public ArrayList<Usuario> pesquisarTodos() throws SQLException {
        instrutorDao = new InstrutorDao();
        ArrayList<Usuario> listaInstrutores = instrutorDao.getListaUsuarios();
        return listaInstrutores;
    }

    @Override
    public boolean cadastrar(Usuario instrutor) throws SQLException {
        boolean testeDao;
        
        instrutorDao = new InstrutorDao();
        testeDao = instrutorDao.postUsuario((Instrutor) instrutor);
        
        return testeDao;
    }

    @Override
    public boolean alterar(Usuario instrutor) throws SQLException {
        boolean testeDao;
        
        instrutorDao = new InstrutorDao();
        testeDao = instrutorDao.putUsuario((Instrutor) instrutor);
        
        return testeDao;
    }

    @Override
    public boolean excluir(String codCpf) throws SQLException {
        boolean testeDao;
        
        instrutorDao = new InstrutorDao();
        testeDao = instrutorDao.deleteUsuario(codCpf);
        
        return testeDao;
    }
}
