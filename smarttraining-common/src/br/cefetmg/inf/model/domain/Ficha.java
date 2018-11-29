package br.cefetmg.inf.model.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Tomatinho
 */
@Entity
public class Ficha implements Serializable {

    @EmbeddedId
    private FichaChave fichaChave;

    @ManyToOne
    @JoinColumn(name="cod_cpf_instrutor", referencedColumnName = "cod_cpf")
    private Instrutor instrutor;

    @Column(name = "dat_ficha")
    private LocalDate data;

    @Column(name = "dat_prevista_troca")
    private LocalDate dataTroca;

    public Ficha() {
    }

    public Ficha(FichaChave fichaChave, Instrutor instrutor, LocalDate data, LocalDate dataTroca) {
        this.fichaChave = fichaChave;
        this.instrutor = instrutor;
        this.data = data;
        this.dataTroca = dataTroca;
    }

    public FichaChave getFichaChave() {
        return fichaChave;
    }

    public void setFichaChave(FichaChave fichaChave) {
        this.fichaChave = fichaChave;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getDataTroca() {
        return dataTroca;
    }

    public void setDataTroca(LocalDate dataTroca) {
        this.dataTroca = dataTroca;
    }
}