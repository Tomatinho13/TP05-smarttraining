package br.cefetmg.inf.model.domain;

import java.util.ArrayList;

/**
 *
 * @author Tomatinho
 */

public class Treino {
    private String codCpfAluno;
    private int nroFicha;
    private int nroTreino;
    private String descriçaoTreino;
    private ArrayList<Atividade> atividades;

    public Treino() {
    }

    public Treino(String codCpfAluno, int nroFicha, int nroTreino, String descriçaoTreino, ArrayList<Atividade> atividades) {
        this.codCpfAluno = codCpfAluno;
        this.nroFicha = nroFicha;
        this.nroTreino = nroTreino;
        this.descriçaoTreino = descriçaoTreino;
        this.atividades = new ArrayList<>(atividades);
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

    public int getNroTreino() {
        return nroTreino;
    }

    public void setNroTreino(int nroTreino) {
        this.nroTreino = nroTreino;
    }

    public String getDescriçaoTreino() {
        return descriçaoTreino;
    }

    public void setDescriçaoTreino(String descriçaoTreino) {
        this.descriçaoTreino = descriçaoTreino;
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = new ArrayList<>(atividades);
    }
    
    
}
