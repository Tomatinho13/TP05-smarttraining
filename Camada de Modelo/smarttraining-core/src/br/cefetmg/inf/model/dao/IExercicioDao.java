package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.AparelhoExercicio;
import br.cefetmg.inf.model.domain.Exercicio;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jamalz
 */
public interface IExercicioDao {
    public Exercicio getExercicio(int codExercicio) throws SQLException;
    public AparelhoExercicio getAparelhoExercicio(int codExercicio, int nroAparelho) throws SQLException;
    public ArrayList<Exercicio> getRegiaoExercicios(String nomRegiao) throws SQLException;
    public ArrayList<Exercicio> getMusculoExercicios(int codMusculo) throws SQLException;
    public void postExercicio(Exercicio exercicio, int codMusculo) throws SQLException;
    public void putExercicio(Exercicio exercicio) throws SQLException;
    public void deleteExercicio(int codExercicio) throws SQLException;
}
