package br.cefetmg.inf.model.domain.jpa;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class AparelhoExercicio implements Serializable {

    @EmbeddedId
    private AparelhoExercicioChave chaveApEx;
    
    @Column(name = "img_execucao", nullable = false)
    private String imgExecucao;

    public AparelhoExercicio() {
    }

    public AparelhoExercicio(AparelhoExercicioChave chaveApEx, String imgExecucao) {
        this.chaveApEx = chaveApEx;
        this.imgExecucao = imgExecucao;
    }

    public AparelhoExercicioChave getChaveApEx() {
        return chaveApEx;
    }

    public void setChaveApEx(AparelhoExercicioChave chaveApEx) {
        this.chaveApEx = chaveApEx;
    }

    public String getImgExecucao() {
        return imgExecucao;
    }

    public void setImgExecucao(String imgExecucao) {
        this.imgExecucao = imgExecucao;
    }

}
