package br.cefetmg.inf.model.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aparelho implements Serializable {
    @Id
    @Column(name="nro_aparelho", nullable = false)
    private int numero;
    
    @Column(name="nom_aparelho", nullable = false)
    private String nome;

    public Aparelho() {
    }

    public Aparelho(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}