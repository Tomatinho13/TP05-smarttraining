package br.cefetmg.inf.model.domain.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Treino implements Serializable {
    @EmbeddedId
    private TreinoChave treinoChave;
    
    @Column(name="des_treino")
    private String descricao;

    public Treino() {
    }

    public Treino(TreinoChave treinoChave, String descricao) {
        this.treinoChave = treinoChave;
        this.descricao = descricao;
    }

    public TreinoChave getTreinoChave() {
        return treinoChave;
    }

    public void setTreinoChave(TreinoChave treinoChave) {
        this.treinoChave = treinoChave;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}