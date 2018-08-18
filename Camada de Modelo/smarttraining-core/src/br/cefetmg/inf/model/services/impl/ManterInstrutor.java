package br.cefetmg.inf.model.services.impl;


import br.cefetmg.inf.model.dao.IUsuarioDao;
import br.cefetmg.inf.model.dao.impl.InstrutorDao;
import br.cefetmg.inf.model.domain.Instrutor;
import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterInstrutor implements IManterUsuario {

    private final IUsuarioDao instrutorDao;
    
    public ManterInstrutor() {
        instrutorDao = new InstrutorDao();
    }
    
    @Override
    public Instrutor pesquisarPorCpf(String codCpf) throws SQLException{
        Instrutor resultado = (Instrutor)instrutorDao.getUsuario(codCpf);
        return resultado;
    }
    
    @Override
    public Usuario pesquisarPorNome(String nome) throws SQLException {
        Instrutor resultado = (Instrutor)instrutorDao.getUsuarioPeloNome(nome);
        return resultado;
    }
    
    @Override
    public ArrayList<Usuario> pesquisarTodos() throws SQLException {
        ArrayList<Usuario> listaInstrutores = instrutorDao.getListaUsuarios();
        return listaInstrutores;
    }
    
    @Override
    public void cadastrar(Usuario instrutor) throws SQLException{
        instrutorDao.postUsuario((Instrutor)instrutor);
    }

    @Override
    public void alterar(Usuario instrutor) throws SQLException{
        instrutorDao.putUsuario((Instrutor)instrutor);
    }

    @Override
    public void excluir(String codCpf) throws SQLException{
        instrutorDao.deleteUsuario(codCpf);
    }     
}
