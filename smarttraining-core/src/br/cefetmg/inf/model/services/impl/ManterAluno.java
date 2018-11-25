package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IUsuarioDao;
import br.cefetmg.inf.model.dao.impl.AlunoDao;
import br.cefetmg.inf.model.domain.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import br.cefetmg.inf.model.services.IManterUsuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ManterAluno extends UnicastRemoteObject implements IManterUsuario {

    private IUsuarioDao alunoDao;

    public ManterAluno() throws RemoteException{
    }

    @Override
    public Usuario pesquisarPorCpf(String codCpf) throws SQLException, RemoteException {
        alunoDao = new AlunoDao();
        Usuario resultado = alunoDao.getUsuario(codCpf);
        return resultado;
    }

    @Override
    public Usuario pesquisarPorNome(String nome) throws SQLException, RemoteException {
        alunoDao = new AlunoDao();
        Usuario resultado = alunoDao.getUsuarioPeloNome(nome);
        return resultado;
    }

    @Override
    public ArrayList<Usuario> pesquisarTodos() throws SQLException, RemoteException {
        alunoDao = new AlunoDao();
        ArrayList<Usuario> listaAlunos = alunoDao.getListaUsuarios();
        return listaAlunos;
    }

    @Override
    public boolean cadastrar(Usuario aluno) throws SQLException, RemoteException {
        boolean testeDao;
        
        alunoDao = new AlunoDao();
        testeDao = alunoDao.postUsuario(aluno);
        
        return testeDao;
    }

    @Override
    public boolean alterar(Usuario aluno) throws SQLException, RemoteException {
        boolean testeDao;
        
        alunoDao = new AlunoDao();
        testeDao = alunoDao.putUsuario(aluno);
        
        return testeDao;
    }

    @Override
    public boolean excluir(String codCpf) throws SQLException, RemoteException {
        boolean testeDao;
        
        alunoDao = new AlunoDao();
        testeDao = alunoDao.deleteUsuario(codCpf);
        
        return testeDao;
    }
}
