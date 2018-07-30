package model.dao;

import com.google.gson.Gson;
import java.sql.*;
import model.classes.Usuario;


public class AlunoDao {
    private Usuario aluno;
    private Connection conn;
    private String sql;
    private Gson gson;
    
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
        resultado.next();
        
        aluno = new Usuario(cpf,
                resultado.getString("nom_usuario"),
                resultado.getString("idt_tipo_usuario").charAt(0),
                resultado.getString("txt_senha"),
                resultado.getString("des_email"),
                resultado.getDate("dat_nascimento").toLocalDate());
        
        conn.close();
        return aluno;
    }
    
    public void postAluno(Usuario aluno) throws SQLException{
        this.aluno = aluno;
        sql = "INSERT INTO usuario VALUES (?,?,?,?,?,?)";
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

    public void deleteAluno(Usuario fromJson) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void putAluno(Usuario fromJson) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
