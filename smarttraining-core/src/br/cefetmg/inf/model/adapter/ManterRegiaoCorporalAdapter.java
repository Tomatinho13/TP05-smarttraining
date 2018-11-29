package br.cefetmg.inf.model.adapter;

import br.cefetmg.inf.model.domain.RegiaoCorporal;
import br.cefetmg.inf.model.services.IManterRegiaoCorporal;
import br.cefetmg.inf.model.services.impl.ManterRegiaoCorporal;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class ManterRegiaoCorporalAdapter implements IManterRegiaoCorporal {

    private final IManterRegiaoCorporal manterRegiaoCorporal;

    public ManterRegiaoCorporalAdapter() throws RemoteException {
        this.manterRegiaoCorporal = new ManterRegiaoCorporal();
    }

    @Override
    public RegiaoCorporal pesquisarRegiaoCorporal(int codRegiao) throws SQLException, RemoteException {
        RegiaoCorporal resultado = manterRegiaoCorporal.pesquisarRegiaoCorporal(codRegiao);
        return resultado;
    }

    @Override
    public boolean cadastrar(RegiaoCorporal regiaoCorporal, int codMusculo) throws SQLException, RemoteException {
        boolean resultado = manterRegiaoCorporal.cadastrar(regiaoCorporal, codMusculo);
        return resultado;
    }

    @Override
    public boolean alterar(RegiaoCorporal regiaoCorporal) throws SQLException, RemoteException {
        boolean resultado = manterRegiaoCorporal.alterar(regiaoCorporal);
        return resultado;
    }

    @Override
    public boolean excluir(int codRegiao) throws SQLException, RemoteException {
        boolean resultado = manterRegiaoCorporal.excluir(codRegiao);
        return resultado;
    }

}
