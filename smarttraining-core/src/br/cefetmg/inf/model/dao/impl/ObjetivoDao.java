package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IObjetivoDao;
import br.cefetmg.inf.model.db.ConectaBd;
import br.cefetmg.inf.model.domain.Objetivo;
import com.google.gson.Gson;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ObjetivoDao implements IObjetivoDao {

    private Objetivo objetivo;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("SmartTrainingPU");
    EntityManager manager = factory.createEntityManager();

    public ObjetivoDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
    }

    @Override
    public Objetivo getObjetivo(int codObjetivo) throws SQLException {
        sql = "SELECT * FROM \"Objetivo\" "
                + "WHERE cod_objetivo='" + codObjetivo + "'";

        Query query = manager.createNativeQuery(sql);
        objetivo = (Objetivo) query.getSingleResult();

        return objetivo;
    }

    @Override
    public ArrayList<Objetivo> getAvaliacaoObjetivos(String codCpf, LocalDate dataAvaliacao) throws SQLException {
        ArrayList<Objetivo> listaObjetivos = new ArrayList<>();
        sql = "SELECT * FROM \"Objetivo\" "
                + "WHERE cod_objetivo IN("
                + "SELECT cod_objetivo FROM \"ObjetivoAvaliacao\" WHERE cod_cpf IN("
                + "SELECT cod_cpf FROM \"Avaliacao\" WHERE cod_cpf='" + codCpf + "') "
                + "AND dat_avaliacao IN("
                + "SELECT dat_avaliacao FROM \"Avaliacao\" WHERE dat_avaliacao='" + dataAvaliacao.toString() + "'))";

        Query query = manager.createNativeQuery(sql);

        return (ArrayList<Objetivo>) query.getResultList();
    }

    @Override
    public ArrayList<Objetivo> getListaObjetivos() throws SQLException {
        ArrayList<Objetivo> listaObjetivos = new ArrayList<>();
        sql = "SELECT * "
                + "FROM \"Objetivo\" ";

        Query query = manager.createNativeQuery(sql);

        return (ArrayList<Objetivo>) query.getResultList();
    }

    @Override
    public boolean postObjetivo(Objetivo objetivo) throws SQLException {
        sql = "INSERT INTO \"Objetivo\" VALUES (?,?,?);";

        Query query = manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public boolean putObjetivo(Objetivo objetivo) throws SQLException {
        sql = "UPDATE \"Usuario\" "
                + "SET nom_objetivo=?, "
                + "des_objetivo=?"
                + "WHERE cod_objetivo=?";

        Query query = manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public boolean deleteObjetivo(int codObjetivo) throws SQLException {
        sql = "DELETE FROM \"Objetivo\" "
                + "WHERE cod_objetivo='" + codObjetivo + "'";

        Query query = manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public Objetivo getObjetivo(String nome) throws SQLException {
        sql = "SELECT * FROM \"Objetivo\" "
                + "WHERE nom_objetivo='" + nome + "'";

        Query query = manager.createNativeQuery(sql);
        objetivo = (Objetivo) query.getSingleResult();

        return objetivo;
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
