package br.cefetmg.inf.model.domain.jpa;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class DiaTreino implements Serializable {
    @EmbeddedId
    private DiaTreinoChave diaTreinoChave;

    public DiaTreino() {
    }

    public DiaTreino(DiaTreinoChave diaTreinoChave) {
        this.diaTreinoChave = diaTreinoChave;
    }

    public DiaTreinoChave getDiaTreinoChave() {
        return diaTreinoChave;
    }

    public void setDiaTreinoChave(DiaTreinoChave diaTreinoChave) {
        this.diaTreinoChave = diaTreinoChave;
    }
}