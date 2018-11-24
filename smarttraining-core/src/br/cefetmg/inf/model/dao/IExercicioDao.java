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

    public Exercicio getExercicio(String nomeExercicio) throws SQLException;

    public AparelhoExercicio getAparelhoExercicio(int codExercicio, int nroAparelho) throws SQLException;

    public ArrayList<Exercicio> getRegiaoExercicios(String nomRegiao) throws SQLException;
    
    public ArrayList<Exercicio> getAparelhoExercicios(int nroAparelho) throws SQLException;

    public ArrayList<Exercicio> getMusculoExercicios(int codMusculo) throws SQLException;

    public ArrayList<Exercicio> getListaExercicios() throws SQLException;

    public boolean postExercicio(Exercicio exercicio) throws SQLException;

    public boolean postAparelhoExercicio(int codExercicio, int nroAparelho, String caminhoImg) throws SQLException;

    public boolean putExercicio(Exercicio exercicio) throws SQLException;

    public boolean deleteExercicio(int codExercicio) throws SQLException;

    public void fechaConexao();
}
