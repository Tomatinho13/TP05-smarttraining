package br.cefetmg.inf.model.adapter;

import br.cefetmg.inf.model.domain.Usuario;
import br.cefetmg.inf.model.services.IManterUsuario;
import br.cefetmg.inf.model.services.impl.ManterInstrutor;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterInstrutorAdapter implements IManterUsuario {

    private final IManterUsuario manterInstrutor;

    public ManterInstrutorAdapter() throws RemoteException {
        this.manterInstrutor = new ManterInstrutor();
    }

    @Override
    public Usuario pesquisarPorCpf(String codCpf) throws SQLException, RemoteException {
        Usuario resultado = manterInstrutor.pesquisarPorCpf(codCpf);
        return resultado;
    }

    @Override
    public Usuario pesquisarPorNome(String nome) throws SQLException, RemoteException {
        Usuario resultado = manterInstrutor.pesquisarPorNome(nome);
        return resultado;
    }

    @Override
    public ArrayList<Usuario> pesquisarTodos() throws SQLException, RemoteException {
        return manterInstrutor.pesquisarTodos();
    }

    @Override
    public boolean cadastrar(Usuario aluno) throws SQLException, RemoteException {
        boolean resultado = manterInstrutor.cadastrar(aluno);
        return resultado;
    }

    @Override
    public boolean alterar(Usuario aluno) throws SQLException, RemoteException {
        boolean resultado = manterInstrutor.alterar(aluno);
        return resultado;
    }

    @Override
    public boolean excluir(String codCpf) throws SQLException, RemoteException {
        boolean resultado = manterInstrutor.excluir(codCpf);
        return resultado;
    }

}
