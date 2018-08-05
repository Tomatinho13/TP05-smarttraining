package br.cefetmg.inf.model.services;

import br.cefetmg.inf.model.domain.Aparelho;
import java.sql.SQLException;

public interface IManterAparelho {

    public Aparelho pesquisar(int nroAparelho) throws SQLException;

    public void cadastrar(Aparelho aparelho) throws SQLException;

    public void alterar(Aparelho aparelho) throws SQLException;

    public void excluir(int nroAparelho) throws SQLException;
}
