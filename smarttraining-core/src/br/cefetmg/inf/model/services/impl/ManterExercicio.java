package br.cefetmg.inf.model.services.impl;

import br.cefetmg.inf.model.dao.IExercicioDao;
import br.cefetmg.inf.model.dao.impl.ExercicioDao;
import br.cefetmg.inf.model.domain.AparelhoExercicio;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.services.IManterExercicio;
import java.sql.SQLException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ManterExercicio extends UnicastRemoteObject implements IManterExercicio {

    private IExercicioDao exercicioDao;

    public ManterExercicio() throws RemoteException{
    }

    @Override
    public Exercicio pesquisarPorCodigo(int codExercicio) throws SQLException, RemoteException {
        exercicioDao = new ExercicioDao();
        Exercicio resultado = exercicioDao.getExercicio(codExercicio);
        return resultado;
    }

    @Override
    public Exercicio pesquisarPorNome(String nomeExercicio) throws SQLException, RemoteException {
        exercicioDao = new ExercicioDao();
        Exercicio exercicio = exercicioDao.getExercicio(nomeExercicio);
        return exercicio;
    }

    @Override
    public AparelhoExercicio pesquisarAparelhoExercicio(int codExercicio, int nroAparelho) throws SQLException, RemoteException {
        exercicioDao = new ExercicioDao();
        AparelhoExercicio resultado = exercicioDao.getAparelhoExercicio(codExercicio, nroAparelho);
        return resultado;
    }

    @Override
    public ArrayList<Exercicio> pesquisarPorRegiao(String nomeRegiao) throws SQLException, RemoteException {
        exercicioDao = new ExercicioDao();
        ArrayList<Exercicio> resultado = exercicioDao.getRegiaoExercicios(nomeRegiao);
        return resultado;
    }
    
    @Override
    public ArrayList<Exercicio> pesquisarPorAparelho(int nroAparelho) throws SQLException, RemoteException {
        exercicioDao = new ExercicioDao();
        ArrayList<Exercicio> resultado = exercicioDao.getAparelhoExercicios(nroAparelho);
        return resultado;
    }

    @Override
    public ArrayList<Exercicio> pesquisarPorMusculo(int codMusculo) throws SQLException, RemoteException {
        exercicioDao = new ExercicioDao();
        ArrayList<Exercicio> resultado = exercicioDao.getMusculoExercicios(codMusculo);
        return resultado;
    }

    @Override
    public ArrayList<Exercicio> pesquisarTodos() throws SQLException, RemoteException {
        exercicioDao = new ExercicioDao();
        ArrayList<Exercicio> resultado = exercicioDao.getListaExercicios();
        return resultado;
    }

    @Override
    public boolean cadastrar(Exercicio exercicio) throws SQLException, RemoteException {
        boolean testeDao;
        
        exercicioDao = new ExercicioDao();
        testeDao = exercicioDao.postExercicio(exercicio);

        return testeDao;
    }

    @Override
    public boolean cadastrarAparelhoExercicio(int codExercicio, int nroAparelho, String caminhoImg) throws SQLException, RemoteException {
        boolean testeDao;
        
        exercicioDao = new ExercicioDao();
        testeDao = exercicioDao.postAparelhoExercicio(codExercicio, nroAparelho, caminhoImg);
        
        return testeDao;
    }

    @Override
    public boolean alterar(Exercicio exercicio) throws SQLException, RemoteException {
        boolean testeDao;
        
        exercicioDao = new ExercicioDao();
        testeDao = exercicioDao.putExercicio(exercicio);
        
        return testeDao;
    }

    @Override
    public boolean excluir(int codExercicio) throws SQLException, RemoteException {
        boolean testeDao;
        
        exercicioDao = new ExercicioDao();
        testeDao = exercicioDao.deleteExercicio(codExercicio);
        
        return testeDao;
    }
}
