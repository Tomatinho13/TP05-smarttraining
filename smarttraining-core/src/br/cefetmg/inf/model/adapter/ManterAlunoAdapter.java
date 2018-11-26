package br.cefetmg.inf.model.adapter;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.model.services.impl.ManterAluno;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterAlunoAdapter implements IManterUsuario {

    public ManterAlunoAdapter() throws RemoteException {
        this.manterAluno = new ManterAluno();
    }

    private final IManterUsuario manterAluno;

    @Override
    public Usuario pesquisarPorCpf(String codCpf) throws SQLException, RemoteException {
        Usuario resultado = manterAluno.pesquisarPorCpf(codCpf);
        return resultado;
    }

    @Override
    public Usuario pesquisarPorNome(String nome) throws SQLException, RemoteException {
        Usuario resultado = manterAluno.pesquisarPorNome(nome);
        return resultado;
    }

    @Override
    public ArrayList<Usuario> pesquisarTodos() throws SQLException, RemoteException {
        return manterAluno.pesquisarTodos();
    }

    @Override
    public boolean cadastrar(Usuario aluno) throws SQLException, RemoteException {
        boolean resultado = manterAluno.cadastrar(aluno);
        return resultado;
    }

    @Override
    public boolean alterar(Usuario aluno) throws SQLException, RemoteException {
        boolean resultado = manterAluno.alterar(aluno);
        return resultado;
    }

    @Override
    public boolean excluir(String codCpf) throws SQLException, RemoteException {
        boolean resultado = manterAluno.excluir(codCpf);
        return resultado;
    }
}
