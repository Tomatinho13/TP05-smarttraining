package br.cefetmg.inf.model.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Musculo implements Serializable {
    @Id
    @Column(name = "cod_musculo")
    private int codigo;
    
    @ManyToOne(targetEntity = RegiaoCorporal.class)
    @JoinColumn(name = "cod_regCorp")
    private RegiaoCorporal regiaoCorporal;
    
    @Column(name = "nom_musculo")
    private String nome;
    
    @Column(name = "img_musculo")
    private String caminhoImagem;

    public Musculo() {
    }

    public Musculo(int codigo, RegiaoCorporal regiaoCorporal, String nome, String caminhoImagem) {
        this.codigo = codigo;
        this.regiaoCorporal = regiaoCorporal;
        this.nome = nome;
        this.caminhoImagem = caminhoImagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public RegiaoCorporal getRegiaoCorporal() {
        return regiaoCorporal;
    }

    public void setRegiaoCorporal(RegiaoCorporal regiaoCorporal) {
        this.regiaoCorporal = regiaoCorporal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
    
    
}