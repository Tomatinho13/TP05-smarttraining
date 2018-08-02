package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import java.util.ArrayList;
import br.cefetmg.inf.model.domain.Aparelho;


public class AparelhoDao {
    private ArrayList<Aparelho> listaAparelhos;
    private Aparelho aparelho;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    
    public AparelhoDao(){
        conn = ConectaBd.conecta();
        gson = new Gson();
    }
    
    public ArrayList<Aparelho> getListaAparelhos() throws SQLException{
        sql = "SELECT * "
                + "FROM \"Aparelho\" ";
        
        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while(resultado.next()){
            listaAparelhos.add(new Aparelho(resultado.getInt("nro_aparelho"),
                    resultado.getString("nom_aparelho")));
        }
        if(listaAparelhos.isEmpty()){
            conn.close();
            return null;
        }
        conn.close();
        return listaAparelhos;
    }
    
    public void postAparelho(Aparelho aparelho) throws SQLException{
        this.aparelho = aparelho;
        sql = "INSERT INTO \"Aparelho\" VALUES (?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, String.valueOf(aparelho.getCodAparelho()));
        stmt.setString(2, aparelho.getNomAparelho());
        
        stmt.executeQuery(sql);
        conn.close();
    }

    public void deleteAparelho(String nroAparelho) throws SQLException {
        sql = "DELETE FROM \"DiaTreino\" "
                    + "WHERE nro_aparelho='"+nroAparelho+"';" +
              "DELETE FROM \"TreinoExercicio\" "
                    + "WHERE nro_aparelho='"+nroAparelho+"';" +
              "DELETE FROM \"AparelhoExercicio\" "
                    + "WHERE nro_aparelho='"+nroAparelho+"';" +
              "DELETE FROM \"Aparelho\" "
                    + "WHERE nro_aparelho='"+nroAparelho+"';";
        
        Statement stmt = conn.createStatement();
        stmt.executeQuery(sql);
        conn.close();
    }

    public void putAparelho(Aparelho aparelho) throws SQLException {
        this.aparelho = aparelho;
        sql = "UPDATE \"Aparelho\" "
                + "SET nom_usuario='"+aparelho.getNomAparelho()+"'"
                + "WHERE nro_aparelho='"+aparelho.getCodAparelho()+"'";
        
        Statement stmt = conn.createStatement();
        stmt.executeQuery(sql);
        conn.close();    }
    
    
}
