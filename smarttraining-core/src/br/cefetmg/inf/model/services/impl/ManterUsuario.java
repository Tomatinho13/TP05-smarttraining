package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IUsuarioDao;
import br.cefetmg.inf.model.dao.impl.UsuarioDao;
import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import br.cefetmg.inf.model.services.IManterUsuario;

public class ManterUsuario extends UnicastRemoteObject implements IManterUsuario {

    private IUsuarioDao usuarioDao;

    public ManterUsuario() throws RemoteException{
    }

    @Override
    public Usuario pesquisarPorCpf(String codCpf) throws SQLException, RemoteException {
        usuarioDao = new UsuarioDao();
        Usuario resultado = usuarioDao.getUsuario(codCpf);
        return resultado;
    }

    @Override
    public Usuario pesquisarPorNome(String nome) throws SQLException, RemoteException {
        usuarioDao = new UsuarioDao();
        Usuario resultado = usuarioDao.getUsuarioPeloNome(nome);
        return resultado;
    }

    @Override
    public ArrayList<Usuario> pesquisarTodos() throws SQLException, RemoteException {
        usuarioDao = new UsuarioDao();
        ArrayList<Usuario> listaAlunos = usuarioDao.getListaUsuarios();
        return listaAlunos;
    }

    @Override
    public boolean cadastrar(Usuario usuario) throws SQLException, RemoteException {
        boolean testeDao;
        
        usuarioDao = new UsuarioDao();
        testeDao = usuarioDao.postUsuario(usuario);
        
        return testeDao;
    }

    @Override
    public boolean alterar(Usuario usuario) throws SQLException, RemoteException {
        boolean testeDao;
        
        usuarioDao = new UsuarioDao();
        testeDao = usuarioDao.putUsuario(usuario);
        
        return testeDao;
    }

    @Override
    public boolean excluir(String codCpf) throws SQLException, RemoteException {
        boolean testeDao;
        
        usuarioDao = new UsuarioDao();
        testeDao = usuarioDao.deleteUsuario(codCpf);
        
        return testeDao;
    }
}
