package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IAtividadeDao;
import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import java.util.ArrayList;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.domain.Atividade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AtividadeDao implements IAtividadeDao {

    private Atividade atividade;
    private ArrayList<Exercicio> listaExercicios;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    private final ExercicioDao exercicioDao;

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("SmartTrainingPU");
    EntityManager manager = factory.createEntityManager();

    public AtividadeDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
        exercicioDao = new ExercicioDao();
    }

    @Override
    public Atividade getAtividade(String codCpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException {
        sql = "SELECT qtd_peso, nro_series, nro_repeticoes "
                + "FROM \"TreinoExercicio\""
                + "WHERE cod_cpf='" + codCpf + "' AND nro_treino = '" + nroTreino + "'"
                + "AND cod_exercicio = '" + codExercicio + "'AND nro_aparelho='" + nroAparelho + "' "
                + "AND nro_ficha='" + nroFicha + "'";

        Query query = manager.createNativeQuery(sql);
        atividade = (Atividade) query.getSingleResult();

        return atividade;
    }

    @Override
    public boolean postAtividade(Atividade atividade) throws SQLException {
//        sql = "INSERT INTO \"TreinoExercicio\" VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            manager.getTransaction().begin();
            manager.persist(atividade);
            manager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            Logger.getLogger(AtividadeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean putAtividade(Atividade atividade) throws SQLException {
//        sql = "UPDATE \"TreinoExercicio\" "
//                + "SET nro_series=?, "
//                + "nro_repeticoes=?, "
//                + "qtd_peso=? "
//                + "WHERE cod_cpf='" + atividade.getCpf() + "' AND nro_treino = '" + atividade.getNroTreino() + "' "
//                + "AND cod_exercicio = '" + atividade.getAparelhoExercicio().getExercicio().getNumero() + "' "
//                + "AND nro_aparelho='" + atividade.getAparelhoExercicio().getAparelho().getNumero() + "' "
//                + "AND nro_ficha='" + atividade.getNroFicha() + "'";

        try {
            manager.getTransaction().begin();
            manager.refresh(atividade);
            manager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            Logger.getLogger(AtividadeDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean deleteAtividade(String cpf, int nroTreino, int codExercicio, int nroAparelho, int nroFicha) throws SQLException {
//        sql = "DELETE FROM \"TreinoExercicio\" "
//                + "WHERE cod_cpf='" + cpf + "' AND nro_treino = '" + nroTreino + "'"
//                + "AND cod_exercicio = '" + codExercicio + "'AND nro_aparelho='" + nroAparelho + "' "
//                + "AND nro_ficha='" + nroFicha + "'";

        try {
            manager.getTransaction().begin();
            manager.remove(atividade);
            manager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            Logger.getLogger(AtividadeDao.class.getName()).log(Level.SEVERE, null, e);
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
