package br.cefetmg.inf.model.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="cod_cpf")
public class Instrutor extends Usuario{
    @Column(name="nro_cref")
    private String nroCref;

    public Instrutor() {
    }

    public Instrutor(String nroCref, String cpf, String nome, char tipo, String senha, String email, LocalDate dataNascimento) {
        super(cpf, nome, tipo, senha, email, dataNascimento);
        this.nroCref = nroCref;
    }

    public String getNroCref() {
        return nroCref;
    }

    public void setNroCref(String nroCref) {
        this.nroCref = nroCref;
    }
}