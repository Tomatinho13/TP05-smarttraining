package model.dao;

import com.google.gson.Gson;
import java.sql.*;
import model.classes.Usuario;


public class AlunoDao {
    private Usuario aluno;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    
    public AlunoDao(){
        conn = ConectaBd.conecta();
        gson = new Gson();
    }
    
    public Usuario getAluno(String cpf) throws SQLException{
        sql = "SELECT * "
                + "FROM \"Usuario\" "
                + "WHERE cod_cpf = '"+cpf+"'";
        
        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if(resultado.next()){
            aluno = new Usuario(cpf,
                    resultado.getString("nom_usuario"),
                    resultado.getString("idt_tipo_usuario").charAt(0),
                    resultado.getString("txt_senha"),
                    resultado.getString("des_email"),
                    resultado.getDate("dat_nascimento").toLocalDate());
        }
        else{
            conn.close();
            return null;
        }
        conn.close();
        return aluno;
    }
    
    public void postAluno(Usuario aluno) throws SQLException{
        this.aluno = aluno;
        sql = "INSERT INTO \"Usuario\" VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, aluno.getCodCpf());
        stmt.setString(2, aluno.getNomUsuario());
        stmt.setString(3, String.valueOf(aluno.getIdtTipoUsuario()));
        stmt.setString(4, aluno.getTxtSenha());
        stmt.setString(5, aluno.getDesEmail());
        stmt.setString(6, String.valueOf(aluno.getDatNascimento()));
        
        stmt.executeQuery(sql);
        conn.close();
    }

    public void deleteAluno(String cpf) throws SQLException {
        sql = "DELETE FROM \"Usuario\" "
                    + "WHERE cod_cpf='"+cpf+"';" +
              "DELETE FROM \"Aluno\" "
                    + "WHERE cod_cpf='"+cpf+"';" +
              "DELETE FROM \"Ficha\" "
                    + "WHERE cod_cpf='"+cpf+"';" +
              "DELETE FROM \"Treino\" "
                    + "WHERE cod_cpf='"+cpf+"';" +
              "DELETE FROM \"TreinoExercicio\" "
                    + "WHERE cod_cpf='"+cpf+"';" +
              "DELETE FROM \"DiaTreino\" "
                    + "WHERE cod_cpf='"+cpf+"';" +
              "DELETE FROM \"Avaliacao\" "
                    + "WHERE cod_cpf='"+cpf+"';" +
              "DELETE FROM \"ObjetivoAvaliacao\" "
                    + "WHERE cod_cpf='"+cpf+"';";
        
        Statement stmt = conn.createStatement();
        stmt.executeQuery(sql);
        conn.close();
    }

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
        conn.close();    }
    
    
}
