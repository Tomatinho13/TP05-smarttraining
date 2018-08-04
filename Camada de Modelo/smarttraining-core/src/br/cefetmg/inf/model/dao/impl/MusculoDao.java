package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IMusculoDao;
import br.cefetmg.inf.model.db.ConectaBd;
import br.cefetmg.inf.model.domain.Exercicio;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Musculo;
import java.util.ArrayList;

public class MusculoDao implements IMusculoDao {

    private Musculo musculo;
    private ArrayList<Musculo> listaMusculos;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    public MusculoDao() {
        conn = ConectaBd.conecta();
        gson = new Gson();
    }

    @Override
    public Musculo getMusculo(String codMusculo) throws SQLException {
        ArrayList<Exercicio> listaExercicios = new ArrayList<>();
        sql = "SELECT * FROM \"Exercicio\" WHERE cod_exercicio IN("
                + "SELECT cod_exercicio FROM \"MusculoExercicio\" WHERE cod_musculo IN("
                + "SELECT cod_musculo FROM \"Musculo\" WHERE cod_musculo='" + codMusculo + "'))";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while (resultado.next()) {
            listaExercicios.add(new Exercicio(Integer.parseInt(resultado.getString("cod_exercicio")),
                    resultado.getString("nom_exercicio"),
                    resultado.getString("des_exercicio")));

            musculo = new Musculo(resultado.getInt("cod_musculo"),
                    resultado.getInt("cod_regCorp"),
                    resultado.getString("nom_musculo"),
                    resultado.getString("img_musculo"),
                    listaExercicios);
        }

        if (musculo != null) {
            return null;
        }
        return musculo;
    }

    @Override
    public ArrayList<Exercicio> getMusculoExercicios(String codMusculo) throws SQLException {
        ArrayList<Exercicio> listaExercicios = new ArrayList<>();

        sql = "SELECT * FROM \"Exercicio\" WHERE cod_exercicio IN("
                + "SELECT cod_exercicio FROM \"MusculoExercicio\" WHERE cod_musculo = '" + codMusculo + "')";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        while (resultado.next()) {
            listaExercicios.add(new Exercicio(resultado.getInt("cod_exercicio"), resultado.getString("nom_exercicio"), resultado.getString("des_exercicio")));
        }
        if (listaExercicios.isEmpty()) {

            return null;
        }

        return listaExercicios;
    }

    @Override
    public void postMusculo(Musculo musculo) throws SQLException {
        this.musculo = musculo;
        sql = "INSERT INTO \"Musculo\" VALUES (?,?,?,?)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, String.valueOf(musculo.getCodMusculo()));
        stmt.setString(2, "(SELECT \"cod_regCorp\" FROM \"RegiaoCorporal\" WHERE \"cod_regCorp\"='" + musculo.getCodRegiaoCorporal() + "')");
        stmt.setString(3, musculo.getNomMusculo());
        stmt.setString(4, musculo.getCaminhoImagem());

        stmt.executeQuery(sql);

    }

    @Override
    public void putMusculo(Musculo musculo) throws SQLException {
        this.musculo = musculo;
        sql = "UPDATE \"Musculo\" "
                + "SET nom_musculo=?, "
                + "img_musculo=? "
                + "WHERE cod_musculo = '" + musculo.getCodMusculo() + "'";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, musculo.getNomMusculo());
        stmt.setString(2, musculo.getCaminhoImagem());

        stmt.executeQuery(sql);

    }

    @Override
    public void deleteMusculo(String codMusculo) throws SQLException {
        sql = "DELETE FROM \"Musculo\" WHERE cod_musculo = '" + codMusculo + "'";

        Statement stmt = conn.createStatement();
        stmt.executeQuery(sql);

    }
}
