package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IExercicioDao;
import br.cefetmg.inf.model.dao.impl.ExercicioDao;
import br.cefetmg.inf.model.domain.AparelhoExercicio;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManterExercicio implements IManterExercicio {

    private IExercicioDao exercicioDao;

    public ManterExercicio() {
    }

    @Override
    public Exercicio pesquisarPorCodigo(int codExercicio) throws SQLException {
        exercicioDao = new ExercicioDao();
        Exercicio resultado = exercicioDao.getExercicio(codExercicio);
        return resultado;
    }

    @Override
    public Exercicio pesquisarPorNome(String nomeExercicio) throws SQLException {
        exercicioDao = new ExercicioDao();
        Exercicio exercicio = exercicioDao.getExercicio(nomeExercicio);
        return exercicio;
    }

    @Override
    public AparelhoExercicio pesquisarAparelhoExercicio(int codExercicio, int nroAparelho) throws SQLException {
        exercicioDao = new ExercicioDao();
        AparelhoExercicio resultado = exercicioDao.getAparelhoExercicio(codExercicio, nroAparelho);
        return resultado;
    }

    @Override
    public ArrayList<Exercicio> pesquisarPorRegiao(String nomeRegiao) throws SQLException {
        exercicioDao = new ExercicioDao();
        ArrayList<Exercicio> resultado = exercicioDao.getRegiaoExercicios(nomeRegiao);
        return resultado;
    }

    @Override
    public ArrayList<Exercicio> pesquisarPorMusculo(int codMusculo) throws SQLException {
        exercicioDao = new ExercicioDao();
        ArrayList<Exercicio> resultado = exercicioDao.getMusculoExercicios(codMusculo);
        return resultado;
    }

    @Override
    public ArrayList<Exercicio> pesquisarTodos() throws SQLException {
        exercicioDao = new ExercicioDao();
        ArrayList<Exercicio> resultado = exercicioDao.getListaExercicios();
        return resultado;
    }

    @Override
    public boolean cadastrar(Exercicio exercicio) throws SQLException {
        try {
            exercicioDao = new ExercicioDao();
            exercicioDao.postExercicio(exercicio);
            exercicioDao.fechaConexao();
        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean cadastrarAparelhoExercicio(int codExercicio, int nroAparelho, String caminhoImg) throws SQLException {
        try {
            exercicioDao = new ExercicioDao();
            exercicioDao.postAparelhoExercicio(codExercicio, nroAparelho, caminhoImg);
            exercicioDao.fechaConexao();
        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean alterar(Exercicio exercicio) throws SQLException {
        try {
            exercicioDao = new ExercicioDao();
            exercicioDao.putExercicio(exercicio);
            exercicioDao.fechaConexao();
        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean excluir(int codExercicio) throws SQLException {
        try {
            exercicioDao = new ExercicioDao();
            exercicioDao.deleteExercicio(codExercicio);
            exercicioDao.fechaConexao();
        } catch (SQLException exception) {
            return false;
        }
        return true;
    }
}
