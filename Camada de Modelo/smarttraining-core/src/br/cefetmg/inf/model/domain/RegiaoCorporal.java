package br.cefetmg.inf.model.domain;

/**
 *
 * @author Tomatinho
 */

public class RegiaoCorporal {
    private int nroSequenciaRegiaoCorporal;
    private String nomeRegiao;

    public RegiaoCorporal() {
    }

    public RegiaoCorporal(int nroSequenciaRegiaoCorporal, String nomeRegiao) {
        this.nroSequenciaRegiaoCorporal = nroSequenciaRegiaoCorporal;
        this.nomeRegiao = nomeRegiao;
    }

    public int getNroSequenciaRegiaoCorporal() {
        return nroSequenciaRegiaoCorporal;
    }

    public void setNroSequenciaRegiaoCorporal(int nroSequenciaRegiaoCorporal) {
        this.nroSequenciaRegiaoCorporal = nroSequenciaRegiaoCorporal;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public void setNomeRegiao(String nomeRegiao) {
        this.nomeRegiao = nomeRegiao;
    }
}
