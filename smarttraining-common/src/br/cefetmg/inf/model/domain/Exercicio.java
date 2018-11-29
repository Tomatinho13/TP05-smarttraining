package br.cefetmg.inf.model.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Exercicio implements Serializable {
    @Id
    @Column(name="cod_exercicio")
    private int codigo;
    
    @Column(name="nom_exercicio")
    private String nome;
    
    @Column(name="des_exercicio")
    private String descricao;

    public Exercicio() {
        
    }

    public Exercicio(int numero, String nome, String descricao) {
        this.codigo = numero;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getNumero() {
        return codigo;
    }

    public void setNumero(int numero) {
        this.codigo = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}