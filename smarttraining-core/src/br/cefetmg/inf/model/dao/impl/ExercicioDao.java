package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import java.util.ArrayList;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.dao.IExercicioDao;
import br.cefetmg.inf.model.dao.IMusculoDao;
import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.domain.AparelhoExercicio;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.server.ServerRMI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ExercicioDao implements IExercicioDao {

    private Exercicio exercicio;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    public ExercicioDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
    }

    @Override
    public Exercicio getExercicio(int codExercicio) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Exercicio\""
                + "WHERE cod_exercicio = '" + codExercicio + "'";

        Query query = ServerRMI.manager.createNativeQuery(sql);
        exercicio = (Exercicio) query.getSingleResult();

        return exercicio;
    }

    @Override
    public Exercicio getExercicio(String nomeExercicio) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Exercicio\""
                + "WHERE nom_exercicio = '" + nomeExercicio + "'";

        Query query = ServerRMI.manager.createNativeQuery(sql);
        exercicio = (Exercicio) query.getSingleResult();

        return exercicio;
    }

    @Override
    public AparelhoExercicio getAparelhoExercicio(int codExercicio, int nroAparelho) throws SQLException {
        AparelhoExercicio aparelhoExercicio;
        sql = "SELECT nom_exercicio, des_exercicio, nom_aparelho, img_execucao "
                + "FROM \"Exercicio\""
                + "JOIN \"AparelhoExercicio\" USING (cod_exercicio)"
                + "JOIN \"Aparelho\" USING (nro_aparelho)"
                + "GROUP BY nro_aparelho, cod_exercicio, nom_aparelho"
                + "HAVING cod_exercicio = '" + codExercicio + "' AND nro_aparelho='" + nroAparelho + "'";

        Query query = ServerRMI.manager.createNativeQuery(sql);
        aparelhoExercicio = (AparelhoExercicio) query.getSingleResult();

        return aparelhoExercicio;
    }

    @Override
    public ArrayList<Exercicio> getRegiaoExercicios(String nomRegiao) throws SQLException {
        sql = "SELECT cod_exercicio FROM \"Exercicio\" "
                + "WHERE cod_exercicio in ("
                + "SELECT cod_exercicio FROM \"MusculoExercicio\" "
                + "WHERE cod_musculo IN ("
                + "SELECT cod_musculo FROM \"Musculo\" "
                + "WHERE \"cod_regCorp\" IN ("
                + "SELECT \"cod_regCorp\" FROM \"RegiaoCorporal\" "
                + "WHERE \"nom_regCorp\" = '" + nomRegiao + "')))";

        Query query = ServerRMI.manager.createNativeQuery(sql);

        return (ArrayList<Exercicio>) query.getResultList();
    }

    @Override
    public ArrayList<Exercicio> getAparelhoExercicios(int nroAparelho) throws SQLException {
        sql = "SELECT cod_exercicio FROM \"Exercicio\" "
                + "WHERE cod_exercicio in ("
                + "SELECT cod_exercicio FROM \"AparelhoExercicio\" "
                + "WHERE nro_aparelho = '" + nroAparelho + "'";

        Query query = ServerRMI.manager.createNativeQuery(sql);

        return (ArrayList<Exercicio>) query.getResultList();
    }

    @Override
    public ArrayList<Exercicio> getMusculoExercicios(int codMusculo) throws SQLException {
        sql = "SELECT * FROM \"Exercicio\" WHERE cod_exercicio IN("
                + "SELECT cod_exercicio FROM \"MusculoExercicio\" WHERE cod_musculo = '" + codMusculo + "')";

        Query query = ServerRMI.manager.createNativeQuery(sql);

        return (ArrayList<Exercicio>) query.getResultList();
    }

    @Override
    public ArrayList<Exercicio> getListaExercicios() throws SQLException {
        sql = "SELECT * FROM \"Exercicio\"";

        Query query = ServerRMI.manager.createNativeQuery(sql);

        return (ArrayList<Exercicio>) query.getResultList();
    }

    @Override
    public boolean postExercicio(Exercicio exercicio) throws SQLException {
        sql = "INSERT INTO \"Exercicio\" (nom_exercicio, des_exercicio) VALUES (?, ?);";

        Query query = ServerRMI.manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public boolean postAparelhoExercicio(int codExercicio, int nroAparelho, String caminhoImg) throws SQLException {
        sql = "INSERT INTO \"AparelhoExercicio\" VALUES (CAST(? as integer), CAST(? as integer), ?);";

        Query query = ServerRMI.manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public boolean putExercicio(Exercicio exercicio) throws SQLException {
        if (!atualizaExercicio(exercicio)) {
            return false;
        }
        if (!deleteMusculoExercicio(exercicio)) {
            return false;
        }
        return postMusculoExercicio(exercicio);
    }

    private boolean atualizaExercicio(Exercicio exercicio) {
        sql = "UPDATE \"Exercicio\" "
                + "SET nom_exercicio=?, "
                + "des_exercicio=? "
                + "WHERE cod_exercicio = '" + exercicio.getNumero() + "'";

        Query query = ServerRMI.manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    private boolean deleteMusculoExercicio(Exercicio exercicio) {
        sql = "DELETE FROM \"MusculoExercicio\" "
                + "WHERE cod_exercicio = '" + exercicio.getNumero() + "'";

        Query query = ServerRMI.manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    private boolean postMusculoExercicio(Exercicio exercicio) {

        sql = "INSERT INTO \"MusculoExercicio\" VALUES(CAST( ? as integer), CAST( ? as bigint))";

        Query query = ServerRMI.manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public boolean deleteExercicio(int codExercicio) throws SQLException {
        sql = "DELETE FROM \"Exercicio\" "
                + "WHERE cod_exercicio=CAST(? as integer)";

        Query query = ServerRMI.manager.createNativeQuery(sql);
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
