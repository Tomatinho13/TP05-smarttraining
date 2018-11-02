package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IAparelhoDao;
import br.cefetmg.inf.model.dao.IExercicioDao;
import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import java.util.ArrayList;
import br.cefetmg.inf.model.domain.Aparelho;
import br.cefetmg.inf.model.domain.Exercicio;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AparelhoDao implements IAparelhoDao {

    private ArrayList<Aparelho> listaAparelhos;
    private Aparelho aparelho;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    public AparelhoDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
    }

    @Override
    public Aparelho getAparelho(int nroAparelho) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Aparelho\" "
                + "WHERE nro_aparelho = '" + nroAparelho + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        if (resultado.next()) {
            aparelho = new Aparelho(nroAparelho,
                    resultado.getString("nom_aparelho"));
        } else {

            return null;
        }

        return aparelho;
    }

    @Override
    public Aparelho getAparelho(String nomAparelho) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Aparelho\" "
                + "WHERE nom_aparelho = '" + nomAparelho + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        if (resultado.next()) {
            aparelho = new Aparelho(resultado.getInt("nro_aparelho"), nomAparelho);
        } else {
            return null;
        }

        return aparelho;
    }

    @Override
    public ArrayList<Aparelho> getListaAparelhos() throws SQLException {
        listaAparelhos = new ArrayList<>();
        sql = "SELECT * "
                + "FROM \"Aparelho\" ";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while (resultado.next()) {
            listaAparelhos.add(new Aparelho(resultado.getInt("nro_aparelho"),
                    resultado.getString("nom_aparelho")));
        }

        return listaAparelhos;
    }

    @Override
    public ArrayList<Exercicio> getListaExercicios(int nroAparelho) throws SQLException {
        ArrayList<Exercicio> listaExercicios = new ArrayList<>();
        IExercicioDao exercicioDao = new ExercicioDao();

        sql = "SELECT cod_exercicio FROM \"Exercicio\" WHERE cod_exercicio IN("
                + "SELECT cod_exercicio FROM \"AparelhoExercicio\" WHERE nro_aparelho = '" + nroAparelho + "')";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        while (resultado.next()) {
            listaExercicios.add(exercicioDao.getExercicio(resultado.getInt("cod_exercicio")));
        }
        if (listaExercicios.isEmpty()) {

            return null;
        }

        return listaExercicios;
    }

    @Override
    public boolean postAparelho(Aparelho aparelho) throws SQLException {
        this.aparelho = aparelho;
        sql = "INSERT INTO \"Aparelho\" VALUES (CAST(? as smallint),?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, String.valueOf(aparelho.getNumero()));
            stmt.setString(2, aparelho.getNome());
            stmt.executeUpdate();

        } catch (SQLException exception) {
            //algum retorno da excecao
            return false;
        }
        return true;
    }

    @Override
    public boolean putAparelho(Aparelho aparelho) throws SQLException {
        this.aparelho = aparelho;
        sql = "UPDATE \"Aparelho\" "
                + "SET nom_usuario='" + aparelho.getNome() + "'"
                + "WHERE nro_aparelho='" + aparelho.getNumero() + "'";

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);

        } catch (SQLException exception) {
            //retorno de exceção
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAparelho(int nroAparelho) throws SQLException {
        sql = "DELETE FROM \"Aparelho\" "
                + "WHERE nro_aparelho='" + nroAparelho + "'";

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);

        } catch (SQLException exception) {
            //retorno da excecao
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
