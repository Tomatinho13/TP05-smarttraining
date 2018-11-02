package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IUsuarioDao;
import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDao implements IUsuarioDao {

    private Usuario aluno;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    public AlunoDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
    }

    @Override
    public Usuario getUsuario(String codCpf) throws SQLException {
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
    public Usuario getUsuarioPeloNome(String nome) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Usuario\" "
                + "WHERE nom_usuario = '" + nome;

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if (resultado.next()) {
            aluno = new Usuario(resultado.getString("cod_cpf"),
                    nome,
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
    public ArrayList<Usuario> getListaUsuarios() throws SQLException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        sql = "SELECT * "
                + "FROM \"Usuario\" "
                + "WHERE idt_tipo_usuario='A'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while (resultado.next()) {
            listaUsuarios.add(new Usuario(resultado.getString("cod_cpf"),
                    resultado.getString("nom_usuario"),
                    resultado.getString("idt_tipo_usuario").charAt(0),
                    resultado.getString("txt_senha"),
                    resultado.getString("des_email"),
                    resultado.getDate("dat_nascimento").toLocalDate()));
        }

        return listaUsuarios;
    }

    @Override
    public boolean postUsuario(Usuario aluno) throws SQLException {
        this.aluno = aluno;
        sql = "INSERT INTO \"Usuario\" VALUES (?,?,?,?,?,CAST(? as date));"
                + "INSERT INTO \"Aluno\" "
                + "VALUES((SELECT cod_cpf FROM \"Usuario\" "
                + "WHERE cod_cpf = '" + aluno.getCpf() + "'))";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getCpf());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, String.valueOf(aluno.getTipo()));
            stmt.setString(4, aluno.getSenha());
            stmt.setString(5, aluno.getEmail());
            stmt.setString(6, String.valueOf(aluno.getDataNascimento()));

            stmt.executeUpdate();

        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean putUsuario(Usuario aluno) throws SQLException {
        this.aluno = aluno;
        sql = "UPDATE \"Usuario\" "
                + "SET nom_usuario=?, "
                + "idt_tipo_usuario=?, "
                + "txt_senha=?, "
                + "des_email=?, "
                + "dat_nascimento=CAST(? as date) "
                + "WHERE cod_cpf=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, String.valueOf(aluno.getTipo()));
            stmt.setString(3, aluno.getSenha());
            stmt.setString(4, aluno.getEmail());
            stmt.setString(5, String.valueOf(aluno.getDataNascimento()));
            stmt.setString(6, aluno.getCpf());

            stmt.executeUpdate();

        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUsuario(String codCpf) {
        sql = "DELETE FROM \"Usuario\" "
                + "WHERE cod_cpf='" + codCpf + "'";

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
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
