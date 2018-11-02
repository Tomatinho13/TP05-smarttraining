package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Atividade;
import java.sql.SQLException;

public interface IManterAtividade {

    public Atividade pesquisar(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException;

    public boolean cadastrar(Atividade atividade) throws SQLException;

    public boolean alterar(Atividade atividade) throws SQLException;

    public boolean excluir(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException;
}
