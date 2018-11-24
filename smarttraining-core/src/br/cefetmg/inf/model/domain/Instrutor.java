package br.cefetmg.inf.model.domain;
import java.time.LocalDate;

/**
 *
 * @author Tomatinho
 */

public class Instrutor extends Usuario {
    private String nroCref;

    public Instrutor(){
        
    }

    public Instrutor(String nroCref, String cpf, String nome, char tipo, String senha, String email, LocalDate dataNascimento) {
        super(cpf, nome, tipo, senha, email, dataNascimento);
        this.nroCref = nroCref;
    } 
    
    public void setNroCref(String nroCref) {
        this.nroCref = nroCref;
    }

    public String getNroCref() {
        return nroCref;
    }
}
