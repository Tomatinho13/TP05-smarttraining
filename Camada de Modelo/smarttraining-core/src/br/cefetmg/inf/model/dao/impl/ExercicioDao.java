package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import java.util.ArrayList;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.dao.IExercicioDao;
import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.domain.AparelhoExercicio;

public class ExercicioDao implements IExercicioDao {

    private Exercicio exercicio;
    private ArrayList<Exercicio> listaExercicios;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    public ExercicioDao() {
        conn = ConectaBd.conecta();
        gson = new Gson();
    }

    @Override
    public Exercicio getExercicio(String codExercicio) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Exercicio\""
                + "WHERE cod_exercicio = '" + codExercicio + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        if (resultado.next()) {
            exercicio = new Exercicio(Integer.parseInt(codExercicio),
                    resultado.getString("nom_exercicio"),
                    resultado.getString("des_exercicio"));
        } else {

            return null;
        }

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

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if (resultado.next()) {
            Aparelho aparelho = new Aparelho(nroAparelho, resultado.getString("nom_aparelho"));
            exercicio = new Exercicio(codExercicio,
                    resultado.getString("nom_exercicio"),
                    resultado.getString("des_exercicio"));
            aparelhoExercicio = new AparelhoExercicio(aparelho, exercicio, resultado.getString("img_execucao"));
        } else {

            return null;
        }

        return aparelhoExercicio;
    }

    @Override
    public void postExercicio(Exercicio exercicio, String seqMusculo) throws SQLException {
        sql = "INSERT INTO \"Exercicio\" (nom_exercicio, des_exercicio) VALUES (?, ?);"
                + "INSERT INTO \"MusculoExercicio\" VALUES"
                + "               ((SELECT cod_exercicio FROM \"Exercicio\" "
                + "WHERE nomExercicio=?),"
                + "               (SELECT seq_musculo FROM \"Musculo\" "
                + "WHERE seq_musculo=?))";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, exercicio.getNomeExercicio());
        stmt.setString(2, exercicio.getDescricaoExercicio());
        stmt.setString(3, exercicio.getNomeExercicio());
        stmt.setString(4, seqMusculo);

        stmt.executeQuery(sql);

    }

    @Override
    public void putExercicio(Exercicio exercicio) throws SQLException {
        sql = "UPDATE \"Exercicio\" "
                + "SET nom_exercicio=?, "
                + "des_exercicio=? "
                + "WHERE cod_exercicio = '" + exercicio.getCodExercicio() + "'";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, exercicio.getNomeExercicio());
        stmt.setString(2, exercicio.getDescricaoExercicio());

        stmt.executeQuery(sql);

    }

    @Override
    public void deleteExercicio(String cod_exercicio) throws SQLException {
        sql = "DELETE FROM \"Exercicio\" "
                + "WHERE cod_exercicio=?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cod_exercicio);

        stmt.executeQuery(sql);

    }
}
