package br.cefetmg.inf.model.dao;

import br.cefetmg.inf.model.domain.AparelhoExercicio;
import br.cefetmg.inf.model.domain.Exercicio;
import java.sql.SQLException;

/**
 *
 * @author Jamalz
 */
public interface IExercicioDao {
    public Exercicio getExercicio(String codExercicio) throws SQLException;
    public AparelhoExercicio getAparelhoExercicio(int codExercicio, int nroAparelho) throws SQLException;
    public void postExercicio(Exercicio exercicio, String seqMusculo) throws SQLException;
    public void putExercicio(Exercicio exercicio) throws SQLException;
    public void deleteExercicio(String codExercicio) throws SQLException;
}
