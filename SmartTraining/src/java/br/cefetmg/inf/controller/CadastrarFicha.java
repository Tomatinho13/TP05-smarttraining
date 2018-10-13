package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import br.cefetmg.inf.proxy.ManterAvaliacaoProxy;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;

public class CadastrarFicha extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "/TelaInicialInstrutor";
        try {
            LocalDate dataAvaliacao = Date.valueOf(request.getParameter("dataAvaliacao")).toLocalDate();
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
            IManterAvaliacao manterAvaliacao = new ManterAvaliacaoProxy();
            
            avaliacao.setCpfAluno(request.getParameter("codCpfAluno").replaceAll("[^0-9]", ""));
            avaliacao.setData(dataAvaliacao);
            avaliacao.setCpfInstrutor(request.getParameter("codCpfInstrutor").replaceAll("[^0-9]", ""));
            avaliacao.setRecencia(true);

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
            manterAvaliacao.alterar(avaliacao);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            String erro = "Erro ao alterar avaliacao!";
            request.setAttribute("erro", erro);
            jsp = "erro.jsp";
        }
        return defineView(request, jsp);
    }
}