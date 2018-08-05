package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IAlunoDao;
import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Usuario;

public class AlunoDao implements IAlunoDao {

    private Usuario aluno;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    public AlunoDao() {
        conn = ConectaBd.conecta();
        gson = new Gson();
    }

    @Override
    public Usuario getAluno(String codCpf) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Usuario\" "
                + "WHERE cod_cpf = '" + codCpf + "' AND idt_tipo_usuario = 'A'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if (resultado.next()) {
            aluno = new Usuario(codCpf,
                    resultado.getString("nom_usuario"),
                    resultado.getString("idt_tipo_usuario").charAt(0),
                    resultado.getString("txt_senha"),
                    resultado.getString("des_email"),
                    resultado.getDate("dat_nascimento").toLocalDate());
        } else {

            return null;
        }

        return aluno;
    }

    @Override
    public void postAluno(Usuario aluno) throws SQLException {
        this.aluno = aluno;
        sql = "INSERT INTO \"Usuario\" VALUES (?,?,?,?,?,?);"
                + "INSERT INTO \"Aluno\" "
                + "VALUES((SELECT cod_cpf FROM \"Usuario\" "
                + "WHERE cod_cpf = '" + aluno.getCodCpf() + "'))";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, aluno.getCodCpf());
        stmt.setString(2, aluno.getNomUsuario());
        stmt.setString(3, String.valueOf(aluno.getIdtTipoUsuario()));
        stmt.setString(4, aluno.getTxtSenha());
        stmt.setString(5, aluno.getDesEmail());
        stmt.setString(6, String.valueOf(aluno.getDatNascimento()));

        stmt.executeQuery(sql);

    }

    @Override
    public void putAluno(Usuario aluno) throws SQLException {
        this.aluno = aluno;
        sql = "UPDATE \"Usuario\" "
                + "SET nom_usuario=?, "
                + "idt_tipo_usuario=?, "
                + "txt_senha=?, "
                + "des_email=?, "
                + "dat_nascimento=? "
                + "WHERE cod_cpf=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, aluno.getNomUsuario());
        stmt.setString(2, String.valueOf(aluno.getIdtTipoUsuario()));
        stmt.setString(3, aluno.getTxtSenha());
        stmt.setString(4, aluno.getDesEmail());
        stmt.setString(5, String.valueOf(aluno.getDatNascimento()));
        stmt.setString(6, aluno.getCodCpf());

        stmt.executeQuery(sql);

    }

    @Override
    public void deleteAluno(String codCpf) throws SQLException {
        sql = "DELETE FROM \"Usuario\" "
                + "WHERE cod_cpf='" + codCpf + "'";

        Statement stmt = conn.createStatement();
        stmt.executeQuery(sql);

    }
}
