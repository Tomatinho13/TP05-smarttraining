package br.cefetmg.inf.controller;

import br.cefetmg.inf.model.domain.Avaliacao;
import br.cefetmg.inf.model.domain.Objetivo;
import br.cefetmg.inf.model.services.IManterAvaliacao;
import br.cefetmg.inf.model.services.IManterObjetivo;
import br.cefetmg.inf.proxy.ManterAvaliacaoProxy;
import br.cefetmg.inf.proxy.ManterObjetivoProxy;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

public class CadastrarAvaliacao extends Controller {

    @Override
    public String execute(HttpServletRequest request) {
        String jsp = "/TelaInicialInstrutor";
        if (request.getAttribute("tipoView").equals("json")) {
            BufferedReader leitor;
            try {
                leitor = request.getReader();

                Gson gson = new Gson();
                IManterAvaliacao manterAvaliacao = new ManterAvaliacaoProxy();

                Avaliacao avaliacao = gson.fromJson(leitor.readLine(), Avaliacao.class);

                if (manterAvaliacao.cadastrar(avaliacao)) {
                    request.setAttribute("resposta", "Sucesso!");
                    jsp = "resposta";
                } else {
                    request.setAttribute("erro", "Erro ao cadastrar avaliacao");
                    jsp = "erro";
                }
            } catch (IOException | SQLException ex) {
                ex.printStackTrace(System.err);
                String erro = "Erro ao cadastrar exercicio!";
                request.setAttribute("erro", erro);
                jsp = "erro";
            }
        } else {
            try {
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
                LocalDate dataAvaliacao = LocalDate.now();

                avaliacao.setCpfAluno(request.getParameter("codCpfAluno").replaceAll("[^0-9]", ""));
                avaliacao.setData(dataAvaliacao);
                avaliacao.setCpfInstrutor(request.getParameter("codCpfInstrutor").replaceAll("[^0-9]", ""));

                String objetivos[] = request.getParameterValues("objetivo");
                ArrayList<Objetivo> listaObjetivos = new ArrayList<>();
                IManterObjetivo manterObjetivo = new ManterObjetivoProxy();
                Objetivo obj;

                for (String objetivo : objetivos) {
                    obj = manterObjetivo.pesquisarPorNome(objetivo);
                    listaObjetivos.add(obj);
                }

                avaliacao.setObjetivos(listaObjetivos);
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
                manterAvaliacao.cadastrar(avaliacao);
            } catch (SQLException e) {
                e.printStackTrace(System.err);
                String erro = "Erro ao cadastrar avaliacao!";
                request.setAttribute("erro", erro);
                jsp = "erro.jsp";
            } catch (RemoteException ex) {
                Logger.getLogger(CadastrarAvaliacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return defineView(request, jsp);
    }
}
