package br.cefetmg.inf.model.domain;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Tomatinho
 */

public class Ficha {
    private String cpfAluno;
    private int numero;
    private String cpfInstrutor;
    private LocalDate data;
    private LocalDate dataTroca;
    ArrayList<Treino> listaTreino;

    public Ficha() {
    }

    public Ficha(String cpfAluno, int numero, String cpfInstrutor, LocalDate data, LocalDate dataTroca, ArrayList<Treino> listaTreino) {
        this.cpfAluno = cpfAluno;
        this.numero = numero;
        this.cpfInstrutor = cpfInstrutor;
        this.data = data;
        this.dataTroca = dataTroca;
        this.listaTreino = new ArrayList<>(listaTreino);
    }
    
    public String getCpfAluno() {
        return cpfAluno;
    }

    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCpfInstrutor() {
        return cpfInstrutor;
    }

    public void setCpfInstrutor(String cpfInstrutor) {
        this.cpfInstrutor = cpfInstrutor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getDataTroca() {
        return dataTroca;
    }

    public void setDataTroca(LocalDate dataTroca) {
        this.dataTroca = dataTroca;
    }
    
    public ArrayList<Treino> getListaTreino() {
        return listaTreino;
    }

    public void setListaTreino(ArrayList<Treino> listaTreino) {
        this.listaTreino = new ArrayList<>(listaTreino);
    }
}
