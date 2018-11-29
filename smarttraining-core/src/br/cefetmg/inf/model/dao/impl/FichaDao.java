package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IFichaDao;
import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Ficha;
import br.cefetmg.inf.model.domain.Treino;
import br.cefetmg.inf.model.services.IManterTreino;
import br.cefetmg.inf.model.services.impl.ManterTreino;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FichaDao implements IFichaDao {

    private Ficha ficha;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    private final TreinoDao treinoDao;

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("SmartTrainingPU");
    EntityManager manager = factory.createEntityManager();

    public FichaDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
        treinoDao = new TreinoDao();
    }

    @Override
    public Ficha getFicha(String cpf, int nroFicha) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Ficha\" "
                + "WHERE cod_cpf = '" + cpf + "' AND nro_ficha = '" + nroFicha + "'";

        Query query = manager.createNativeQuery(sql);
        ficha = (Ficha) query.getSingleResult();

        return ficha;
    }

    @Override
    public ArrayList<Ficha> getListaFicha(String cpf) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Ficha\" "
                + "WHERE cod_cpf = '" + cpf + "'";

        Query query = manager.createNativeQuery(sql);

        return (ArrayList<Ficha>) query.getResultList();
    }

    @Override
    public boolean postFicha(Ficha ficha) throws SQLException {
        sql = "INSERT INTO \"Ficha\" VALUES (?,?,?,CAST(? as date),CAST(? as date))";

        Query query = manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public boolean putFicha(Ficha ficha) throws SQLException {
        sql = "UPDATE \"Ficha\" "
                + "SET cod_cpf_instrutor=?, "
                + "dat_ficha=CAST(? as date), "
                + "dat_prevista_troca=CAST(? as date), "
                + "WHERE cod_cpf=?"
                + "AND nro_ficha=?";

        Query query = manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public boolean deleteFicha(String cpf, int nroFicha) throws SQLException {
        sql = "DELETE FROM \"Ficha\" "
                + "WHERE cod_cpf='" + cpf + "' AND nro_ficha='" + nroFicha + "'";

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
