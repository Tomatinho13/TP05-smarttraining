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
import java.util.logging.Level;
import java.util.logging.Logger;

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
        IMusculoDao musculoDao = new MusculoDao();
        exercicio = new Exercicio();
        sql = "SELECT * "
                + "FROM \"Exercicio\""
                + "WHERE cod_exercicio = '" + codExercicio + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        if (resultado.next()) {
            exercicio = new Exercicio(codExercicio,
                    resultado.getString("nom_exercicio"),
                    resultado.getString("des_exercicio"),
                    musculoDao.getExercicioMusculos(codExercicio));
        }

        return exercicio;
    }

    @Override
    public Exercicio getExercicio(String nomeExercicio) throws SQLException {
        IMusculoDao musculoDao = new MusculoDao();
        exercicio = new Exercicio();
        sql = "SELECT * "
                + "FROM \"Exercicio\""
                + "WHERE nom_exercicio = '" + nomeExercicio + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        if (resultado.next()) {
            exercicio = new Exercicio(resultado.getInt("cod_exercicio"),
                    nomeExercicio,
                    resultado.getString("des_exercicio"),
                    musculoDao.getExercicioMusculos(resultado.getInt("cod_exercicio")));
        }
        return exercicio;
    }

    @Override
    public AparelhoExercicio getAparelhoExercicio(int codExercicio, int nroAparelho) throws SQLException {
        IMusculoDao musculoDao = new MusculoDao();
        AparelhoExercicio aparelhoExercicio = new AparelhoExercicio();
        sql = "SELECT nom_exercicio, des_exercicio, nom_aparelho, img_execucao "
                + "FROM \"Exercicio\""
                + "JOIN \"AparelhoExercicio\" USING (cod_exercicio)"
                + "JOIN \"Aparelho\" USING (nro_aparelho)"
                + "GROUP BY nro_aparelho, cod_exercicio, nom_aparelho"
                + "HAVING cod_exercicio = '" + codExercicio + "' AND nro_aparelho='" + nroAparelho + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if (resultado.next()) {
            Aparelho aparelho = new Aparelho(nroAparelho, resultado.getString("nom_aparelho"), new ArrayList<>());
            exercicio = new Exercicio(codExercicio,
                    resultado.getString("nom_exercicio"),
                    resultado.getString("des_exercicio"),
                    musculoDao.getExercicioMusculos(codExercicio));
            aparelhoExercicio = new AparelhoExercicio(aparelho, exercicio, resultado.getString("img_execucao"));
        }

        return aparelhoExercicio;
    }

    @Override
    public ArrayList<Exercicio> getRegiaoExercicios(String nomRegiao) throws SQLException {
        ArrayList<Exercicio> listaExercicios = new ArrayList<>();
        sql = "SELECT cod_exercicio FROM \"Exercicio\" "
                + "WHERE cod_exercicio in ("
                + "SELECT cod_exercicio FROM \"MusculoExercicio\" "
                + "WHERE cod_musculo IN ("
                + "SELECT cod_musculo FROM \"Musculo\" "
                + "WHERE \"cod_regCorp\" IN ("
                + "SELECT \"cod_regCorp\" FROM \"RegiaoCorporal\" "
                + "WHERE \"nom_regCorp\" = '" + nomRegiao + "')))";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while (resultado.next()) {
            listaExercicios.add(getExercicio(resultado.getInt("cod_exercicio")));
        }

        return listaExercicios;
    }
    
    @Override
    public ArrayList<Exercicio> getAparelhoExercicios(int nroAparelho) throws SQLException {
        ArrayList<Exercicio> listaExercicios = new ArrayList<>();
        sql = "SELECT cod_exercicio FROM \"Exercicio\" "
                + "WHERE cod_exercicio in ("
                + "SELECT cod_exercicio FROM \"AparelhoExercicio\" "
                + "WHERE nro_aparelho = '"+ nroAparelho +"'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while (resultado.next()) {
            listaExercicios.add(getExercicio(resultado.getInt("cod_exercicio")));
        }

        return listaExercicios;
    }

    @Override
    public ArrayList<Exercicio> getMusculoExercicios(int codMusculo) throws SQLException {
        IMusculoDao musculoDao = new MusculoDao();
        ArrayList<Exercicio> listaExercicios = new ArrayList<>();

        sql = "SELECT * FROM \"Exercicio\" WHERE cod_exercicio IN("
                + "SELECT cod_exercicio FROM \"MusculoExercicio\" WHERE cod_musculo = '" + codMusculo + "')";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        while (resultado.next()) {
            listaExercicios.add(new Exercicio(resultado.getInt("cod_exercicio"),
                    resultado.getString("nom_exercicio"),
                    resultado.getString("des_exercicio"),
                    new ArrayList<>()));
        }

        return listaExercicios;
    }

    @Override
    public ArrayList<Exercicio> getListaExercicios() throws SQLException {
        IMusculoDao musculoDao = new MusculoDao();
        ArrayList<Exercicio> listaExercicios = new ArrayList<>();
        sql = "SELECT * FROM \"Exercicio\"";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        while (resultado.next()) {
            listaExercicios.add(new Exercicio(resultado.getInt("cod_exercicio"),
                    resultado.getString("nom_exercicio"),
                    resultado.getString("des_exercicio"),
                    musculoDao.getExercicioMusculos(resultado.getInt("cod_exercicio"))));
        }
        return listaExercicios;
    }

    @Override
    public boolean postExercicio(Exercicio exercicio) throws SQLException {
        sql = "INSERT INTO \"Exercicio\" (nom_exercicio, des_exercicio) VALUES (?, ?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, exercicio.getNome());
            stmt.setString(2, exercicio.getDescricao());
            stmt.executeUpdate();
            stmt.close();

            postMusculoExercicio(exercicio);
        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean postAparelhoExercicio(int codExercicio, int nroAparelho, String caminhoImg) throws SQLException {
        sql = "INSERT INTO \"AparelhoExercicio\" VALUES (CAST(? as integer), CAST(? as integer), ?);";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, String.valueOf(codExercicio));
            stmt.setString(2, String.valueOf(nroAparelho));
            stmt.setString(3, caminhoImg);
            stmt.executeUpdate();

        } catch (SQLException exception) {
            return false;
        }
        return true;
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

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, exercicio.getNome());
            stmt.setString(2, exercicio.getDescricao());
            stmt.executeUpdate();

        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    private boolean deleteMusculoExercicio(Exercicio exercicio) {
        sql = "DELETE FROM \"MusculoExercicio\" "
                + "WHERE cod_exercicio = '" + exercicio.getNumero() + "'";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, exercicio.getNome());
            stmt.setString(2, exercicio.getDescricao());
            stmt.executeUpdate();

        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    private boolean postMusculoExercicio(Exercicio exercicio) {
        try {
            sql = "INSERT INTO \"MusculoExercicio\" VALUES(CAST( ? as integer), CAST( ? as bigint))";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                ArrayList<Musculo> listaMusculos = exercicio.getListaMusculos();
                
                for (int i = 0; i < listaMusculos.size(); i++) {
                    String codMusculo = String.valueOf(listaMusculos.get(i).getNumero());
                    stmt.setString(1, String.valueOf(getExercicio(exercicio.getNome()).getNumero()));
                    stmt.setString(2, codMusculo);
                    
                    stmt.addBatch();
                }
                
                stmt.executeBatch();
            }
        } catch (SQLException exception) {
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteExercicio(int codExercicio) throws SQLException {
        sql = "DELETE FROM \"Exercicio\" "
                + "WHERE cod_exercicio=CAST(? as integer)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, String.valueOf(codExercicio));
            stmt.executeUpdate();

        } catch (SQLException exception) {
            return false;
        }
        return true;
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
