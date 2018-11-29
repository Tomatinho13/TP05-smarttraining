package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import java.util.ArrayList;
import br.cefetmg.inf.model.dao.IRegiaoCorporalDao;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.domain.RegiaoCorporal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RegiaoCorporalDao implements IRegiaoCorporalDao {

    private RegiaoCorporal regiao;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("SmartTrainingPU");
    EntityManager manager = factory.createEntityManager();

    public RegiaoCorporalDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
    }

    @Override
    public RegiaoCorporal getRegiaoCorporal(int codRegiao) throws SQLException {
        ArrayList<Musculo> listaMusculos = new ArrayList<>();
        sql = "SELECT * FROM \"RegiaoCorporal\" "
                + "JOIN \"Musculo\" USING(\"cod_regCorp\") "
                + "GROUP BY \"cod_regCorp\", cod_musculo "
                + "HAVING \"cod_regCorp\"='" + codRegiao + "'";

        Query query = manager.createNativeQuery(sql);
        regiao = (RegiaoCorporal) query.getSingleResult();

        return regiao;
    }

    @Override
    public boolean postRegiaoCorporal(RegiaoCorporal regiao, int codMusculo) throws SQLException {
        this.regiao = regiao;
        sql = "INSERT INTO \"RegiaoCorporal\" (nom_regiao) VALUES (?);";

        Query query = manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public boolean putRegiaoCorporal(RegiaoCorporal regiao) throws SQLException {
        this.regiao = regiao;
        sql = "UPDATE \"RegiaoCorporal\" "
                + "SET nom_regiao=?";

        Query query = manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public boolean deleteRegiaoCorporal(int cod_regiao) throws SQLException {
        sql = "DELETE FROM \"RegiaoCorporal\" "
                + "WHERE cod_regiao=?";

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
