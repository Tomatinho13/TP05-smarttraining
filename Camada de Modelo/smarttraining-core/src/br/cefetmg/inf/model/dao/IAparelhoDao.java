package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.domain.Exercicio;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jamalz
 */
public interface IAparelhoDao {
    public Aparelho getAparelho(String codAparelho) throws SQLException;
    public ArrayList<Aparelho> getListaAparelhos() throws SQLException;
    public ArrayList<Exercicio> getListaExercicios(int nroAparelho) throws SQLException;
    public void postAparelho(Aparelho aparelho) throws SQLException;
    public void putAparelho(Aparelho aparelho) throws SQLException;
    public void deleteAparelho(String codAparelho) throws SQLException;
}
