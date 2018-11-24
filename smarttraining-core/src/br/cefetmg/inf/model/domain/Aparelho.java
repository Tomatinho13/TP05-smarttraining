package br.cefetmg.inf.model.domain;

/**
 *
 * @author Tomatinho
 */

public class Aparelho {
    private int numero;
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