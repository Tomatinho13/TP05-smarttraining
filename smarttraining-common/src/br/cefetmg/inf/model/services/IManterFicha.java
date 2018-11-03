package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Ficha;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IManterFicha {

    public Ficha pesquisarPorCodigo(String codCpf, int nroFicha) throws SQLException;

    public ArrayList<Ficha> pesquisarPorAluno(String codCpf) throws SQLException;

    public boolean cadastrar(Ficha ficha) throws SQLException;

    public boolean alterar(Ficha ficha) throws SQLException;

    public boolean excluir(String codCpf, int nroFicha) throws SQLException;
}
