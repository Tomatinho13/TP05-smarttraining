package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IDiaTreinoDao;
import br.cefetmg.inf.model.db.ConectaBd;
import br.cefetmg.inf.model.domain.Atividade;
import br.cefetmg.inf.model.domain.DiaTreino;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DiaTreinoDao implements IDiaTreinoDao {

    private Usuario aluno;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    private Atividade atividade;
    private DiaTreino diaTreino;

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("SmartTrainingPU");
    EntityManager manager = factory.createEntityManager();

    public DiaTreinoDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
    }

    @Override
    public ArrayList<DiaTreino> getListaDiaTreino(String codCpf, String nroFicha) throws SQLException {
        sql = "SELECT dat_treino, cod_cpf, nro_treino, cod_exercicio, nro_aparelho, nro_ficha FROM \"DiaTreino\" "
                + "WHERE cod_cpf='" + codCpf + "' "
                + "AND nro_ficha='" + nroFicha + "'";

        Query query = manager.createNativeQuery(sql);

        return (ArrayList<DiaTreino>) query.getResultList();
    }

    @Override
    public boolean postDiaTreino(DiaTreino diaTreino) throws SQLException {
        sql = "INSERT INTO \"DiaTreino\" VALUES (?,?,?,?,?,CAST(? as date))";

        try {
            manager.getTransaction().begin();
            manager.persist(diaTreino);
            manager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            Logger.getLogger(DiaTreinoDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
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
