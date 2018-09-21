package br.cefetmg.inf.model.domain;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Tomatinho
 */

public class Avaliacao {
    private String cpfAluno;
    private LocalDate data;
    private String cpfInstrutor;
    private boolean recencia;
    private double peso;
    private double percentualGordura;
    private double tamanhoPescoco;
    private double tamanhoOmbro;
    private double tamanhoTorax;
    private double tamanhoAbdomen;
    private double tamanhoCintura;
    private double tamanhoQuadril;
    private double massaGorda;
    private double tamanhoBracoEsquerdo;
    private double tamanhoBracoDireito;
    private double tamanhoAntebracoEsquerdo;
    private double tamanhoAntebracoDireito;
    private double tamanhoCoxaEsquerda;
    private double tamanhoCoxaDireita;
    private double tamanhoPanturrilhaEsquerda;
    private double tamanhoPanturrilhaDireita;
    private ArrayList<Objetivo> listaObjetivos;
    
    public Avaliacao(){
    }
    
    public Avaliacao(String cpfAluno, LocalDate data, String cpfInstrutor, boolean recencia, double peso, 
            double percentualGordura, double tamanhoPescoco, double tamanhoOmbro, double tamanhoTorax, double tamanhoAbdomen, 
            double tamanhoCintura, double tamanhoQuadril, double massaGorda, double tamanhoBracoEsquerdo, double tamanhoBracoDireito, 
            double tamanhoAntebracoEsquerdo, double tamanhoAntebracoDireito, double tamanhoCoxaEsquerda, double tamanhoCoxaDireita, 
            double tamanhoPanturrilhaEsquerda, double tamanhoPanturrilhaDireita, ArrayList<Objetivo> listaObjetivos) {
        this.cpfAluno = cpfAluno;
        this.data = data;
        this.cpfInstrutor = cpfInstrutor;
        this.recencia = recencia;
        this.peso = peso;
        this.percentualGordura = percentualGordura;
        this.tamanhoPescoco = tamanhoPescoco;
        this.tamanhoOmbro = tamanhoOmbro;
        this.tamanhoTorax = tamanhoTorax;
        this.tamanhoAbdomen = tamanhoAbdomen;
        this.tamanhoCintura = tamanhoCintura;
        this.tamanhoQuadril = tamanhoQuadril;
        this.massaGorda = massaGorda;
        this.tamanhoBracoEsquerdo = tamanhoBracoEsquerdo;
        this.tamanhoBracoDireito = tamanhoBracoDireito;
        this.tamanhoAntebracoEsquerdo = tamanhoAntebracoEsquerdo;
        this.tamanhoAntebracoDireito = tamanhoAntebracoDireito;
        this.tamanhoCoxaEsquerda = tamanhoCoxaEsquerda;
        this.tamanhoCoxaDireita = tamanhoCoxaDireita;
        this.tamanhoPanturrilhaEsquerda = tamanhoPanturrilhaEsquerda;
        this.tamanhoPanturrilhaDireita = tamanhoPanturrilhaDireita;
        this.listaObjetivos = listaObjetivos;
    }

    public double getTamanhoQuadril() {
        return tamanhoQuadril;
    }

    public void setTamanhoQuadril(double tamanhoQuadril) {
        this.tamanhoQuadril = tamanhoQuadril;
    }
    
    public String getCpfAluno() {
        return cpfAluno;
    }

    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getCpfInstrutor() {
        return cpfInstrutor;
    }

    public void setCpfInstrutor(String cpfInstrutor) {
        this.cpfInstrutor = cpfInstrutor;
    }

    public boolean getRecencia() {
        return recencia;
    }

    public void setRecencia(boolean recencia) {
        this.recencia = recencia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(double percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

    public double getTamanhoPescoco() {
        return tamanhoPescoco;
    }

    public void setTamanhoPescoco(double tamanhoPescoco) {
        this.tamanhoPescoco = tamanhoPescoco;
    }

    public double getTamanhoOmbro() {
        return tamanhoOmbro;
    }

    public void setTamanhoOmbro(double tamanhoOmbro) {
        this.tamanhoOmbro = tamanhoOmbro;
    }

    public double getTamanhoTorax() {
        return tamanhoTorax;
    }

    public void setTamanhoTorax(double tamanhoTorax) {
        this.tamanhoTorax = tamanhoTorax;
    }

    public double getTamanhoAbdomen() {
        return tamanhoAbdomen;
    }

    public void setTamanhoAbdomen(double tamanhoAbdomen) {
        this.tamanhoAbdomen = tamanhoAbdomen;
    }

    public double getTamanhoCintura() {
        return tamanhoCintura;
    }

    public void setTamanhoCintura(double tamanhoCintura) {
        this.tamanhoCintura = tamanhoCintura;
    }

    public double getMassaGorda() {
        return massaGorda;
    }

    public void setMassaGorda(double massaGorda) {
        this.massaGorda = massaGorda;
    }

    public double getTamanhoBracoEsquerdo() {
        return tamanhoBracoEsquerdo;
    }

    public void setTamanhoBracoEsquerdo(double tamanhoBracoEsquerdo) {
        this.tamanhoBracoEsquerdo = tamanhoBracoEsquerdo;
    }

    public double getTamanhoBracoDireito() {
        return tamanhoBracoDireito;
    }

    public void setTamanhoBracoDireito(double tamanhoBracoDireito) {
        this.tamanhoBracoDireito = tamanhoBracoDireito;
    }

    public double getTamanhoAntebracoEsquerdo() {
        return tamanhoAntebracoEsquerdo;
    }

    public void setTamanhoAntebracoEsquerdo(double tamanhoAntebracoEsquerdo) {
        this.tamanhoAntebracoEsquerdo = tamanhoAntebracoEsquerdo;
    }

    public double getTamanhoAntebracoDireito() {
        return tamanhoAntebracoDireito;
    }

    public void setTamanhoAntebracoDireito(double tamanhoAntebracoDireito) {
        this.tamanhoAntebracoDireito = tamanhoAntebracoDireito;
    }

    public double getTamanhoCoxaEsquerda() {
        return tamanhoCoxaEsquerda;
    }

    public void setTamanhoCoxaEsquerda(double tamanhoCoxaEsquerda) {
        this.tamanhoCoxaEsquerda = tamanhoCoxaEsquerda;
    }

    public double getTamanhoCoxaDireita() {
        return tamanhoCoxaDireita;
    }

    public void setTamanhoCoxaDireita(double tamanhoCoxaDireita) {
        this.tamanhoCoxaDireita = tamanhoCoxaDireita;
    }

    public double getTamanhoPanturrilhaEsquerda() {
        return tamanhoPanturrilhaEsquerda;
    }

    public void setTamanhoPanturrilhaEsquerda(double tamanhoPanturrilhaEsquerda) {
        this.tamanhoPanturrilhaEsquerda = tamanhoPanturrilhaEsquerda;
    }

    public double getTamanhoPanturrilhaDireita() {
        return tamanhoPanturrilhaDireita;
    }

    public void setTamanhoPanturrilhaDireita(double tamanhoPanturrilhaDireita) {
        this.tamanhoPanturrilhaDireita = tamanhoPanturrilhaDireita;
    }

    public ArrayList<Objetivo> getListaObjetivos() {
        return listaObjetivos;
    }

    public void setListaObjetivos(ArrayList<Objetivo> listaObjetivos) {
        this.listaObjetivos = listaObjetivos;
    }
}
