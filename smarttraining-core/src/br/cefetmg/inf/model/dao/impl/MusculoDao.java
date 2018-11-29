package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IExercicioDao;
import br.cefetmg.inf.model.dao.IMusculoDao;
import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Musculo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MusculoDao implements IMusculoDao {

    private Musculo musculo;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("SmartTrainingPU");
    EntityManager manager = factory.createEntityManager();

    public MusculoDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
    }

    @Override
    public Musculo getMusculo(int codMusculo) throws SQLException {
        sql = "SELECT * FROM \"Musculo\" WHERE cod_musculo = '" + codMusculo + "'";

        Query query = manager.createNativeQuery(sql);
        musculo = (Musculo) query.getSingleResult();

        return musculo;
    }

    @Override
    public ArrayList<Musculo> getListaMusculos() throws SQLException {
        IExercicioDao exercicioDao = new ExercicioDao();
        ArrayList<Musculo> listaMusculos = new ArrayList<>();

        sql = "SELECT * FROM \"Musculo\" order by nom_musculo";

        Query query = manager.createNativeQuery(sql);

        return (ArrayList<Musculo>) query.getResultList();
    }

    @Override
    public ArrayList<Musculo> getExercicioMusculos(int codExercicio) {
        ArrayList<Musculo> listaMusculos = new ArrayList<>();

        sql = "SELECT * FROM \"Musculo\" WHERE cod_musculo IN("
                + "SELECT cod_musculo FROM \"MusculoExercicio\" WHERE cod_exercicio = '" + codExercicio + "')";

        Query query = manager.createNativeQuery(sql);

        return (ArrayList<Musculo>) query.getResultList();
    }

    @Override
    public boolean postMusculo(Musculo musculo) throws SQLException {
        this.musculo = musculo;
        sql = "INSERT INTO \"Musculo\" VALUES (?,?,?,?)";

        Query query = manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public boolean putMusculo(Musculo musculo) throws SQLException {
        this.musculo = musculo;
//        sql = "UPDATE \"Musculo\" "
//                + "SET nom_musculo=?, "
//                + "img_musculo=? "
//                + "WHERE cod_musculo = '" + musculo.getNumero() + "'";

        try {
            manager.getTransaction().begin();
            manager.refresh(musculo);
            manager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            Logger.getLogger(AvaliacaoDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean deleteMusculo(int codMusculo) throws SQLException {
        sql = "DELETE FROM \"Musculo\" WHERE cod_musculo = '" + codMusculo + "'";

        Query query = manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public void fechaConexao() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
