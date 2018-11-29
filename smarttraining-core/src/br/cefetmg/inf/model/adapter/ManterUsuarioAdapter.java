package br.cefetmg.inf.model.adapter;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.model.services.impl.ManterUsuario;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterUsuarioAdapter implements IManterUsuario {

    private final IManterUsuario manterUsuario;

    public ManterUsuarioAdapter() throws RemoteException {
        this.manterUsuario = new ManterUsuario();
    }

    @Override
    public Usuario pesquisarPorCpf(String codCpf) throws SQLException, RemoteException {
        Usuario resultado = manterUsuario.pesquisarPorCpf(codCpf);
        return resultado;
    }

    @Override
    public Usuario pesquisarPorNome(String nome) throws SQLException, RemoteException {
        Usuario resultado = manterUsuario.pesquisarPorNome(nome);
        return resultado;
    }

    @Override
    public ArrayList<Usuario> pesquisarTodos() throws SQLException, RemoteException {
        return manterUsuario.pesquisarTodos();
    }

    @Override
    public boolean cadastrar(Usuario aluno) throws SQLException, RemoteException {
        boolean resultado = manterUsuario.cadastrar(aluno);
        return resultado;
    }

    @Override
    public boolean alterar(Usuario aluno) throws SQLException, RemoteException {
        boolean resultado = manterUsuario.alterar(aluno);
        return resultado;
    }

    @Override
    public boolean excluir(String codCpf) throws SQLException, RemoteException {
        boolean resultado = manterUsuario.excluir(codCpf);
        return resultado;
    }

}
