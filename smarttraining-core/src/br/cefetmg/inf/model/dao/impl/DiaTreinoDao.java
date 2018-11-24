package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IDiaTreinoDao;
import br.cefetmg.inf.model.db.ConectaBd;
import br.cefetmg.inf.model.domain.Atividade;
import br.cefetmg.inf.model.domain.DiaTreino;
import br.cefetmg.inf.model.domain.Ficha;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DiaTreinoDao implements IDiaTreinoDao {

    private Usuario aluno;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    private Atividade atividade;
    private DiaTreino diaTreino;

    public DiaTreinoDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
    }

    @Override
    public ArrayList<DiaTreino> getListaDiaTreino(String codCpf, String nroFicha) throws SQLException {
        AtividadeDao atividadeDao = new AtividadeDao();
        ArrayList<DiaTreino> listaDiaTreino = new ArrayList<>();
        sql = "SELECT dat_treino, cod_cpf, nro_treino, cod_exercicio, nro_aparelho, nro_ficha FROM \"DiaTreino\" "
                + "WHERE cod_cpf='" + codCpf + "' "
                + "AND nro_ficha='" + nroFicha + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        if (resultado.next()) {
            do {
                atividade = atividadeDao.getAtividade(resultado.getString(2), resultado.getInt(3), resultado.getInt(4), resultado.getInt(5), resultado.getInt(6));
                diaTreino = new DiaTreino(atividade, resultado.getDate("dat_treino").toLocalDate());
                listaDiaTreino.add(diaTreino);
            } while (resultado.next());
        }

        return listaDiaTreino;
    }

    @Override
    public boolean postDiaTreino(DiaTreino diaTreino) throws SQLException {
        atividade = diaTreino.getAtividade();
        sql = "INSERT INTO \"DiaTreino\" VALUES (?,?,?,?,?,CAST(? as date))";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "(SELECT \"cod_exercicio\" FROM \"TreinoExercicio\" "
                    + "WHERE cod_cpf='" + atividade.getCpf() + "' AND nro_treino = '" + atividade.getNroTreino() + "'"
                    + "AND cod_exercicio = '" + atividade.getAparelhoExercicio().getExercicio().getNumero() + "' "
                    + "AND nro_aparelho='" + atividade.getAparelhoExercicio().getAparelho().getNumero() + "' "
                    + "AND nro_ficha='" + atividade.getNroFicha() + "'");

            stmt.setString(2, "(SELECT \"nro_aparelho\" FROM \"TreinoExercicio\" "
                    + "WHERE cod_cpf='" + atividade.getCpf() + "' AND nro_treino = '" + atividade.getNroTreino() + "'"
                    + "AND cod_exercicio = '" + atividade.getAparelhoExercicio().getExercicio().getNumero() + "' "
                    + "AND nro_aparelho='" + atividade.getAparelhoExercicio().getAparelho().getNumero() + "' "
                    + "AND nro_ficha='" + atividade.getNroFicha() + "'");

            stmt.setString(3, "(SELECT \"cod_cpf\" FROM \"TreinoExercicio\" "
                    + "WHERE cod_cpf='" + atividade.getCpf() + "' AND nro_treino = '" + atividade.getNroTreino() + "'"
                    + "AND cod_exercicio = '" + atividade.getAparelhoExercicio().getExercicio().getNumero() + "' "
                    + "AND nro_aparelho='" + atividade.getAparelhoExercicio().getAparelho().getNumero() + "' "
                    + "AND nro_ficha='" + atividade.getNroFicha() + "'");

            stmt.setString(4, "(SELECT \"nro_treino\" FROM \"TreinoExercicio\" "
                    + "WHERE cod_cpf='" + atividade.getCpf() + "' AND nro_treino = '" + atividade.getNroTreino() + "'"
                    + "AND cod_exercicio = '" + atividade.getAparelhoExercicio().getExercicio().getNumero() + "' "
                    + "AND nro_aparelho='" + atividade.getAparelhoExercicio().getAparelho().getNumero() + "' "
                    + "AND nro_ficha='" + atividade.getNroFicha() + "'");

            stmt.setString(5, "(SELECT \"nro_ficha\" FROM \"TreinoExercicio\" "
                    + "WHERE cod_cpf='" + atividade.getCpf() + "' AND nro_treino = '" + atividade.getNroTreino() + "'"
                    + "AND cod_exercicio = '" + atividade.getAparelhoExercicio().getExercicio().getNumero() + "' "
                    + "AND nro_aparelho='" + atividade.getAparelhoExercicio().getAparelho().getNumero() + "' "
                    + "AND nro_ficha='" + atividade.getNroFicha() + "'");

            stmt.setString(6, diaTreino.getDataTreino().toString());
            stmt.executeQuery(sql);

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
