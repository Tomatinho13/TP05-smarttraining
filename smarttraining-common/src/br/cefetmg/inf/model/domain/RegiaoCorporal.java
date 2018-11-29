package br.cefetmg.inf.model.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RegiaoCorporal implements Serializable {
    @Id
    @Column(name = "cod_regCorp")
    private int codigo;

    @Column(name = "nom_regCorp")
    private String nome;

    public RegiaoCorporal() {
    }

    public RegiaoCorporal(int numero, String nome) {
        this.codigo = numero;
        this.nome = nome;
    }

    public int getNumero() {
        return codigo;
    }

    public void setNumero(int numero) {
        this.codigo = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}