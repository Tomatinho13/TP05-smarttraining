package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.ITreinoDao;
import br.cefetmg.inf.model.db.ConectaBd;
import br.cefetmg.inf.model.domain.AparelhoExercicio;
import br.cefetmg.inf.model.domain.Atividade;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Treino;
import br.cefetmg.inf.server.ServerRMI;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TreinoDao implements ITreinoDao {

    private Treino treino;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    private final AparelhoDao aparelhoDao;
    private final ExercicioDao exercicioDao;

    public TreinoDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
        aparelhoDao = new AparelhoDao();
        exercicioDao = new ExercicioDao();
    }

    @Override
    public Treino getTreino(String cpf, int nroFicha, int nroTreino) throws SQLException {
        ArrayList<Atividade> listaAtividade = new ArrayList<>();
        AparelhoExercicio aparelhoExercicio;

        sql = "SELECT * FROM \"Treino\" "
                + "JOIN \"TreinoExercicio\" USING(cod_cpf, nro_ficha, nro_treino) "
                + "GROUP BY cod_cpf, nro_ficha, nro_treino, cod_exercicio, nro_aparelho, nro_series, qtd_peso, nro_repeticoes "
                + "HAVING cod_cpf='" + cpf + "' AND nro_ficha='" + nroFicha + "' AND nro_treino='" + nroTreino + "'";

        Query query = ServerRMI.manager.createNativeQuery(sql);
        treino = (Treino) query.getSingleResult();

        return treino;
    }

    @Override
    public ArrayList<Treino> getFichaTreinos(String cpf, int nroFicha) throws SQLException {
        ArrayList<Treino> listaTreino = new ArrayList<>();
        int nroTreino = 1;
        while (true) {
            ArrayList<Atividade> listaAtividade = new ArrayList<>();
            AparelhoExercicio aparelhoExercicio;

            sql = "SELECT * FROM \"Treino\" "
                    + "JOIN \"TreinoExercicio\" USING(cod_cpf, nro_ficha, nro_treino) "
                    + "GROUP BY cod_cpf, nro_ficha, nro_treino, cod_exercicio, nro_aparelho, nro_series, qtd_peso, nro_repeticoes "
                    + "HAVING cod_cpf='" + cpf + "' AND nro_ficha='" + nroFicha + "' AND nro_treino='" + nroTreino + "'";

            Query query = ServerRMI.manager.createNativeQuery(sql);

            return (ArrayList<Treino>) query.getSingleResult();
        }
    }

    @Override
    public boolean postTreino(Treino treino) throws SQLException {
        sql = "INSERT INTO \"Treino\" VALUES (?,?,?,?)";

        Query query = ServerRMI.manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public boolean putTreino(Treino treino) throws SQLException {
        sql = "UPDATE \"Treino\" "
                + "SET des_treino=?";

        Query query = ServerRMI.manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public boolean deleteTreino(String cpf, int nroFicha, int nroTreino) throws SQLException {
        sql = "DELETE FROM \"Treino\" "
                + "WHERE cod_cpf='" + cpf + "' AND nro_ficha='" + nroFicha + "' AND nro_treino='" + nroTreino + "'";

        Query query = ServerRMI.manager.createNativeQuery(sql);
        boolean resultado = (boolean) query.getSingleResult();

        return resultado;
    }

    @Override
    public void fechaConexao() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TreinoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
