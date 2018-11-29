package br.cefetmg.inf.model.domain;

import java.util.ArrayList;

/**
 *
 * @author Tomatinho
 */
public class Exercicio {

    private int numero;
    private String nome;
    private String descricao;
    private ArrayList<Musculo> musculos;
    private ArrayList<Aparelho> aparelhos;

    public Exercicio() {

    }

    public Exercicio(int numero, String nome, String descricao, ArrayList<Musculo> musculos, ArrayList<Aparelho> aparelhos) {
        this.numero = numero;
        this.nome = nome;
        this.descricao = descricao;
        this.musculos = musculos;
        this.aparelhos = aparelhos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public ArrayList<Musculo> getMusculos() {
        return musculos;
    }

    public void setMusculos(ArrayList<Musculo> musculos) {
        this.musculos = musculos;
    }

    public ArrayList<Aparelho> getAparelhos() {
        return aparelhos;
    }

    public void setAparelhos(ArrayList<Aparelho> aparelhos) {
        this.aparelhos = aparelhos;
    }
}
