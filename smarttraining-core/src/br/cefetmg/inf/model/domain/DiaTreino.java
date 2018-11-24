package br.cefetmg.inf.model.domain;

import java.time.LocalDate;

/**
 *
 * @author Jamalz
 */

public class DiaTreino {
    private Atividade atividade;
    private LocalDate data;

    public DiaTreino(Atividade atividade, LocalDate dataTreino) {
        this.atividade = atividade;
        this.data = dataTreino;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public LocalDate getDataTreino() {
        return data;
    }

    public void setDataTreino(LocalDate dataTreino) {
        this.data = dataTreino;
    }
     
}
