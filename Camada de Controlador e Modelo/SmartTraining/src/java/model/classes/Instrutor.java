package model.classes;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Tomatinho
 */

public class Instrutor extends Usuario {
    private String codCREF;

    public Instrutor(){
        
    }

    public Instrutor(String codCREF, String codCpf, String nomUsuario, char idtTipoUsuario, String txtSenha, String desEmail, LocalDate datNascimento) {
        super(codCpf, nomUsuario, idtTipoUsuario, txtSenha, desEmail, datNascimento);
        this.codCREF = codCREF;
    } 
    
    public void setCodCREF(String codCREF) {
        this.codCREF = codCREF;
    }

    public String getCodCREF() {
        return codCREF;
    }
}
