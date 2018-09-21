package br.cefetmg.inf.model.domain;

import java.util.ArrayList;

/**
 *
 * @author Tomatinho
 */

public class Treino {
    private String cpfAluno;
    private int nroFicha;
    private int nroTreino;
    private String descricao;
    private ArrayList<Atividade> atividades;

    public Treino() {
    }

    public Treino(String cpfAluno, int nroFicha, int nroTreino, String descricao, ArrayList<Atividade> atividades) {
        this.cpfAluno = cpfAluno;
        this.nroFicha = nroFicha;
        this.nroTreino = nroTreino;
        this.descricao = descricao;
        this.atividades = new ArrayList<>(atividades);
    }

    public String getCpfAluno() {
        return cpfAluno;
    }

    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades) {
        this.atividades = new ArrayList<>(atividades);
    }
}
