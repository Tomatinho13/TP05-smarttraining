package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IExercicioDao;
import br.cefetmg.inf.model.dao.IMusculoDao;
import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Musculo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MusculoDao implements IMusculoDao {

    private Musculo musculo;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    public MusculoDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
    }

    @Override
    public Musculo getMusculo(int codMusculo) throws SQLException {
        IExercicioDao exercicioDao = new ExercicioDao();
        sql = "SELECT * FROM Musculo WHERE cod_musculo = '"+codMusculo+"'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if (resultado.next()) {
            musculo = new Musculo(resultado.getInt("cod_musculo"),
                    resultado.getInt("cod_regCorp"),
                    resultado.getString("nom_musculo"),
                    resultado.getString("img_musculo"),
                    exercicioDao.getMusculoExercicios(codMusculo));
        }

        return musculo;
    }

    @Override
    public ArrayList<Musculo> getListaMusculos() throws SQLException {
        IExercicioDao exercicioDao = new ExercicioDao();
        ArrayList<Musculo> listaMusculos = new ArrayList<>();

        sql = "SELECT * FROM \"Musculo\" order by nom_musculo";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while (resultado.next()) {
            musculo = new Musculo(resultado.getInt("cod_musculo"),
                    resultado.getInt("cod_regCorp"),
                    resultado.getString("nom_musculo"),
                    resultado.getString("img_musculo"),
                    exercicioDao.getMusculoExercicios(resultado.getInt("cod_musculo")));
            listaMusculos.add(musculo);
        }

        return listaMusculos;

    }

    @Override
    public ArrayList<Musculo> getExercicioMusculos(int codExercicio) {
        ArrayList<Musculo> listaMusculos = new ArrayList<>();

        sql = "SELECT cod_musculo FROM \"Musculo\" WHERE cod_musculo IN("
                + "SELECT cod_musculo FROM \"MusculoExercicio\" WHERE cod_exercicio = '" + codExercicio + "')";
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                listaMusculos.add(getMusculo(resultado.getInt("cod_musculo")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MusculoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaMusculos;
    }

    @Override
    public void postMusculo(Musculo musculo) throws SQLException {
        this.musculo = musculo;
        sql = "INSERT INTO \"Musculo\" VALUES (?,?,?,?)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, String.valueOf(musculo.getNumero()));
        stmt.setString(2, "(SELECT \"cod_regCorp\" FROM \"RegiaoCorporal\" WHERE \"cod_regCorp\"='" + musculo.getCodRegiaoCorporal() + "')");
        stmt.setString(3, musculo.getNome());
        stmt.setString(4, musculo.getCaminhoImagem());

        stmt.executeQuery(sql);

    }

    @Override
    public void putMusculo(Musculo musculo) throws SQLException {
        this.musculo = musculo;
        sql = "UPDATE \"Musculo\" "
                + "SET nom_musculo=?, "
                + "img_musculo=? "
                + "WHERE cod_musculo = '" + musculo.getNumero() + "'";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, musculo.getNome());
        stmt.setString(2, musculo.getCaminhoImagem());

        stmt.executeQuery(sql);

    }

    @Override
    public void deleteMusculo(int codMusculo) throws SQLException {
        sql = "DELETE FROM \"Musculo\" WHERE cod_musculo = '" + codMusculo + "'";

        Statement stmt = conn.createStatement();
        stmt.executeQuery(sql);

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
