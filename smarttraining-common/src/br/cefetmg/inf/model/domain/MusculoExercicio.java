package br.cefetmg.inf.model.domain;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class MusculoExercicio implements Serializable {
    @EmbeddedId
    private MusculoExercicioChave musculoExercicioChave;

    public MusculoExercicio() {
    }

    public MusculoExercicio(MusculoExercicioChave musculoExercicioChave) {
        this.musculoExercicioChave = musculoExercicioChave;
    }

    public MusculoExercicioChave getMusculoExercicioChave() {
        return musculoExercicioChave;
    }

    public void setMusculoExercicioChave(MusculoExercicioChave musculoExercicioChave) {
        this.musculoExercicioChave = musculoExercicioChave;
    }
}