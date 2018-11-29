package br.cefetmg.inf.model.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class DiaTreinoChave implements Serializable {
    @ManyToOne
    @JoinColumns({
        @JoinColumn(referencedColumnName="cod_exercicio"),
        @JoinColumn(referencedColumnName="nro_aparelho"),
        @JoinColumn(referencedColumnName="cod_cpf"),
        @JoinColumn(referencedColumnName="nro_treino"),
        @JoinColumn(referencedColumnName="nro_ficha")
    })
    private Atividade atividade;
    
    @Column(name="dat_treino", nullable = false)
    private LocalDate dataTreino;

    public DiaTreinoChave() {
    }

    public DiaTreinoChave(Atividade atividade, LocalDate dataTreino) {
        this.atividade = atividade;
        this.dataTreino = dataTreino;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public LocalDate getDataTreino() {
        return dataTreino;
    }

    public void setDataTreino(LocalDate dataTreino) {
        this.dataTreino = dataTreino;
    }
     
}