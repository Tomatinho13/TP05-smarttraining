package br.cefetmg.inf.model.domain.jpa;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class AvaliacaoChave implements Serializable {
    @ManyToOne
    @JoinColumn(referencedColumnName = "cod_cpf")
    private Aluno aluno;
    
    @Column(name = "dat_avaliacao")
    private LocalDate data;

    public AvaliacaoChave(Aluno aluno, LocalDate data) {
        this.aluno = aluno;
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    
}
