package br.cefetmg.inf.model.domain;

/**
 *
 * @author Tomatinho
 */

public class Exercicio {
    private int codExercicio;
    private String descriçaoExercicio;
    private String nomeExercicio;

    public Exercicio() {
        
    }

    public Exercicio(int codExercicio, String descriçaoExercicio, String nomeExercicio) {
        this.codExercicio = codExercicio;
        this.descriçaoExercicio = descriçaoExercicio;
        this.nomeExercicio = nomeExercicio;
    }

    public int getCodExercicio() {
        return codExercicio;
    }

    public void setCodExercicio(int codExercicio) {
        this.codExercicio = codExercicio;
    }

    public String getDescriçaoExercicio() {
        return descriçaoExercicio;
    }

    public void setDescriçaoExercicio(String descriçaoExercicio) {
        this.descriçaoExercicio = descriçaoExercicio;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }
    
    
}
