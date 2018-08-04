package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Instrutor;


public class InstrutorDao {
    private Instrutor instrutor;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    
    public InstrutorDao(){
        conn = ConectaBd.conecta();
        gson = new Gson();
    }
    
    public Instrutor getInstrutor(String cpf) throws SQLException{
        sql = "SELECT * "
                + "FROM \"Usuario\""
                + "JOIN \"Instrutor\""
                + "USING(cod_cpf) "
                + "GROUP BY cod_cpf, nro_cref "
                + "HAVING cod_cpf='"+cpf+"'";
        
        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if(resultado.next()){
        instrutor = new Instrutor(resultado.getString("nro_cref"),
                cpf,
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
        return instrutor;
    }
    
    public void postInstrutor(Instrutor instrutor) throws SQLException{
        this.instrutor = instrutor;
        sql = "INSERT INTO \"Usuario\" VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, instrutor.getCodCpf());
        stmt.setString(2, instrutor.getNomUsuario());
        stmt.setString(3, String.valueOf(instrutor.getIdtTipoUsuario()));
        stmt.setString(4, instrutor.getTxtSenha());
        stmt.setString(5, instrutor.getDesEmail());
        stmt.setString(6, String.valueOf(instrutor.getDatNascimento()));
        
        stmt.executeQuery(sql);
        conn.close();
    }

    public void deleteInstrutor(String cpf) throws SQLException {
        sql = "DELETE FROM \"Usuario\" "
                    + "WHERE cod_cpf='"+cpf+"';\n" +
              "DELETE FROM \"Instrutor\" "
                    + "WHERE cod_cpf='"+cpf+"';\n" +
              "DELETE FROM \"Ficha\" "
                    + "WHERE cod_cpf='"+cpf+"';\n" +
              "DELETE FROM \"Treino\" "
                    + "WHERE cod_cpf='"+cpf+"';\n" +
              "DELETE FROM \"TreinoExercicio\" "
                    + "WHERE cod_cpf='"+cpf+"';\n" +
              "DELETE FROM \"DiaTreino\" "
                    + "WHERE cod_cpf='"+cpf+"';\n" +
              "DELETE FROM \"Avaliacao\" "
                    + "WHERE cod_cpf='"+cpf+"';\n" +
              "DELETE FROM \"ObjetivoAvaliacao\" "
                    + "WHERE cod_cpf='"+cpf+"';";
        
        Statement stmt = conn.createStatement();
        stmt.executeQuery(sql);
        conn.close();
    }

    public void putInstrutor(Instrutor instrutor) throws SQLException {
        this.instrutor = instrutor;
        sql = "UPDATE \"Usuario\" "
                + "SET nom_usuario=?, "
                + "idt_tipo_usuario=?, "
                + "txt_senha=?, "
                + "des_email=?, "
                + "dat_nascimento=? "
                + "WHERE cod_cpf=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, instrutor.getNomUsuario());
        stmt.setString(2, String.valueOf(instrutor.getIdtTipoUsuario()));
        stmt.setString(3, instrutor.getTxtSenha());
        stmt.setString(4, instrutor.getDesEmail());
        stmt.setString(5, String.valueOf(instrutor.getDatNascimento()));
        stmt.setString(6, instrutor.getCodCpf());

        stmt.executeQuery(sql);
        conn.close();
    }
    
    
}
