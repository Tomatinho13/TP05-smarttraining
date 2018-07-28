package model.classes;
import java.time.LocalDate;

/**
 *
 * @author Tomatinho
 */

public class Avaliaçao {
    private String codCpfAluno;
    private LocalDate datAvaliaçao;
    private String codCpfInstrutor;
    private boolean idtRecencia;
    private double peso;
    private double qtdGordura;
    private double tamanhoPescoço;
    private double tamanhoOmbro;
    private double tamanhoTorax;
    private double tamanhoAbdomen;
    private double tamanhoCintura;
    private double tamanhoQuadril;
    private double tamanhoBraçoEsquerdo;
    private double tamanhoBraçoDireito;
    private double tamanhoAntebraçoEsquerdo;
    private double tamanhoAntebraçoDireito;
    private double tamanhoCoxaEsquerda;
    private double tamanhoCoxaDireita;
    private double tamanhoPanturrilhaEsquerda;
    private double tamanhoPanturrilhaDireita;
    
    public Avaliaçao(){

    }
    
    public Avaliaçao(String codCpfAluno, LocalDate datAvaliaçao, String codCpfInstrutor,
                     boolean idtRecencia, double peso, double qtdGordura){
       this.codCpfAluno = codCpfAluno;
       this.datAvaliaçao = datAvaliaçao;
       this.codCpfInstrutor = codCpfInstrutor;
       this.idtRecencia = idtRecencia;
       this.peso = peso;
       this.qtdGordura = qtdGordura;   
    }

    public Avaliaçao(String codCpfAluno, LocalDate datAvaliaçao, String codCpfInstrutor, boolean idtRecencia, double peso, double qtdGordura, double tamanhoPescoço, double tamanhoOmbro, double tamanhoTorax, double tamanhoAbdomen, double tamanhoCintura, double tamanhoQuadril, double tamanhoBraçoEsquerdo, double tamanhoBraçoDireito, double tamanhoAntebraçoEsquerdo, double tamanhoAntebraçoDireito, double tamanhoCoxaEsquerda, double tamanhoCoxaDireita, double tamanhoPanturrilhaEsquerda, double tamanhoPanturrilhaDireita) {
        this.codCpfAluno = codCpfAluno;
        this.datAvaliaçao = datAvaliaçao;
        this.codCpfInstrutor = codCpfInstrutor;
        this.idtRecencia = idtRecencia;
        this.peso = peso;
        this.qtdGordura = qtdGordura;
        this.tamanhoPescoço = tamanhoPescoço;
        this.tamanhoOmbro = tamanhoOmbro;
        this.tamanhoTorax = tamanhoTorax;
        this.tamanhoAbdomen = tamanhoAbdomen;
        this.tamanhoCintura = tamanhoCintura;
        this.tamanhoQuadril = tamanhoQuadril;
        this.tamanhoBraçoEsquerdo = tamanhoBraçoEsquerdo;
        this.tamanhoBraçoDireito = tamanhoBraçoDireito;
        this.tamanhoAntebraçoEsquerdo = tamanhoAntebraçoEsquerdo;
        this.tamanhoAntebraçoDireito = tamanhoAntebraçoDireito;
        this.tamanhoCoxaEsquerda = tamanhoCoxaEsquerda;
        this.tamanhoCoxaDireita = tamanhoCoxaDireita;
        this.tamanhoPanturrilhaEsquerda = tamanhoPanturrilhaEsquerda;
        this.tamanhoPanturrilhaDireita = tamanhoPanturrilhaDireita;
    }
    
    public String getCodCpfAluno() {
        return codCpfAluno;
    }

    public void setCodCpfAluno(String codCpfAluno) {
        this.codCpfAluno = codCpfAluno;
    }

    public LocalDate getDatAvaliaçao() {
        return datAvaliaçao;
    }

    public void setDatAvaliaçao(LocalDate datAvaliaçao) {
        this.datAvaliaçao = datAvaliaçao;
    }

    public String getCodCpfInstrutor() {
        return codCpfInstrutor;
    }

    public void setCodCpfInstrutor(String codCpfInstrutor) {
        this.codCpfInstrutor = codCpfInstrutor;
    }

    public boolean isIdtRecencia() {
        return idtRecencia;
    }

    public void setIdtRecencia(boolean idtRecencia) {
        this.idtRecencia = idtRecencia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getQtdGordura() {
        return qtdGordura;
    }

    public void setQtdGordura(double qtdGordura) {
        this.qtdGordura = qtdGordura;
    }

    public double getTamanhoPescoço() {
        return tamanhoPescoço;
    }

    public void setTamanhoPescoço(double tamanhoPescoço) {
        this.tamanhoPescoço = tamanhoPescoço;
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

    public double getTamanhoQuadril() {
        return tamanhoQuadril;
    }

    public void setTamanhoQuadril(double tamanhoQuadril) {
        this.tamanhoQuadril = tamanhoQuadril;
    }

    public double getTamanhoBraçoEsquerdo() {
        return tamanhoBraçoEsquerdo;
    }

    public void setTamanhoBraçoEsquerdo(double tamanhoBraçoEsquerdo) {
        this.tamanhoBraçoEsquerdo = tamanhoBraçoEsquerdo;
    }

    public double getTamanhoBraçoDireito() {
        return tamanhoBraçoDireito;
    }

    public void setTamanhoBraçoDireito(double tamanhoBraçoDireito) {
        this.tamanhoBraçoDireito = tamanhoBraçoDireito;
    }

    public double getTamanhoAntebraçoEsquerdo() {
        return tamanhoAntebraçoEsquerdo;
    }

    public void setTamanhoAntebraçoEsquerdo(double tamanhoAntebraçoEsquerdo) {
        this.tamanhoAntebraçoEsquerdo = tamanhoAntebraçoEsquerdo;
    }

    public double getTamanhoAntebraçoDireito() {
        return tamanhoAntebraçoDireito;
    }

    public void setTamanhoAntebraçoDireito(double tamanhoAntebraçoDireito) {
        this.tamanhoAntebraçoDireito = tamanhoAntebraçoDireito;
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
}
