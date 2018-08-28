/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.util;

/**
 *
 * @author gabriel
 */
public class Pacote {

    TipoOperacao tipoOperacao;
    String dados;

    public Pacote(TipoOperacao tipoOperacao, String dados) {
        this.tipoOperacao = tipoOperacao;
        this.dados = dados;
    }

    public TipoOperacao getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(TipoOperacao tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }
}
