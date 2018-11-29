package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IAparelhoDao;
import br.cefetmg.inf.model.dao.IExercicioDao;
import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import java.util.ArrayList;
import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.server.ServerRMI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AparelhoDao implements IAparelhoDao {

    private ArrayList<Aparelho> listaAparelhos;
    private Aparelho aparelho;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    public AparelhoDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
    }

    @Override
    public Aparelho getAparelho(int nroAparelho) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Aparelho\" "
                + "WHERE nro_aparelho = '" + nroAparelho + "'";

        Query query = ServerRMI.manager.createNativeQuery(sql);
        aparelho = (Aparelho) query.getSingleResult();

        return aparelho;
    }

    @Override
    public Aparelho getAparelho(String nomAparelho) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Aparelho\" "
                + "WHERE nom_aparelho = '" + nomAparelho + "'";

        Query query = ServerRMI.manager.createNativeQuery(sql);
        aparelho = (Aparelho) query.getSingleResult();

        return aparelho;
    }

    @Override
    public ArrayList<Aparelho> getListaAparelhos() throws SQLException {
        listaAparelhos = new ArrayList<>();
        sql = "SELECT * "
                + "FROM \"Aparelho\" ";

        Query query = ServerRMI.manager.createNativeQuery(sql);

        return (ArrayList<Aparelho>) query.getResultList();
    }

    @Override
    public ArrayList<Exercicio> getListaExercicios(int nroAparelho) throws SQLException {
        ArrayList<Exercicio> listaExercicios = new ArrayList<>();
        IExercicioDao exercicioDao = new ExercicioDao();

        sql = "SELECT cod_exercicio FROM \"Exercicio\" WHERE cod_exercicio IN("
                + "SELECT cod_exercicio FROM \"AparelhoExercicio\" WHERE nro_aparelho = '" + nroAparelho + "')";

        Query query = ServerRMI.manager.createNativeQuery(sql);

        return (ArrayList<Exercicio>) query.getResultList();
    }

    @Override
    public boolean postAparelho(Aparelho aparelho) throws SQLException {
        this.aparelho = aparelho;
        sql = "INSERT INTO \"Aparelho\" VALUES (CAST(? as smallint),?)";

        Query query = ServerRMI.manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public boolean putAparelho(Aparelho aparelho) throws SQLException {
        this.aparelho = aparelho;
        sql = "UPDATE \"Aparelho\" "
                + "SET nom_usuario='" + aparelho.getNome() + "'"
                + "WHERE nro_aparelho='" + aparelho.getNumero() + "'";

        Query query = ServerRMI.manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public boolean deleteAparelho(int nroAparelho) throws SQLException {
        sql = "DELETE FROM \"Aparelho\" "
                + "WHERE nro_aparelho='" + nroAparelho + "'";

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
