package br.cefetmg.inf.model.domain.jpa;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ObjetivoAvaliacao implements Serializable {
    @EmbeddedId
    private ObjetivoAvaliacaoChave objetivoAvaliacaoChave;

    public ObjetivoAvaliacao() {
    }

    public ObjetivoAvaliacao(ObjetivoAvaliacaoChave objetivoAvaliacaoChave) {
        this.objetivoAvaliacaoChave = objetivoAvaliacaoChave;
    }

    public ObjetivoAvaliacaoChave getObjetivoAvaliacaoChave() {
        return objetivoAvaliacaoChave;
    }

    public void setObjetivoAvaliacaoChave(ObjetivoAvaliacaoChave objetivoAvaliacaoChave) {
        this.objetivoAvaliacaoChave = objetivoAvaliacaoChave;
    }
}