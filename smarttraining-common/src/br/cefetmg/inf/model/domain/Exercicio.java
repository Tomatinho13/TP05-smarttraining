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
    private ArrayList<Musculo> listaMusculos;

    public Exercicio() {

    }

    public Exercicio(int numero, String nome, String descricao, ArrayList<Musculo> listaMusculos) {
        this.numero = numero;
        this.nome = nome;
        this.descricao = descricao;
        this.listaMusculos = listaMusculos;
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

    public ArrayList<Musculo> getListaMusculos() {
        return listaMusculos;
    }

    public void setListaMusculos(ArrayList<Musculo> listaMusculos) {
        this.listaMusculos = listaMusculos;
    }

}
