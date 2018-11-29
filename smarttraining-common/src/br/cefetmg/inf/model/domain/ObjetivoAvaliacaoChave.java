package br.cefetmg.inf.model.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class ObjetivoAvaliacaoChave implements Serializable {
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "cod_avaliacao"),
        @JoinColumn(name = "cod_cpf")
    })
    private Avaliacao avaliacao;
    
    @ManyToOne
    @JoinColumn(name = "cod_objetivo")
    private Objetivo objetivo;

    public ObjetivoAvaliacaoChave() {
    }
    
    public ObjetivoAvaliacaoChave(Avaliacao avaliacao, Objetivo objetivo) {
        this.avaliacao = avaliacao;
        this.objetivo = objetivo;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }
}