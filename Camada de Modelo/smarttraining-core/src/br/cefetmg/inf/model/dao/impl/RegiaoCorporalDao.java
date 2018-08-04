package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import java.util.ArrayList;
import br.cefetmg.inf.model.dao.IRegiaoCorporalDao;
import br.cefetmg.inf.model.domain.Exercicio;
import br.cefetmg.inf.model.domain.Musculo;
import br.cefetmg.inf.model.domain.RegiaoCorporal;

public class RegiaoCorporalDao implements IRegiaoCorporalDao {

    private RegiaoCorporal regiao;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    public RegiaoCorporalDao() {
        conn = ConectaBd.conecta();
        gson = new Gson();
    }

    @Override
    public RegiaoCorporal getRegiaoCorporal(String codRegiao) throws SQLException {
        ArrayList<Musculo> listaMusculos = new ArrayList<>();
        sql = "SELECT * FROM \"RegiaoCorporal\" "
                + "JOIN \"Musculo\" USING(\"cod_regCorp\") "
                + "GROUP BY \"cod_regCorp\", cod_musculo "
                + "HAVING \"cod_regCorp\"='" + codRegiao + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        while (resultado.next()) {
            listaMusculos.add(new Musculo(resultado.getInt("cod_musculo"), resultado.getInt("cod_regCorp"), resultado.getString("nom_musculo"), resultado.getString("img_musculo"), null));
            regiao = new RegiaoCorporal(Integer.parseInt(codRegiao), resultado.getString("nom_regCorp"), listaMusculos);
        }

        return regiao;
    }

    @Override
    public ArrayList<Exercicio> getRegiaoExercicios(String nomRegiao) throws SQLException {
        ArrayList<Exercicio> listaExercicios = new ArrayList<>();
        sql = "SELECT * FROM \"Exercicio\" "
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
            listaExercicios.add(new Exercicio(resultado.getInt("cod_exercicio"),
                    resultado.getString("nom_regiao"),
                    resultado.getString("des_regiao")));
        }
        if (listaExercicios.isEmpty()) {

            return null;
        }

        return listaExercicios;
    }

    @Override
    public void postRegiaoCorporal(RegiaoCorporal regiao, String seqMusculo) throws SQLException {
        this.regiao = regiao;
        sql = "INSERT INTO \"RegiaoCorporal\" (nom_regiao) VALUES (?);";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, regiao.getNomeRegiao());

        stmt.executeQuery(sql);

    }

    @Override
    public void deleteRegiaoCorporal(String cod_regiao) throws SQLException {
        sql = "DELETE FROM \"RegiaoCorporal\" "
                + "WHERE cod_regiao=?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cod_regiao);

        stmt.executeQuery(sql);

    }

    @Override
    public void putRegiaoCorporal(RegiaoCorporal regiao) throws SQLException {
        this.regiao = regiao;
        sql = "UPDATE \"RegiaoCorporal\" "
                + "SET nom_regiao=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, regiao.getNomeRegiao());

        stmt.executeQuery(sql);

    }
}
