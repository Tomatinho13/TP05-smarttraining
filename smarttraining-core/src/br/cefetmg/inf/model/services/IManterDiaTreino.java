package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Atividade;
import br.cefetmg.inf.model.domain.DiaTreino;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IManterDiaTreino {

    public ArrayList<DiaTreino> pesquisarTodos(Atividade atividade) throws SQLException;

    public boolean cadastrar(DiaTreino diaTreino) throws SQLException;
}
