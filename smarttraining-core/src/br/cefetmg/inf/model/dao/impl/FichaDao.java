package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IFichaDao;
import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Ficha;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FichaDao implements IFichaDao {

    private Ficha ficha;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    private final TreinoDao treinoDao;

    public FichaDao() {
        conn = ConectaBd.conecta();
        gson = new Gson();
        treinoDao = new TreinoDao();
    }

    @Override
    public Ficha getFicha(String cpf, int nroFicha) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Ficha\" "
                + "WHERE cod_cpf = '" + cpf + "' AND nro_ficha = '" + nroFicha + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if (resultado.next()) {
            ficha = new Ficha(cpf,
                    nroFicha,
                    resultado.getString("cod_cpf_instrutor"),
                    resultado.getDate("dat_ficha").toLocalDate(),
                    resultado.getDate("dat_prevista_troca").toLocalDate(),
                    treinoDao.getFichaTreinos(cpf, nroFicha));
        } else {

            return null;
        }

        return ficha;
    }

    @Override
    public ArrayList<Ficha> getListaFicha(String cpf) throws SQLException {
        ArrayList<Ficha> listaFicha = new ArrayList<>();
        sql = "SELECT * "
                + "FROM \"Ficha\" "
                + "WHERE cod_cpf = '" + cpf + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while (resultado.next()) {
            ficha = new Ficha(cpf,
                    resultado.getInt("nro_ficha"),
                    resultado.getString("cod_cpf_instrutor"),
                    resultado.getDate("dat_ficha").toLocalDate(),
                    resultado.getDate("dat_prevista_troca").toLocalDate(),
                    treinoDao.getFichaTreinos(cpf, resultado.getInt("nro_ficha")));
            listaFicha.add(ficha);
        }

        return listaFicha;
    }

    @Override
    public void postFicha(Ficha ficha) throws SQLException {
        sql = "INSERT INTO \"Ficha\" VALUES (?,?,?,CAST(? as date),CAST(? as date))";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "(SELECT \"cod_cpf\" FROM \"Aluno\" WHERE \"cod_cpf\"='" + ficha.cpfAluno() + "')");
        stmt.setString(2, String.valueOf(ficha.getNumero()));
        stmt.setString(3, "(SELECT \"cod_cpf\" FROM \"Instrutor\" WHERE \"cod_cpf\"='" + ficha.getCpfInstrutor() + "')");
        stmt.setString(4, ficha.getData().toString());
        stmt.setString(5, ficha.getDataTroca().toString());

        stmt.executeQuery(sql);

    }

    @Override
    public void putFicha(Ficha ficha) throws SQLException {
        sql = "UPDATE \"Ficha\" "
                + "SET cod_cpf_instrutor=?, "
                + "dat_ficha=CAST(? as date), "
                + "dat_prevista_troca=CAST(? as date), "
                + "WHERE cod_cpf=?"
                + "AND nro_ficha=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "(SELECT \"cod_cpf\" FROM \"Instrutor\" WHERE \"cod_cpf\"='" + ficha.getCpfInstrutor() + "')");
        stmt.setString(2, ficha.getData().toString());
        stmt.setString(3, ficha.getDataTroca().toString());
        stmt.setString(4, ficha.cpfAluno());
        stmt.setString(5, String.valueOf(ficha.getNumero()));

        stmt.executeQuery(sql);

    }

    @Override
    public void deleteFicha(String cpf, int nroFicha) throws SQLException {
        sql = "DELETE FROM \"Ficha\" "
                + "WHERE cod_cpf='" + cpf + "' AND nro_ficha='" + nroFicha + "'";

        Statement stmt = conn.createStatement();
        stmt.executeQuery(sql);

    }
    
    @Override
    public void fechaConexao(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
