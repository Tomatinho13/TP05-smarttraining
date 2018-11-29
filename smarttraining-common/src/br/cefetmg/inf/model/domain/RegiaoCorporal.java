package br.cefetmg.inf.model.domain;

import java.util.ArrayList;

/**
 *
 * @author Tomatinho
 */

public class RegiaoCorporal {
    private int numero;
    private String nome;
    private ArrayList<Musculo> listaMusculos;

    public RegiaoCorporal() {
    }

    public RegiaoCorporal(int numero, String nome, ArrayList<Musculo> listaMusculos) {
        this.numero = numero;
        this.nome = nome;
        this.listaMusculos=new ArrayList<>(listaMusculos);
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

    public ArrayList<Musculo> getListaMusculos() {
        return listaMusculos;
    }

    public void setListaMusculos(ArrayList<Musculo> listaMusculos) {
        this.listaMusculos = new ArrayList<>(listaMusculos);
    }
}
