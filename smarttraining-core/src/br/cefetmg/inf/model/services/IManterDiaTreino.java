package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.DiaTreino;
import br.cefetmg.inf.model.domain.Ficha;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IManterDiaTreino {

    public ArrayList<DiaTreino> pesquisarTodos(String codCpf, String nroFicha) throws SQLException;

    public boolean cadastrar(DiaTreino diaTreino) throws SQLException;
}
