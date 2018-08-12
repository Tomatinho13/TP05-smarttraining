package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.domain.Objetivo;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import br.cefetmg.inf.model.services.IManterObjetivo;
import br.cefetmg.inf.model.services.impl.ManterAvaliacao;
import br.cefetmg.inf.model.services.impl.ManterObjetivo;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class CadastrarAvaliacao implements Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp;
        double peso = Double.parseDouble(request.getParameter("peso"));
        double percentualGordura = Double.parseDouble(request.getParameter("percentualGordura"));
        double massaGorda = Double.parseDouble(request.getParameter("massaGorda"));
        double tamanhoPescoco = Double.parseDouble(request.getParameter("tamanhoPescoco"));
        double tamanhoOmbro = Double.parseDouble(request.getParameter("tamanhoOmbro"));
        double tamanhoTorax = Double.parseDouble(request.getParameter("tamanhoTorax"));
        double tamanhoAbdomen = Double.parseDouble(request.getParameter("tamanhoAbdomen"));
        double tamanhoCintura = Double.parseDouble(request.getParameter("tamanhoCintura"));
        double tamanhoQuadril = Double.parseDouble(request.getParameter("tamanhoQuadril"));
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

        avaliacao.setCodCpfAluno((String) request.getAttribute("codCpfAluno"));
        avaliacao.setDatAvaliacao(dataAvaliacao);
        avaliacao.setCodCpfInstrutor((String) request.getAttribute("codCpfInstrutor"));
        avaliacao.setIdtRecencia(true);

        String objetivos[] = request.getParameterValues("objetivo");
        ArrayList<Objetivo> listaObjetivos = new ArrayList<>();
        IManterObjetivo manterObjetivo = new ManterObjetivo();
        Objetivo obj;

        for (String objetivo : objetivos) {
            try {
                obj = manterObjetivo.pesquisarPorNome(objetivo);
                listaObjetivos.add(obj);
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        avaliacao.setListaObjetivos(listaObjetivos);
        avaliacao.setPeso(peso);
        avaliacao.setPercentualGordura(percentualGordura);
        avaliacao.setMassaGorda(massaGorda);
        avaliacao.setTamanhoPescoco(tamanhoPescoco);
        avaliacao.setTamanhoOmbro(tamanhoOmbro);
        avaliacao.setTamanhoTorax(tamanhoTorax);
        avaliacao.setTamanhoAbdomen(tamanhoAbdomen);
        avaliacao.setTamanhoCintura(tamanhoCintura);
        avaliacao.setTamanhoQuadril(tamanhoQuadril);
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
        jsp = "/TelaInicialAluno.jsp";
        return jsp;
    }
}
