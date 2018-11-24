package br.cefetmg.inf.model.domain;

import java.util.ArrayList;

public class Aparelho {
    private int numero;
    private String nome;
    private ArrayList<Exercicio> exercicios;

    public Aparelho() {
    }

    public Aparelho(int numero, String nome, ArrayList<Exercicio> exercicios) {
        this.numero = numero;
        this.nome = nome;
        this.exercicios = exercicios;
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

    public ArrayList<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(ArrayList<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }
}
