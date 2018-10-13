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
    public void cadastrar(Exercicio exercicio) throws SQLException {
        exercicioDao = new ExercicioDao();
        exercicioDao.postExercicio(exercicio);
    }

    @Override
    public void cadastrarAparelhoExercicio(int codExercicio, int nroAparelho, String caminhoImg) throws SQLException {
        exercicioDao = new ExercicioDao();
        exercicioDao.postAparelhoExercicio(codExercicio, nroAparelho, caminhoImg);
    }

    @Override
    public void alterar(Exercicio exercicio) throws SQLException {
        exercicioDao = new ExercicioDao();
        exercicioDao.putExercicio(exercicio);
    }

    @Override
    public void excluir(int codExercicio) throws SQLException {
        exercicioDao = new ExercicioDao();
        exercicioDao.deleteExercicio(codExercicio);
    }
}
