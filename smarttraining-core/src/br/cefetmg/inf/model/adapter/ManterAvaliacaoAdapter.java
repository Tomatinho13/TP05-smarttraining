package br.cefetmg.inf.model.adapter;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import br.cefetmg.inf.model.services.impl.ManterAvaliacao;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManterAvaliacaoAdapter implements IManterAvaliacao {

    public ManterAvaliacaoAdapter() throws RemoteException {
        this.manterAvaliacao = new ManterAvaliacao();
    }

    private final IManterAvaliacao manterAvaliacao;

    @Override
    public ArrayList<Avaliacao> pesquisarPorAluno(String codCpf) throws SQLException, RemoteException {
        return manterAvaliacao.pesquisarPorAluno(codCpf);
    }

    @Override
    public Avaliacao pesquisar(String codCpf, LocalDate data) throws SQLException, RemoteException {
        Avaliacao resultado = manterAvaliacao.pesquisar(codCpf, data);
        return resultado;
    }

    @Override
    public boolean cadastrar(Avaliacao avaliacao) throws SQLException, RemoteException {
        boolean resultado = manterAvaliacao.cadastrar(avaliacao);
        return resultado;
    }

    @Override
    public boolean alterar(Avaliacao avaliacao) throws SQLException, RemoteException {
        boolean resultado = manterAvaliacao.alterar(avaliacao);
        return resultado;
    }

    @Override
    public boolean excluir(String codCpf, LocalDate datAvaliacao) throws SQLException, RemoteException {
        boolean resultado = manterAvaliacao.excluir(codCpf, datAvaliacao);
        return resultado;
    }
}
