package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import br.cefetmg.inf.model.services.impl.ManterAvaliacao;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class CadastrarAvaliacao {
    
     public static String execute(HttpServletRequest request) {
        String jsp = "";
        double peso = Double.parseDouble(request.getParameter("peso"));
        double percentualGordura = Double.parseDouble(request.getParameter("percentualGordura"));
        double tamanhoPescoco = Double.parseDouble(request.getParameter("tamanhoPescoco"));
        double tamanhoOmbro = Double.parseDouble(request.getParameter("tamanhoOmbro"));
        double tamanhoTorax = Double.parseDouble(request.getParameter("tamanhoTorax"));
        double tamanhoAbdomen = Double.parseDouble(request.getParameter("tamanhoAbdomen"));
        double tamanhoCintura = Double.parseDouble(request.getParameter("tamanhoCintura"));
        double tamanhoBracoDireito = Double.parseDouble(request.getParameter("tamanhoBracoDireito"));
        double tamanhoBracoEsquerdo = Double.parseDouble(request.getParameter("tamanhoBracoEsquerdo"));
        double tamanhoAntebracoDireito = Double.parseDouble(request.getParameter("tamanhoAnteBracoDireito"));
        double tamanhoAntebracoEsquerdo = Double.parseDouble(request.getParameter("tamanhoAnteBracoEsquerdo"));
        double tamanhoCoxaDireita = Double.parseDouble(request.getParameter("tamanhoCoxaDireita"));
        double tamanhoCoxaEsquerda = Double.parseDouble(request.getParameter("tamanhoCoxaEsquerda"));
        double tamanhoPanturrilhaDireita = Double.parseDouble(request.getParameter("tamanhoPanturrilhaDireita"));
        double tamanhoPanturrilhaEsquerda = Double.parseDouble(request.getParameter("tamanhoPanturrilhaEsquerda"));

        Avaliacao avaliacao = new Avaliacao();
        IManterAvaliacao manterAvaliacao = new ManterAvaliacao();
        LocalDate dataAvaliacao = LocalDate.now();
        
        avaliacao.setCodCpfAluno();
        avaliacao.setDatAvaliacao(dataAvaliacao);
        avaliacao.setCodCpfInstrutor();
        avaliacao.setIdtRecencia(true);
        avaliacao.setListaObjetivos();
        
        avaliacao.setPeso(peso);
        avaliacao.setPercentualGordura(percentualGordura);
        avaliacao.setTamanhoPescoco(tamanhoPescoco);
        avaliacao.setTamanhoOmbro(tamanhoOmbro);
        avaliacao.setTamanhoTorax(tamanhoTorax);
        avaliacao.setTamanhoAbdomen(tamanhoAbdomen);
        avaliacao.setTamanhoCintura(tamanhoCintura);
        avaliacao.setTamanhoBracoDireito(tamanhoBracoDireito);
        avaliacao.setTamanhoBracoEsquerdo(tamanhoBracoEsquerdo);
        avaliacao.setTamanhoAntebracoDireito(tamanhoAntebracoDireito);
        avaliacao.setTamanhoAntebracoEsquerdo(tamanhoAntebracoEsquerdo);
        avaliacao.setTamanhoCoxaDireita(tamanhoCoxaDireita);
        avaliacao.setTamanhoCoxaEsquerda(tamanhoCoxaEsquerda);
        avaliacao.setTamanhoPanturrilhaDireita(tamanhoPanturrilhaDireita);
        avaliacao.setTamanhoPanturrilhaEsquerda(tamanhoPanturrilhaEsquerda);
        

        try {
            manterAvaliacao.cadastrar(avaliacao);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        jsp = "/MostrarAvaliacao.jsp";
        return jsp;
    }
}

