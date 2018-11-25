package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.dao.IUsuarioDao;
import br.cefetmg.inf.model.db.ConectaBd;
import br.cefetmg.inf.model.domain.Instrutor;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDao implements IUsuarioDao {

    private Usuario usuario;
    private final Connection conn;
    private String sql;
    private final Gson gson;

    public UsuarioDao() {
        conn = ConectaBd.obterInstancia().obterConexao();
        gson = new Gson();
    }

    @Override
    public Usuario getUsuario(String codCpf) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Usuario\" "
                + "WHERE cod_cpf = '" + codCpf + "'";

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if (resultado.next()) {
            if (resultado.getString("idt_tipo_usuario").charAt(0) == 'I') {
                IUsuarioDao instrutorDao = new InstrutorDao();
                usuario = instrutorDao.getUsuario(codCpf);
            } else {
                usuario = new Usuario(codCpf,
                        resultado.getString("nom_usuario"),
                        resultado.getString("idt_tipo_usuario").charAt(0),
                        resultado.getString("txt_senha"),
                        resultado.getString("des_email"),
                        resultado.getDate("dat_nascimento").toLocalDate());
            }
        } else {
            return null;
        }

        return usuario;
    }

    @Override
    public Usuario getUsuarioPeloNome(String nome) throws SQLException {
        sql = "SELECT * "
                + "FROM \"Usuario\" "
                + "WHERE nom_usuario = '" + nome;

        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if (resultado.next()) {
            usuario = new Usuario(resultado.getString("cod_cpf"),
                    nome,
                    resultado.getString("idt_tipo_usuario").charAt(0),
                    resultado.getString("txt_senha"),
                    resultado.getString("des_email"),
                    resultado.getDate("dat_nascimento").toLocalDate());
        } else {

            return null;
        }

        return usuario;
    }

    @Override
    public ArrayList<Usuario> getListaUsuarios() throws SQLException {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        sql = "SELECT * "
                + "FROM \"Usuario\" ";

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
    public boolean postUsuario(Usuario usuario) throws SQLException {
        this.usuario = usuario;
        sql = "INSERT INTO \"Usuario\" VALUES (?,?,?,?,?,CAST(? as date));";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getCpf());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, String.valueOf(usuario.getTipo()));
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, String.valueOf(usuario.getDataNascimento()));

            stmt.executeUpdate();

        } catch (SQLException exception) {
            return false;
        }
        return true;
    }

    @Override
    public boolean putUsuario(Usuario usuario) throws SQLException {
        this.usuario = usuario;
        sql = "UPDATE \"Usuario\" "
                + "SET nom_usuario=?, "
                + "idt_tipo_usuario=?, "
                + "txt_senha=?, "
                + "des_email=?, "
                + "dat_nascimento=CAST(? as date) "
                + "WHERE cod_cpf=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, String.valueOf(usuario.getTipo()));
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, String.valueOf(usuario.getDataNascimento()));
            stmt.setString(6, usuario.getCpf());

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
