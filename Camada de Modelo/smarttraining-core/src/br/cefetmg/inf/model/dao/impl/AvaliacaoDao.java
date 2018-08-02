package br.cefetmg.inf.model.dao.impl;

import br.cefetmg.inf.model.db.ConectaBd;
import com.google.gson.Gson;
import java.sql.*;
import java.time.LocalDate;
import br.cefetmg.inf.model.domain.Avaliacao;


public class AvaliacaoDao {
    private Avaliacao avaliacao;
    private final Connection conn;
    private String sql;
    private final Gson gson;
    
    public AvaliacaoDao(){
        conn = ConectaBd.conecta();
        gson = new Gson();
    }
    
    public Avaliacao getAvaliacao(String cpf) throws SQLException{
        sql = "SELECT * "
                + "FROM \"Avaliacao\" "
                + "WHERE cod_cpf = '"+cpf+"'";
        
        Statement stmt = conn.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        if(resultado.next()){
            avaliacao = new Avaliacao(cpf,
                    resultado.getDate("dat_avaliacao").toLocalDate(),
                    resultado.getString("cod_cpf_instrutor"),
                    resultado.getBoolean("idt_recencia"),
                    Double.parseDouble(resultado.getString("qtd_peso")),
                    Double.parseDouble(resultado.getString("qtd_gordura")),
                    Double.parseDouble(resultado.getString("tam_pescoco")),
                    Double.parseDouble(resultado.getString("tam_ombro")),
                    Double.parseDouble(resultado.getString("tam_torax")),
                    Double.parseDouble(resultado.getString("tam_abdomen")),
                    Double.parseDouble(resultado.getString("tam_cintura")),
                    Double.parseDouble(resultado.getString("tam_quadril")),
                    Double.parseDouble(resultado.getString("tam_bracoEsq")),
                    Double.parseDouble(resultado.getString("tam_bracoDir")),
                    Double.parseDouble(resultado.getString("tam_antebracoEsq")),
                    Double.parseDouble(resultado.getString("tam_antebracoDir")),
                    Double.parseDouble(resultado.getString("tam_coxaEsq")),
                    Double.parseDouble(resultado.getString("tam_coxaDir")),
                    Double.parseDouble(resultado.getString("tam_panturrilhaEsq")),
                    Double.parseDouble(resultado.getString("tam_panturrilhaDir")));
                    
        }
        else{
            conn.close();
            return null;
        }
        conn.close();
        return avaliacao;
    }
    
    public void postAvaliacao(Avaliacao avaliacao) throws SQLException{
        this.avaliacao = avaliacao;
        sql = "INSERT INTO \"Avaliacao\" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, avaliacao.getCodCpfAluno());
        stmt.setString(2, avaliacao.getDatAvaliacao().toString());
        stmt.setString(3, avaliacao.getCodCpfInstrutor());
        stmt.setString(4, String.valueOf(avaliacao.getIdtRecencia()));
        stmt.setString(5, String.valueOf(avaliacao.getPeso()));
        stmt.setString(6, String.valueOf(avaliacao.getPercentualGordura()));
        stmt.setString(7, String.valueOf(avaliacao.getTamanhoPescoco()));
        stmt.setString(8, String.valueOf(avaliacao.getTamanhoOmbro()));
        stmt.setString(9, String.valueOf(avaliacao.getTamanhoTorax()));
        stmt.setString(10, String.valueOf(avaliacao.getTamanhoAbdomen()));
        stmt.setString(11, String.valueOf(avaliacao.getTamanhoCintura()));
        stmt.setString(12, String.valueOf(avaliacao.getTamanhoQuadril()));
        stmt.setString(13, String.valueOf(avaliacao.getTamanhoBracoEsquerdo()));
        stmt.setString(14, String.valueOf(avaliacao.getTamanhoBracoDireito()));
        stmt.setString(15, String.valueOf(avaliacao.getTamanhoAntebracoEsquerdo()));
        stmt.setString(16, String.valueOf(avaliacao.getTamanhoAntebracoDireito()));
        stmt.setString(17, String.valueOf(avaliacao.getTamanhoCoxaEsquerda()));
        stmt.setString(18, String.valueOf(avaliacao.getTamanhoCoxaDireita()));
        stmt.setString(19, String.valueOf(avaliacao.getTamanhoPanturrilhaEsquerda()));
        stmt.setString(20, String.valueOf(avaliacao.getTamanhoPanturrilhaDireita()));
        
        stmt.executeQuery(sql);
        conn.close();
    }

