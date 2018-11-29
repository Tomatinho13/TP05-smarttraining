package br.cefetmg.inf.model.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class MusculoExercicioChave implements Serializable {
    @ManyToOne
    @JoinColumn(referencedColumnName = "cod_exercicio")
    private Exercicio exercicio;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "cod_regCorp")
    private RegiaoCorporal regiaoCorporal;

    public MusculoExercicioChave() {
    }

    public MusculoExercicioChave(Exercicio exercicio, RegiaoCorporal regiaoCorporal) {
        this.exercicio = exercicio;
        this.regiaoCorporal = regiaoCorporal;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public RegiaoCorporal getRegiaoCorporal() {
        return regiaoCorporal;
    }

    public void setRegiaoCorporal(RegiaoCorporal regiaoCorporal) {
        this.regiaoCorporal = regiaoCorporal;
    }
}