package model.dao;

import com.google.gson.Gson;
import java.sql.*;
import java.util.ArrayList;
import model.classes.Aparelho;
import model.classes.AparelhoExercicio;
import model.classes.Exercicio;


public class ExercicioDao {
    private Exercicio exercicio;
    private ArrayList<Exercicio> listaExercicios;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    
    public ExercicioDao(){
        conn = ConectaBd.conecta();
        gson = new Gson();
    }
    
    public AparelhoExercicio getExercicio(String codExercicio, String nroAparelho) throws SQLException{
        AparelhoExercicio aparelhoExercicio;
        sql =   "SELECT nom_exercicio, des_exercicio, nom_aparelho, img_execucao "
                + "FROM \"Exercicio\"" +
                  "JOIN \"AparelhoExercicio\" USING (cod_exercicio)" +
                  "JOIN \"Aparelho\" USING (nro_aparelho)" +
                  "GROUP BY nro_aparelho, cod_exercicio, nom_aparelho" +
                  "HAVING cod_exercicio = '"+codExercicio+"' AND nro_aparelho='"+nroAparelho+"'";
        
        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if(resultado.next()){
            Aparelho aparelho = new Aparelho(Integer.parseInt(nroAparelho), resultado.getString("nom_aparelho"));
            exercicio = new Exercicio(Integer.parseInt(codExercicio),
                    resultado.getString("nom_exercicio"),
                    resultado.getString("des_exercicio"));
            aparelhoExercicio = new AparelhoExercicio(aparelho, exercicio, resultado.getString("img_execucao"));
        }
        else{
            conn.close();
            return null;
        }
        conn.close();
        return aparelhoExercicio;
    }
    
    public Exercicio getExerciciosRegiao(String codExercicio) throws SQLException{
        sql =   "SELECT * FROM \"Exercicio\" "
                + "WHERE cod_exercicio in (" +
                    "SELECT cod_exercicio FROM \"MusculoExercicio\" "
                    + "WHERE seq_musculo IN (" +
                            "SELECT seq_musculo FROM \"Musculo\" "
                            + "WHERE \"seq_regCorp\" IN (" +
                                    "SELECT \"seq_regCorp\" FROM \"RegiaoCorporal\" "
                                    + "WHERE \"nom_regCorp\" = 'teste')))";
        
        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while(resultado.next()){
            listaExercicios.add(new Exercicio(Integer.parseInt(codExercicio),
                    resultado.getString("nom_exercicio"),
                    resultado.getString("des_exercicio")));
        }
        if(listaExercicios.isEmpty()){
            conn.close();
            return null;
        }
        conn.close();
        return exercicio;
    }
    
    public void postExercicio(Exercicio exercicio, String seqMusculo) throws SQLException{
        this.exercicio = exercicio;
        sql = "INSERT INTO \"Exercicio\" (nom_exercicio, des_exercicio) VALUES (?, ?);"
                + "INSERT INTO \"MusculoExercicio\" VALUES" +
"               ((SELECT cod_exercicio FROM \"Exercicio\" "
                    + "WHERE nomExercicio=?)," +
"               (SELECT seq_musculo FROM \"Musculo\" "
                    + "WHERE seq_musculo=?))";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, exercicio.getNomeExercicio());
        stmt.setString(2, exercicio.getDescriçaoExercicio());
        stmt.setString(3, exercicio.getNomeExercicio());
        stmt.setString(4, seqMusculo);
        
        stmt.executeQuery(sql);
        conn.close();
    }

    public void deleteExercicio(String cod_exercicio) throws SQLException {
        sql = "DELETE FROM \"MusculoExercicio\" "
                +"WHERE cod_exercicio=?;" +
              "DELETE FROM \"Exercicio\" "
                +"WHERE cod_exercicio=?;";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, cod_exercicio);
        stmt.setString(2, cod_exercicio);
        
        stmt.executeQuery(sql);
        conn.close();
    }

    public void putExercicio(Exercicio exercicio) throws SQLException {
        this.exercicio = exercicio;
        sql = "UPDATE \"Exercicio\" "
                + "SET nom_exercicio=?, "
                + "des_exercicio=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, exercicio.getNomeExercicio());
        stmt.setString(2, exercicio.getDescriçaoExercicio());

        stmt.executeQuery(sql);
        conn.close();
    }
    
    
}
