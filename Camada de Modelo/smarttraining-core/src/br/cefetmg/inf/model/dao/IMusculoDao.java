package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Musculo;
import java.sql.SQLException;

/**
 *
 * @author Jamalz
 */
public interface IMusculoDao {
    public Musculo getMusculo(int codMusculo) throws SQLException;
    public void postMusculo(Musculo musculo) throws SQLException;
    public void putMusculo(Musculo musculo) throws SQLException;
    public void deleteMusculo(int codMusculo) throws SQLException;
}
