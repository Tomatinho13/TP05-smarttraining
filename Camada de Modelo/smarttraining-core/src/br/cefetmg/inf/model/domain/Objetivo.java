package br.cefetmg.inf.model.domain;

/**
 *
 * @author Tomatinho
 */

public class Objetivo {
    private int nroSequenciaObjetivo;
    private String nome;
    private String descriçao;

    public Objetivo() {
    }

    public Objetivo(int nroSequenciaObjetivo, String nome, String descriçao) {
        this.nroSequenciaObjetivo = nroSequenciaObjetivo;
        this.nome = nome;
        this.descriçao = descriçao;
    }

    public int getNroSequenciaObjetivo() {
        return nroSequenciaObjetivo;
    }

    public void setNroSequenciaObjetivo(int nroSequenciaObjetivo) {
        this.nroSequenciaObjetivo = nroSequenciaObjetivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescriçao() {
        return descriçao;
    }

    public void setDescriçao(String descriçao) {
        this.descriçao = descriçao;
    }
}
