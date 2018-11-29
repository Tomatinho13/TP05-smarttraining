package br.cefetmg.inf.model.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Avaliacao implements Serializable {

    @EmbeddedId
    private AvaliacaoChave avaliacaoChave;

    @ManyToOne
    @JoinColumn(referencedColumnName = "cod_cpf")
    private Instrutor instrutor;

    @Column(name = "qtd_peso")
    private double peso;

    @Column(name = "qtd_percGordura")
    private double percentualGordura;

    @Column(name = "tam_pescoco")
    private double tamanhoPescoco;

    @Column(name = "tam_ombro")
    private double tamanhoOmbro;

    @Column(name = "tam_torax")
    private double tamanhoTorax;

    @Column(name = "tam_abdomen")
    private double tamanhoAbdomen;

    @Column(name = "tam_cintura")
    private double tamanhoCintura;

    @Column(name = "tam_quadril")
    private double tamanhoQuadril;

    @Column(name = "qtd_massaGorda")
    private double massaGorda;

    @Column(name = "tam_BracoEsq")
    private double tamanhoBracoEsquerdo;

    @Column(name = "tam_bracoDir")
    private double tamanhoBracoDireito;

    @Column(name = "tam_antebracoEsq")
    private double tamanhoAntebracoEsquerdo;

    @Column(name = "tam_antebracoDir")
    private double tamanhoAntebracoDireito;

    @Column(name = "tam_coxaEs")
    private double tamanhoCoxaEsquerda;

    @Column(name = "tam_coxaDir")
    private double tamanhoCoxaDireita;

    @Column(name = "tam_panturrilhaEsq")
    private double tamanhoPanturrilhaEsquerda;

    @Column(name = "tam_panturrilhaDir")
    private double tamanhoPanturrilhaDireita;

    public Avaliacao() {
    }

    public Avaliacao(AvaliacaoChave avaliacaoChave, Instrutor instrutor, double peso, double percentualGordura, double tamanhoPescoco, double tamanhoOmbro, double tamanhoTorax, double tamanhoAbdomen, double tamanhoCintura, double tamanhoQuadril, double massaGorda, double tamanhoBracoEsquerdo, double tamanhoBracoDireito, double tamanhoAntebracoEsquerdo, double tamanhoAntebracoDireito, double tamanhoCoxaEsquerda, double tamanhoCoxaDireita, double tamanhoPanturrilhaEsquerda, double tamanhoPanturrilhaDireita) {
        this.avaliacaoChave = avaliacaoChave;
        this.instrutor = instrutor;
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
    }

    public AvaliacaoChave getAvaliacaoChave() {
        return avaliacaoChave;
    }

    public void setAvaliacaoChave(AvaliacaoChave avaliacaoChave) {
        this.avaliacaoChave = avaliacaoChave;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
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

    public double getTamanhoQuadril() {
        return tamanhoQuadril;
    }

    public void setTamanhoQuadril(double tamanhoQuadril) {
        this.tamanhoQuadril = tamanhoQuadril;
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
}
