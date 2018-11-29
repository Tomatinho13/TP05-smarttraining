package br.cefetmg.inf.model.domain.jpa;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class AparelhoExercicioChave implements Serializable {

    @ManyToOne
    @JoinColumn(name = "nro_aparelho")
    private Aparelho aparelho;
    @ManyToOne
    @JoinColumn(name = "cod_exercicio")
    private Exercicio exercicio;

    public AparelhoExercicioChave() {
    }

    public AparelhoExercicioChave(Aparelho aparelho, Exercicio exercicio) {
        this.aparelho = aparelho;
        this.exercicio = exercicio;
    }

    public Aparelho getAparelho() {
        return aparelho;
    }

    public void setAparelho(Aparelho aparelho) {
        this.aparelho = aparelho;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

}
