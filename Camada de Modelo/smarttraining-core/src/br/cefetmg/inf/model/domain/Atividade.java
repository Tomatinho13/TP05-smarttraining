package br.cefetmg.inf.model.domain;

/**
 *
 * @author Felipe
 */

public class Atividade {
    private Exercicio exercicio;
    private int peso;
    private int series;
    private int repeticoes;

    public Atividade() {
    }

    public Atividade(Exercicio exercicio, int peso, int series, int repeticoes) {
        this.exercicio = exercicio;
        this.peso = peso;
        this.series = series;
        this.repeticoes = repeticoes;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }
    
}