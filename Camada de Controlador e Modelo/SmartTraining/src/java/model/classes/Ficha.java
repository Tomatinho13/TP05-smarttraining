package model.classes;
import java.time.LocalDate;

/**
 *
 * @author Tomatinho
 */

public class Ficha {
    private String codCpfAluno;
    private int nroFicha;
    private String codCpfInstrutor;
    private LocalDate dataFicha;
    private LocalDate dataPrevistaTroca;
    private char idtTreino;

    public Ficha() {
    }

    public Ficha(String codCpfAluno, int nroFicha, String codCpfInstrutor, LocalDate dataFicha, LocalDate dataPrevistaTroca, char idtTreino) {
        this.codCpfAluno = codCpfAluno;
        this.nroFicha = nroFicha;
        this.codCpfInstrutor = codCpfInstrutor;
        this.dataFicha = dataFicha;
        this.dataPrevistaTroca = dataPrevistaTroca;
        this.idtTreino = idtTreino;
    }
    
    public String getCodCpfAluno() {
        return codCpfAluno;
    }

    public void setCodCpfAluno(String codCpfAluno) {
        this.codCpfAluno = codCpfAluno;
    }

    public int getNroFicha() {
        return nroFicha;
    }

    public void setNroFicha(int nroFicha) {
        this.nroFicha = nroFicha;
    }

    public String getCodCpfInstrutor() {
        return codCpfInstrutor;
    }

    public void setCodCpfInstrutor(String codCpfInstrutor) {
        this.codCpfInstrutor = codCpfInstrutor;
    }

    public LocalDate getDataFicha() {
        return dataFicha;
    }

    public void setDataFicha(LocalDate dataFicha) {
        this.dataFicha = dataFicha;
    }

    public LocalDate getDataPrevistaTroca() {
        return dataPrevistaTroca;
    }

    public void setDataPrevistaTroca(LocalDate dataPrevistaTroca) {
        this.dataPrevistaTroca = dataPrevistaTroca;
    }

    public char getIdtTreino() {
        return idtTreino;
    }

    public void setIdtTreino(char idtTreino) {
        this.idtTreino = idtTreino;
    }
    
    
}
