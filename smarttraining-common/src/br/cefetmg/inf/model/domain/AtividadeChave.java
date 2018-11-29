package br.cefetmg.inf.model.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 *
 * @author Felipe
 */
@Embeddable
public class AtividadeChave implements Serializable {

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "cod_cpf"),
        @JoinColumn(name = "nro_ficha"),
        @JoinColumn(name = "nro_treino")
    })
    private Treino treino;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "cod_exercicio"),
        @JoinColumn(name = "nro_aparelho")
    })
    private AparelhoExercicio aparelhoExercicio;

    public AtividadeChave() {
    }

    public AtividadeChave(Treino treino, AparelhoExercicio aparelhoExercicio) {
        this.treino = treino;
        this.aparelhoExercicio = aparelhoExercicio;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }

    public AparelhoExercicio getAparelhoExercicio() {
        return aparelhoExercicio;
    }

    public void setAparelhoExercicio(AparelhoExercicio aparelhoExercicio) {
        this.aparelhoExercicio = aparelhoExercicio;
    }
}
