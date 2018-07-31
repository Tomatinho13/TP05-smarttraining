package model.dao;

import com.google.gson.Gson;
import java.sql.*;
import model.classes.Ficha;


public class FichaDao {
    private Ficha ficha;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    
    public FichaDao(){
        conn = ConectaBd.conecta();
        gson = new Gson();
    }
    
    public Ficha getFicha(String cpf) throws SQLException{
        sql = "SELECT * "
                + "FROM \"Ficha\" "
                + "WHERE cod_cpf = '"+cpf+"'";
        
        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if(resultado.next()){
            ficha = new Ficha(cpf,
                    resultado.getInt("nro_ficha"),
                    resultado.getString("cod_cpf_instrutor"),
                    resultado.getDate("dat_ficha").toLocalDate(),
                    resultado.getDate("dat_prevista_troca").toLocalDate(),
                    resultado.getString("idt_treino").charAt(0));
        }
        else{
            conn.close();
            return null;
        }
        conn.close();
        return ficha;
    }
    
    public void postFicha(Ficha ficha) throws SQLException{
        this.ficha = ficha;
        sql = "INSERT INTO \"Ficha\" VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, ficha.getCodCpfAluno());
        stmt.setString(2, String.valueOf(ficha.getNroFicha()));
        stmt.setString(3, ficha.getCodCpfInstrutor());
        stmt.setString(4, ficha.getDataFicha().toString());
        stmt.setString(5, ficha.getDataPrevistaTroca().toString());
        stmt.setString(6, String.valueOf(ficha.getIdtTreino()));
        
        stmt.executeQuery(sql);
        conn.close();
    }

    public void deleteFicha(String cpf, int nroFicha) throws SQLException {
        sql = "DELETE FROM \"Ficha\" "
                    + "WHERE cod_cpf='"+cpf+"' AND nro_ficha='"+nroFicha+"';" +
              "DELETE FROM \"Treino\" "
                    + "WHERE cod_cpf='"+cpf+"' AND nro_ficha='"+nroFicha+"';" +
              "DELETE FROM \"TreinoExercicio\" "
                    + "WHERE cod_cpf='"+cpf+"' AND nro_ficha='"+nroFicha+"';" +
              "DELETE FROM \"DiaTreino\" "
                    + "WHERE cod_cpf='"+cpf+"' AND nro_ficha='"+nroFicha+"';";
        
        Statement stmt = conn.createStatement();
        stmt.executeQuery(sql);
        conn.close();
    }

    public void putFicha(Ficha ficha) throws SQLException {
        this.ficha = ficha;
        sql = "UPDATE \"Ficha\" "
                + "SET cod_cpf_instrutor=?, "
                + "dat_ficha=?, "
                + "dat_prevista_troca=?, "
                + "idt_treino=? "
                + "WHERE cod_cpf=?"
                + "AND nro_ficha=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, ficha.getCodCpfInstrutor());
        stmt.setString(2, ficha.getDataFicha().toString());
        stmt.setString(3, ficha.getDataPrevistaTroca().toString());
        stmt.setString(4, String.valueOf(ficha.getIdtTreino()));
        stmt.setString(5, ficha.getCodCpfAluno());
        stmt.setString(6, String.valueOf(ficha.getNroFicha()));
        
        stmt.executeQuery(sql);
        conn.close();    }
    
    
}
