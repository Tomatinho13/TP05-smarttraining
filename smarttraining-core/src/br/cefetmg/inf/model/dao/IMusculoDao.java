package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.Musculo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jamalz
 */
public interface IMusculoDao {

    public Musculo getMusculo(int codMusculo) throws SQLException;

    public ArrayList<Musculo> getListaMusculos() throws SQLException;

    public ArrayList<Musculo> getExercicioMusculos(int codExercicio);

    public boolean postMusculo(Musculo musculo) throws SQLException;

    public boolean putMusculo(Musculo musculo) throws SQLException;

    public boolean deleteMusculo(int codMusculo) throws SQLException;

    public void fechaConexao();
}