    public void deleteAvaliacao(String cpf, LocalDate datAvaliacao) throws SQLException {
        sql = "DELETE FROM \"Avaliacao\" "
                    + "WHERE cod_cpf='"+cpf+"' AND dat_avaliacao='"+datAvaliacao.toString()+"';" +
              "DELETE FROM \"Treino\" "
                    + "WHERE cod_cpf='"+cpf+"' AND dat_avaliacao='"+datAvaliacao.toString()+"';";
        
        Statement stmt = conn.createStatement();
        stmt.executeQuery(sql);
        conn.close();
    }

    public void putAvaliacao(Avaliacao avaliacao) throws SQLException {
        this.avaliacao = avaliacao;
        sql = "UPDATE \"Avaliacao\" "
                + "SET cod_cpf_instrutor=?, "
                + "idt_recencia=?, "
                + "qtd_peso=?, "
                + "qtd_gordura=? "
                + "tam_pescoco=? "
                + "tam_ombro=? "
                + "tam_torax=? "
                + "tam_abdomen=? "
                + "tam_cintura=? "
                + "tam_quadril=? "
                + "tam_bracoEsq=? "
                + "tam_bracoDir=? "
                + "tam_antebracoEsq=? "
                + "tam_antebracoDir=? "
                + "tam_coxaEsq=? "
                + "tam_coxaDir=? "
                + "tam_panturrilhaEsq=? "
                + "tam_panturrilhaDir=? "
                + "WHERE cod_cpf=?"
                + "AND dat_avaliacao=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, avaliacao.getCodCpfInstrutor());
        stmt.setString(2, String.valueOf(avaliacao.getIdtRecencia()));
        stmt.setString(3, String.valueOf(avaliacao.getPeso()));
        stmt.setString(4, String.valueOf(avaliacao.getPercentualGordura()));
        stmt.setString(5, String.valueOf(avaliacao.getTamanhoPescoco()));
        stmt.setString(6, String.valueOf(avaliacao.getTamanhoOmbro()));
        stmt.setString(7, String.valueOf(avaliacao.getTamanhoTorax()));
        stmt.setString(8, String.valueOf(avaliacao.getTamanhoAbdomen()));
        stmt.setString(9, String.valueOf(avaliacao.getTamanhoCintura()));
        stmt.setString(10, String.valueOf(avaliacao.getTamanhoQuadril()));
        stmt.setString(11, String.valueOf(avaliacao.getTamanhoBracoEsquerdo()));
        stmt.setString(12, String.valueOf(avaliacao.getTamanhoBracoDireito()));
        stmt.setString(13, String.valueOf(avaliacao.getTamanhoAntebracoEsquerdo()));
        stmt.setString(14, String.valueOf(avaliacao.getTamanhoAntebracoDireito()));
        stmt.setString(15, String.valueOf(avaliacao.getTamanhoCoxaEsquerda()));
        stmt.setString(16, String.valueOf(avaliacao.getTamanhoCoxaDireita()));
        stmt.setString(17, String.valueOf(avaliacao.getTamanhoPanturrilhaEsquerda()));
        stmt.setString(18, String.valueOf(avaliacao.getTamanhoPanturrilhaDireita()));
        stmt.setString(19, avaliacao.getCodCpfAluno());
        stmt.setString(20, avaliacao.getDatAvaliacao().toString());
        
        stmt.executeQuery(sql);
        conn.close();    }
    
    
}