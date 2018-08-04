package br.cefetmg.inf.model.domain;

/**
 *
 * @author Tomatinho
 */

public class Exercicio {
    private int codExercicio;
    private String descricaoExercicio;
    private String nomeExercicio;

    public Exercicio() {
        
    }

    public Exercicio(int codExercicio, String descricaoExercicio, String nomeExercicio) {
        this.codExercicio = codExercicio;
        this.descricaoExercicio = descricaoExercicio;
        this.nomeExercicio = nomeExercicio;
    }

    public int getCodExercicio() {
        return codExercicio;
    }

    public void setCodExercicio(int codExercicio) {
        this.codExercicio = codExercicio;
    }

    public String getDescricaoExercicio() {
        return descricaoExercicio;
    }

    public void setDescricaoExercicio(String descricaoExercicio) {
        this.descricaoExercicio = descricaoExercicio;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }
    
    
}
