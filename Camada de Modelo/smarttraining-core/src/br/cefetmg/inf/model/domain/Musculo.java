package br.cefetmg.inf.model.domain;

/**
 *
 * @author Tomatinho
 */

public class Musculo {
    private int nroSequenciaMusculo;
    private int nroSequenciaRegiaoCorporal;
    private String nomeMusculo;
    private String caminhoImagem; 

    public Musculo() {
    }

    public Musculo(int nroSequenciaMusculo, int nroSequenciaRegiaoCorporal, String nomeMusculo, String caminhoImagem) {
        this.nroSequenciaMusculo = nroSequenciaMusculo;
        this.nroSequenciaRegiaoCorporal = nroSequenciaRegiaoCorporal;
        this.nomeMusculo = nomeMusculo;
        this.caminhoImagem = caminhoImagem;
    }

    public int getNroSequenciaMusculo() {
        return nroSequenciaMusculo;
    }

    public void setNroSequenciaMusculo(int nroSequenciaMusculo) {
        this.nroSequenciaMusculo = nroSequenciaMusculo;
    }

    public int getNroSequenciaRegiaoCorporal() {
        return nroSequenciaRegiaoCorporal;
    }

    public void setNroSequenciaRegiaoCorporal(int nroSequenciaRegiaoCorporal) {
        this.nroSequenciaRegiaoCorporal = nroSequenciaRegiaoCorporal;
    }

    public String getNomeMusculo() {
        return nomeMusculo;
    }

    public void setNomeMusculo(String nomeMusculo) {
        this.nomeMusculo = nomeMusculo;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
     
}
