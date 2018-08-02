package br.cefetmg.inf.model.domain;

/**
 *
 * @author Tomatinho
 */

public class Aparelho {
    private int codAparelho;
    private String nomAparelho;

    public Aparelho() {
        
    }

    public Aparelho(int codAparelho, String nomAparelho) {
        this.codAparelho = codAparelho;
        this.nomAparelho = nomAparelho;
    }
    
    public int getCodAparelho() {
        return codAparelho;
    }

    public void setCodAparelho(int codAparelho) {
        this.codAparelho = codAparelho;
    }

    public String getNomAparelho() {
        return nomAparelho;
    }

    public void setNomAparelho(String nomAparelho) {
        this.nomAparelho = nomAparelho;
    }
    
    
    
    
}
