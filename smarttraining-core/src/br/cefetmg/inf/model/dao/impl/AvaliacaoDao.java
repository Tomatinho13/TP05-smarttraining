package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IAvaliacaoDao;
import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import java.time.LocalDate;
import br.cefetmg.inf.model.domain.Avaliacao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AvaliacaoDao implements IAvaliacaoDao {

    private Avaliacao avaliacao;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    private final ObjetivoDao objetivoDao;

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("SmartTrainingPU");
    EntityManager manager = factory.createEntityManager();

    public AvaliacaoDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
        objetivoDao = new ObjetivoDao();
    }

    @Override
    public Avaliacao getAvaliacao(String cpf, LocalDate data) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Avaliacao\" "
                + "WHERE cod_cpf = '" + cpf + "' AND dat_avaliacao = '" + data + "'";

        Query query = manager.createNativeQuery(sql);
        avaliacao = (Avaliacao) query.getSingleResult();

        return avaliacao;
    }

    @Override
    public ArrayList<Avaliacao> getListaAvaliacao(String codCpf) throws SQLException {
        ArrayList<Avaliacao> listaAvaliacao = new ArrayList<>();
        sql = "SELECT * "
                + "FROM \"Avaliacao\" "
                + "WHERE cod_cpf = '" + codCpf + "'";

        Query query = manager.createNativeQuery(sql);
        return (ArrayList<Avaliacao>) query.getResultList();
    }

    @Override
    public boolean postAvaliacao(Avaliacao avaliacao) throws SQLException {
//        sql = "INSERT INTO \"Avaliacao\" VALUES ("
//                + "(SELECT \"cod_cpf\" FROM \"Aluno\" WHERE \"cod_cpf\"='" + avaliacao.getCpfAluno() + "'),"
//                + "CAST(? as date),"
//                + "(SELECT \"cod_cpf\" FROM \"Instrutor\" WHERE \"cod_cpf\"='" + avaliacao.getCpfInstrutor() + "'),"
//                + "CAST(? as numeric),"
//                + "CAST(? as numeric),"
//                + "CAST(? as numeric),"
//                + "CAST(? as numeric),"
//                + "CAST(? as numeric),"
//                + "CAST(? as numeric),"
//                + "CAST(? as numeric),"
//                + "CAST(? as numeric),"
//                + "CAST(? as numeric),"
//                + "CAST(? as numeric),"
//                + "CAST(? as numeric),"
//                + "CAST(? as numeric),"
//                + "CAST(? as numeric),"
//                + "CAST(? as numeric),"
//                + "CAST(? as numeric),"
//                + "CAST(? as numeric),"
//                + "CAST(? as numeric))";

        try {
            manager.getTransaction().begin();
            manager.persist(avaliacao);
            manager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            Logger.getLogger(AvaliacaoDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean putAvaliacao(Avaliacao avaliacao) throws SQLException {
        if (!atualizaAvaliacao(avaliacao)) {
            return false;
        } else if (!deletaObjetivoAvaliacao(avaliacao)) {
            return false;
        }
        return postObjetivoAvaliacao(avaliacao);
    }

    private boolean atualizaAvaliacao(Avaliacao avaliacao) {
        sql = "UPDATE \"Avaliacao\" "
                + "SET \"cod_cpf_instrutor\"=?, "
                + "\"qtd_peso\"=CAST(? as numeric), "
                + "\"qtd_massaGorda\"=CAST(? as numeric), "
                + "\"qtd_percGordura\"=CAST(? as numeric), "
                + "tam_pescoco=CAST(? as numeric), "
                + "tam_ombro=CAST(? as numeric), "
                + "tam_torax=CAST(? as numeric), "
                + "tam_abdomen=CAST(? as numeric), "
                + "tam_cintura=CAST(? as numeric), "
                + "tam_quadril=CAST(? as numeric), "
                + "\"tam_bracoEsq\"=CAST(? as numeric), "
                + "\"tam_bracoDir\"=CAST(? as numeric), "
                + "\"tam_antebracoEsq\"=CAST(? as numeric), "
                + "\"tam_antebracoDir\"=CAST(? as numeric), "
                + "\"tam_coxaEsq\"=CAST(? as numeric), "
                + "\"tam_coxaDir\"=CAST(? as numeric), "
                + "\"tam_panturrilhaEsq\"=CAST(? as numeric), "
                + "\"tam_panturrilhaDir\"=CAST(? as numeric) "
                + "WHERE cod_cpf=? "
                + "AND dat_avaliacao= CAST(? as date)";

        Query query = manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    private boolean deletaObjetivoAvaliacao(Avaliacao avaliacao) {
//        sql = "DELETE FROM \"ObjetivoAvaliacao\" "
//                + "WHERE cod_cpf='" + avaliacao.getCpfAluno() + "' AND dat_avaliacao='" + avaliacao.getData().toString() + "';";

        try {
            manager.getTransaction().begin();
            manager.remove(avaliacao);
            manager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            Logger.getLogger(AvaliacaoDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    private boolean postObjetivoAvaliacao(Avaliacao avaliacao) {
//            for (int i = 0; i < avaliacao.getObjetivos().size(); i++) {
//                sql = "INSERT INTO \"ObjetivoAvaliacao\" VALUES ("
//                        + "CAST((SELECT dat_avaliacao FROM \"Avaliacao\" "
//                        + "WHERE cod_cpf='" + avaliacao.getCpfAluno() + "' "
//                        + "AND dat_avaliacao=CAST('" + avaliacao.getData().toString() + "' as date)) as date),"
//                        + " (SELECT cod_cpf FROM \"Avaliacao\" "
//                        + "WHERE cod_cpf='" + avaliacao.getCpfAluno() + "' "
//                        + "AND dat_avaliacao=CAST('" + avaliacao.getData().toString() + "' as date)), "
//                        + "CAST((SELECT cod_objetivo FROM \"Objetivo\" "
//                        + "WHERE cod_objetivo='" + avaliacao.getObjetivos().get(i).getCodigo() + "') as bigint))";

        try {
            manager.getTransaction().begin();
            manager.persist(avaliacao);
            manager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            Logger.getLogger(AvaliacaoDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean deleteAvaliacao(String cpf, LocalDate datAvaliacao) throws SQLException {
        sql = "DELETE FROM \"Avaliacao\" "
                + "WHERE cod_cpf='" + cpf + "' AND dat_avaliacao='" + datAvaliacao.toString() + "';";

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
