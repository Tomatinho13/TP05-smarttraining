package br.cefetmg.inf.model.domain.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class TreinoChave implements Serializable {
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name="cod_cpf", referencedColumnName = "cod_cpf"),
        @JoinColumn(name="nro_ficha", referencedColumnName = "nro_ficha")
    })
    private Ficha ficha;
    
    @Column(name = "nro_treino")
    private String numero;

    public TreinoChave(Ficha ficha, String numero) {
        this.ficha = ficha;
        this.numero = numero;
    }
    
    public TreinoChave() {
    }
    
    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}