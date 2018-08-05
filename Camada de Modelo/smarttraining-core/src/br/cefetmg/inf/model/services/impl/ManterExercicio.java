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
        exercicioDao = new ExercicioDao();
    }
    
    @Override
    public Exercicio pesquisarPorCodigo(int codExercicio) throws SQLException{
        Exercicio resultado = exercicioDao.getExercicio(codExercicio);
        return resultado;
    }
    
    @Override
    public AparelhoExercicio pesquisarAparelhoExercicio(int codExercicio, int nroAparelho) throws SQLException{
        AparelhoExercicio resultado = exercicioDao.getAparelhoExercicio(codExercicio, nroAparelho);
        return resultado;       
    }
    
    @Override
    public ArrayList<Exercicio> pesquisarPorRegiao(String nomeRegiao) throws SQLException{
        ArrayList<Exercicio> resultado = new ArrayList<>(exercicioDao.getRegiaoExercicios(nomeRegiao));
        return resultado;       
    }
    
    @Override
    public ArrayList<Exercicio> pesquisarPorMusculo(int codMusculo) throws SQLException{
        ArrayList<Exercicio> resultado = new ArrayList<>(exercicioDao.getMusculoExercicios(codMusculo));
        return resultado;       
    }
    
    @Override
    public void cadastrar(Exercicio exercicio, int codMusculo) throws SQLException{
        exercicioDao.postExercicio(exercicio, codMusculo);
    }

    @Override
    public void alterar(Exercicio exercicio) throws SQLException{
        exercicioDao.putExercicio(exercicio);
    }

    @Override
    public void excluir(int codExercicio) throws SQLException{
        exercicioDao.deleteExercicio(codExercicio);
    }     
}