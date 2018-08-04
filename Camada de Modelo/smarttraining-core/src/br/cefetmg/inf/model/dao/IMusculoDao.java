package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.domain.Musculo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jamalz
 */
public interface IMusculoDao {
    public Musculo getMusculo(String codMusculo) throws SQLException;
    public ArrayList<Exercicio> getMusculoExercicios(String codMusculo) throws SQLException;
    public void postMusculo(Musculo musculo) throws SQLException;
    public void putMusculo(Musculo musculo) throws SQLException;
    public void deleteMusculo(String codMusculo) throws SQLException;
}
