package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IObjetivoDao;
import br.cefetmg.inf.model.db.ConectaBd;
import br.cefetmg.inf.model.domain.Objetivo;
import com.google.gson.Gson;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjetivoDao implements IObjetivoDao {

    private Objetivo objetivo;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    public ObjetivoDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
    }

    @Override
    public Objetivo getObjetivo(int codObjetivo) throws SQLException {
        sql = "SELECT * FROM \"Objetivo\" "
                + "WHERE cod_objetivo='" + codObjetivo + "'";
        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        if (resultado.next()) {
            objetivo = new Objetivo(resultado.getInt("cod_objetivo"),
                    resultado.getString("nom_objetivo"),
                    resultado.getString("des_objetivo"));
        } else {

            return null;
        }

        return objetivo;
    }

    @Override
    public ArrayList<Objetivo> getAvaliacaoObjetivos(String codCpf, LocalDate dataAvaliacao) throws SQLException {
        ArrayList<Objetivo> listaObjetivos = new ArrayList<>();
        sql = "SELECT * FROM \"Objetivo\" "
                + "WHERE cod_objetivo IN("
                + "SELECT cod_objetivo FROM \"ObjetivoAvaliacao\" WHERE cod_cpf IN("
                + "SELECT cod_cpf FROM \"Avaliacao\" WHERE cod_cpf='" + codCpf + "') "
                + "AND dat_avaliacao IN("
                + "SELECT dat_avaliacao FROM \"Avaliacao\" WHERE dat_avaliacao='" + dataAvaliacao.toString() + "'))";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if (resultado.next()) {
            do {
                objetivo = new Objetivo(resultado.getInt("cod_objetivo"),
                        resultado.getString("nom_objetivo"),
                        resultado.getString("des_objetivo"));
                listaObjetivos.add(objetivo);
            } while (resultado.next());
        } else {

            return null;
        }

        return listaObjetivos;
    }

    @Override
    public ArrayList<Objetivo> getListaObjetivos() throws SQLException {
        ArrayList<Objetivo> listaObjetivos = new ArrayList<>();
        sql = "SELECT * "
                + "FROM \"Objetivo\" ";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while (resultado.next()) {
            listaObjetivos.add(new Objetivo(resultado.getInt("cod_objetivo"),
                    resultado.getString("nom_objetivo"),
                    resultado.getString("des_objetivo")));
        }

        return listaObjetivos;
    }

    @Override
    public boolean postObjetivo(Objetivo objetivo) throws SQLException {
        sql = "INSERT INTO \"Objetivo\" VALUES (?,?,?);";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, String.valueOf(objetivo.getCodigo()));
            stmt.setString(2, objetivo.getNome());
            stmt.setString(3, objetivo.getDescricao());

            stmt.executeQuery(sql);

        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean putObjetivo(Objetivo objetivo) throws SQLException {
        sql = "UPDATE \"Usuario\" "
                + "SET nom_objetivo=?, "
                + "des_objetivo=?"
                + "WHERE cod_objetivo=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, objetivo.getNome());
            stmt.setString(2, objetivo.getDescricao());
            stmt.setString(3, String.valueOf(objetivo.getCodigo()));

            stmt.executeQuery(sql);

        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteObjetivo(int codObjetivo) throws SQLException {
        sql = "DELETE FROM \"Objetivo\" "
                + "WHERE cod_objetivo='" + codObjetivo + "'";

        try (Statement stmt = conn.createStatement()) {
            stmt.executeQuery(sql);

        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    @Override
    public Objetivo getObjetivo(String nome) throws SQLException {
        sql = "SELECT * FROM \"Objetivo\" "
                + "WHERE nom_objetivo='" + nome + "'";
        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        if (resultado.next()) {
            objetivo = new Objetivo(resultado.getInt("cod_objetivo"),
                    nome,
                    resultado.getString("des_objetivo"));
        } else {
            return null;
        }
        return objetivo;
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
