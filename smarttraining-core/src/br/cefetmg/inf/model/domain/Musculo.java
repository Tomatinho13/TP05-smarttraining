package br.cefetmg.inf.model.domain;

import java.util.ArrayList;

/**
 *
 * @author Tomatinho
 */

public class Musculo {
    private int numero;
    private int codRegiaoCorporal;
    private String nome;
    private String caminhoImagem; 
    private ArrayList<Exercicio> exercicios;

    public Musculo() {
    }

    
    public Musculo(int numero, int codRegiaoCorporal, String nome, String caminhoImagem, ArrayList<Exercicio> listaExercicios) {
        this.numero = numero;
        this.codRegiaoCorporal = codRegiaoCorporal;
        this.nome = nome;
        this.caminhoImagem = caminhoImagem;
        this.exercicios = new ArrayList<>(listaExercicios);
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodRegiaoCorporal() {
        return codRegiaoCorporal;
    }

    public void setCodRegiaoCorporal(int codRegiaoCorporal) {
        this.codRegiaoCorporal = codRegiaoCorporal;
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

    public ArrayList<Exercicio> getListaExercicios() {
        return exercicios;
    }

    public void setListaExercicios(ArrayList<Exercicio> listaExercicios) {
        this.exercicios = listaExercicios;
    }
}
