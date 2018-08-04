package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.db.ConectaBd;
import br.cefetmg.inf.model.domain.Exercicio;
import com.google.gson.Gson;
import java.sql.*;
import br.cefetmg.inf.model.domain.Musculo;
import java.util.ArrayList;


public class MusculoDao {
    private Musculo musculo;
    private ArrayList<Musculo> listaMusculos;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    
    public MusculoDao(){
        conn = ConectaBd.conecta();
        gson = new Gson();
    }
    
    public Musculo getMusculo(String seqMusculo) throws SQLException{
        ArrayList<Exercicio> listaExercicios = new ArrayList<>();
        sql = "SELECT * FROM \"Exercicio\" WHERE cod_exercicio IN("
                    + "SELECT cod_exercicio FROM \"MusculoExercicio\" WHERE cod_musculo IN("
                        + "SELECT cod_musculo FROM \"Musculo\" WHERE cod_musculo='"+seqMusculo+"'))";
        
        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while(resultado.next()){
            listaExercicios.add(new Exercicio(Integer.parseInt(resultado.getString("cod_exercicio")),
                resultado.getString("nom_exercicio"),
                resultado.getString("des_exercicio")));
            
            musculo = new Musculo(resultado.getInt("cod_musculo"),
                resultado.getInt("cod_regCorp"),
                resultado.getString("nom_musculo"),
                resultado.getString("img_musculo"),
                listaExercicios);
        }
        
        conn.close();
        if(musculo != null){
           return null;
        }
        return musculo;
    }
    
    public void postMusculo(Musculo musculo) throws SQLException{
        this.musculo = musculo;
        sql = "INSERT INTO \"Musculo\" VALUES (?,?,?,?)";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, String.valueOf(musculo.getNroSequenciaMusculo()));
        stmt.setString(2, "SELECT \"cod_regCorp\" FROM \"RegiaoCorporal\" WHERE \"cod_regCorp\"='"+musculo.getNroSequenciaRegiaoCorporal()+"'");
        stmt.setString(3, musculo.getNomeMusculo());
        stmt.setString(4, musculo.getCaminhoImagem());
        
        stmt.executeQuery(sql);
        conn.close();
    }

    public void deleteMusculo(String seqMusculo) throws SQLException {
        sql = ""; //*****************************
        
        Statement stmt = conn.createStatement();
        stmt.executeQuery(sql);
        conn.close();
    }

    public void putMusculo(Musculo musculo) throws SQLException {
        this.musculo = musculo;
        sql = "UPDATE \"Musculo\" "
                + "SET nom_musculo=?, "
                + "img_musculo=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, musculo.getNomeMusculo());
        stmt.setString(2, musculo.getCaminhoImagem());

        stmt.executeQuery(sql);
        conn.close();
    }
}