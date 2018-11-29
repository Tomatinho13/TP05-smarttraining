package br.cefetmg.inf.model.domain.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Gabriel
 */
@Embeddable
public class FichaChave implements Serializable {
    @ManyToOne
    @JoinColumn(name="cod_cpf", referencedColumnName = "cod_cpf")
    private Aluno aluno;

    @Column(name = "nro_ficha")
    private int numero;

    public FichaChave() {
    }

    public FichaChave(Aluno aluno, int numero) {
        this.aluno = aluno;
        this.numero = numero;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}