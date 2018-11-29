package br.cefetmg.inf.model.domain.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Atividade implements Serializable {

    @EmbeddedId
    private AtividadeChave atividadeChave;
    
    @Column(name = "qtd_peso", nullable = false)
    private int qtdPeso;
    
    @Column(name = "nro_series", nullable = false)
    private int nroSeries;
    
    @Column(name = "nro_repeticoes", nullable = false)
    private int nroRepeticoes;

    public Atividade() {
    }

    public Atividade(AtividadeChave atividadeChave, int qtdPeso, int nroSeries, int nroRepeticoes) {
        this.atividadeChave = atividadeChave;
        this.qtdPeso = qtdPeso;
        this.nroSeries = nroSeries;
        this.nroRepeticoes = nroRepeticoes;
    }

    public AtividadeChave getAtividadeChave() {
        return atividadeChave;
    }

    public void setAtividadeChave(AtividadeChave atividadeChave) {
        this.atividadeChave = atividadeChave;
    }

    public int getQtdPeso() {
        return qtdPeso;
    }

    public void setQtdPeso(int qtdPeso) {
        this.qtdPeso = qtdPeso;
    }

    public int getNroSeries() {
        return nroSeries;
    }

    public void setNroSeries(int nroSeries) {
        this.nroSeries = nroSeries;
    }

    public int getNroRepeticoes() {
        return nroRepeticoes;
    }

    public void setNroRepeticoes(int nroRepeticoes) {
        this.nroRepeticoes = nroRepeticoes;
    }
}
